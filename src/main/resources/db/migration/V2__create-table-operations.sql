CREATE TABLE operations (
    id_operacao SERIAL PRIMARY KEY NOT NULL UNIQUE,
    id_item TEXT NOT NULL,
    tipo VARCHAR(30) NOT NULL CHECK (tipo IN ('entrada', 'saida', 'ajuste')),
    data_hora_operacao TIMESTAMP NOT NULL,
    destino TEXT NOT NULL,
    observacao TEXT NOT NULL,
    FOREIGN KEY (id_item) REFERENCES items(id)
 );