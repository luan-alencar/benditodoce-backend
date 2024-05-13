package br.com.benditodoce.usuarioservice.usuarioservice.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Embeddable
public class ItemCarrinho implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer produtoId;
    private String produtoNome;
    private BigDecimal preco;
    private Integer quantidade;

}
