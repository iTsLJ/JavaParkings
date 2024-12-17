-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.40 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para estacionamento
CREATE DATABASE IF NOT EXISTS `estacionamento` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `estacionamento`;

-- Copiando estrutura para tabela estacionamento.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(150) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela estacionamento.cliente: ~13 rows (aproximadamente)
INSERT INTO `cliente` (`ID`, `NOME`) VALUES
	(1, 'Lucas'),
	(2, 'Júlia'),
	(3, 'Anônimo'),
	(4, 'João Pedro'),
	(5, 'Mateus'),
	(6, 'Arthur'),
	(7, 'Davi'),
	(8, 'Cláudio'),
	(9, 'Wilson'),
	(10, 'Carlos'),
	(11, 'Teste'),
	(12, 'Rafaela'),
	(13, 'Anônimo');

-- Copiando estrutura para tabela estacionamento.estacionamento
CREATE TABLE IF NOT EXISTS `estacionamento` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(150) NOT NULL,
  `VAGAS_VIP` int NOT NULL,
  `VAGAS_PCD` int NOT NULL,
  `VAGAS_IDOSOS` int NOT NULL,
  `VAGAS_COMUNS` int NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela estacionamento.estacionamento: ~1 rows (aproximadamente)
INSERT INTO `estacionamento` (`ID`, `NOME`, `VAGAS_VIP`, `VAGAS_PCD`, `VAGAS_IDOSOS`, `VAGAS_COMUNS`) VALUES
	(1, 'LinkPark', 5, 5, 3, 7),
	(2, 'Java Parking', 10, 7, 7, 25);

-- Copiando estrutura para tabela estacionamento.tiquete
CREATE TABLE IF NOT EXISTS `tiquete` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `ID_Estacionamento` int DEFAULT NULL,
  `veiculo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cliente` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `vaga` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tipoDeVaga` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Data` date DEFAULT NULL,
  `horarioDeEntrada` time NOT NULL,
  `horarioDeSaida` time DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `valor` decimal(10,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`codigo`) USING BTREE,
  KEY `fk_estacionamento` (`ID_Estacionamento`),
  CONSTRAINT `fk_estacionamento` FOREIGN KEY (`ID_Estacionamento`) REFERENCES `estacionamento` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela estacionamento.tiquete: ~7 rows (aproximadamente)
INSERT INTO `tiquete` (`codigo`, `ID_Estacionamento`, `veiculo`, `cliente`, `vaga`, `tipoDeVaga`, `Data`, `horarioDeEntrada`, `horarioDeSaida`, `status`, `valor`) VALUES
	(1, 1, 'AAA-0001', 'Lucas', '1', 'VIP', '2024-11-09', '08:09:32', '16:11:29', 0, 60.00),
	(2, 1, 'ABC-1234', 'Lucas', '2', 'VIP', '2024-12-09', '08:10:19', '16:11:32', 0, 60.00),
	(3, 1, 'ABC-1234', 'Lucas', '14', 'COMUM', '2024-12-09', '08:22:16', '16:22:59', 0, 50.00),
	(4, 1, 'CAM-2013', 'Julia', '6', 'PCD', '2024-10-09', '20:19:15', '23:19:39', 0, 41.76),
	(5, 2, 'POO-2024', 'João Pedro', '45', 'COMUM', '2024-10-08', '18:30:52', '19:32:11', 0, 16.00),
	(6, 2, 'POO-2024', 'Joâo Pedro', '21', 'VIP', '2024-12-10', '18:00:14', NULL, 1, NULL),
	(7, 2, 'OPS-6852', 'Arthur', '45', 'COMUM', '2024-12-10', '19:33:21', NULL, 1, NULL);

-- Copiando estrutura para tabela estacionamento.vaga
CREATE TABLE IF NOT EXISTS `vaga` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `TIPO` varchar(20) NOT NULL,
  `OCUPADA` tinyint(1) NOT NULL DEFAULT '0',
  `ESTACIONAMENTO_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ESTACIONAMENTO_ID` (`ESTACIONAMENTO_ID`),
  CONSTRAINT `vaga_fk` FOREIGN KEY (`ESTACIONAMENTO_ID`) REFERENCES `estacionamento` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela estacionamento.vaga: ~69 rows (aproximadamente)
