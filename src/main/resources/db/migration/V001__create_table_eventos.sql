CREATE TABLE IF NOT EXISTS "eventos" (
    "id" BIGSERIAL NOT NULL,
    "tipo" VARCHAR(30) NOT NULL,
    "nome" VARCHAR(100) NOT NULL,
    "data" DATE,
    "descricao" VARCHAR(200) NOT NULL,
    PRIMARY KEY ("id")
);
