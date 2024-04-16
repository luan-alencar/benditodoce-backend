package br.com.benditodoce.usuarioservice.usuarioservice.repositories;

import br.com.benditodoce.usuarioservice.usuarioservice.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
