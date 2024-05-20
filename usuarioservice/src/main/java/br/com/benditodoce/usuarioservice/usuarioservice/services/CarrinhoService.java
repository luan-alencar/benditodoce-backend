package br.com.benditodoce.usuarioservice.usuarioservice.services;

import br.com.benditodoce.usuarioservice.usuarioservice.domain.Carrinho;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.Cliente;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.ItemCarrinho;
import br.com.benditodoce.usuarioservice.usuarioservice.repositories.CarrinhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;
    private final ClienteService clienteService;


    @Transactional
    public void criarCarrinho(Integer clienteID) {
        Cliente cliente = clienteService.findById(clienteID);
        Carrinho carrinho = new Carrinho();
        carrinho.setCliente(cliente);

        carrinhoRepository.save(carrinho);
    }

    @Transactional
    public Carrinho adicionarItemCarrinho(Integer carrinhoId, ItemCarrinho item) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        carrinho.adicionarItem(item);
        return carrinhoRepository.save(carrinho);
    }

    @Transactional
    public Carrinho removerItemCarrinho(Integer carrinhoId, ItemCarrinho item) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        carrinho.removerItem(item);
        return carrinhoRepository.save(carrinho);
    }
}

