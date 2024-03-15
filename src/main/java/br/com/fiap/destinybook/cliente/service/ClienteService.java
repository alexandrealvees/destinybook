package br.com.fiap.destinybook.cliente.service;

import br.com.fiap.destinybook.cliente.entidade.Cliente;
import br.com.fiap.destinybook.cliente.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar( Cliente cliente) {
        if(!"Brasil".equals(cliente.getPaisOrigem())) {
            throw new IllegalArgumentException("Passaporte é obrigatório para estrangeiros.");
         }
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        Cliente clienteSalvo = buscarClientePeloId(id);

        BeanUtils.copyProperties(cliente, clienteSalvo, "id");
        return clienteRepository.save(clienteSalvo);
    }
    public Cliente buscarClientePeloId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public void delete(Cliente cliente){
        this.clienteRepository.delete(cliente);
    }

}
