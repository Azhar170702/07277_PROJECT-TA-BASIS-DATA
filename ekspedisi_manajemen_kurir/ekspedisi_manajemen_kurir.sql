-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Jun 2022 pada 11.49
-- Versi server: 10.4.17-MariaDB
-- Versi PHP: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ekspedisi_manajemen_kurir`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin_kurir`
--

CREATE TABLE `admin_kurir` (
  `id_admin` int(11) NOT NULL,
  `nama_admin` varchar(100) NOT NULL,
  `password_admin` varchar(50) NOT NULL,
  `alamat_admin` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin_kurir`
--

INSERT INTO `admin_kurir` (`id_admin`, `nama_admin`, `password_admin`, `alamat_admin`) VALUES
(1, 'Azhar', '123', 'jl.anu');

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `jenis_barang` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `jenis_barang`) VALUES
(1, 'Minyak Rambut', 'Perlengkapan Rambut'),
(2, 'Sisir Rambut', 'Perlengkapan Rambut'),
(3, 'Sapu', 'Perlengkapan Rumah'),
(4, 'Kain Pel', 'Perlengkapan Rumah'),
(5, 'Meja', 'Perlengkapan Rumah'),
(6, 'Kursi', 'Perlengkapan Rumah'),
(7, 'Sprei kasur ', 'Perlengkapan Rumah'),
(8, 'Sofabed', 'Perlengkapan Rumah'),
(9, 'Bantal', 'Perlengkapan Tidur'),
(10, 'Guling ', 'Perlengkapan Tidur'),
(11, 'Baju Tidur ', 'Perlengkapan Tidur'),
(12, 'Sandal Tidur', 'Perlengkapan Tidur'),
(13, 'Penutup Mata', 'Perlengkapan Tidur');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jadwal_kerja`
--

CREATE TABLE `jadwal_kerja` (
  `id_jadwal` int(11) NOT NULL,
  `day` varchar(50) NOT NULL,
  `date_time` time NOT NULL,
  `admin_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `jadwal_kerja`
--

INSERT INTO `jadwal_kerja` (`id_jadwal`, `day`, `date_time`, `admin_id`) VALUES
(1, 'Senin', '08:00:00', 1),
(2, 'Selasa', '10:00:00', 1),
(3, 'Rabu', '12:00:00', 1),
(4, 'Kamis', '15:00:00', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kurir`
--

CREATE TABLE `kurir` (
  `id_kurir` int(11) NOT NULL,
  `nama_kurir` varchar(50) NOT NULL,
  `alamat_kurir` varchar(50) NOT NULL,
  `no_telp` varchar(13) NOT NULL,
  `jadwal_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kurir`
--

INSERT INTO `kurir` (`id_kurir`, `nama_kurir`, `alamat_kurir`, `no_telp`, `jadwal_id`) VALUES
(1, 'Hirdhan', 'Jl.anu', '0821', 1),
(2, 'Udin', 'Jl.anu', '0821', 2),
(3, 'Azhar', 'Jl.anu2', '0821', 2),
(4, 'Ferdi', 'Jl.anu23', '0821', 3),
(5, 'Alan', 'jl.wwwsss', '082135', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `penerima`
--

CREATE TABLE `penerima` (
  `id_penerima` int(11) NOT NULL,
  `nama_penerima` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penerima`
--

INSERT INTO `penerima` (`id_penerima`, `nama_penerima`, `password`, `alamat`) VALUES
(1, 'Nab', '123', 'JL.Arief Rahman Hakim no 81 Surabaya'),
(2, 'Yusan', '123', 'Jl.Gubernur suryo no 23 Surabaya');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesanan`
--

CREATE TABLE `pesanan` (
  `id_pesanan` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `id_penerima` int(11) NOT NULL,
  `id_kurir` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `tanggal_pengiriman` date DEFAULT NULL,
  `tanggal_diterima` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pesanan`
--

INSERT INTO `pesanan` (`id_pesanan`, `id_barang`, `id_penerima`, `id_kurir`, `status_id`, `tanggal_pengiriman`, `tanggal_diterima`) VALUES
(2, 1, 2, 4, 2, '2022-06-20', NULL),
(3, 5, 1, 4, 3, '2022-06-20', '2022-06-21'),
(4, 1, 1, 1, 3, '2022-06-20', '2022-06-21'),
(5, 11, 1, 4, 2, '2022-06-20', NULL),
(6, 9, 2, 3, 2, '2022-06-21', NULL),
(7, 6, 2, NULL, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `status`
--

CREATE TABLE `status` (
  `id_status` int(11) NOT NULL,
  `keterangan` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `status`
--

INSERT INTO `status` (`id_status`, `keterangan`) VALUES
(1, 'Diproses'),
(2, 'Dikirim'),
(3, 'Diterima');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin_kurir`
--
ALTER TABLE `admin_kurir`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indeks untuk tabel `jadwal_kerja`
--
ALTER TABLE `jadwal_kerja`
  ADD PRIMARY KEY (`id_jadwal`),
  ADD KEY `fk_admin_kurir` (`admin_id`);

--
-- Indeks untuk tabel `kurir`
--
ALTER TABLE `kurir`
  ADD PRIMARY KEY (`id_kurir`),
  ADD KEY `fk_jadwal` (`jadwal_id`);

--
-- Indeks untuk tabel `penerima`
--
ALTER TABLE `penerima`
  ADD PRIMARY KEY (`id_penerima`);

--
-- Indeks untuk tabel `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`id_pesanan`),
  ADD KEY `fk_barang` (`id_barang`),
  ADD KEY `fk_kurir` (`id_kurir`),
  ADD KEY `fk_penerima` (`id_penerima`),
  ADD KEY `fk_pengiriman` (`status_id`);

--
-- Indeks untuk tabel `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id_status`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin_kurir`
--
ALTER TABLE `admin_kurir`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT untuk tabel `jadwal_kerja`
--
ALTER TABLE `jadwal_kerja`
  MODIFY `id_jadwal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `kurir`
--
ALTER TABLE `kurir`
  MODIFY `id_kurir` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `penerima`
--
ALTER TABLE `penerima`
  MODIFY `id_penerima` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `pesanan`
--
ALTER TABLE `pesanan`
  MODIFY `id_pesanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `status`
--
ALTER TABLE `status`
  MODIFY `id_status` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `jadwal_kerja`
--
ALTER TABLE `jadwal_kerja`
  ADD CONSTRAINT `fk_admin_kurir` FOREIGN KEY (`admin_id`) REFERENCES `admin_kurir` (`id_admin`);

--
-- Ketidakleluasaan untuk tabel `kurir`
--
ALTER TABLE `kurir`
  ADD CONSTRAINT `fk_jadwal` FOREIGN KEY (`jadwal_id`) REFERENCES `jadwal_kerja` (`id_jadwal`);

--
-- Ketidakleluasaan untuk tabel `pesanan`
--
ALTER TABLE `pesanan`
  ADD CONSTRAINT `fk_barang` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_kurir` FOREIGN KEY (`id_kurir`) REFERENCES `kurir` (`id_kurir`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_penerima` FOREIGN KEY (`id_penerima`) REFERENCES `penerima` (`id_penerima`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pengiriman` FOREIGN KEY (`status_id`) REFERENCES `status` (`id_status`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
