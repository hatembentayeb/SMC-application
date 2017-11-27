-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2017 at 01:53 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `smc`
--

-- --------------------------------------------------------

--
-- Table structure for table `bon_livraison`
--

CREATE TABLE IF NOT EXISTS `bon_livraison` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL,
  `date` date NOT NULL,
  `client_id` int(11) NOT NULL,
  `quantie` int(11) NOT NULL,
  `Produit_id` int(11) NOT NULL,
  `prix_untaire` int(11) NOT NULL,
  `prix_totale` int(11) NOT NULL,
  `totale` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  KEY `Produit_id` (`Produit_id`),
  KEY `Produit_id_2` (`Produit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `charge`
--

CREATE TABLE IF NOT EXISTS `charge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lebelle` varchar(400) NOT NULL,
  `date` date NOT NULL,
  `montant` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_c` int(11) NOT NULL,
  `Nom` varchar(300) NOT NULL,
  `Matricule_Fiscal` varchar(400) NOT NULL,
  `adresse_livraison` varchar(400) NOT NULL,
  `num_tel` int(11) NOT NULL,
  `Mode_Paiment` varchar(400) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_fac` int(11) NOT NULL,
  `date_fac` date NOT NULL,
  `client_id` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `Produit_id` int(11) NOT NULL,
  `prix_untaire_ht` int(11) NOT NULL,
  `tva_prix` double NOT NULL,
  `prix_total_ht` int(11) NOT NULL,
  `base_ht` int(11) NOT NULL,
  `taux_tva` double NOT NULL,
  `tva` int(11) NOT NULL,
  `total_ht` int(11) NOT NULL,
  `doit_de_timbre` int(11) NOT NULL,
  `ttc` int(11) NOT NULL,
  `ttc_lettre` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  KEY `client_id_2` (`client_id`),
  KEY `Produit_id` (`Produit_id`),
  KEY `Produit_id_2` (`Produit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `fournisseur`
--

CREATE TABLE IF NOT EXISTS `fournisseur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_f` int(11) NOT NULL,
  `nom` varchar(500) NOT NULL,
  `raison_sociale` varchar(1000) NOT NULL,
  `adresse` varchar(500) NOT NULL,
  `num_tel` int(11) NOT NULL,
  `num_fax` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_P` int(11) NOT NULL,
  `lebelle` varchar(200) NOT NULL,
  `code_tva` varchar(200) NOT NULL,
  `pu_tva` varchar(200) NOT NULL,
  `unite` varchar(200) NOT NULL,
  `type` varchar(200) NOT NULL,
  `taille` varchar(200) NOT NULL,
  `remise` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `vente`
--

CREATE TABLE IF NOT EXISTS `vente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_v` int(11) NOT NULL,
  `produit_id` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `type_vente` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `produit` (`produit_id`),
  KEY `produit_2` (`produit_id`),
  KEY `produit_id` (`produit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bon_livraison`
--
ALTER TABLE `bon_livraison`
  ADD CONSTRAINT `bon_livraison_ibfk_2` FOREIGN KEY (`Produit_id`) REFERENCES `produit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bon_livraison_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `facture_ibfk_2` FOREIGN KEY (`Produit_id`) REFERENCES `produit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `facture_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `vente`
--
ALTER TABLE `vente`
  ADD CONSTRAINT `vente_ibfk_1` FOREIGN KEY (`produit_id`) REFERENCES `produit` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
