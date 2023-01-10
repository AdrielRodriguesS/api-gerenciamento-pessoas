INSERT INTO pessoa (nome, data_nascimento) VALUES ('Pessoa1','2001-01-01');
INSERT INTO pessoa (nome, data_nascimento) VALUES ('Pessoa1','2002-02-02');
INSERT INTO pessoa (nome, data_nascimento) VALUES ('Pessoa1','2003-03-03');

INSERT INTO endereco (logradouro, cep, numero, cidade, endereco_principal, pessoa_id) VALUES ('Rua um_um', '11111-111', '001', 'CidadeUm', true, 1);
INSERT INTO endereco (logradouro, cep, numero, cidade, endereco_principal, pessoa_id) VALUES ('Rua um_dois', '11111-222', '111', 'CidadeUm', false, 1);
INSERT INTO endereco (logradouro, cep, numero, cidade, endereco_principal, pessoa_id) VALUES ('Rua dois_um', '22222-111', '002', 'CidadeDois', true, 2);
INSERT INTO endereco (logradouro, cep, numero, cidade, endereco_principal, pessoa_id) VALUES ('Rua dois_dois', '22222-222', '222', 'CidadeDois', false, 2);
INSERT INTO endereco (logradouro, cep, numero, cidade, endereco_principal, pessoa_id) VALUES ('Rua tres_um', '33333-111', '003', 'CidadeTres', true, 3);
INSERT INTO endereco (logradouro, cep, numero, cidade, endereco_principal, pessoa_id) VALUES ('Rua tres_dois', '33333-222', '333', 'CidadeTres', false);