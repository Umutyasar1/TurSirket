-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.3.12-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- tursirket için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `tursirket` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `tursirket`;

-- tablo yapısı dökülüyor tursirket.araclar
CREATE TABLE IF NOT EXISTS `araclar` (
  `arac_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `arac_marka` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `arac_plaka` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`arac_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- tursirket.araclar: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `araclar` DISABLE KEYS */;
INSERT INTO `araclar` (`arac_id`, `arac_marka`, `arac_plaka`) VALUES
	(6, 'mercedes', '06 DY 949'),
	(7, 'mercedes', '06 abz 35'),
	(8, 'Audi', '03 FU 1118'),
	(9, 'Bentley', '34 szd 68'),
	(10, 'Wolkwagen', '06 ev 5446'),
	(11, 'Renault', '61 tb 8988');
/*!40000 ALTER TABLE `araclar` ENABLE KEYS */;

-- tablo yapısı dökülüyor tursirket.calisanlar
CREATE TABLE IF NOT EXISTS `calisanlar` (
  `calisan_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `calisan_adi` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `calisan_soyad` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `calisan_yas` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sirket_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`calisan_id`),
  KEY `FK_calisanlar_sirket_tur` (`sirket_id`),
  CONSTRAINT `FK_calisanlar_sirket_tur` FOREIGN KEY (`sirket_id`) REFERENCES `sirket_tur` (`sirket_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- tursirket.calisanlar: ~5 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `calisanlar` DISABLE KEYS */;
INSERT INTO `calisanlar` (`calisan_id`, `calisan_adi`, `calisan_soyad`, `calisan_yas`, `sirket_id`) VALUES
	(11, 'Gamze', 'Yaşar', '11', 13),
	(16, 'Serpil', 'Doğan', '21', 13),
	(17, 'İpek', 'Çiçekçi', '21', 12),
	(18, 'Esra', 'Varol', '20', 13),
	(19, 'Ferhat', 'Başboğa', '34', 12),
	(20, 'Umut', 'Keser', '24', 12),
	(21, 'Ramazan', 'Varol', '35', 13);
/*!40000 ALTER TABLE `calisanlar` ENABLE KEYS */;

-- tablo yapısı dökülüyor tursirket.grup
CREATE TABLE IF NOT EXISTS `grup` (
  `grup_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `grup_adi` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`grup_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- tursirket.grup: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `grup` DISABLE KEYS */;
/*!40000 ALTER TABLE `grup` ENABLE KEYS */;

-- tablo yapısı dökülüyor tursirket.katilan
CREATE TABLE IF NOT EXISTS `katilan` (
  `musteri_id` int(10) unsigned NOT NULL,
  `tur_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`musteri_id`,`tur_id`),
  KEY `Sütun 2` (`tur_id`),
  CONSTRAINT `FK_katilan_musteri` FOREIGN KEY (`musteri_id`) REFERENCES `musteri` (`musteri_id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_katilan_turlar` FOREIGN KEY (`tur_id`) REFERENCES `turlar` (`tur_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- tursirket.katilan: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `katilan` DISABLE KEYS */;
INSERT INTO `katilan` (`musteri_id`, `tur_id`) VALUES
	(1, 2),
	(1, 3),
	(1, 6),
	(2, 2),
	(5, 4),
	(7, 1),
	(8, 5);
/*!40000 ALTER TABLE `katilan` ENABLE KEYS */;

-- tablo yapısı dökülüyor tursirket.musteri
CREATE TABLE IF NOT EXISTS `musteri` (
  `musteri_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ad` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `soyad` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telno` int(11) NOT NULL,
  PRIMARY KEY (`musteri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- tursirket.musteri: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `musteri` DISABLE KEYS */;
INSERT INTO `musteri` (`musteri_id`, `ad`, `soyad`, `telno`) VALUES
	(1, 'Funda', 'Ördek', 531591),
	(2, 'Umut', 'Yasar', 145214),
	(3, 'Sinem', 'Güler', 14596),
	(4, 'Melih', 'Varol', 158756),
	(5, 'Yusuf', 'Keser', 1563287),
	(6, 'Muhammed', 'Ali', 1632874),
	(7, 'Ahmet', 'Enes', 152304),
	(8, 'Ziya', 'Gökalp', 196574),
	(9, 'Ali', 'Rıza', 19657),
	(10, 'Gamze', 'Keskin', 452178);
/*!40000 ALTER TABLE `musteri` ENABLE KEYS */;

-- tablo yapısı dökülüyor tursirket.sirket_tur
CREATE TABLE IF NOT EXISTS `sirket_tur` (
  `sirket_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sirket_ad` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hakkimizda` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`sirket_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- tursirket.sirket_tur: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `sirket_tur` DISABLE KEYS */;
INSERT INTO `sirket_tur` (`sirket_id`, `sirket_ad`, `hakkimizda`) VALUES
	(12, 'Ben Turizm', '1998 yılında istanbulda kurulmuştur'),
	(13, 'Seç Turizm', '2012 yılında kurulmustur'),
	(16, 'Pamukkale Tur', '2010 da kurulmustur'),
	(17, 'Enez Tur', '2010 da kurulmustur'),
	(18, 'Osmangazi Tur', '2013 da kurulmustur'),
	(19, 'Kalecik Tur', '2014 de kurulmustur');
/*!40000 ALTER TABLE `sirket_tur` ENABLE KEYS */;

-- tablo yapısı dökülüyor tursirket.subeler
CREATE TABLE IF NOT EXISTS `subeler` (
  `sube_id` int(11) NOT NULL AUTO_INCREMENT,
  `sube_il` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sube_ilce` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sube_isim` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sube_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- tursirket.subeler: ~1 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `subeler` DISABLE KEYS */;
INSERT INTO `subeler` (`sube_id`, `sube_il`, `sube_ilce`, `sube_isim`) VALUES
	(2, 'istanbul', 'esenler', 'astur'),
	(3, 'İstanbul', 'Adalar', 'Adalar Tur'),
	(4, 'Istanbul', 'Maltepe', 'Maltepe Tur'),
	(5, 'Denizli', 'Tavas', 'Tavas Tur'),
	(6, 'Edirne', 'Enez', 'Enez Tur'),
	(7, 'Ankara', 'Evren', 'Evren Tur');
/*!40000 ALTER TABLE `subeler` ENABLE KEYS */;

-- tablo yapısı dökülüyor tursirket.turlar
CREATE TABLE IF NOT EXISTS `turlar` (
  `tur_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tur_yeri` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tur_fiyat` int(11) NOT NULL,
  PRIMARY KEY (`tur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- tursirket.turlar: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `turlar` DISABLE KEYS */;
INSERT INTO `turlar` (`tur_id`, `tur_yeri`, `tur_fiyat`) VALUES
	(1, 'İzmir', 150),
	(2, 'İstanbul', 250),
	(3, 'Ankara', 120),
	(4, 'Gaziantep', 200),
	(5, 'Şanlıurfa', 270),
	(6, 'Antalya', 180),
	(7, 'Trabzon', 220),
	(8, 'Kocaeli', 80);
/*!40000 ALTER TABLE `turlar` ENABLE KEYS */;

-- tablo yapısı dökülüyor tursirket.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `uname` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `userTuru` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `c` tinyint(3) unsigned NOT NULL,
  `r` tinyint(3) unsigned NOT NULL,
  `u` tinyint(3) unsigned NOT NULL,
  `d` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- tursirket.user: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `uname`, `password`, `userTuru`, `c`, `r`, `u`, `d`) VALUES
	(1, 'umut', 'umut', 'Admin', 1, 1, 1, 1),
	(2, 'funda', 'funda', 'Admin', 1, 1, 1, 1),
	(3, 'umut1', 'umut', 'User', 0, 0, 0, 0),
	(4, 'melih', 'melih', 'User', 0, 1, 0, 0),
	(5, 'admin', 'admin', 'Admin', 1, 1, 1, 1),
	(6, 'sinem', 'sinem', 'Admin', 1, 1, 1, 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- tablo yapısı dökülüyor tursirket.yetki
CREATE TABLE IF NOT EXISTS `yetki` (
  `yetki_id` int(11) NOT NULL AUTO_INCREMENT,
  `module` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Grup_id` int(11) unsigned NOT NULL,
  `c` tinyint(4) NOT NULL,
  `r` tinyint(4) NOT NULL,
  `u` tinyint(4) NOT NULL,
  `d` tinyint(4) NOT NULL,
  PRIMARY KEY (`yetki_id`),
  KEY `FK__grup` (`Grup_id`),
  CONSTRAINT `FK__grup` FOREIGN KEY (`Grup_id`) REFERENCES `grup` (`grup_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- tursirket.yetki: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `yetki` DISABLE KEYS */;
/*!40000 ALTER TABLE `yetki` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
