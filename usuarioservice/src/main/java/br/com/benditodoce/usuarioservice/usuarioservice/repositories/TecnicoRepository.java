package br.com.benditodoce.usuarioservice.usuarioservice.repositories;

import br.com.benditodoce.usuarioservice.usuarioservice.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
