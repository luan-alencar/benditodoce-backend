package br.com.benditodoce.usuarioservice.usuarioservice.repositories;

import br.com.benditodoce.usuarioservice.usuarioservice.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
