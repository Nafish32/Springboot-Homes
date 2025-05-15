-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2024 at 03:56 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `homes_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--
CREATE DATABASE `homes_db`;


USE `homes_db`;


CREATE TABLE `booking` (
  `id` bigint(20) NOT NULL,
  `booking_time` datetime(6) DEFAULT NULL,
  `guest_contact_number` varchar(255) DEFAULT NULL,
  `guestnid` varchar(255) DEFAULT NULL,
  `guest_name` varchar(255) DEFAULT NULL,
  `hotel_id` bigint(20) DEFAULT NULL,
  `booking_date` varchar(255) DEFAULT NULL,
  `guest_nid` varchar(255) DEFAULT NULL,
  `one_person_rooms` int(11) NOT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `total_amount` double NOT NULL,
  `two_person_rooms` int(11) NOT NULL,
  `check_in_date` datetime(6) DEFAULT NULL,
  `check_out_date` datetime(6) DEFAULT NULL,
  `status` enum('CANCELLED','COMPLETED','CONFIRMED','PENDING') DEFAULT NULL,
  `three_person_rooms` int(11) NOT NULL,
  `vip_suites` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `number_of_rooms` int(11) NOT NULL,
  `total_price` double NOT NULL,
  `days` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `booking_details`
--

CREATE TABLE `booking_details` (
  `id` bigint(20) NOT NULL,
  `days` int(11) DEFAULT NULL,
  `guest_contact_number` varchar(255) DEFAULT NULL,
  `guest_email` varchar(255) DEFAULT NULL,
  `guest_full_name` varchar(255) DEFAULT NULL,
  `guestnid` varchar(255) DEFAULT NULL,
  `hotel_id` bigint(20) DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `total_price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking_details`
--

INSERT INTO `booking_details` (`id`, `days`, `guest_contact_number`, `guest_email`, `guest_full_name`, `guestnid`, `hotel_id`, `payment_method`, `total_price`) VALUES
(11, 1, '01884531301', 'nafishimtiazimti@gmail.com', 'Nafish Imtiaz Imti', '02103103', 11, 'cash', 3998),
(23, 1, '01884531301', 'nafishimtiazimti@gmail.com', 'Nafish Imtiaz Imti', '0242310005101930', 11, 'credit_card', 3998),
(26, 1, '01884531301', 'nafishimtiazimti@gmail.com', 'Nafish Imtiaz Imti', '0210312123', 11, 'cash', 8896),
(27, 1, '01884531301', 'nafishimtiazimti@gmail.com', 'Nafish Imtiaz Imti', '0210312123', 11, 'cash', 8896),
(28, 1, '01751540311', 'talimafrid.net@gmail.com', 'Talim Afrid Tomal', '192012', 12, 'credit_card', 31500),
(29, 1, '01751540311', 'talimafrid.net@gmail.com', 'Talim Afrid Tomal', '192012', 12, 'cash', 31500),
(30, 2, '01765982774', 'aliadnan82835@gmail.com', 'adnan', '123456789', 11, 'cash', 1398),
(31, 2, '01402881433', 'ghosh23105101295@diu.edu.bd', 'Ovik Ghosh', '031231232', 24, 'cash', 17922),
(32, 2, '015215469765', 'mailofrajarshi@gmail.com', 'Rajarshi Golder', '3452367868', 13, 'cash', 1200);

-- --------------------------------------------------------

--
-- Table structure for table `booking_details_room_counts`
--

CREATE TABLE `booking_details_room_counts` (
  `booking_details_id` bigint(20) NOT NULL,
  `room_counts` int(11) DEFAULT NULL,
  `room_counts_key` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `booking_room_counts`
--

CREATE TABLE `booking_room_counts` (
  `booking_id` bigint(20) NOT NULL,
  `room_count` int(11) DEFAULT NULL,
  `room_type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `id` bigint(20) NOT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `room_options` varchar(255) DEFAULT NULL,
  `category` int(11) DEFAULT 1,
  `four_person_room_cost` decimal(38,2) DEFAULT NULL,
  `four_person_room_count` int(11) NOT NULL,
  `four_person_room_description` varchar(255) DEFAULT NULL,
  `general_description` longtext DEFAULT NULL,
  `one_person_room_cost` decimal(38,2) DEFAULT NULL,
  `one_person_room_count` int(11) NOT NULL,
  `one_person_room_description` varchar(255) DEFAULT NULL,
  `three_person_room_cost` decimal(38,2) DEFAULT NULL,
  `three_person_room_count` int(11) NOT NULL,
  `three_person_room_description` varchar(255) DEFAULT NULL,
  `two_person_room_cost` decimal(38,2) DEFAULT NULL,
  `two_person_room_count` int(11) NOT NULL,
  `two_person_room_description` varchar(255) DEFAULT NULL,
  `vip_suite_cost` decimal(38,2) DEFAULT NULL,
  `vip_suite_count` int(11) NOT NULL,
  `vip_suite_description` varchar(255) DEFAULT NULL,
  `hotel_category` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`id`, `contact_number`, `image_path`, `location`, `name`, `rating`, `description`, `room_options`, `category`, `four_person_room_cost`, `four_person_room_count`, `four_person_room_description`, `general_description`, `one_person_room_cost`, `one_person_room_count`, `one_person_room_description`, `three_person_room_cost`, `three_person_room_count`, `three_person_room_description`, `two_person_room_cost`, `two_person_room_count`, `two_person_room_description`, `vip_suite_cost`, `vip_suite_count`, `vip_suite_description`, `hotel_category`) VALUES
