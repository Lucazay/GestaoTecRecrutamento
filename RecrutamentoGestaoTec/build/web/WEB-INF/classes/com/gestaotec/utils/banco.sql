/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Acer
 * Created: 27/05/2022
 */

create table marca(
	idmarca serial primary key,
	descricao varchar(50) not null,
	situacao varchar(1)
);

create table produto(
	idproduto serial primary key,
	descricao varchar(50) not null,
	dataValidade date,
	idmarca int not null,
	constraint fk_marca foreign key (idmarca) references marca(idmarca)
);

insert into marca (descricao,situacao)values ('teste','A');
insert into produto (descricao,dataValidade,idmarca)values('teste2','2021-05-27',1);