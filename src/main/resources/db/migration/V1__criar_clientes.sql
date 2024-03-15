CREATE TABLE pessoa (
                        id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
                        paisOrigem VARCHAR(20) NOT NULL,
                        cpf VARCHAR(15),
                        passaporte VARCHAR(20),
                        endereco endereco(30),
                        nomeCompleto VARCHAR(30),
                        dataNascimento DATE(20),
                        telefone VARCHAR(20),
                        email VARCHAR(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#INSERT INTO cliente (id, pais_origem, cpf, passaporte, endereco, nome_completo, data_nascimento, telefone, email)
#VALUES (3, 'Brasil', '123.456.789-00', 'AB123456', 'Rua Exemplo, 123', 'Fulano de Tal', '1990-01-01', '(00) 1234-5678', 'globo@example.com.br');