INSERT INTO `vaga` (`ID`, `TIPO`, `OCUPADA`, `ESTACIONAMENTO_ID`) VALUES
	(1, 'VIP', 0, 1),
	(2, 'VIP', 0, 1),
	(3, 'VIP', 0, 1),
	(4, 'VIP', 0, 1),
	(5, 'VIP', 0, 1),
	(6, 'PCD', 0, 1),
	(7, 'PCD', 0, 1),
	(8, 'PCD', 0, 1),
	(9, 'PCD', 0, 1),
	(10, 'PCD', 0, 1),
	(11, 'IDOSOS', 0, 1),
	(12, 'IDOSOS', 0, 1),
	(13, 'IDOSOS', 0, 1),
	(14, 'COMUM', 0, 1),
	(15, 'COMUM', 0, 1),
	(16, 'COMUM', 0, 1),
	(17, 'COMUM', 0, 1),
	(18, 'COMUM', 0, 1),
	(19, 'COMUM', 0, 1),
	(20, 'COMUM', 0, 1),
	(21, 'VIP', 1, 2),
	(22, 'VIP', 0, 2),
	(23, 'VIP', 0, 2),
	(24, 'VIP', 0, 2),
	(25, 'VIP', 0, 2),
	(26, 'VIP', 0, 2),
	(27, 'VIP', 0, 2),
	(28, 'VIP', 0, 2),
	(29, 'VIP', 0, 2),
	(30, 'VIP', 0, 2),
	(31, 'PCD', 0, 2),
	(32, 'PCD', 0, 2),
	(33, 'PCD', 0, 2),
	(34, 'PCD', 0, 2),
	(35, 'PCD', 0, 2),
	(36, 'PCD', 0, 2),
	(37, 'PCD', 0, 2),
	(38, 'IDOSOS', 0, 2),
	(39, 'IDOSOS', 0, 2),
	(40, 'IDOSOS', 0, 2),
	(41, 'IDOSOS', 0, 2),
	(42, 'IDOSOS', 0, 2),
	(43, 'IDOSOS', 0, 2),
	(44, 'IDOSOS', 0, 2),
	(45, 'COMUM', 1, 2),
	(46, 'COMUM', 0, 2),
	(47, 'COMUM', 0, 2),
	(48, 'COMUM', 0, 2),
	(49, 'COMUM', 0, 2),
	(50, 'COMUM', 0, 2),
	(51, 'COMUM', 0, 2),
	(52, 'COMUM', 0, 2),
	(53, 'COMUM', 0, 2),
	(54, 'COMUM', 0, 2),
	(55, 'COMUM', 0, 2),
	(56, 'COMUM', 0, 2),
	(57, 'COMUM', 0, 2),
	(58, 'COMUM', 0, 2),
	(59, 'COMUM', 0, 2),
	(60, 'COMUM', 0, 2),
	(61, 'COMUM', 0, 2),
	(62, 'COMUM', 0, 2),
	(63, 'COMUM', 0, 2),
	(64, 'COMUM', 0, 2),
	(65, 'COMUM', 0, 2),
	(66, 'COMUM', 0, 2),
	(67, 'COMUM', 0, 2),
	(68, 'COMUM', 0, 2),
	(69, 'COMUM', 0, 2);

-- Copiando estrutura para tabela estacionamento.veiculo
CREATE TABLE IF NOT EXISTS `veiculo` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE` int NOT NULL,
  `PLACA` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `PLACA` (`PLACA`),
  KEY `ID_CLIENTE` (`ID_CLIENTE`),
  CONSTRAINT `veiculo_fk` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela estacionamento.veiculo: ~14 rows (aproximadamente)
INSERT INTO `veiculo` (`ID`, `ID_CLIENTE`, `PLACA`) VALUES
	(1, 1, 'ABC-1234'),
	(2, 1, 'AAA-0001'),
	(3, 4, 'RCT-4523'),
	(4, 9, 'TFC-5674'),
	(5, 5, 'IMH-4685'),
	(6, 10, 'OPS-6852'),
	(7, 8, 'ZAD-7485'),
	(8, 8, 'DHB-8264'),
	(9, 11, 'AAA-0000'),
	(10, 12, 'MIN-1045'),
	(11, 2, 'CBA-1234'),
	(12, 2, 'CAM-2013'),
	(13, 1, 'RMV-8020'),
	(14, 4, 'POO-2024');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
