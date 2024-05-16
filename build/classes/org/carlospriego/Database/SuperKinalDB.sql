-- DROP DATABASE IF EXISTS SuperKinalDB;

CREATE DATABASE if not exists SuperKinalDB;

USE SuperKinalDB;

CREATE TABLE Clientes(
    clienteId INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    nit Varchar(10) NOT NULL,
    PRIMARY KEY PK_clienteId (clienteId)
);

create table Cargos(
	cargoId int not null auto_increment,
    nombreCargo varchar(30) not null,
    descripcionCargo varchar(100) not null,
    
    primary key PK_cargoId (cargoId)
);

create table Compras (
	compraId int not null auto_increment,
    fechaCompra date not null,
    totalCompra decimal (10,2),
    
    primary key PK_compraId(compraId)
);

create table CategoriaProductos(
	categoriaProductoId int  not null auto_increment,
    nombreCategoria varchar(30) not null,
    descripcionCategoria varchar(100) not null,
    
    primary key PK_categoriaProductoId(categoriaProductoId)
);

create table Distribuidores(
	distribuidorId int not null auto_increment,
    nombreDistribuidor varchar (30)  not null,
    direccionDistribuidor varchar (200) not null,
    nitDistribuidor varchar (15) not null,
    telefonoDistribuidor varchar(15) not null,
    web varchar (50),
    
    primary key PK_distribuidorId(distribuidorId)
);

create table Productos(
	productoId int not null auto_increment,
    nombreProducto varchar(50) not null,
    descripcionProducto varchar(100) ,
    cantidadStock int not null,
    precioVentaUnitario decimal (10,2) not null,
    precioVentaMayor decimal(10,2) not null,
    precioCompra decimal(10,2) not null,
-- BloB 
	distribuidorId int not null,
	categoriaProductoId int not null,
    
    primary key PK_productoId(productoId),
	constraint FK_Productos_Distribuidores foreign key Productos(distribuidorId)
		references Distribuidores(distribuidorId),
	constraint FK_Productos_CategoriaProductos foreign key Productos(categoriaProductoId)
		references CategoriaProductos(categoriaProductoId)
);

create table DetallesCompras(
	detalleCompraId int not null auto_increment,
    cantidadCompra int not null,
    productoId int not null,
    compraId int not null,
    
    primary key PK_detalleCompraId(detalleCompraId),
    constraint FK_DetallesCompras_Productos foreign key DetallesCompras(productoId)
		references Productos(productoId),
    constraint FK_DetallesCompras_Compras foreign key DetallesCompras(compraId)
		references Compras(compraId)
    
);

create table Promociones(
	promocionId int not null auto_increment,
    precioPromocion decimal(10,2)not null,
    descripcionPromocion varchar(1000),
	fechaInicio date not null,
    fechaFinalizacion date not null,
    productoId int not null,
    
    primary key PK_promocionId(promocionId),
    constraint FK_Promociones_Productos foreign key Promociones(productoId)
		references Productos(productoId)
);

create table Empleados(
	empleadoId int not null auto_increment,
    nombreEmpleado varchar(30) not null,
    apellidoEmpleado varchar (30) not null,
    sueldo decimal (10,2) not null,
    horaEntrada time not null,
    horaSalida time not null,
    cargoId int not null,
    encargadoId int,
    
    primary key PK_Empleados(empleadoId),
    constraint FK_Empleados_Cargos foreign key Empleados(cargoId)
		references Cargos(cargoId),
	constraint FK_encargadoId foreign key Empleados(encargadoId)
		references Empleados(empleadoId)

);

create table Facturas(
	facturaId int not null auto_increment,
    fecha time not null,
    hora time not null,
    clienteId int not null,
	empleadoId int not null,
    total decimal (10,2),
    
    primary key PK_Facturas(facturaId),
    constraint FK_Facturas_Clientes foreign key Facturas(clienteId)
		references Clientes (clienteId),
	constraint PK_Facturas_Empleados foreign key Facturas(empleadoId)
		references Empleados(empleadoId)
);

create table DetallesFacturas(
	detalleFacturaId int not null auto_increment,
    facturaId int not null,
    productoId int not null,
    
    primary key PK_detalleFacturaId(detalleFacturaId),
    constraint FK_DetallesFacturas_Facturas foreign key DetallesFacturas(facturaId)
		references Facturas(facturaId),
	constraint FK_DetallesFacturas_Productos foreign key DetallesFacturas(productoId)
		references Productos(productoId)
);

create table TicketsSoportes(
	ticketSoporteId int not null auto_increment,
    descripcionTicket varchar(250) not null,
    estatus varchar (30) not null,
    clienteId int not null,
    facturaId int null,
    
	primary key PK_TicketsSoportes(ticketSoporteId),
    constraint FK_TicketsSoportes_Clientes foreign key TicketsSoportes(clienteId)
		references Clientes(clienteId),
	constraint FK_TicketsSoportes_Facturas foreign key TicketsSoportes(facturaId)
		references Facturas(facturaId)
	
);

SET GLOBAL time_zone = '-6:00';