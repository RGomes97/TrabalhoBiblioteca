create database trabalhoBiblioteca;

use trabalhoBiblioteca;

create table tipo_usuario (
	id int auto_increment primary key,
	nome varchar(255) not null
);
insert into tipo_usuario (nome) values ('Aluno'),('Funcionario'),('Professor');

create table permissoes (
	id int auto_increment primary key,
	permissao varchar(255) not null
);

create table usuarios (
	id int auto_increment primary key,
	ra varchar(10) not null,
	nome varchar(255) not null,
	email varchar(255) not null,
	tipo_usuario_id int not null,
	senha varchar(255) not null,
	permissao_id int not null,
	constraint fk_tipo_usuario foreign key (tipo_usuario_id) references tipo_usuario(id),
	constraint fk_permissao foreign key (permissao_id) references permissoes(id)
);

insert into usuarios (nome,email,tipo_usuario_id,senha,ra,permissao_id) values
	("Cleber Fernandes","cleber@cleber",1,"cleber","1600763",2),
	("Amanda Nuds","nuds@nuds",1,"amanda","1600763",2),
	("Fabio Asker","fabio@fabio",1,"fabio","1600763",1),
	("Rubens Agostinho","ruby@ruby",1,"rubens","1600763",1),
	("William Tiririca","tiri@tiri",1,"tiririca","1600763",0),
	("Fernando Alecrim","ale@ale",1,"alecrim","1600763",0);
	

	
	
	
//Não executar o codigo abaixo na criação do banco, não está pronto




create table tipo_produto (
	id int auto_increment primary key,
	nome varchar(255) not null
);

create table assuntos (
	in int auto_increment primary key,
	nome varchar(255) not null
);

create table autores (
	id int auto_increment primary key,
	nome varchar(255) not null,
);

create table produtos (
	id int auto_increment primary key,
	tipo_produto_id int not null,
	assunto_id int not null,
	autor_id int not null,
	isbn_issn int null,
	ano int,
	n_chamada varchar(255), not null,
	titulo varchar(255) not null,
	editora varchar(255),
	serie varchar(255),
	descricao varchar(255),
	
);

create table pedidos (
	id int auto_increment primary key,	
);
create table item_pedidos (
	id int auto_increment primary key,	
);
create table multas (
	id int auto_increment primary key,	
);
