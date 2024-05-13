package br.com.benditodoce.usuarioservice.usuarioservice.repositories;

import br.com.benditodoce.usuarioservice.usuarioservice.domain.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {
}

