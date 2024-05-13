package br.com.benditodoce.usuarioservice.usuarioservice.domain.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ItemCarrinhoDTO implements Serializable {
    private Integer produtoId;
    private String produtoNome;
    private BigDecimal preco;
    private Integer quantidade;

}
