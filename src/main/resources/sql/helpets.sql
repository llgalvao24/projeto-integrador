create database helpets;

use helpets;

create table perfil(
	id_perfil integer not null auto_increment,
    cpf varchar(14) unique not null,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    endereco varchar(255) not null,
    bairro varchar(255) not null,
    cidade varchar(255) not null,
    estado varchar(255) not null,
    cep varchar(255) not null,
    data_nascimento date not null,
    primary key (id_perfil)
);

create table padrinho(
	id_padrinho integer not null auto_increment,
    fk_perfil integer,
	email varchar(255) unique not null,
    senha varchar(255) not null,
    imagem varchar(510),
    frequencia date,
    primary key (id_padrinho)
);

alter table padrinho
add foreign key (fk_perfil)
references perfil(id_perfil);

create table administrador(
	id_admin integer not null auto_increment,
    fk_perfil integer,
    email varchar(255) unique not null,
    senha varchar(255) not null,
    primary key (id_admin)
);

alter table administrador
add foreign key (fk_perfil)
references perfil(id_perfil);

create table animal(
	id_animal integer not null auto_increment,
    fk_padrinho integer,
    tipo_animal varchar(255) not null,
    nome varchar(255) not null,
    idade integer not null,
    raca varchar(255) not null,
    porte varchar(255) not null,
    cor varchar(255) not null,
    peso decimal(5,2) not null,
    vacinado boolean,
    primary key (id_animal)
);

alter table animal
add foreign key (fk_padrinho)
references padrinho(id_padrinho);

create table doacao(
	id_doacao integer not null auto_increment,
    fk_padrinho integer,
    fk_animal integer,
	racao integer not null,
    banho_tosa integer not null,
    medicamentos_vacina integer not null,
    acessorios integer not null,
    primary key (id_doacao)
);

alter table doacao
add foreign key (fk_padrinho)
references padrinho(id_padrinho);

alter table doacao
add foreign key (fk_animal)
references animal(id_animal);

create table post(
	id_post integer not null auto_increment,
    fk_administrador integer,
    titulo varchar(255),
    texto longtext,
    imagem varchar(510),
    data_post date,
    primary key (id_post)
);

alter table post
add foreign key (fk_administrador)
references administrador(id_admin);

create table comentario(
	id_comentario integer not null auto_increment,
    fk_padrinho integer,
    fk_post integer,
    texto longtext,
    data_hora datetime,
    primary key (id_comentario)
);

alter table comentario
add foreign key (fk_padrinho)
references padrinho(id_padrinho);

alter table comentario
add foreign key (fk_post)
references post(id_post);