(11, '01712-247349', NULL, 'Plot # 40, Block # C, Kolatoli, Cox\'s Bazar, 4700 Cox\'s Bazar, Bangladesh', 'Hotel Windy Terrace', 4, NULL, NULL, 1, 1700.00, 20, '2 double bed, two washroom, two balcony', 'Hotel Windy Terrace is located in Cox\'s Bazar. It offers room service and a restaurant. The property also has a terrace, free Wi-Fi, and free private parking.\r\n', 699.00, 19, 'single bed, attached bathroom, one balcony ', 1499.00, 30, 'one double bed, one single bed, one common washroom, two balcony', 1000.00, 30, 'Two single bed, one common washroom, one balcony', 3998.00, 10, 'one master bed, sea view, one balcony, TV ', 4),
(12, '01712-247349', NULL, 'Sea Beach Road, Laboni Point, Hotel Motel Zone, Cox\'s Bazar, 4700 Cox\'s Bazar, Bangladesh', 'Hotel Sea World Cox\'s Bazar', 5, NULL, NULL, 1, 12499.00, 33, 'm', 'Hotel Sea World Cox\'s Bazar is located on the beachfront in Cox\'s Bazar, 200 meters from Cox\'s Bazar Sea Beach. This 3-star hotel offers room service, a 24-hour front desk, and free WiFi. A restaurant serving Chinese cuisine is also on site, and free private parking is available.\r\nThe hotel\'s guest rooms include a seating area and a TV. Each has a private bathroom with a shower and slippers, and certain rooms at Hotel Sea World Cox\'s Bazar also offer a balcony.\r\n', 3500.00, 24, 'm', 11200.00, 15, 'm', 10799.00, 25, 'm', 99999.00, 9, 'm', 5),
(13, '01721-247349', NULL, 'Laboni Beach Rd, 4700 Cox\'s Bazar, Bangladesh', 'Hotel Mishuk', 2, NULL, NULL, 1, 1600.00, 8, 'm', 'Facing the beachfront, Hotel Mishuk offers 3-star accommodation in Cox\'s Bazar and has a garden, shared lounge and restaurant. All rooms boast a TV with satellite channels and a private bathroom. The accommodation offers a 24-hour front desk, airport transfers, room service and free WiFi. \r\nAt the hotel, all rooms are fitted with bed linen and towels.', 600.00, 16, 'm', 1400.00, 14, 'm', 899.00, 13, 'm', 3100.00, 4, 'm', 2),
(15, '01712-241249', NULL, '14 Kalatoli, Hotel-Motel Zone, 4700 Cox\'s Bazar, Bangladesh', 'Long Beach Hotel', 3, NULL, NULL, 1, 2000.00, 30, 'm', 'Offering an indoor pool, a fitness centre and a spa and wellness centre, Long Beach Hotel is located 3.3 km from the Cox\'s Bazar Airport and Local Bus Station. Free wired internet is available in the rooms of the property.', 0.00, 0, 'N/A', 1700.00, 30, 'm', 1000.00, 14, 'm', 5000.00, 15, 'm', 4),
(16, '01712-247142', NULL, 'HS Tower, 3rd Floor, Waves -1 East Darga Gate, 3100 Sylhet, Bangladesh', 'The Grand Hotel BD', 4, NULL, NULL, 1, 1701.00, 30, 'm', 'The Grand Hotel BD is located in Sylhet. Featuring an ATM, this property also welcomes guests with a restaurant and a terrace. The accommodation provides a 24-hour front desk, airport transfers, room service and free WiFi throughout the property.', 600.00, 14, 'm', 1300.00, 23, 'm', 899.00, 20, 'm', 3999.00, 7, 'm', 3),
(17, '01512-247349', NULL, 'Mira Tower Mira Bazar, 3100 Sylhet, Bangladesh', 'Hotel Mira Garden', 1, NULL, NULL, 1, -1.00, 0, 'N/A', 'Hotel Mira Garden has a garden, shared lounge, a terrace and restaurant in Sylhet. This 4-star hotel offers an ATM and a concierge service. The accommodation features a 24-hour front desk, airport transfers, room service and free WiFi throughout the property.', 799.00, 12, 'm', 1500.00, 24, 'm', 1100.00, 12, 'm', 5000.00, 3, 'm', 4),
(18, '01121-247349', NULL, 'M.M Ali Road, Oposite of Handi Restaurant, Dam Para, Chittagong, 4000 Chittagong, Bangladesh', 'White Park Boutique Hotel', 4, NULL, NULL, 1, 1500.00, 12, 'm', 'White Park Boutique Hotel offers accommodation in Chittagong. The accommodation features room service and a 24-hour front desk for guests.\r\nAll guest rooms at the hotel are fitted with a seating area. The rooms will provide guests with air conditioning, a safety deposit box and a flat-screen TV.', 499.00, 15, 'm', 1200.00, 25, 'm', 800.00, 14, 'm', 3000.00, 7, 'm', 2),
(19, '01812-427142', NULL, 'Shamim Center, Zakir Hossain Road, Khulshi, 4000 Chittagong, Bangladesh', 'The Al Aqsa', 5, NULL, NULL, 1, 0.00, 0, 'm', 'Set in Chittagong, The Al Aqsa has a shared lounge. With a fitness centre, the 3-star hotel has air-conditioned rooms with free WiFi, each with a private bathroom. There is a restaurant serving Chinese cuisine, and free private parking is available.', 699.00, 8, 'm', 1599.00, 19, 'm', 900.00, 14, 'm', 4000.00, 5, 'm', 3),
(20, '01512-243749', NULL, 'Habiganj Road Uttarsur, 3210 Sreemangal, Bangladesh', 'Tea Heaven Resort', 5, NULL, NULL, 1, -1.00, 0, 'N/A', 'Tea Heaven Resort in Sreemangal has 3-star accommodations with an outdoor swimming pool, a grade,n and a restaurant. The accommodation offers room service and a 24-hour front desk for guests.\r\nAll guest rooms in the hotel are fitted with a flat-screen TV and free toiletries.\r\nThe area is popular for cycling, and car hire is available at Tea Heaven Resort.', 700.00, 14, 'm', 1399.00, 21, 'm', 1000.00, 23, 'm', 4000.00, 11, 'm', 3),
(21, '01712-246349', NULL, 'Paragon Hotel & Resorts Radhanagar, Sreemangal Moulvibazar, 3210 Sreemangal, Bangladesh', 'Paragon Hotel & Resort', 2, NULL, NULL, 1, 0.00, 0, 'N/A', 'Paragon Hotel & Resort features an outdoor swimming pool, fitness center, garden, and shared lounge in Sreemangal. Each accommodation at the 3-star hotel has mountain views, and guests can enjoy access to a terrace and to a hot tub. There is a restaurant serving Chinese cuisine, and free private parking is available.\r\nThe hotel will provide guests with air-conditioned rooms with a desk, a kettle, a fridge, a minibar, a safety deposit box, a flat-screen TV, a balcony, and a private bathroom with a shower. At Paragon Hotel & Resort every room is fitted with bed linen and towels.', 800.00, 14, 'm', 1799.00, 45, 'm', 1100.00, 22, 'm', 4999.00, 12, 'm', 4),
(25, '01738282901', NULL, 'Sheikh Mujib road, Agrabad 4100 Chittagong, Bangladesh.', 'Orchid Business Hotel', 0, NULL, NULL, 1, 6931.00, 12, 'Perfect for Families', 'Set in Chittagong, Orchid Business Hotel has a restaurant. With a terrace, the 3 star hotel has a magnificent pool and the whole hotel is air conditioned.', 2987.00, 12, 'Best for one person!', 4063.00, 12, 'Best for friends.', 3456.00, 23, 'Best for couples!', 10000.00, 12, 'Enjoy our utmost hospitality!', 3);

