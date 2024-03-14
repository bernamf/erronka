-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-03-2024 a las 11:50:14
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caballero`
--

CREATE TABLE `caballero` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Arma_ID` int(11) DEFAULT NULL,
  `Escudo_ID` int(11) DEFAULT NULL,
  `Experiencia` int(11) NOT NULL,
  `Fuerza` int(11) NOT NULL,
  `Agilidad` int(11) NOT NULL,
  `Inteligencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `caballero`
--

INSERT INTO `caballero` (`ID`, `Nombre`, `Arma_ID`, `Escudo_ID`, `Experiencia`, `Fuerza`, `Agilidad`, `Inteligencia`) VALUES
(1, 'black prior', 2, 7, 5, 6, 7, 5),
(2, 'topuria', 4, 8, 15, 8, 9, 6),
(3, 'shugoki', 7, 1, 10, 4, 5, 2),
(4, 'nobushi', 3, 5, 3, 1, 9, 5),
(5, 'afeera', 1, 6, 18, 6, 2, 2),
(6, 'orochi', 5, 3, 7, 3, 6, 7),
(7, 'warmonger', 6, 2, 7, 9, 3, 1),
(8, 'conqueror', 8, 4, 20, 10, 10, 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `caballero`
--
ALTER TABLE `caballero`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Caballero_Arma` (`Arma_ID`),
  ADD KEY `FK_Caballero_Escudo` (`Escudo_ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `caballero`
--
ALTER TABLE `caballero`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `caballero`
--
ALTER TABLE `caballero`
  ADD CONSTRAINT `FK_Caballero_Arma` FOREIGN KEY (`Arma_ID`) REFERENCES `arma` (`ID`),
  ADD CONSTRAINT `FK_Caballero_Escudo` FOREIGN KEY (`Escudo_ID`) REFERENCES `escudo` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
