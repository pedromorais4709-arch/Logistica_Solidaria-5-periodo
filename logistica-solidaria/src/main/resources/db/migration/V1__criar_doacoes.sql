CREATE TABLE doacoes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    quantidade INT NOT NULL,
    localizacao VARCHAR(100) NOT NULL,
    status VARCHAR(30) NOT NULL,
    data_cadastro DATE
);