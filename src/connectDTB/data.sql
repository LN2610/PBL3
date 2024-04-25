-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th4 20, 2024 lúc 02:54 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `data`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Bills`
--

CREATE TABLE `Bills` (
  `Bill_ID` int(11) NOT NULL,
  `Time` datetime NOT NULL,
  `Total` int(11) NOT NULL,
  `Status` tinyint(1) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Phone` int(11) NOT NULL,
  `Table_ID` int(11) NOT NULL,
  `Emp_ID` int(11) NOT NULL,
  `Order_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `Bills`
--

INSERT INTO `Bills` (`Bill_ID`, `Time`, `Total`, `Status`, `Quantity`, `Phone`, `Table_ID`, `Emp_ID`, `Order_ID`) VALUES
(100200, '2024-01-01 10:10:00', 360000, 1, 4, 339402833, 1, 1, 102111),
(177200, '2024-12-03 00:00:00', 200000, 1, 4, 738392732, 3, 155064, 107100);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Customer`
--

CREATE TABLE `Customer` (
  `Phone` int(12) NOT NULL,
  `Name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `Customer`
--

INSERT INTO `Customer` (`Phone`, `Name`) VALUES
(339402833, 'Cao Ngọc Mai'),
(738392732, 'Mai Quốc Trung'),
(842938333, 'Trần Thu Phương'),
(849283928, 'Nguyễn Hà Duyên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Drink_category`
--

CREATE TABLE `Drink_category` (
  `Drink_ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Price` double NOT NULL,
  `Quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `Drink_category`
--

INSERT INTO `Drink_category` (`Drink_ID`, `Name`, `Price`, `Quantity`) VALUES
(201, 'Soda', 30000, 40),
(202, 'Soju', 120000, 20),
(203, 'Nước cam', 40000, 20),
(204, 'Trà gừng', 45000, 30);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Employment`
--

CREATE TABLE `Employment` (
  `Emp_ID` int(6) NOT NULL,
  `Name` text NOT NULL,
  `Phone` text DEFAULT NULL,
  `Address` text NOT NULL,
  `Position` text NOT NULL,
  `Password` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `Employment`
--

INSERT INTO `Employment` (`Emp_ID`, `Name`, `Phone`, `Address`, `Position`, `Password`) VALUES
(1, 'Cao Hoang', '993890211', '11 Nam Cao', 'Employee', '001122'),
(101200, 'Lê Quang Vinh', '0333333101', '94 Nguyễn Lương Bằng', 'Employee', '221111'),
(126860, 'Cao Thanh Vinh', '0333333201', '77 Nguyễn Lương Bằng', 'Admin', '123456'),
(155064, 'Hồ Thị Thanh Thanh', '0332001901', '01 Tôn Đức Thắng', 'Employee', '111111'),
(171200, 'Nguyễn Thị Hoa', '0333333100', '15 Thanh Vinh 10', 'Employee', '170104');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Food_category`
--

CREATE TABLE `Food_category` (
  `Food_ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Price` double NOT NULL,
  `Quantity` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `Food_category`
--

INSERT INTO `Food_category` (`Food_ID`, `Name`, `Price`, `Quantity`) VALUES
(101, 'Bánh bột chiên', 50000, 30),
(110, 'Sương sáo', 40000, 50),
(111, 'Mì nghêu', 80000, 20),
(121, 'Gà tần', 250000, 15);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Order_detail`
--

CREATE TABLE `Order_detail` (
  `Order_ID` int(11) NOT NULL,
  `Food_ID` int(11) NOT NULL,
  `Drink_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `Order_detail`
--

INSERT INTO `Order_detail` (`Order_ID`, `Food_ID`, `Drink_ID`) VALUES
(102007, 101, 202),
(102111, 121, 204),
(107100, 121, 203),
(122000, 121, 201);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `Tables`
--

CREATE TABLE `Tables` (
  `Table_ID` int(3) NOT NULL,
  `Status` tinyint(1) NOT NULL,
  `Seat_Capacity` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `Tables`
--

INSERT INTO `Tables` (`Table_ID`, `Status`, `Seat_Capacity`) VALUES
(1, 0, 10),
(2, 0, 10),
(3, 1, 10),
(4, 0, 20),
(5, 1, 20);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `Bills`
--
ALTER TABLE `Bills`
  ADD PRIMARY KEY (`Bill_ID`),
  ADD KEY `Customer_ID` (`Phone`),
  ADD KEY `fk_Order_detail` (`Order_ID`),
  ADD KEY `bills_ibfk_2` (`Emp_ID`),
  ADD KEY `Table_ID` (`Table_ID`) USING BTREE;

--
-- Chỉ mục cho bảng `Customer`
--
ALTER TABLE `Customer`
  ADD PRIMARY KEY (`Phone`) USING BTREE;

--
-- Chỉ mục cho bảng `Drink_category`
--
ALTER TABLE `Drink_category`
  ADD PRIMARY KEY (`Drink_ID`);

--
-- Chỉ mục cho bảng `Employment`
--
ALTER TABLE `Employment`
  ADD PRIMARY KEY (`Emp_ID`);

--
-- Chỉ mục cho bảng `Food_category`
--
ALTER TABLE `Food_category`
  ADD PRIMARY KEY (`Food_ID`);

--
-- Chỉ mục cho bảng `Order_detail`
--
ALTER TABLE `Order_detail`
  ADD PRIMARY KEY (`Order_ID`),
  ADD KEY `fk_Food_Order_detail` (`Food_ID`),
  ADD KEY `fk_Drink_Order_detail` (`Drink_ID`);

--
-- Chỉ mục cho bảng `Tables`
--
ALTER TABLE `Tables`
  ADD PRIMARY KEY (`Table_ID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `Drink_category`
--
ALTER TABLE `Drink_category`
  MODIFY `Drink_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=205;

--
-- AUTO_INCREMENT cho bảng `Order_detail`
--
ALTER TABLE `Order_detail`
  MODIFY `Order_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=122457;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `Bills`
--
ALTER TABLE `Bills`
  ADD CONSTRAINT `Customer_ID` FOREIGN KEY (`Phone`) REFERENCES `dt`.`Customer` (`Phone`),
  ADD CONSTRAINT `bills_ibfk_2` FOREIGN KEY (`Emp_ID`) REFERENCES `dt`.`Employment` (`Emp_ID`),
  ADD CONSTRAINT `bills_ibfk_3` FOREIGN KEY (`Table_ID`) REFERENCES `dt`.`Tables` (`Table_ID`),
  ADD CONSTRAINT `fk_Order_detail` FOREIGN KEY (`Order_ID`) REFERENCES `dt`.`Order_detail` (`Order_ID`);

--
-- Các ràng buộc cho bảng `Order_detail`
--
ALTER TABLE `Order_detail`
  ADD CONSTRAINT `fk_Drink_Order_detail` FOREIGN KEY (`Drink_ID`) REFERENCES `Drink_category` (`Drink_ID`),
  ADD CONSTRAINT `fk_Food_Order_detail` FOREIGN KEY (`Food_ID`) REFERENCES `Food_category` (`Food_ID`),
  ADD CONSTRAINT `fk_drink_id` FOREIGN KEY (`Drink_ID`) REFERENCES `Drink_category` (`Drink_ID`),
  ADD CONSTRAINT `fk_food_id` FOREIGN KEY (`Food_ID`) REFERENCES `Food_category` (`Food_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
