CREATE TABLE items (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    descricao TEXT NOT NULL,
    disponiveis INT NOT NULL,
    categoria TEXT NOT NULL
);