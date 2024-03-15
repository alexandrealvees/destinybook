package br.com.fiap.destinybook.cliente.entidade.dto;

import br.com.fiap.destinybook.cliente.entidade.Cliente;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class ClienteDto {


    private Long id;
    private String paisOrigem;
    private String cpf;
    private String passaporte;
    private String endereco;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;

    public Cliente toEntity(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();

        cliente.setId(clienteDto.getId());
        cliente.setPaisOrigem(clienteDto.getPaisOrigem());
        cliente.setCpf(clienteDto.getCpf());
        cliente.setPassaporte(clienteDto.getPassaporte());
        cliente.setEndereco(clienteDto.getEndereco());
        cliente.setNomeCompleto(clienteDto.getNomeCompleto());
        cliente.setDataNascimento(clienteDto.getDataNascimento());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setEmail(clienteDto.getEmail());

        return cliente;
    }
}
