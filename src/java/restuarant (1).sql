-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 12, 2018 at 01:22 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restuarant`
--

-- --------------------------------------------------------

--
-- Table structure for table `bankdetails`
--

CREATE TABLE `bankdetails` (
  `account_number` varchar(100) NOT NULL,
  `account_name` varchar(100) NOT NULL,
  `bank_name` varchar(100) NOT NULL,
  `ifsc_code` varchar(100) NOT NULL,
  `balance` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bankdetails`
--

INSERT INTO `bankdetails` (`account_number`, `account_name`, `bank_name`, `ifsc_code`, `balance`) VALUES
('1715', 'nayra', 'sbi', 'sbin0005321', '5000'),
('1716', 'harshita sinari', 'sbi', 'sbin0005321', '4400.0');

-- --------------------------------------------------------

--
-- Table structure for table `dishes`
--

CREATE TABLE `dishes` (
  `Name` varchar(100) NOT NULL,
  `imge` varchar(100) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `category` varchar(100) NOT NULL,
  `show_site` varchar(100) NOT NULL,
  `Price` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dishes`
--

INSERT INTO `dishes` (`Name`, `imge`, `Description`, `category`, `show_site`, `Price`) VALUES
('chana masala', 'kadi.jpg', 'special gujrati chana', 'veg', '0', '100'),
('dosa', 'dosa.jpg', 'special dish of the day', 'veg', '1', '250'),
('Dum_Aloo', 'dum_aloo.jpg', 'special dish of the day', 'veg', '0', '150'),
('kadi', 'kadi.jpg', 'special rajastjani kadi', 'veg', '1', '150'),
('paneer', 'paneer.jpg', 'special dish of the day', 'veg', '1', '250'),
('rayta', 'paneer.jpg', 'special dish of the day', 'veg', '0', '250'),
('rice', 'bundi_rayta.jpg', 'special dish of the day', 'veg', '1', '150');

-- --------------------------------------------------------

--
-- Table structure for table `mybank`
--

CREATE TABLE `mybank` (
  `Available_balance` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mybank`
--

INSERT INTO `mybank` (`Available_balance`) VALUES
('600.0');

-- --------------------------------------------------------

--
-- Table structure for table `user_cart`
--

CREATE TABLE `user_cart` (
  `order_number` varchar(100) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `dish_name` varchar(100) NOT NULL,
  `quantity` varchar(100) NOT NULL,
  `total_price` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_cart`
--

INSERT INTO `user_cart` (`order_number`, `user_id`, `dish_name`, `quantity`, `total_price`) VALUES
('1', 'nayra123', 'rice', '3', '450.0'),
('3', 'harshita123', 'kadi', '4', '600.0'),
('6', 'nayra123', 'Dum_Aloo', '1', '150.0');

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `pin_code` varchar(20) NOT NULL,
  `contact_number` varchar(20) NOT NULL,
  `email_id` varchar(200) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `account_number` varchar(100) NOT NULL,
  `password` varchar(20) NOT NULL,
  `repassword` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`first_name`, `last_name`, `address`, `pin_code`, `contact_number`, `email_id`, `user_id`, `account_number`, `password`, `repassword`) VALUES
('harshita', 'sinari', 'jaipur', '302034', '7297029108', 'harshitasinari03@gmail.com', 'harshita123', '1716', '1234', '1234'),
('nayra', 'thakur', 'jaipur', '302034', '7297029108', 'harshitasinari03@gmail.com', 'nayra123', '1715', '1234', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bankdetails`
--
ALTER TABLE `bankdetails`
  ADD PRIMARY KEY (`account_number`);

--
-- Indexes for table `dishes`
--
ALTER TABLE `dishes`
  ADD PRIMARY KEY (`Name`);

--
-- Indexes for table `user_cart`
--
ALTER TABLE `user_cart`
  ADD PRIMARY KEY (`order_number`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`user_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
