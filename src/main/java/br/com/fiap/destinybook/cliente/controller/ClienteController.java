package br.com.fiap.destinybook.cliente.controller;

import br.com.fiap.destinybook.cliente.entidade.Cliente;
import br.com.fiap.destinybook.cliente.entidade.dto.ClienteDto;
import br.com.fiap.destinybook.cliente.event.RecursoCriadoEvent;
import br.com.fiap.destinybook.cliente.repository.ClienteRepository;
import br.com.fiap.destinybook.cliente.service.ClienteService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Cliente> listaTodos() {

        return clienteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@Valid @RequestBody ClienteDto clienteDto, HttpServletResponse response) {
        Cliente clienteSalvo = clienteService.salvar(clienteDto.toEntity(clienteDto));
        publisher.publishEvent(new RecursoCriadoEvent(this, response, clienteSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPeloCodigo(@PathVariable Long id) {
        Optional<Cliente> cliente = Optional.ofNullable(clienteService.buscarClientePeloId(id));
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Long id){
        Optional<Cliente> cliente = Optional.ofNullable(clienteService.buscarClientePeloId(id));
        if(cliente.isPresent()){
            this.clienteService.delete(cliente.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
