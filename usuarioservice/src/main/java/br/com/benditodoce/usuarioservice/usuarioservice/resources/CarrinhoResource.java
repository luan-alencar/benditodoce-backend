package br.com.benditodoce.usuarioservice.usuarioservice.resources;

import br.com.benditodoce.usuarioservice.usuarioservice.domain.dtos.ItemCarrinhoDTO;
import br.com.benditodoce.usuarioservice.usuarioservice.services.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carrinho")
public class CarrinhoResource {

    private final CarrinhoService carrinhoService;

    @PostMapping
    public void adicionarItem(@RequestBody ItemCarrinhoDTO itemCarrinhoDTO) {
        // Implemente a lógica para adicionar um item ao carrinho
    }

    @DeleteMapping("/{produtoId}")
    public void removerItem(@PathVariable Integer produtoId) {
        // Implemente a lógica para remover um item do carrinho
    }

    @GetMapping("/total")
    public BigDecimal calcularTotal() {
        // Implemente a lógica para calcular o total do carrinho
        return null;
    }
}

