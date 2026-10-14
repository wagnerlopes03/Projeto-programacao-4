CREATE TABLE
    categoria (
        id SERIAL PRIMARY KEY,
        Nome VARCHAR(50) NOT NULL UNIQUE
    );

CREATE TABLE
    bonecas (
        id SERIAL PRIMARY KEY,
        nome VARCHAR(255) NOT NULL UNIQUE,
        id_categoria INT NOT NULL,
        FOREIGN KEY (id_categoria) REFERENCES categoria (id),
        link_foto VARCHAR(1000),
        descricao VARCHAR(255) NOT NULL,
        ano INT
    );

CREATE TABLE
    usuario (
        id SERIAL PRIMARY KEY,
        nome VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL UNIQUE,
        id_boneca_fav INT,
        FOREIGN KEY (id_boneca_fav) REFERENCES bonecas (id) ON DELETE SET NULL,
        senha VARCHAR(255) NOT NULL
    );

CREATE TABLE
    noticia (
        id SERIAL PRIMARY KEY,
        id_categoria INT NOT NULL,
        FOREIGN KEY (id_categoria) REFERENCES categoria (id),
        titulo VARCHAR(255) NOT NULL UNIQUE,
        descricao VARCHAR(255) NOT NULL,
        data_publicacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE
    filmes (
        id SERIAL PRIMARY KEY,
        titulo VARCHAR(255) NOT NULL UNIQUE,
        sinopse VARCHAR(255) NOT NULL,
        id_categoria INT,
        FOREIGN KEY (id_categoria) REFERENCES categoria (id),
        ano INT
    );

CREATE TABLE
    wiki_bonecas (
        id SERIAL PRIMARY KEY,
        id_boneca INT NOT NULL,
        FOREIGN KEY (id_boneca) REFERENCES bonecas (id) ON DELETE CASCADE,
        descricao VARCHAR(255) NOT NULL,
        ano INT NOT NULL,
        link_imagem VARCHAR(1000) NOT NULL
    );

CREATE TABLE
    item_colecao (
        id SERIAL PRIMARY KEY,
        id_usuario INTEGER,
        FOREIGN KEY (id_usuario) REFERENCES usuario (id) ON DELETE CASCADE,
        id_boneca INT,
        FOREIGN KEY (id_boneca) REFERENCES bonecas (id),
        UNIQUE (id_usuario, id_boneca)
    );

CREATE TABLE
    posts (
        id SERIAL PRIMARY KEY,
        topico VARCHAR(255) not null,
        descricao VARCHAR(255) not null,
        data_post TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        id_usuario INTEGER,
        FOREIGN KEY (id_usuario) REFERENCES usuario (id) ON DELETE CASCADE
    );

CREATE TABLE
    comentario (
        id SERIAL PRIMARY KEY,
        mensagem VARCHAR(255) not null,
        data_comentario TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        id_usuario INTEGER,
        FOREIGN KEY (id_usuario) REFERENCES usuario (id) ON DELETE CASCADE,
        id_post INTEGER,
        FOREIGN KEY (id_post) REFERENCES posts (id) ON DELETE CASCADE
    );