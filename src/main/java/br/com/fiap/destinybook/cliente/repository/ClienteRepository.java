package br.com.fiap.destinybook.cliente.repository;

import br.com.fiap.destinybook.cliente.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
