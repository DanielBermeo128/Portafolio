-- MariaDB dump 10.19  Distrib 10.11.2-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: admon
-- ------------------------------------------------------
-- Server version	10.11.2-MariaDB
create database ejemplo;
use ejemplo;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `deudas`
--

DROP TABLE IF EXISTS `deudas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deudas` (
  `id_deuda` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT curdate(),
  `monto` int(11) DEFAULT NULL,
  `concepto` varchar(255) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `id_gasto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_deuda`),
  KEY `id_gasto` (`id_gasto`),
  CONSTRAINT `deudas_ibfk_1` FOREIGN KEY (`id_gasto`) REFERENCES `gastos` (`id_gasto`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deudas`
--

LOCK TABLES `deudas` WRITE;
/*!40000 ALTER TABLE `deudas` DISABLE KEYS */;
INSERT INTO `deudas` VALUES
(1,'2024-03-29',1500,'Prueba primera deuda',0,2),
(2,'2024-03-29',2000,'Deuda de prueba',0,3),
(3,'2024-03-29',1000,'Primer pago',0,2),
(4,'2024-03-29',500,'Segundo pago',0,2),
(5,'2024-03-30',1500,'Deuda prueba 1 dia 2',0,3),
(6,'2024-03-30',450,'Segunda prueba dia 2',0,2),
(7,'2024-03-30',500,'Deuda dia 2',0,6);
/*!40000 ALTER TABLE `deudas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fondos`
--

DROP TABLE IF EXISTS `fondos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fondos` (
  `id_fondo` int(11) NOT NULL AUTO_INCREMENT,
  `monto` int(11) DEFAULT NULL,
  `nom_fondo` varchar(255) DEFAULT NULL,
  `capital` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_fondo`),
  UNIQUE KEY `nom_fondo` (`nom_fondo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fondos`
--

LOCK TABLES `fondos` WRITE;
/*!40000 ALTER TABLE `fondos` DISABLE KEYS */;
INSERT INTO `fondos` VALUES
(1,0,'Deuda',0),
(2,1000,'Fondo A',700),
(3,2000,'Fondo B',200),
(4,1500,'Fondo C',2100),
(5,3000,'Fondo D',0),
(6,2500,'Fondo E',0),
(7,1000,'Prueba Creacion de Fondo',1000);
/*!40000 ALTER TABLE `fondos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gastos`
--

DROP TABLE IF EXISTS `gastos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gastos` (
  `id_gasto` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT curdate(),
  `monto` int(11) DEFAULT NULL,
  `concepto` varchar(255) DEFAULT NULL,
  `clasificacion` varchar(50) DEFAULT NULL,
  `fondo_tomado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_gasto`),
  KEY `fondo_tomado` (`fondo_tomado`),
  CONSTRAINT `gastos_ibfk_1` FOREIGN KEY (`fondo_tomado`) REFERENCES `fondos` (`id_fondo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gastos`
--

LOCK TABLES `gastos` WRITE;
/*!40000 ALTER TABLE `gastos` DISABLE KEYS */;
INSERT INTO `gastos` VALUES
(1,'2024-03-29',150,'Primer Gasto','Bueno',2),
(2,'2024-03-29',1500,'Prueba de gasto con Deuda','Necesario',1),
(3,'2024-03-29',2000,'Deuda para filtro','Innecesario',1),
(4,'2024-03-30',150,'Gasto prueba','Bueno',2),
(5,'2024-03-30',1000,'Gaso 2','Innecesario',3),
(6,'2024-03-30',500,'Prueba 1 deuda dia 2','Necesario',1);
/*!40000 ALTER TABLE `gastos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresos`
--

DROP TABLE IF EXISTS `ingresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingresos` (
  `id_ingreso` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT curdate(),
  `monto` int(11) DEFAULT NULL,
  `concepto` varchar(255) DEFAULT NULL,
  `fondo_destino` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ingreso`),
  KEY `fondo_destino` (`fondo_destino`),
  CONSTRAINT `ingresos_ibfk_1` FOREIGN KEY (`fondo_destino`) REFERENCES `fondos` (`id_fondo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresos`
--

LOCK TABLES `ingresos` WRITE;
/*!40000 ALTER TABLE `ingresos` DISABLE KEYS */;
INSERT INTO `ingresos` VALUES
(1,'2024-03-29',1000,'Ingreso Prueba 1',2),
(2,'2024-03-29',500,'Ingreso Prueba 2',4),
(3,'2024-03-29',500,'Prueba Ingreso',4),
(4,'2024-03-29',-500,'Primer pago',1),
(5,'2024-03-29',-500,'Segundo pago',1),
(6,'2024-03-30',-500,'Deuda prueba 1 dia 2',1),
(7,'2024-03-30',-50,'Segunda prueba dia 2',1),
(8,'2024-03-30',500,'Nuevo ingreso',7),
(9,'2024-03-30',1000,'Nuevo Ingreso 2',4),
(10,'2024-03-30',1000,'Nuevo ingreso 2',3),
(11,'2024-03-30',-450,'Eliminar Deuda con nuevo metodo',1),
(12,'2024-03-31',-1500,'checar influencia de deuda en estabilidad',1),
(13,'2024-03-31',-500,'Habia 7000 en estabilidad',1);
/*!40000 ALTER TABLE `ingresos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-31  9:15:16
