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

-- Agregar Clientes**
DELIMITER $$

CREATE PROCEDURE sp_AgregarCliente(IN nom VARCHAR(20),IN ape VARCHAR (20), IN TEL VARCHAR(20), dir VARCHAR(200), nitC VARCHAR(10))
    BEGIN
        INSERT INTO Clientes(nombre, apellido, telefono, direccion, nit)
            VALUES (nom, ape, tel, dir, nitC);
    END$$

DELIMITER ;

call sp_AgregarCliente('Carlos', 'Priego', '10101010', 'Zona1', '1006');
-- Listar: Clientes

DELIMITER $$

CREATE PROCEDURE sp_ListarClientes()
    BEGIN
        SELECT
            Clientes.clienteId,
            Clientes.nombre,
            Clientes.apellido,
            Clientes.telefono,
            Clientes.direccion,
            Clientes.nit
                FROM Clientes;
    END$$
DELIMITER ;

DELIMITER $$

-- Eliminar Clientes
CREATE PROCEDURE sp_EliminarClientes(IN cliId INT)
    BEGIN
        DELETE FROM Clientes
            WHERE clienteid = cliId;
    END$$

DELIMITER ;

-- Buscar Cliente
DELIMITER $$ 
CREATE PROCEDURE sp_BuscarClientes(IN cliId INT)
    BEGIN
        SELECT
            Clientes.clienteId,
            Clientes.nombre,
            Clientes.apellido,
            Clientes.telefono,
            Clientes.direccion,
            Clientes.nit
                FROM Clientes
                    WHERE clienteid = cliId;
    END$$

DELIMITER ;

-- Editar Cliente
DELIMITER $$ 
CREATE PROCEDURE sp_EditarClientes(IN cliId INT, IN nom VARCHAR(20),IN ape VARCHAR (20), IN tel VARCHAR(20), dir VARCHAR(200), nitC VARCHAR(10))
    BEGIN
        UPDATE Clientes
            SET
                nombre = nom,
                apellido = ape,
                telefono = tel,
                direccion = dir,
                nit = nitC
                    Where clienteId = cliId;
    END$$

DELIMITER ;

SET GLOBAL time_zone = '-6:00';