
create database bd_farmaciasOnline;

use  bd_farmaciasOnline;

create table tb_cliente(
id_cliente int auto_increment,
dni varchar(8) not null,
nombres varchar(150) not null,
ape_mat varchar(150) not null,
ape_pat varchar(150) not null,
telefono bigint not null,
PRIMARY KEY(id_cliente)
);

insert into tb_cliente(dni,nombres,ape_mat,ape_pat,telefono) values('12312323','Josias','Carhuas','Ospina','45698752'),
('45452309','Jherson','Pando','Revilla','12589636');

create table tb_farmacia(
id_farmacia int auto_increment,
nombre varchar(150) not null,
ruc varchar(20) null,
telefono int null,
PRIMARY KEY(id_farmacia)
);

insert into tb_farmacia(nombre,ruc,telefono) values('Ciberfarma','1232312','2647172');

create table tb_categoria(
id_categoria int auto_increment,
descripcion varchar(250) not null,
PRIMARY KEY(id_categoria)
);
insert into tb_categoria(descripcion) values('Jarabes');
insert into tb_categoria(descripcion) values('Pastillas');
insert into tb_categoria(descripcion) values('Inyectables');
insert into tb_categoria(descripcion) values('Bebibles');
insert into tb_categoria(descripcion) values('Unguentos');
insert into tb_categoria(descripcion) values('otros');

create table tb_producto(
id_producto int auto_increment,
descripcion varchar(500) not null,
stock int not null,
precio decimal(10,2)  not null,
unidadMed varchar(20) null,
id_categoria int not null references tb_categoria,
PRIMARY KEY(id_producto)
);-- Añadir unidades
insert into tb_producto(descripcion,stock,precio,id_categoria) values
('Limonada Marcos el purgante de rico sabor',5,24.2,4),('Curitas',8,34.2,6),('VipVaporub',2,45.2,5);

create table tb_boleta(
id_boleta int auto_increment,
id_cliente int not null references tb_cliente,
fecha date null,
id_farmacia int not null references tb_farmacia,
total decimal(10,2) null,
PRIMARY KEY(id_boleta)
);

insert into tb_boleta(id_cliente,id_farmacia,fecha) values (1,1,'12/10/20'),(2,1,'27/10/20');

create table tb_detalle_boleta(
id_detalle int not null auto_increment,
id_boleta int not null references tb_boleta,
id_producto int not null references tb_producto,
precio decimal(10,2) not null,
cantidad int not null,
PRIMARY KEY(id_detalle)
);

insert into tb_detalle_boleta(id_boleta,id_producto,precio,cantidad) values (1,1,24.34,5),(1,2,24.34,5);

