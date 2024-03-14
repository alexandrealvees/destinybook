package br.com.fiap.destinybook.cliente.entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
        private String paisOrigem;

    @Column
    private String cpf;

    @Column
    private String passaporte;

    @Column

    private String endereco;

    @Column
    private String nomeCompleto;

    @Column
    private LocalDate dataNascimento;

    @Column
    private String telefone;

    @Column
    private String email;


}
