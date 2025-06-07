-- Base de datos
CREATE DATABASE IF NOT EXISTS lab7db;
USE lab7db;

-- Tabla proveedor
CREATE TABLE proveedor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    razon_social VARCHAR(100) NOT NULL,
    nombre_comercial VARCHAR(100) NOT NULL,
    ruc CHAR(11) NOT NULL UNIQUE,
    telefono VARCHAR(20),
    correo_electronico VARCHAR(100),
    sitio_web VARCHAR(255),
    direccion_fisica VARCHAR(150),
    pais VARCHAR(100),
    representante_legal VARCHAR(100),
    dni_representante_legal VARCHAR(20),
    tipo_proveedor ENUM('Nacional', 'Internacional'),
    categoria ENUM('Servicios', 'Productos', 'Tecnología', 'Otros'),
    facturacion_anual_dolares DECIMAL(15,2),
    fecha_registro DATETIME,
    ultima_actualizacion DATETIME,
    estado BOOLEAN
);
