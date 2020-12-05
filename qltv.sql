-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 05, 2020 lúc 04:25 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qltv`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi tiết nhập hàng`
--

CREATE TABLE `chi tiết nhập hàng` (
  `MaSach` varchar(10) NOT NULL,
  `MaPD` varchar(10) NOT NULL,
  `NgayDat` date NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chi tiết phiếu mượn`
--

CREATE TABLE `chi tiết phiếu mượn` (
  `MaSach` varchar(10) NOT NULL,
  `MaPM` varchar(10) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loại sách`
--

CREATE TABLE `loại sách` (
  `MaLoai` varchar(10) NOT NULL,
  `TenLoai` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhà cung cấp`
--

CREATE TABLE `nhà cung cấp` (
  `MaNCC` varchar(10) NOT NULL,
  `TenNCC` text NOT NULL,
  `DiaChi` text NOT NULL,
  `SDT` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phiếu mượn`
--

CREATE TABLE `phiếu mượn` (
  `MaPM` varchar(10) NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `MaTDG` varchar(10) NOT NULL,
  `MaSach` varchar(10) NOT NULL,
  `NgayLap` date NOT NULL,
  `TongTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phiếu trả`
--

CREATE TABLE `phiếu trả` (
  `MAPT` varchar(10) NOT NULL,
  `MaSach` varchar(10) NOT NULL,
  `MaTDG` varchar(10) NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `NgayLap` date NOT NULL,
  `TienPhat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phiếu đặt hàng`
--

CREATE TABLE `phiếu đặt hàng` (
  `MaPD` varchar(10) NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `MaNCC` varchar(10) NOT NULL,
  `NgayDat` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quản lý nhân viên`
--

CREATE TABLE `quản lý nhân viên` (
  `MaNV` varchar(10) NOT NULL,
  `TenNV` text NOT NULL,
  `NgaySinh` date NOT NULL,
  `SDT` text NOT NULL,
  `DiaChi` text NOT NULL,
  `ChucVu` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `MaSach` varchar(10) NOT NULL,
  `MaLoai` varchar(10) NOT NULL,
  `MaNCC` varchar(10) NOT NULL,
  `TenSach` text NOT NULL,
  `NXB` text NOT NULL,
  `TacGia` text NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thẻ độc giả`
--

CREATE TABLE `thẻ độc giả` (
  `MaTDG` varchar(10) NOT NULL,
  `MADG` varchar(10) NOT NULL,
  `TenDG` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `độc giả`
--

CREATE TABLE `độc giả` (
  `MaDG` varchar(10) NOT NULL,
  `TenDG` text NOT NULL,
  `NgaySinh` date NOT NULL,
  `SDT` text NOT NULL,
  `DiaChi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chi tiết nhập hàng`
--
ALTER TABLE `chi tiết nhập hàng`
  ADD PRIMARY KEY (`MaSach`,`MaPD`);

--
-- Chỉ mục cho bảng `chi tiết phiếu mượn`
--
ALTER TABLE `chi tiết phiếu mượn`
  ADD PRIMARY KEY (`MaSach`);

--
-- Chỉ mục cho bảng `loại sách`
--
ALTER TABLE `loại sách`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `nhà cung cấp`
--
ALTER TABLE `nhà cung cấp`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `phiếu mượn`
--
ALTER TABLE `phiếu mượn`
  ADD PRIMARY KEY (`MaPM`);

--
-- Chỉ mục cho bảng `phiếu trả`
--
ALTER TABLE `phiếu trả`
  ADD PRIMARY KEY (`MAPT`);

--
-- Chỉ mục cho bảng `phiếu đặt hàng`
--
ALTER TABLE `phiếu đặt hàng`
  ADD PRIMARY KEY (`MaPD`);

--
-- Chỉ mục cho bảng `quản lý nhân viên`
--
ALTER TABLE `quản lý nhân viên`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`MaSach`);

--
-- Chỉ mục cho bảng `thẻ độc giả`
--
ALTER TABLE `thẻ độc giả`
  ADD PRIMARY KEY (`MaTDG`);

--
-- Chỉ mục cho bảng `độc giả`
--
ALTER TABLE `độc giả`
  ADD PRIMARY KEY (`MaDG`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
