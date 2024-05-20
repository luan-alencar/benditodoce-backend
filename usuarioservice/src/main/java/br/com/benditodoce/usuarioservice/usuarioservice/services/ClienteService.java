package br.com.benditodoce.usuarioservice.usuarioservice.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.benditodoce.usuarioservice.usuarioservice.domain.Carrinho;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.Cliente;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.Pessoa;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.dtos.ClienteDTO;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.dtos.EmailDTO;
import br.com.benditodoce.usuarioservice.usuarioservice.exceptions.DataIntegrityViolationException;
import br.com.benditodoce.usuarioservice.usuarioservice.exceptions.ObjectnotFoundException;
import br.com.benditodoce.usuarioservice.usuarioservice.repositories.CarrinhoRepository;
import br.com.benditodoce.usuarioservice.usuarioservice.repositories.ClienteRepository;
import br.com.benditodoce.usuarioservice.usuarioservice.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final PessoaRepository pessoaRepository;
    private final BCryptPasswordEncoder encoder;
    private final ProdutorServico produtorServico;
    private final EmailService emailService;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        objDTO.setId(null);
        objDTO.setSenha(encoder.encode(objDTO.getSenha()));
        validaPorCpfEEmail(objDTO);
        EmailDTO emailDTO = gerarEmailCriarUsuario(objDTO);
        produtorServico.enviarEmail(emailDTO);
        emailService.enviarEmailTexto(objDTO.getEmail(),
                "Novo usuário cadastrado",
                "Você está recebendo um email de cadastro o número para validação é ");

        Cliente newObj = new Cliente(objDTO);
        return repository.save(newObj);
    }

    private EmailDTO gerarEmailCriarUsuario(ClienteDTO cliente) {
        EmailDTO emailDTO = new EmailDTO();

        emailDTO.setAssunto("Cadastro de Usuário");
        emailDTO.setCorpo("Você se cadastrou com sucesso na plataforma de eventos, esta é sua chave de inscrição aos eventos: <b>" + cliente.getEmail() + "</b>");
        emailDTO.setDestinatario(cliente.getEmail());

        return emailDTO;
    }


    public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
        objDTO.setId(id);
        Cliente oldObj = findById(id);

        if (!objDTO.getSenha().equals(oldObj.getSenha()))
            objDTO.setSenha(encoder.encode(objDTO.getSenha()));

        validaPorCpfEEmail(objDTO);
        oldObj = new Cliente(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Cliente obj = findById(id);

        if (obj.getChamados().size() > 0) {
            throw new DataIntegrityViolationException("Cliente possui ordens de serviço e não pode ser deletado!");
        }

        repository.deleteById(id);
    }

    private void validaPorCpfEEmail(ClienteDTO objDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }

}
