CREATE SEQUENCE IF NOT EXISTS usuario_sequence;

CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario integer NOT NULL,
    cod_autorizacao integer,
    cod_pessoa integer,
    data_criacao timestamp,
    email character varying(60),
    login character varying(14),
    nome_usuario character varying(60),
    senha character varying(45),
    status_usuario boolean,
    tempo_expiracao_senha integer,
    CONSTRAINT usuarios_pkey PRIMARY KEY (id_usuario)
);

CREATE SEQUENCE IF NOT EXISTS perfil_sequence;

CREATE TABLE IF NOT EXISTS perfil (
    id_perfil integer NOT NULL,
    nome_perfil character varying(60),
    CONSTRAINT perfil_pkey PRIMARY KEY (id_perfil)
);

CREATE SEQUENCE IF NOT EXISTS aparelho_sequence;

CREATE TABLE IF NOT EXISTS aparelhos(
    id_aparelho integer NOT NULL,
    codigo_aparelho character varying(100),
    descricao_aparelho character varying(15),
    CONSTRAINT aparelhos_pkey PRIMARY KEY (id_aparelho)
); 

CREATE TABLE IF NOT EXISTS usuarios_aparelhos (
    id_usuario integer NOT NULL,
    id_aparelho integer NOT NULL,

    CONSTRAINT usuarios_aparelhos_pkey PRIMARY KEY (id_usuario, id_aparelho),
    CONSTRAINT aparelho_fk FOREIGN KEY (id_aparelho) REFERENCES aparelhos (id_aparelho),
    CONSTRAINT usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario) 
);

CREATE TABLE IF NOT EXISTS usuarios_perfil (
    id_usuario integer NOT NULL,
    id_perfil integer NOT NULL,

    CONSTRAINT usuarios_perfil_pkey PRIMARY KEY (id_usuario, id_perfil),
    CONSTRAINT perfil_fk FOREIGN KEY (id_perfil) REFERENCES perfil (id_perfil),
    
    CONSTRAINT usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario)
);