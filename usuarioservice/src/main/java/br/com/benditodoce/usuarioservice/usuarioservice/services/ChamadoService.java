package br.com.benditodoce.usuarioservice.usuarioservice.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.benditodoce.usuarioservice.usuarioservice.domain.Chamado;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.Cliente;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.Tecnico;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.dtos.ChamadoDTO;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.enums.Prioridade;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.enums.Status;
import br.com.benditodoce.usuarioservice.usuarioservice.exceptions.ObjectnotFoundException;
import br.com.benditodoce.usuarioservice.usuarioservice.repositories.ChamadoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ChamadoService {

	private final ChamadoRepository repository;
	private final TecnicoService tecnicoService;
	private final ClienteService clienteService;

	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

	public Chamado create(ChamadoDTO obj) {
		return repository.save(newChamado(obj));
	}

	public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
		objDTO.setId(id);
		Chamado oldObj = findById(id);
		oldObj = newChamado(objDTO);
		return repository.save(oldObj);
	}

	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());
		
		Chamado chamado = new Chamado();
		if(obj.getId() != null) {
			chamado.setId(obj.getId());
		}
		
		if(obj.getStatus().equals(2)) {
			chamado.setDataFechamento(LocalDate.now());
		}
		
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnum(obj.getStatus()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacoes(obj.getObservacoes());
		return chamado;
	}

}
















