-- Eliminar la base de datos AdMon si existe
DROP DATABASE IF EXISTS AdMon1;

-- Crear la base de datos AdMon
CREATE DATABASE AdMon1;

-- Usar la base de datos AdMon
USE AdMon1;

-- Crear la tabla fondos
CREATE TABLE fondos (
    id_fondo INT AUTO_INCREMENT PRIMARY KEY,
    monto INT,
    nom_fondo VARCHAR(255) UNIQUE,
    capital INT
);

-- Crear la tabla ingresos
CREATE TABLE ingresos (
    id_ingreso INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE  DEFAULT CURRENT_DATE,
    monto INT,
    concepto VARCHAR(255),
    fondo_destino INT,
    FOREIGN KEY (fondo_destino) REFERENCES fondos(id_fondo)
);

-- Crear la tabla gastos
CREATE TABLE gastos (
    id_gasto INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE  DEFAULT CURRENT_DATE,
    monto INT,
    concepto VARCHAR(255),
    clasificacion VARCHAR(50),
    fondo_tomado INT,
    FOREIGN KEY (fondo_tomado) REFERENCES fondos(id_fondo)
);


-- Crear la tabla deudas
CREATE TABLE deudas (
    id_deuda INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE DEFAULT CURRENT_DATE,
    monto INT,
    concepto VARCHAR(255),
    estado BOOLEAN,
    id_gasto INT,
    FOREIGN KEY (id_gasto) REFERENCES gastos(id_gasto)		
);

-- Insercion de configuracion de Deuda
INSERT INTO fondos (monto, nom_fondo, capital)
VALUES 
    (0, 'Deuda', 0);

-- Insertar 5 fondos aleatorios
INSERT INTO fondos (monto, nom_fondo, capital)
VALUES 
    (1000, 'Fondo A', 0),
    (2000, 'Fondo B', 200),
    (1500, 'Fondo C', 100),
    (3000, 'Fondo D', 0),
    (2500, 'Fondo E', 0);

mysqldump -u root -p admon > AdmonSemiCargadaAprueba.sql