-- --------------------------------------------------------

--
-- Table structure for table `hotel_images`
--

CREATE TABLE `hotel_images` (
  `hotel_id` bigint(20) NOT NULL,
  `images` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hotel_images`
--

INSERT INTO `hotel_images` (`hotel_id`, `images`, `image_path`) VALUES
(11, NULL, 'uploads\\67598705.jpg'),
(11, NULL, 'uploads\\506290455.jpg'),
(11, NULL, 'uploads\\506290468.jpg'),
(11, NULL, 'uploads\\506720224.jpg'),
(11, NULL, 'uploads\\507830854.jpg'),
(12, NULL, 'uploads\\333872353.jpg'),
(12, NULL, 'uploads\\333872355.jpg'),
(12, NULL, 'uploads\\333872369.jpg'),
(12, NULL, 'uploads\\333872379.jpg'),
(12, NULL, 'uploads\\333872380.jpg'),
(13, NULL, 'uploads\\55553963.jpg'),
(13, NULL, 'uploads\\271506337.jpg'),
(13, NULL, 'uploads\\271578552.jpg'),
(13, NULL, 'uploads\\271579070.jpg'),
(13, NULL, 'uploads\\271579219.jpg'),
(15, NULL, 'uploads\\63266574.jpg'),
(15, NULL, 'uploads\\63266643.jpg'),
(15, NULL, 'uploads\\63267527.jpg'),
(15, NULL, 'uploads\\283183777.jpg'),
(16, NULL, 'uploads\\231300083.jpg'),
(16, NULL, 'uploads\\231301044.jpg'),
(16, NULL, 'uploads\\231301057.jpg'),
(16, NULL, 'uploads\\231301104.jpg'),
(16, NULL, 'uploads\\231301108.jpg'),
(16, NULL, 'uploads\\232340180.jpg'),
(17, NULL, 'uploads\\175327413.jpg'),
(17, NULL, 'uploads\\175327421.jpg'),
(17, NULL, 'uploads\\175327422.jpg'),
(17, NULL, 'uploads\\175327449.jpg'),
(17, NULL, 'uploads\\175327455.jpg'),
(18, NULL, 'uploads\\293864902.jpg'),
(18, NULL, 'uploads\\342953536.jpg'),
(18, NULL, 'uploads\\342953537.jpg'),
(18, NULL, 'uploads\\342953539.jpg'),
(18, NULL, 'uploads\\342953543.jpg'),
(19, NULL, 'uploads\\597996433.jpg'),
(19, NULL, 'uploads\\597998407.jpg'),
(19, NULL, 'uploads\\597998420.jpg'),
(19, NULL, 'uploads\\597998439.jpg'),
(19, NULL, 'uploads\\597998787.jpg'),
(19, NULL, 'uploads\\599505786.jpg'),
(20, NULL, 'uploads\\428510096.jpg'),
(20, NULL, 'uploads\\428510116.jpg'),
(20, NULL, 'uploads\\428510117.jpg'),
(20, NULL, 'uploads\\428510133.jpg'),
(20, NULL, 'uploads\\428511959.jpg'),
(20, NULL, 'uploads\\458780643.jpg'),
(21, NULL, 'uploads\\445388972.jpg'),
(21, NULL, 'uploads\\507812221.jpg'),
(21, NULL, 'uploads\\507812265.jpg'),
(21, NULL, 'uploads\\507812378.jpg'),
(21, NULL, 'uploads\\507812591.jpg'),
(21, NULL, 'uploads\\507812613.jpg'),
(21, NULL, 'uploads\\597008610.jpg'),
(25, NULL, 'uploads\\orchid4.jpg'),
(25, NULL, 'uploads\\orchid3.jpg'),
(25, NULL, 'uploads\\orchid2.jpg'),
(25, NULL, 'uploads\\orchid1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `room_counts`
--

CREATE TABLE `room_counts` (
  `booking_id` bigint(20) NOT NULL,
  `room_count` int(11) DEFAULT NULL,
  `room_type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `role`, `username`) VALUES
