-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 05 déc. 2018 à 09:16
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `businessconsult`
--

-- --------------------------------------------------------

--
-- Structure de la table `chefsprojet`
--

DROP TABLE IF EXISTS `chefsprojet`;
CREATE TABLE IF NOT EXISTS `chefsprojet` (
  `idChefProjet` int(11) NOT NULL,
  `statutChef` varchar(40) NOT NULL,
  `idConsultant` int(11) NOT NULL,
  `idProjet` int(11) NOT NULL,
  PRIMARY KEY (`idChefProjet`),
  KEY `idConsultant` (`idConsultant`),
  KEY `idProjet` (`idProjet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `consultants`
--

DROP TABLE IF EXISTS `consultants`;
CREATE TABLE IF NOT EXISTS `consultants` (
  `idConsultant` int(11) NOT NULL AUTO_INCREMENT,
  `nomConsultant` varchar(40) NOT NULL,
  `prenomConsultant` varchar(40) NOT NULL,
  `telConsultant` varchar(10) NOT NULL,
  `mailConsultant` varchar(50) NOT NULL,
  PRIMARY KEY (`idConsultant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `domainesprojet`
--

DROP TABLE IF EXISTS `domainesprojet`;
CREATE TABLE IF NOT EXISTS `domainesprojet` (
  `idDomaine` int(11) NOT NULL AUTO_INCREMENT,
  `libelleDomaine` varchar(30) NOT NULL,
  PRIMARY KEY (`idDomaine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `etapes`
--

DROP TABLE IF EXISTS `etapes`;
CREATE TABLE IF NOT EXISTS `etapes` (
  `idEtape` int(11) NOT NULL AUTO_INCREMENT,
  `nomEtape` varchar(50) NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `montantPrevu` double NOT NULL,
  `dureeJourPrevu` int(11) NOT NULL,
  `idProjet` int(11) NOT NULL,
  PRIMARY KEY (`idEtape`),
  KEY `idProjet` (`idProjet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `numeroFacture` int(11) NOT NULL AUTO_INCREMENT,
  `montantFacture` double NOT NULL,
  `dateFacture` date NOT NULL,
  `idProjet` int(11) NOT NULL,
  PRIMARY KEY (`numeroFacture`),
  KEY `idProjet` (`idProjet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `intervention`
--

DROP TABLE IF EXISTS `intervention`;
CREATE TABLE IF NOT EXISTS `intervention` (
  `idIntervention` int(11) NOT NULL AUTO_INCREMENT,
  `dureeHeure` int(11) NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `idProjet` int(11) NOT NULL,
  `idConsultant` int(11) NOT NULL,
  PRIMARY KEY (`idIntervention`),
  KEY `idProjet` (`idProjet`),
  KEY `idConsultant` (`idConsultant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `projets`
--

DROP TABLE IF EXISTS `projets`;
CREATE TABLE IF NOT EXISTS `projets` (
  `idProjet` int(11) NOT NULL AUTO_INCREMENT,
  `libelleProjet` varchar(40) NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `idDomaine` int(11) NOT NULL,
  PRIMARY KEY (`idProjet`),
  KEY `idDomaine` (`idDomaine`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `chefsprojet`
--
ALTER TABLE `chefsprojet`
  ADD CONSTRAINT `chefsprojet_ibfk_1` FOREIGN KEY (`idConsultant`) REFERENCES `consultants` (`idConsultant`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `chefsprojet_ibfk_2` FOREIGN KEY (`idProjet`) REFERENCES `projets` (`idProjet`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `etapes`
--
ALTER TABLE `etapes`
  ADD CONSTRAINT `etapes_ibfk_1` FOREIGN KEY (`idProjet`) REFERENCES `projets` (`idProjet`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `facture_ibfk_1` FOREIGN KEY (`idProjet`) REFERENCES `projets` (`idProjet`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `intervention`
--
ALTER TABLE `intervention`
  ADD CONSTRAINT `intervention_ibfk_1` FOREIGN KEY (`idProjet`) REFERENCES `projets` (`idProjet`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `intervention_ibfk_2` FOREIGN KEY (`idConsultant`) REFERENCES `consultants` (`idConsultant`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `projets`
--
ALTER TABLE `projets`
  ADD CONSTRAINT `projets_ibfk_1` FOREIGN KEY (`idDomaine`) REFERENCES `domainesprojet` (`idDomaine`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
