-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-02-2024 a las 22:24:19
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
-- Base de datos: `agency`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `booking_hosts`
--

CREATE TABLE `booking_hosts` (
  `booking_id` bigint(20) NOT NULL,
  `person_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `booking_hosts`
--

INSERT INTO `booking_hosts` (`booking_id`, `person_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `booking_passengers`
--

CREATE TABLE `booking_passengers` (
  `booking_id` bigint(20) NOT NULL,
  `person_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `booking_passengers`
--

INSERT INTO `booking_passengers` (`booking_id`, `person_id`) VALUES
(1, 1),
(1, 5),
(1, 7),
(2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flight`
--

CREATE TABLE `flight` (
  `flight_code` varchar(255) NOT NULL,
  `departure_date` date DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `price_per_person` double DEFAULT NULL,
  `seat_type` varchar(255) DEFAULT NULL,
  `plane_code` bigint(20) DEFAULT NULL,
  `capacity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `flight`
--

INSERT INTO `flight` (`flight_code`, `departure_date`, `destination`, `origin`, `price_per_person`, `seat_type`, `plane_code`, `capacity`) VALUES
('MACI8157', '2024-05-30', 'Ciudad de Mexico', 'Madrid', 1200, 'Tourist', 1, 365),
('SEBI7692', '2024-10-14', 'Bilbao', 'Sevilla', 250, 'Tourist', 5, 177),
('VAES9786', '2024-05-30', 'Estambul', 'Varsovia', 400, 'Tourist', 4, 189);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `flight_booking`
--

CREATE TABLE `flight_booking` (
  `id` bigint(20) NOT NULL,
  `departure_date` date DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `peopleq` int(11) NOT NULL,
  `seat_type` varchar(255) DEFAULT NULL,
  `flight_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `flight_booking`
--

INSERT INTO `flight_booking` (`id`, `departure_date`, `destination`, `origin`, `peopleq`, `seat_type`, `flight_id`) VALUES
(1, '2024-10-14', 'Bilbao', 'Sevilla', 3, 'Tourist', 'SEBI7692'),
(2, '2024-05-30', 'Ciudad de Mexico', 'Madrid', 1, 'Tourist', 'MACI8157');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hotel`
--

CREATE TABLE `hotel` (
  `hotel_code` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `hotel`
--

INSERT INTO `hotel` (`hotel_code`, `name`, `place`) VALUES
('HOT-001', 'NH Valencia', 'Valencia'),
('HOT-002', 'Hotel Madrid', 'Madrid'),
('HOT-004', 'Hotel Barcelo', 'Huelva'),
('HUE-002', 'NH HUELVA', 'Huelva'),
('SEV-001', 'Alfonso XIII', 'Sevilla');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE `person` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `person`
--

INSERT INTO `person` (`id`, `email`, `name`) VALUES
(1, 'alfonso@gmail.com', 'Alfonso'),
(4, 'florentino@madrid.com', 'Florentino Perez'),
(5, 'igor@gmail.com', 'Igor'),
(7, 'alvaro@gmail.com', 'Alvaro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plane`
--

CREATE TABLE `plane` (
  `plane_id` bigint(20) NOT NULL,
  `business_capacity` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `model` varchar(255) DEFAULT NULL,
  `tourist_capacity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `plane`
--

INSERT INTO `plane` (`plane_id`, `business_capacity`, `capacity`, `model`, `tourist_capacity`) VALUES
(1, 116, 366, 'Boeing 747', 250),
(4, 29, 189, 'Boeing 737-800', 160),
(5, 30, 180, 'Airbus A320', 150);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room`
--

CREATE TABLE `room` (
  `room_id` varchar(255) NOT NULL,
  `night_price` double DEFAULT NULL,
  `room_number` bigint(20) DEFAULT NULL,
  `room_type` varchar(255) DEFAULT NULL,
  `hotel_code` varchar(255) DEFAULT NULL,
  `room_size` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `room`
--

INSERT INTO `room` (`room_id`, `night_price`, `room_number`, `room_type`, `hotel_code`, `room_size`) VALUES
('HOT-001-1', 100, 1, 'Single', 'HOT-001', 1),
('HOT-001-2', 150, 2, 'Double', 'HOT-001', 2),
('HOT-001-3', 250, 3, 'Suite', 'HOT-001', 2),
('HOT-002-1', 180, 1, 'Double', 'HOT-002', 2),
('HOT-002-2', 120, 2, 'Single', 'HOT-002', 1),
('HOT-002-7', 280, 7, 'Family', 'HOT-002', 5),
('HOT-004-1', 200, 1, 'Single', 'HOT-004', 1),
('HOT-004-2', 400, 2, 'Double', 'HOT-004', 2),
('HOT-004-3', 850, 3, 'Suite', 'HOT-004', 2),
('HUE-002-10', 50, 10, 'Double', 'HUE-002', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room_booking`
--

CREATE TABLE `room_booking` (
  `id` bigint(20) NOT NULL,
  `check_in` date DEFAULT NULL,
  `check_out` date DEFAULT NULL,
  `nights` bigint(20) DEFAULT NULL,
  `peopleq` int(11) NOT NULL,
  `room_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `room_booking`
--

INSERT INTO `room_booking` (`id`, `check_in`, `check_out`, `nights`, `peopleq`, `room_id`) VALUES
(1, '2024-07-10', '2024-07-17', 7, 1, 'HOT-004-3');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `booking_hosts`
--
ALTER TABLE `booking_hosts`
  ADD KEY `FKf7spyq83wodl820modfx1tw4o` (`booking_id`),
  ADD KEY `FKgy1kkhlp59u0x6dif262qukw1` (`person_id`);

--
-- Indices de la tabla `booking_passengers`
--
ALTER TABLE `booking_passengers`
  ADD KEY `FKjcws5gr10frd9026vix7gjye5` (`person_id`),
  ADD KEY `FKf22bb7pgkb61387504dj728lb` (`booking_id`);

--
-- Indices de la tabla `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`flight_code`),
  ADD KEY `FKnt2vtisytq56u30bp56d3uwsv` (`plane_code`);

--
-- Indices de la tabla `flight_booking`
--
ALTER TABLE `flight_booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3uiklmjy1d7ba6rrjp6iq08kq` (`flight_id`);

--
-- Indices de la tabla `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`hotel_code`);

--
-- Indices de la tabla `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `plane`
--
ALTER TABLE `plane`
  ADD PRIMARY KEY (`plane_id`);

--
-- Indices de la tabla `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`room_id`),
  ADD KEY `FK52stjyn379yiqc4od3rie9f9a` (`hotel_code`);

--
-- Indices de la tabla `room_booking`
--
ALTER TABLE `room_booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiwt0ws97ta91ukd4xonewjbxl` (`room_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `flight_booking`
--
ALTER TABLE `flight_booking`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `plane`
--
ALTER TABLE `plane`
  MODIFY `plane_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `room_booking`
--
ALTER TABLE `room_booking`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `booking_hosts`
--
ALTER TABLE `booking_hosts`
  ADD CONSTRAINT `FKf7spyq83wodl820modfx1tw4o` FOREIGN KEY (`booking_id`) REFERENCES `room_booking` (`id`),
  ADD CONSTRAINT `FKgy1kkhlp59u0x6dif262qukw1` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

--
-- Filtros para la tabla `booking_passengers`
--
ALTER TABLE `booking_passengers`
  ADD CONSTRAINT `FKf22bb7pgkb61387504dj728lb` FOREIGN KEY (`booking_id`) REFERENCES `flight_booking` (`id`),
  ADD CONSTRAINT `FKjcws5gr10frd9026vix7gjye5` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

--
-- Filtros para la tabla `flight`
--
ALTER TABLE `flight`
  ADD CONSTRAINT `FKnt2vtisytq56u30bp56d3uwsv` FOREIGN KEY (`plane_code`) REFERENCES `plane` (`plane_id`);

--
-- Filtros para la tabla `flight_booking`
--
ALTER TABLE `flight_booking`
  ADD CONSTRAINT `FK3uiklmjy1d7ba6rrjp6iq08kq` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`flight_code`);

--
-- Filtros para la tabla `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `FK52stjyn379yiqc4od3rie9f9a` FOREIGN KEY (`hotel_code`) REFERENCES `hotel` (`hotel_code`);

--
-- Filtros para la tabla `room_booking`
--
ALTER TABLE `room_booking`
  ADD CONSTRAINT `FKiwt0ws97ta91ukd4xonewjbxl` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