(3, '1234', 'GUEST', 'imti'),
(10, '6969', 'GUEST', 'rajarshigo'),
(12, '@drrago16', 'GUEST', 'drrago16'),
(13, 'tomal', 'GUEST', 'tomal'),
(14, '1234', 'GUEST', 'adnan'),
(24, 'imti', 'ADMIN', 'tomal'),
(28, '12345678', 'ADMIN', 'tomal12'),
(29, '12345678', 'GUEST', 'imtiazimti');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhacdq9bfa3r9xdimovsnonbyi` (`hotel_id`),
  ADD KEY `FKkgseyy7t56x7lkjgu3wah5s3t` (`user_id`);

--
-- Indexes for table `booking_details`
--
ALTER TABLE `booking_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `booking_details_room_counts`
--
ALTER TABLE `booking_details_room_counts`
  ADD PRIMARY KEY (`booking_details_id`,`room_counts_key`);

--
-- Indexes for table `booking_room_counts`
--
ALTER TABLE `booking_room_counts`
  ADD PRIMARY KEY (`booking_id`,`room_type`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hotel_images`
--
ALTER TABLE `hotel_images`
  ADD KEY `FKadn1gvxou3am344390whule8a` (`hotel_id`);

--
-- Indexes for table `room_counts`
--
ALTER TABLE `room_counts`
  ADD PRIMARY KEY (`booking_id`,`room_type`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `booking_details`
--
ALTER TABLE `booking_details`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `FKhacdq9bfa3r9xdimovsnonbyi` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  ADD CONSTRAINT `FKkgseyy7t56x7lkjgu3wah5s3t` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `booking_details_room_counts`
--
ALTER TABLE `booking_details_room_counts`
  ADD CONSTRAINT `FKiy7w31jiuybf4inrsm576e8de` FOREIGN KEY (`booking_details_id`) REFERENCES `booking_details` (`id`);

--
-- Constraints for table `booking_room_counts`
--
ALTER TABLE `booking_room_counts`
  ADD CONSTRAINT `FKk2ivqomm6odmokrckoee48x32` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`);

--
-- Constraints for table `hotel_images`
--
ALTER TABLE `hotel_images`
  ADD CONSTRAINT `FKadn1gvxou3am344390whule8a` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`);

--
-- Constraints for table `room_counts`
--
ALTER TABLE `room_counts`
  ADD CONSTRAINT `FKob0lcqg1shrsgx0l6cp8ahudd` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
