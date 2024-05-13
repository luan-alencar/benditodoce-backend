package br.com.benditodoce.usuarioservice.usuarioservice.services.mapper;

import br.com.benditodoce.usuarioservice.usuarioservice.domain.Chamado;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.Cliente;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.Tecnico;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.dtos.ChamadoDTO;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.enums.Prioridade;
import br.com.benditodoce.usuarioservice.usuarioservice.domain.enums.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ChamadoMapper extends EntityMapper<ChamadoDTO, Chamado> {

    @Override
    @Mapping(target = "tecnico", source = "tecnico")
    @Mapping(target = "prioridade", source = "prioridade")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "cliente", source = "cliente")
    Chamado toEntity(ChamadoDTO dto);

    @Override
    @Mapping(target = "tecnico", source = "tecnico.id")
    @Mapping(target = "prioridade", source = "prioridade.codigo")
    @Mapping(target = "status", source = "status.codigo")
    @Mapping(target = "cliente", source = "cliente.id")
    ChamadoDTO toDto(Chamado entity);

    default Tecnico mapTecnico(Integer tecnicoId) {
        Tecnico tecnico = new Tecnico();
        tecnico.setId(tecnicoId);
        return tecnico;
    }

    default Integer mapTecnico(Tecnico tecnico) {
        return tecnico != null ? tecnico.getId() : null;
    }

    default Prioridade mapPrioridade(Integer prioridadeCodigo) {
        return Prioridade.toEnum(prioridadeCodigo);
    }

    default Integer mapPrioridade(Prioridade prioridade) {
        return prioridade != null ? prioridade.getCodigo() : null;
    }

    default Status mapStatus(Integer statusCodigo) {
        return Status.toEnum(statusCodigo);
    }

    default Integer mapStatus(Status status) {
        return status != null ? status.getCodigo() : null;
    }

    default Cliente mapCliente(Integer clienteId) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteId);
        return cliente;
    }

    default Integer mapCliente(Cliente cliente) {
        return cliente != null ? cliente.getId() : null;
    }
}


