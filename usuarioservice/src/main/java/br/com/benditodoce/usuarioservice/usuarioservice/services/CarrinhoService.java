package br.com.benditodoce.usuarioservice.usuarioservice.services;

import br.com.benditodoce.usuarioservice.usuarioservice.domain.ItemCarrinho;
import br.com.benditodoce.usuarioservice.usuarioservice.repositories.CarrinhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

    private List<ItemCarrinho> itens = new ArrayList<>();
    
    public void adicionarItem(ItemCarrinho item) {
        itens.add(item);
    }

    public void removerItem(ItemCarrinho item) {
        itens.remove(item);
    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCarrinho item : itens) {
            total = total.add(item.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())));
        }
        return total;
    }

}

