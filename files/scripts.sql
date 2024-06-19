CREATE TABLE pessoa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(500) NOT NULL,
    email VARCHAR(500) NOT NULL,
    data_nascimento DATE NOT NULL,
    idade INT NOT NULL
);

CREATE TABLE dados_bancarios (
    id SERIAL PRIMARY KEY,
    pessoa_id INT REFERENCES pessoa(id),
    agencia INT NOT NULL,
    conta INT NOT NULL,
    banco INT NOT NULL
);
