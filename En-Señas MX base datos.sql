-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-10-2019 a las 04:04:28
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `lsm`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `abecedario`
--

CREATE TABLE `abecedario` (
  `id` int(10) NOT NULL,
  `ejemplo` varchar(255) NOT NULL,
  `imagen` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `abecedario`
--

INSERT INTO `abecedario` (`id`, `ejemplo`, `imagen`) VALUES
(1, 'Aa', 'Aa'),
(2, 'Bb', 'Bb'),
(3, 'Cc', 'Cc'),
(4, 'Dd', 'Dd'),
(5, 'Ee', 'Ee'),
(6, 'Ff', 'Ff'),
(7, 'Gg', 'Gg'),
(8, 'Hh', 'Hh'),
(9, 'Ii', 'Ii'),
(10, 'Jj', 'Jj'),
(11, 'Kk', 'Kk'),
(12, 'Ll', 'Ll'),
(13, 'Mm', 'Mm'),
(14, 'Nn', 'Nn'),
(15, 'Ññ', 'Ññ'),
(16, 'Oo', 'Oo'),
(17, 'Pp', 'Pp'),
(18, 'Qq', 'Qq'),
(19, 'Rr', 'Rr'),
(20, 'Ss', 'Ss'),
(21, 'Tt', 'Tt'),
(22, 'Uu', 'Uu'),
(23, 'Vv', 'Vv'),
(24, 'Ww', 'Ww'),
(25, 'Xx', 'Xx'),
(26, 'Yy', 'Yy'),
(27, 'Zz', 'Zz');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `animales`
--

CREATE TABLE `animales` (
  `id` int(11) NOT NULL,
  `ejemplo` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `animales`
--

INSERT INTO `animales` (`id`, `ejemplo`, `imagen`) VALUES
(1, 'Jaguar', 'Jaguar'),
(2, 'Gato', 'gato'),
(3, 'Víbora', 'vibora');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colores`
--

CREATE TABLE `colores` (
  `id` int(11) NOT NULL,
  `ejemplo` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `colores`
--

INSERT INTO `colores` (`id`, `ejemplo`, `imagen`) VALUES
(1, 'Rojo', 'Rojo'),
(2, 'Azul', 'Azul');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `desbloqueo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`id`, `nombre`, `desbloqueo`) VALUES
(1, 'Abecedario', 0),
(2, 'Saludos', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `frases`
--

CREATE TABLE `frases` (
  `id` int(11) NOT NULL,
  `ejemplo` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `frases`
--

INSERT INTO `frases` (`id`, `ejemplo`, `imagen`) VALUES
(1, '¿Cómo estás?', 'como estas'),
(2, '¡Qué genial!', 'quegenial'),
(3, '¡Saludos a todos!', 'saludostodos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugares`
--

CREATE TABLE `lugares` (
  `id` int(11) NOT NULL,
  `ejemplo` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `lugares`
--

INSERT INTO `lugares` (`id`, `ejemplo`, `imagen`) VALUES
(1, 'Aguascalientes', 'Aguascalientes'),
(2, 'Monterrey', 'Monterrey'),
(3, 'México', 'México');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `id_pregunta` int(11) NOT NULL,
  `curso` int(11) NOT NULL,
  `pregunta` varchar(255) NOT NULL,
  `r1` varchar(255) NOT NULL,
  `r2` varchar(255) NOT NULL,
  `r3` varchar(255) NOT NULL,
  `rc` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`id_pregunta`, `curso`, `pregunta`, `r1`, `r2`, `r3`, `rc`) VALUES
(1, 1, '1. ¿Cómo se muestra la letra \"o\" en LSM?', 'a', 'g', 'o', '3'),
(2, 1, '2. ¿Cómo se representa la letra H en LSM?', 'h', 't', 'y', '1'),
(3, 1, '3. ¿Cómo se representa la letra K en la LSM?', 'e', 'k', 'z', '2'),
(4, 2, '1. ¿Cómo se dice Hola en LSM?', 'hola', 'adios', 'quechido', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `saludos`
--

CREATE TABLE `saludos` (
  `id` int(11) NOT NULL,
  `ejemplo` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `saludos`
--

INSERT INTO `saludos` (`id`, `ejemplo`, `imagen`) VALUES
(1, 'Hola', 'salud'),
(2, '¡Te Quiero!', 'tequiero'),
(3, '¡Qué onda!', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Id` int(12) NOT NULL,
  `Nombre` text NOT NULL,
  `Apellido` text NOT NULL,
  `Correo` text NOT NULL,
  `Contraseña` text NOT NULL,
  `Nivel` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Id`, `Nombre`, `Apellido`, `Correo`, `Contraseña`, `Nivel`) VALUES
(1, 'lalo', 'davila', 'e', '1', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `abecedario`
--
ALTER TABLE `abecedario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `animales`
--
ALTER TABLE `animales`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `colores`
--
ALTER TABLE `colores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `frases`
--
ALTER TABLE `frases`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `lugares`
--
ALTER TABLE `lugares`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`id_pregunta`),
  ADD KEY `curso` (`curso`);

--
-- Indices de la tabla `saludos`
--
ALTER TABLE `saludos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `abecedario`
--
ALTER TABLE `abecedario`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `animales`
--
ALTER TABLE `animales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `colores`
--
ALTER TABLE `colores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cursos`
--
ALTER TABLE `cursos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `frases`
--
ALTER TABLE `frases`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `lugares`
--
ALTER TABLE `lugares`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `id_pregunta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `saludos`
--
ALTER TABLE `saludos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `Id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD CONSTRAINT `preguntas_ibfk_1` FOREIGN KEY (`curso`) REFERENCES `cursos` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
