package br.com.benditodoce.usuarioservice.usuarioservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Carrinho implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<ItemCarrinho> itens = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private Double total = 0.0;

    public void adicionarItem(ItemCarrinho item) {
        this.itens.add(item);
        calcularTotal();
    }

    public void removerItem(ItemCarrinho item) {
        this.itens.remove(item);
        calcularTotal();
    }

    private void calcularTotal() {
        this.total = this.itens.stream()
                .mapToDouble(item -> item.getPreco().doubleValue() * item.getQuantidade())
                .sum();
    }
}

