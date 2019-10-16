-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 16 Okt 2019 pada 14.46
-- Versi server: 10.1.36-MariaDB
-- Versi PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `driver`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tiket_bioskop`
--

CREATE TABLE `tiket_bioskop` (
  `id_film` int(11) NOT NULL,
  `nama_film` varchar(50) NOT NULL,
  `nama_bioskop` varchar(50) NOT NULL,
  `no_studio` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tiket_bioskop`
--

INSERT INTO `tiket_bioskop` (`id_film`, `nama_film`, `nama_bioskop`, `no_studio`) VALUES
(1, 'Joker', 'XXI Setia Budi', 1),
(2, 'Pengabdi Kost-an', 'CGV Java Mall', 2),
(3, 'Ketika Cinta Bertasbih', 'XXI Paragon Solo', 5),
(4, 'PSP : Gaya Mahasiswa', 'CGV Citra Mall', 3);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tiket_bioskop`
--
ALTER TABLE `tiket_bioskop`
  ADD PRIMARY KEY (`id_film`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tiket_bioskop`
--
ALTER TABLE `tiket_bioskop`
  MODIFY `id_film` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
