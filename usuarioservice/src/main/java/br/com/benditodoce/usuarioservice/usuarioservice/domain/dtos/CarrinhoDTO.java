package br.com.benditodoce.usuarioservice.usuarioservice.domain.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class CarrinhoDTO implements Serializable {
    private List<ItemCarrinhoDTO> itens;

}
