-- Crea la base de datos dbgestor
drop database IF EXISTS dbgestor;
CREATE DATABASE dbgestor;
USE dbgestor;
-- Crea la tabla cliente con varios campos

CREATE TABLE cliente (
  -- ID único para cada cliente, que se autoincrementa
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  edad INT (3) NOT NULL,
  telefono VARCHAR(50) NOT NULL,
  correo VARCHAR(50) NOT NULL,
  direccion VARCHAR(50) NOT NULL,
  -- La fecha de nacimiento se almacena en formato de fecha
  PRIMARY KEY (id) -- Define el ID como clave primaria
);
-- Crea la tabla tareas con varios campos

CREATE TABLE tareas (
    --ID único para cada tarea, que se autoincrementa--
    id INT NOT NULL AUTO_INCREMENT,
    tarea VARCHAR (75) NOT NULL, 
    tipo VARCHAR (50) NOT NULL,
    importancia VARCHAR(50) NOT NULL,
    horario VARCHAR(50) NOT NULL,
    duracion VARCHAR (50) NOT NULL;
);
INSERT INTO cliente (nombre, apellido, telefono, correo, direccion) VALUES
('Juan', 'Pérez', '555-1234', 'juan.perez@example.com', 'Calle Falsa 123'),
('María', 'López', '555-5678', 'maria.lopez@example.com', 'Avenida Siempre Viva 456'),
('Carlos', 'Martínez', '555-9101', 'carlos.martinez@example.com', 'Ruta 78 Km 5'),
('Ana', 'González', '555-1122', 'ana.gonzalez@example.com', 'Boulevard Los Olivos 789'),
('Luis', 'García', '555-3344', 'luis.garcia@example.com', 'Callejón Quito 101'),
('Lucía', 'Fernández', '555-5566', 'lucia.fernandez@example.com', 'Alameda Norte 234'),
('Roberto', 'Hernández', '555-7788', 'roberto.hernandez@example.com', 'Camino Largo 567'),
('Patricia', 'Sánchez', '555-9900', 'patricia.sanchez@example.com', 'Sendero de la Luna 890'),
('Jorge', 'Ramírez', '555-2233', 'jorge.ramirez@example.com', 'Plaza Central 345');

INSERT INTO tareas (tarea, tipo,importancia, horario, duracion) VALUES
('Ejercicio', 'Diario','Recomendable','Mañana/Tarde','2 horas'),
('Lavar el coche','Mensual','No urgente','Mañana/Tarde','1 hora'),
('Hacer la compra','Semanal','Urgente','Mañana/Tarde','2 horas 30 minutos'),
('Hacer los planes de vacaciones','Estacional','Recomendable','Mañana/Tarde','2 horas');
SELECT * FROM tareas;
