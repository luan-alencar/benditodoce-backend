package br.com.benditodoce.usuarioservice.usuarioservice.resources;

import br.com.benditodoce.usuarioservice.usuarioservice.domain.Carrinho;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.ItemCarrinho;
import br.com.benditodoce.usuarioservice.usuarioservice.services.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carrinhos")
public class CarrinhoResource {

    private final CarrinhoService carrinhoService;

    @PostMapping("/clientes/{clienteID}")
    public void criarCarrinho(@PathVariable("clienteID") Integer clienteID) {
        carrinhoService.criarCarrinho(clienteID);
    }

    @PostMapping("/{carrinhoId}/adicionarItem")
    public Carrinho adicionarItemCarrinho(@PathVariable Integer carrinhoId, @RequestBody ItemCarrinho item) {
        return carrinhoService.adicionarItemCarrinho(carrinhoId, item);
    }

    @PostMapping("/{carrinhoId}/removerItem")
    public Carrinho removerItemCarrinho(@PathVariable Integer carrinhoId, @RequestBody ItemCarrinho item) {
        return carrinhoService.removerItemCarrinho(carrinhoId, item);
    }
}

