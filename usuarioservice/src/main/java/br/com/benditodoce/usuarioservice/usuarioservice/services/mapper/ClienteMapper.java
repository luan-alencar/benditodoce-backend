package br.com.benditodoce.usuarioservice.usuarioservice.services.mapper;

import br.com.benditodoce.usuarioservice.usuarioservice.domain.Cliente;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.dtos.ClienteDTO;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.enums.Perfil;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.enums.Prioridade;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper extends EntityMapper<ClienteDTO, Cliente> {

    @Override
    Cliente toEntity(ClienteDTO dto);

    @Override
    ClienteDTO toDto(Cliente entity);

    default Perfil mapPrioridade(Integer codigoPerfil) {
        return Perfil.toEnum(codigoPerfil);
    }

    default Integer mapPrioridade(Perfil perfil) {
        return perfil != null ? perfil.getCodigo() : null;
    }

}


