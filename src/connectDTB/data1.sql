-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th5 03, 2024 lúc 01:50 PM
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
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `bill_ID` int(11) NOT NULL,
  `Time` datetime NOT NULL,
  `Table_ID` int(11) DEFAULT NULL,
  `Emp_ID` int(11) DEFAULT NULL,
  `Total` int(11) NOT NULL,
  `Status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`bill_ID`, `Time`, `Table_ID`, `Emp_ID`, `Total`, `Status`) VALUES
(1, '2024-04-24 00:00:00', 1, 101200, 320000, 1),
(2, '2024-04-13 00:00:00', 2, 108796, 500000, 1),
(3, '2024-01-25 00:00:00', 4, 155064, 700000, 1),
(4, '2024-03-25 00:00:00', 5, 896532, 850000, 1),
(5, '2024-04-25 18:45:45', 3, 896532, 300000, 0),
(6, '2024-05-02 12:19:33', 10, 101200, 80000, 0),
(7, '2024-05-02 16:30:02', 24, 171200, 140000, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `Phone` varchar(10) NOT NULL,
  `Name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`Phone`, `Name`) VALUES
('0339402833', 'Cao Ngọc Mai'),
('0738392732', 'Mai Quốc Trung'),
('0842938333', 'Trần Thu Phương'),
('0849283928', 'Nguyễn Hà Duyên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employment`
--

CREATE TABLE `employment` (
  `Emp_ID` int(6) NOT NULL,
  `Name` text NOT NULL,
  `Phone` varchar(10) DEFAULT NULL,
  `Address` text NOT NULL,
  `Position` text NOT NULL,
  `Password` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `employment`
--

INSERT INTO `employment` (`Emp_ID`, `Name`, `Phone`, `Address`, `Position`, `Password`) VALUES
(101200, 'Lê Quang Vinh', '0333333101', '94 Nguyễn Lương Bằng', 'Employee', '221111'),
(108796, 'Trương Văn Bình', '0236589745', '102 Trương Định', 'Employee', '023654'),
(122080, 'Cao Hoang', '0993890211', '11 Nam Cao', 'Employee', '001122'),
(126860, 'Cao Thanh Vinh', '0333333201', '77 Nguyễn Lương Bằng', 'Admin', '123456'),
(155064, 'Hồ Thị Thanh Thanh', '0332001901', '01 Tôn Đức Thắng', 'Employee', '111111'),
(171200, 'Nguyễn Thị Hoa', '0333333100', '15 Thanh Vinh 10', 'Employee', '170104'),
(896532, 'Nguyễn Hoàn', '0896532014', '101 Nam Cao', 'Employee', '569874');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `food_drink`
--

CREATE TABLE `food_drink` (
  `ID` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Price` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Classify` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `food_drink`
--

INSERT INTO `food_drink` (`ID`, `Name`, `Price`, `Quantity`, `Classify`) VALUES
(101, 'Cao lầu', 40000, 40, 0),
(102, 'Mì Quảng', 35000, 50, 0),
(103, 'Bún thang', 30000, 60, 0),
(104, 'Bún riêu cua', 35000, 70, 0),
(105, 'Mì gà tần', 30000, 80, 0),
(106, 'Bánh canh cua', 35000, 90, 0),
(107, 'Bún bò Huế', 40000, 80, 0),
(108, 'Cơm gà Hội An', 40000, 70, 0),
(109, 'Phở Hà Nội', 35000, 60, 0),
(110, 'Bún măng vịt', 35000, 50, 0),
(111, 'Bò sốt vang', 20000, 100, 0),
(112, 'Bánh bao kim sa', 15000, 120, 0),
(113, 'Bánh xèo miền Trung', 20000, 110, 0),
(114, 'Gỏi cuốn Hà Nội', 25000, 90, 0),
(115, 'Xôi gà xé', 15000, 130, 0),
(116, 'Bánh cuốn Tây Sơn', 25000, 100, 0),
(117, 'Gỏi ngó sen', 35000, 80, 0),
(118, 'Bún chả Hà Nội', 30000, 70, 0),
(119, 'Cơm lam', 20000, 110, 0),
(120, 'Vịt om măng', 15000, 120, 0),
(121, 'Gà nướng lu', 40000, 60, 0),
(122, 'Bò xào thập cẩm', 45000, 50, 0),
(123, 'Cá nướng', 50000, 40, 0),
(124, 'Ốc hương mỡ hành', 30000, 80, 0),
(125, 'Gà bó xôi', 35000, 70, 0),
(126, 'Bánh tráng thịt heo', 25000, 100, 0),
(127, 'Bánh hồng Bình Định', 30000, 90, 0),
(128, 'Bánh gio', 25000, 120, 0),
(129, 'Bún ốc', 35000, 80, 0),
(130, 'Gỏi gà măng cụt', 20000, 100, 0),
(131, 'Nem chua Thanh Hoá', 30000, 70, 0),
(132, 'Nem nướng', 35000, 60, 0),
(133, 'Gà xối mỡ', 20000, 110, 0),
(134, 'Cơm chiên trứng', 15000, 120, 0),
(135, 'Cơm chiên dương châu', 40000, 50, 0),
(136, 'Bánh bao chiên', 35000, 70, 0),
(137, 'Salad rau củ', 25000, 90, 0),
(138, 'Bánh canh cua', 35000, 60, 0),
(139, 'Salad dầu giấm', 30000, 80, 0),
(140, 'Ốc len xào dừa', 45000, 40, 0),
(201, 'Nước dừa', 25000, 50, 1),
(202, 'Nước cam', 20000, 60, 1),
(203, 'Cà phê đen', 30000, 70, 1),
(204, 'Sinh tố bơ', 35000, 80, 1),
(205, 'Cà phê sữa', 25000, 90, 1),
(206, 'Soda chanh', 20000, 100, 1),
(207, 'Trà lài', 35000, 110, 1),
(208, 'Nước ép cà rốt', 30000, 120, 1),
(209, 'Nước ép thơm', 15000, 130, 1),
(210, 'Sinh tố xoài', 35000, 140, 1),
(211, 'Trà đen', 35000, 150, 1),
(212, 'Bạc xỉu', 25000, 160, 1),
(213, 'Nước ép cà chua', 20000, 170, 1),
(214, 'Trà sen vàng', 40000, 180, 1),
(215, 'Nước bưởi ép', 30000, 190, 1),
(216, 'Nước lọc', 10000, 200, 1),
(217, 'Soda dâu', 25000, 210, 1),
(218, 'Trà dâu tằm', 35000, 220, 1),
(219, 'Nước ép táo', 30000, 230, 1),
(220, 'Trà xanh', 25000, 240, 1),
(221, 'Nước chanh muối', 20000, 250, 1),
(222, 'Trà chanh dây', 35000, 260, 1),
(223, 'Cà phê phin', 35000, 270, 1),
(224, 'Trà me', 20000, 280, 1),
(225, 'Soda việt quất', 30000, 290, 1),
(226, 'Trà mãng cầu', 15000, 300, 1),
(227, 'Sữa chua nha đam', 35000, 310, 1),
(228, 'Trà vải', 25000, 320, 1),
(229, 'Nước ép dưa hấu', 40000, 330, 1),
(230, 'Trà hương nhài', 30000, 340, 1),
(231, 'Sữa chua dâu', 25000, 350, 1),
(232, 'Sữa chua đá', 35000, 360, 1),
(233, 'Soda bạc hà', 20000, 370, 1),
(234, 'Nước ép ổi', 30000, 380, 1),
(235, 'Trà hoa hồng', 25000, 390, 1),
(236, 'Sinh tố dâu', 35000, 400, 1),
(237, 'Rượu Bàu đá', 20000, 410, 1),
(238, 'Bia Huda', 30000, 420, 1),
(239, 'Bia hơi', 25000, 430, 1),
(240, 'Rượu táo mèo', 35000, 440, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_details`
--

CREATE TABLE `order_details` (
  `bill_ID` int(11) NOT NULL,
  `item_ID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `total_price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `order_details`
--

INSERT INTO `order_details` (`bill_ID`, `item_ID`, `Quantity`, `total_price`) VALUES
(1, 101, 3, 120000),
(1, 102, 4, 200000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tables`
--

CREATE TABLE `tables` (
  `Table_ID` int(3) NOT NULL,
  `Status` tinyint(1) NOT NULL,
  `Seat_Capacity` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tables`
--

INSERT INTO `tables` (`Table_ID`, `Status`, `Seat_Capacity`) VALUES
(1, 0, 10),
(2, 0, 10),
(3, 0, 10),
(4, 0, 20),
(5, 0, 20),
(6, 0, 20),
(7, 0, 25),
(8, 0, 40),
(9, 0, 25),
(10, 0, 10),
(11, 0, 6),
(12, 0, 4),
(13, 0, 25),
(14, 0, 30),
(15, 0, 12),
(16, 0, 10),
(17, 0, 8),
(18, 0, 20),
(19, 0, 10),
(20, 0, 5),
(21, 0, 8),
(22, 0, 15),
(23, 0, 5),
(24, 0, 7),
(25, 0, 10);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`bill_ID`),
  ADD KEY `FK_Employee` (`Emp_ID`),
  ADD KEY `FK_Table` (`Table_ID`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Phone`) USING BTREE;

--
-- Chỉ mục cho bảng `employment`
--
ALTER TABLE `employment`
  ADD PRIMARY KEY (`Emp_ID`);

--
-- Chỉ mục cho bảng `food_drink`
--
ALTER TABLE `food_drink`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `order_details`
--
ALTER TABLE `order_details`
  ADD KEY `FK_Bill` (`bill_ID`),
  ADD KEY `FK_item` (`item_ID`);

--
-- Chỉ mục cho bảng `tables`
--
ALTER TABLE `tables`
  ADD PRIMARY KEY (`Table_ID`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `FK_Employee` FOREIGN KEY (`Emp_ID`) REFERENCES `employment` (`Emp_ID`),
  ADD CONSTRAINT `FK_Table` FOREIGN KEY (`Table_ID`) REFERENCES `tables` (`Table_ID`);

--
-- Các ràng buộc cho bảng `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `FK_Bill` FOREIGN KEY (`bill_ID`) REFERENCES `bill` (`bill_ID`),
  ADD CONSTRAINT `FK_item` FOREIGN KEY (`item_ID`) REFERENCES `food_drink` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
