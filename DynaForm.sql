-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 20 Juin 2015 à 05:53
-- Version du serveur :  5.5.28
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `form`
--

-- --------------------------------------------------------

--
-- Structure de la table `cookie`
--

CREATE TABLE IF NOT EXISTS `cookie` (
  `ID_USER` int(11) DEFAULT NULL,
  `ID` char(26) NOT NULL DEFAULT '',
  PRIMARY KEY (`ID`),
  KEY `FK_RELATION_1` (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `form`
--

CREATE TABLE IF NOT EXISTS `form` (
  `ID_FORM` int(11) NOT NULL AUTO_INCREMENT,
  `ID_USER` int(11) DEFAULT NULL,
  `NAME` char(50) DEFAULT NULL,
  `CREATION_DATE` date DEFAULT NULL,
  `MODIFIED_DATE` date DEFAULT NULL,
  `FORM_PICTURE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_FORM`),
  KEY `FK_RELATION_1` (`ID_USER`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=94 ;

--
-- Contenu de la table `form`
--

INSERT INTO `form` (`ID_FORM`, `ID_USER`, `NAME`, `CREATION_DATE`, `MODIFIED_DATE`, `FORM_PICTURE`) VALUES
(2, NULL, 'form 1', NULL, NULL, ''),
(3, NULL, 'form 3', NULL, NULL, ''),
(4, NULL, 'form 4', NULL, NULL, ''),
(5, NULL, 'form 5', NULL, NULL, ''),
(7, NULL, 'form 7', NULL, NULL, ''),
(9, NULL, 'oussama', '2015-01-31', NULL, ''),
(10, NULL, NULL, '2015-01-31', NULL, ''),
(11, NULL, NULL, '2015-02-01', NULL, ''),
(12, NULL, NULL, '2015-02-01', NULL, ''),
(13, NULL, NULL, '2015-02-01', NULL, ''),
(14, NULL, NULL, '2015-02-01', NULL, ''),
(15, NULL, NULL, '2015-02-01', NULL, ''),
(16, NULL, NULL, '2015-02-01', NULL, ''),
(17, NULL, NULL, '2015-02-01', NULL, ''),
(18, NULL, NULL, '2015-02-01', NULL, ''),
(19, NULL, NULL, '2015-02-01', NULL, ''),
(20, NULL, NULL, '2015-02-01', NULL, ''),
(21, NULL, NULL, '2015-02-01', NULL, ''),
(22, NULL, NULL, '2015-02-01', NULL, ''),
(23, NULL, NULL, '2015-02-01', NULL, ''),
(24, NULL, NULL, '2015-02-03', NULL, ''),
(25, NULL, NULL, '2015-02-03', NULL, ''),
(26, NULL, NULL, '2015-02-03', NULL, ''),
(27, NULL, NULL, '2015-02-03', NULL, ''),
(28, NULL, NULL, '2015-02-03', NULL, ''),
(29, NULL, NULL, '2015-02-03', NULL, ''),
(30, NULL, NULL, '2015-02-03', NULL, ''),
(31, NULL, NULL, '2015-02-03', NULL, ''),
(32, NULL, NULL, '2015-02-03', NULL, ''),
(33, NULL, NULL, '2015-02-03', NULL, ''),
(34, NULL, NULL, '2015-02-03', NULL, ''),
(35, NULL, NULL, '2015-02-03', NULL, ''),
(36, NULL, NULL, '2015-02-03', NULL, ''),
(37, NULL, NULL, '2015-02-03', NULL, ''),
(38, NULL, NULL, '2015-02-03', NULL, ''),
(39, NULL, NULL, '2015-02-03', NULL, ''),
(40, NULL, NULL, '2015-02-03', NULL, ''),
(41, NULL, NULL, '2015-02-03', NULL, ''),
(42, NULL, NULL, '2015-02-03', NULL, ''),
(43, NULL, NULL, '2015-02-03', NULL, ''),
(44, NULL, NULL, '2015-02-03', NULL, ''),
(45, NULL, NULL, '2015-02-03', NULL, ''),
(46, NULL, NULL, '2015-02-03', NULL, ''),
(47, NULL, NULL, '2015-02-03', NULL, ''),
(48, NULL, NULL, '2015-02-03', NULL, ''),
(49, NULL, NULL, '2015-02-03', NULL, ''),
(50, NULL, NULL, '2015-02-03', NULL, ''),
(51, NULL, NULL, '2015-02-03', NULL, ''),
(52, NULL, NULL, '2015-02-03', NULL, ''),
(53, NULL, NULL, '2015-02-03', NULL, ''),
(54, NULL, NULL, '2015-02-03', NULL, ''),
(55, NULL, NULL, '2015-02-03', NULL, ''),
(56, NULL, NULL, '2015-02-03', NULL, ''),
(57, NULL, NULL, '2015-02-03', NULL, ''),
(58, NULL, NULL, '2015-02-03', NULL, ''),
(59, NULL, NULL, '2015-02-03', NULL, ''),
(60, NULL, NULL, '2015-02-03', NULL, ''),
(61, NULL, NULL, '2015-02-03', NULL, ''),
(62, NULL, NULL, '2015-02-04', NULL, ''),
(63, NULL, NULL, '2015-02-04', NULL, ''),
(64, 1, 'testform', '2015-02-17', '2015-02-11', '/images/form/default.jpg'),
(65, NULL, NULL, '2015-02-19', NULL, ''),
(66, NULL, NULL, '2015-02-19', NULL, ''),
(67, NULL, NULL, '2015-02-19', NULL, ''),
(68, NULL, NULL, '2015-02-19', NULL, ''),
(69, NULL, 'form1', '2015-02-19', NULL, ''),
(70, NULL, 'form1', '2015-02-19', NULL, ''),
(71, NULL, 'Untitled', '2015-02-19', NULL, ''),
(73, NULL, 'oussama', '2015-02-19', '2015-02-20', ''),
(75, NULL, 'Untitled', '2015-02-20', '2015-02-20', ''),
(76, NULL, 'Untitled', '2015-02-22', NULL, ''),
(77, NULL, 'wafai', '2015-02-26', NULL, ''),
(78, NULL, 'dada', '2015-05-13', NULL, '/images/form/default.jpg'),
(80, 2, 'fAhmed', '2015-05-18', NULL, '/images/form/default.jpg'),
(81, 2, 'faat', '2015-05-18', NULL, '/images/form/default.jpg'),
(84, 2, 'testage', '2015-05-19', NULL, '/images/form/default.jpg'),
(85, 2, 'ka', '2015-05-20', NULL, '/images/form/default.jpg'),
(86, 2, 'ww', '2015-05-20', NULL, '/images/form/default.jpg'),
(87, 2, 'gg', '2015-05-20', NULL, '/images/form/2074707013.jpg'),
(88, 2, 'dd', '2015-05-21', NULL, '/images/form/default.jpg'),
(90, 1, 'Evaluation du professeur', '2015-05-21', '2015-05-22', '/images/form/2068817956.png'),
(91, 1, 'test', '2015-05-22', NULL, '/images/form/default.jpg'),
(93, 1, 'yourself', '2015-06-20', NULL, '/images/form/default.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `input`
--

CREATE TABLE IF NOT EXISTS `input` (
  `ID_INPUT` int(11) NOT NULL AUTO_INCREMENT,
  `ID_FORM` int(11) DEFAULT NULL,
  `ID_TYPE` int(11) NOT NULL,
  `TITLE` char(100) DEFAULT NULL,
  `LABEL` char(20) DEFAULT NULL,
  `INPUT_ORDER` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_INPUT`),
  KEY `FK_RELATION_2` (`ID_FORM`),
  KEY `FK_RELATION_6` (`ID_TYPE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=205 ;

--
-- Contenu de la table `input`
--

INSERT INTO `input` (`ID_INPUT`, `ID_FORM`, `ID_TYPE`, `TITLE`, `LABEL`, `INPUT_ORDER`) VALUES
(7, 2, 101, 'dsds', NULL, NULL),
(8, 3, 101, 'dsds', NULL, NULL),
(9, 4, 101, 'what is your name ?', NULL, NULL),
(10, NULL, 101, 'your age ?', NULL, NULL),
(11, NULL, 101, 'your favorite game', NULL, NULL),
(12, 5, 101, 'your favorite game?', NULL, NULL),
(13, 7, 102, 'do you love ?', NULL, NULL),
(15, 9, 101, 'whats your name ?', NULL, NULL),
(16, NULL, 102, 'your gender', NULL, NULL),
(17, NULL, 102, 'are you racist ?', NULL, NULL),
(18, 10, 102, 'gender?', NULL, NULL),
(19, 10, 101, 'who are you ?', NULL, NULL),
(20, 10, 102, 'where do you leave ?', NULL, NULL),
(21, 11, 102, 'your name ?', NULL, NULL),
(22, 11, 102, 'game?', NULL, NULL),
(23, 12, 102, '', NULL, NULL),
(24, 12, 102, '', NULL, NULL),
(25, 12, 101, 'kkkkkkkkkkkkkkkkkkkk', NULL, NULL),
(26, 13, 101, 'dfdfdf', NULL, NULL),
(27, 13, 102, 'salut', NULL, NULL),
(28, 14, 102, 'chwa', NULL, NULL),
(29, 15, 102, 'll', NULL, NULL),
(30, 16, 101, NULL, NULL, NULL),
(31, 16, 102, 'll', NULL, NULL),
(32, 17, 102, 'cxd', NULL, NULL),
(33, 17, 102, 'hhhhhh', NULL, NULL),
(34, 18, 102, 'cxd', NULL, NULL),
(35, 18, 102, 'hhhhhh', NULL, NULL),
(36, 19, 101, 'dfg', NULL, NULL),
(37, 19, 102, 'www', NULL, NULL),
(38, 20, 101, '', NULL, NULL),
(39, 20, 102, '', NULL, NULL),
(40, 21, 102, 'aaaaa', NULL, NULL),
(41, 21, 101, 'ae', NULL, NULL),
(42, 22, 102, 'c', NULL, NULL),
(43, 22, 102, 'b', NULL, NULL),
(44, 22, 101, 'a', NULL, NULL),
(45, 22, 102, '', NULL, NULL),
(46, 23, 102, 'kkkk', NULL, NULL),
(47, 23, 101, 'llll', NULL, NULL),
(48, 23, 102, 'sss', NULL, NULL),
(49, 24, 101, 'what''s your name ?', NULL, NULL),
(50, 24, 105, 'favorite food', NULL, NULL),
(51, 24, 102, 'your favorite game?', NULL, NULL),
(52, 24, 104, 'your language?', NULL, NULL),
(53, 25, 101, 'your text?', NULL, NULL),
(54, 25, 102, 'list?', NULL, NULL),
(55, 25, 102, 'another list?', NULL, NULL),
(56, 26, 102, 'another list?', NULL, NULL),
(57, 26, 102, 'list?', NULL, NULL),
(58, 26, 101, 'your text?', NULL, NULL),
(59, 27, 102, 'another list?', NULL, NULL),
(60, 27, 102, 'list?', NULL, NULL),
(61, 27, 101, 'your text?', NULL, NULL),
(62, 28, 102, 'list?', NULL, NULL),
(63, 28, 101, 'your text?', NULL, NULL),
(64, 28, 102, 'another list?', NULL, NULL),
(65, 29, 102, '3', NULL, NULL),
(66, 29, 101, '1', NULL, NULL),
(67, 29, 101, '2', NULL, NULL),
(68, 30, 101, '2', NULL, NULL),
(69, 30, 101, '1', NULL, NULL),
(70, 30, 101, '3', NULL, NULL),
(71, 31, 101, '1', NULL, NULL),
(72, 32, 101, '2', NULL, NULL),
(73, 32, 101, '1', NULL, NULL),
(74, 32, 102, '3', NULL, NULL),
(75, 33, 101, '1', NULL, NULL),
(76, 33, 102, '2', NULL, NULL),
(77, 34, 101, 'aaa', NULL, NULL),
(78, 34, 102, 'ff', NULL, NULL),
(79, 35, 102, 'bbbbb', NULL, NULL),
(80, 35, 101, 'aaaaaa', NULL, NULL),
(81, 36, 102, 'bbbb', NULL, NULL),
(82, 36, 101, 'aaa', NULL, NULL),
(83, 37, 101, 'sssss', NULL, NULL),
(84, 37, 102, 'ddddd', NULL, NULL),
(85, 38, 101, 'aaa', NULL, NULL),
(86, 38, 102, 'bb', NULL, NULL),
(87, 39, 101, 'oussama', NULL, NULL),
(88, 39, 102, 'reguez', NULL, NULL),
(89, 40, 101, 'text', NULL, NULL),
(90, 40, 102, 'select', NULL, NULL),
(91, 41, 102, 'bbbb', NULL, NULL),
(92, 41, 101, 'aaaa', NULL, NULL),
(93, 41, 101, '', NULL, NULL),
(94, 42, 101, 'aaaaaaaaa', NULL, NULL),
(95, 42, 102, 'bbbbbbbbb', NULL, NULL),
(96, 43, 102, '', NULL, NULL),
(97, 43, 101, '', NULL, NULL),
(98, 44, 102, '', NULL, NULL),
(99, 44, 101, 'aa', NULL, NULL),
(100, 45, 102, '', NULL, NULL),
(101, 45, 101, '', NULL, NULL),
(102, NULL, 102, 'bb', NULL, NULL),
(103, 46, 101, 'aa', NULL, NULL),
(104, 47, 101, 'a', NULL, NULL),
(105, 47, 102, 'b', NULL, NULL),
(106, 48, 102, 'b', NULL, NULL),
(107, 48, 101, '', NULL, NULL),
(108, 49, 101, '', NULL, NULL),
(109, 49, 102, '', NULL, NULL),
(110, 50, 102, '', NULL, NULL),
(111, 50, 101, '', NULL, NULL),
(112, 51, 102, '', NULL, NULL),
(113, 51, 101, '', NULL, NULL),
(114, 52, 102, '', NULL, NULL),
(115, 52, 101, '', NULL, NULL),
(116, 53, 102, 'ds', NULL, NULL),
(117, 53, 101, '', NULL, NULL),
(118, 54, 102, 'd', NULL, NULL),
(119, 54, 101, '', NULL, NULL),
(120, 55, 101, '', NULL, NULL),
(121, 55, 102, 'a', NULL, NULL),
(122, 56, 101, '', NULL, NULL),
(123, 56, 102, '', NULL, NULL),
(124, 57, 102, 'ddddd', NULL, NULL),
(125, 57, 101, '', NULL, NULL),
(126, 58, 102, 'ddd', NULL, NULL),
(127, 58, 101, '', NULL, NULL),
(128, NULL, 101, '', NULL, NULL),
(129, 59, 102, '', NULL, NULL),
(130, 60, 102, 'dd', NULL, NULL),
(131, 60, 102, '', NULL, NULL),
(132, 61, 102, '', NULL, NULL),
(133, 61, 101, '', NULL, NULL),
(134, NULL, 102, '', NULL, NULL),
(135, 62, 101, 'xx', NULL, NULL),
(136, 63, 101, '', NULL, NULL),
(137, NULL, 102, '', NULL, NULL),
(138, 64, 101, 'what''s your name ?', NULL, NULL),
(139, 64, 102, 'favorite game ?', NULL, NULL),
(140, 64, 103, 'describe yours', NULL, NULL),
(143, 64, 105, 'favorite film?', NULL, NULL),
(144, 64, 106, 'date ?', NULL, NULL),
(145, 65, 101, NULL, NULL, NULL),
(146, 66, 101, NULL, NULL, NULL),
(147, 67, 101, NULL, NULL, NULL),
(148, 68, 101, 'aze', NULL, NULL),
(149, 68, 102, 'dff', NULL, NULL),
(150, 69, 101, 'err', NULL, NULL),
(151, 69, 102, 'err', NULL, NULL),
(152, 70, 101, 'err', NULL, NULL),
(153, 70, 102, 'err', NULL, NULL),
(154, 71, 101, '', NULL, NULL),
(161, 73, 101, 'ezzzzz', NULL, NULL),
(165, 75, 101, 'INPUT1', NULL, 0),
(166, 75, 102, 'INPUT3', NULL, 2),
(167, 75, 101, 'midle', NULL, 1),
(168, 76, 101, 'dfdf', NULL, 0),
(169, 77, 101, 'whats you rname', NULL, 0),
(170, 77, 102, 'favorite game', NULL, 1),
(171, 64, 101, 'test', NULL, NULL),
(172, 78, 103, 'bbbbbb', NULL, 1),
(173, 78, 101, 'aaaaaaa', NULL, 0),
(176, 80, 101, 'salut?', NULL, 0),
(177, 81, 101, 'zz', NULL, 0),
(187, 84, 101, 'this a test ?', NULL, 0),
(188, 85, 103, 'bbbb', NULL, 1),
(190, 85, 102, 'cccc', NULL, 2),
(191, 85, 101, 'aaaaaa', NULL, 0),
(192, 86, 101, 'aaazza', NULL, 0),
(193, 87, 101, 'gg?', NULL, 0),
(194, 88, 101, 'ssss', NULL, 0),
(195, 90, 105, 'L''enseignant maitrise visiblement cette matiére ?', NULL, 1),
(196, 90, 105, 'Les reponses aux etudiant sont claires et precis ?', NULL, 2),
(197, 90, 105, 'L''enseignant est ponctuel?', NULL, 0),
(198, 90, 103, 'Suggestion a l''enseignant', NULL, 3),
(199, 91, 101, 'q1', NULL, 0),
(200, 91, 105, 'q2', NULL, 1),
(202, 93, 101, 'whats your name', NULL, 0),
(203, 93, 102, 'your favorite color', NULL, 2),
(204, 93, 103, 'describe yourself', NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `list_value`
--

CREATE TABLE IF NOT EXISTS `list_value` (
  `ID_LIST_VALUE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_INPUT` int(11) DEFAULT NULL,
  `VALUE` char(100) DEFAULT NULL,
  PRIMARY KEY (`ID_LIST_VALUE`),
  KEY `FK_RELATION_9` (`ID_INPUT`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=202 ;

--
-- Contenu de la table `list_value`
--

INSERT INTO `list_value` (`ID_LIST_VALUE`, `ID_INPUT`, `VALUE`) VALUES
(54, 39, 'df'),
(55, 39, 'df'),
(56, 40, 'dd'),
(57, 40, 'ff'),
(58, 42, 'xx'),
(59, 43, 'xx'),
(60, 45, ''),
(61, 42, 'xx'),
(62, 48, 'f'),
(63, 46, 'dd'),
(64, 46, 'ff'),
(65, 48, 'd'),
(66, 52, 'english'),
(67, 50, 'hamburger'),
(68, 51, 'cs 1.6'),
(69, 50, 'pizza'),
(70, 52, 'french'),
(71, 51, 'cs go'),
(72, 54, 'a'),
(73, 55, 'fd'),
(74, 55, 'sd'),
(75, 54, 'c'),
(76, 54, 'b'),
(77, 56, 'fd'),
(78, 58, 'sd'),
(79, 58, 'fd'),
(80, 56, 'sd'),
(81, 56, 'c'),
(82, 59, 'fd'),
(83, 61, 'sd'),
(84, 61, 'fd'),
(85, 59, 'c'),
(86, 59, 'sd'),
(87, 64, 'sd'),
(88, 64, 'fd'),
(89, 64, 'c'),
(90, 63, 'fd'),
(91, 63, 'sd'),
(92, 66, 'b'),
(93, 66, 'a'),
(94, 71, 'a'),
(95, 71, 'b'),
(96, 73, 'b'),
(97, 73, 'a'),
(98, 76, 'b'),
(99, 76, 'a'),
(100, 77, 'df'),
(101, 77, 'df'),
(102, 80, 'xxxxx'),
(103, 80, 'xxxxx'),
(104, 82, 'www'),
(105, 82, 'www'),
(106, 83, 'qq'),
(107, 83, 'dd'),
(108, 85, 'xxx'),
(109, 85, 'xxxx'),
(110, 87, 'xxxx'),
(111, 87, 'xxx'),
(112, 89, 'select'),
(113, 89, 'select'),
(114, 92, 'dfd'),
(115, 94, 'sdd'),
(116, 94, 'sdds'),
(117, 97, 'dd'),
(118, 98, ''),
(119, 98, 'aa'),
(120, 101, 'a'),
(121, 103, 'xx'),
(122, 102, 'hello'),
(123, 104, 'bb'),
(124, 104, 'aa'),
(125, 107, 'aa'),
(126, NULL, 'hello1'),
(127, 107, 'bb'),
(128, NULL, 'hello1'),
(129, NULL, 'hello1'),
(130, NULL, 'hello1'),
(131, NULL, 'hello1'),
(132, NULL, 'hello1'),
(133, NULL, 'hello1'),
(134, NULL, 'hello1'),
(135, NULL, 'hello1'),
(136, NULL, 'hello1'),
(137, NULL, 'dd'),
(138, NULL, 'hello1'),
(139, NULL, 'hello1'),
(140, NULL, 'ss'),
(141, 114, 'd'),
(142, 114, 'f'),
(143, 116, 'd'),
(144, 116, 's'),
(145, 118, 'dd'),
(146, 118, 'ggg'),
(147, 120, 'd'),
(148, 120, 'f'),
(149, NULL, 'hello1'),
(150, NULL, 'hello1'),
(151, NULL, 'gg'),
(152, NULL, 'dd'),
(153, NULL, 'hello1'),
(154, NULL, 'd'),
(155, NULL, 'd'),
(156, NULL, 'hello1'),
(157, 126, 'd'),
(158, 126, 'd'),
(159, 129, ''),
(160, NULL, 'ss'),
(161, 130, 'dd'),
(162, 130, 'dd'),
(163, 131, ''),
(164, 131, ''),
(165, 133, 'xx'),
(166, 133, 'xx'),
(167, 134, ''),
(168, 137, ''),
(169, 139, 'cs go'),
(170, 139, 'cs 1.6'),
(171, 143, 'pulp fiction'),
(172, 143, 'forrest gump'),
(173, 149, 'dfd'),
(174, 151, ''),
(175, 153, ''),
(180, 166, 'ZE'),
(181, 166, 'ER'),
(182, 170, 'cs 1.6'),
(183, 170, 'cs go'),
(184, 190, 'ccc'),
(187, 190, 'aaa'),
(189, 190, 'bbb'),
(190, 197, 'non'),
(191, 196, 'oui'),
(192, 195, 'oui'),
(193, 195, 'non'),
(194, 196, 'non'),
(195, 197, 'oui'),
(196, 200, 'b'),
(197, 200, 'a'),
(198, 203, 'red'),
(199, 203, 'blue'),
(200, 203, 'white'),
(201, 203, 'black');

-- --------------------------------------------------------

--
-- Structure de la table `password_reset`
--

CREATE TABLE IF NOT EXISTS `password_reset` (
  `ID_USER` int(11) DEFAULT NULL,
  `TOKEN` char(26) NOT NULL DEFAULT '',
  PRIMARY KEY (`TOKEN`),
  KEY `FK_RELATION_1` (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `password_reset`
--

INSERT INTO `password_reset` (`ID_USER`, `TOKEN`) VALUES
(1, '2pbmul3qaj7q6dbco2u6sknipr'),
(1, '53t13f4djogn78o84744v0s8as'),
(1, '688tpauvs17irqbcrgjonv5pn5'),
(1, '8vaac08k7h2humhsc4m8unc5ie'),
(1, 'cnt9p353rh7tk6nu49i9g9qfr0'),
(1, 'g94mpu0ngra28irg6ks220oamb'),
(1, 'j38guhojehfvebi57rprmm4rl'),
(1, 'lhg4n5rmu1nggfmjibmn5q4bun'),
(1, 'nd0ni7sol4urghe91mjvb4oij'),
(1, 'tethtpfu14uelbc611lqtho9o9'),
(6, 'j24oc0l0obdfc7i7d5k0jhpovq');

-- --------------------------------------------------------

--
-- Structure de la table `submitted_form`
--

CREATE TABLE IF NOT EXISTS `submitted_form` (
  `ID_SUBMITTED_FORM` int(11) NOT NULL AUTO_INCREMENT,
  `ID_FORM` int(11) NOT NULL,
  `ID_USER` int(11) DEFAULT NULL,
  `DATE_` date DEFAULT NULL,
  `NAME` varchar(20) NOT NULL DEFAULT 'no-name',
  PRIMARY KEY (`ID_SUBMITTED_FORM`),
  KEY `FK_RELATION_7` (`ID_FORM`),
  KEY `FK_RELATION_8` (`ID_USER`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=51 ;

--
-- Contenu de la table `submitted_form`
--

INSERT INTO `submitted_form` (`ID_SUBMITTED_FORM`, `ID_FORM`, `ID_USER`, `DATE_`, `NAME`) VALUES
(1, 64, 1, '2015-05-16', ''),
(2, 64, NULL, '2015-05-16', ''),
(3, 64, NULL, '2015-03-04', ''),
(4, 64, NULL, '2015-03-04', ''),
(5, 64, NULL, '2015-03-10', ''),
(6, 64, NULL, '2015-03-10', ''),
(7, 64, NULL, '2015-03-10', ''),
(8, 64, NULL, '2015-03-10', ''),
(29, 84, 1, '2015-05-19', '2015-05-19-1'),
(30, 84, 2, '2015-05-19', '2015-05-19-2'),
(31, 85, 2, '2015-05-20', '2015-05-20-1'),
(32, 90, 26, '2015-05-21', '2015-05-21-1'),
(33, 90, 26, '2015-05-21', '2015-05-21-2'),
(34, 90, 26, '2015-05-21', '2015-05-21-3'),
(35, 90, 26, '2015-05-21', '2015-05-21-4'),
(36, 90, 26, '2015-05-27', '2015-05-27-1'),
(37, 90, 26, '2015-05-27', '2015-05-27-2'),
(38, 90, 26, '2015-05-27', '2015-05-27-3'),
(39, 90, 26, '2015-05-31', '2015-05-31-1'),
(40, 90, 26, '2015-05-31', '2015-05-31-2'),
(41, 90, 26, '2015-05-31', '2015-05-31-3'),
(42, 90, 26, '2015-05-31', '2015-05-31-4'),
(43, 90, 36, '2015-06-02', '2015-06-02-1'),
(44, 90, 36, '2015-06-02', '2015-06-02-2'),
(45, 90, 36, '2015-06-08', '2015-06-08-1'),
(46, 90, 36, '2015-06-08', '2015-06-08-2'),
(47, 90, 36, '2015-06-08', '2015-06-08-3'),
(48, 90, 2, '2015-05-22', '2015-05-22-1'),
(49, 90, 44, '2015-06-20', '2015-06-20-1'),
(50, 90, 45, '2015-06-20', '2015-06-20-1');

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

CREATE TABLE IF NOT EXISTS `type` (
  `ID_TYPE` int(11) NOT NULL,
  `TYPE` char(30) DEFAULT NULL,
  PRIMARY KEY (`ID_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type`
--

INSERT INTO `type` (`ID_TYPE`, `TYPE`) VALUES
(101, 'textarea'),
(102, 'select'),
(103, 'paragraph'),
(104, 'checkbox'),
(105, 'radio boxes'),
(106, 'date');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ID_USER` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` char(30) DEFAULT NULL,
  `PASSWORD` char(32) DEFAULT NULL,
  `EMAIL` char(50) DEFAULT NULL,
  `USER_PICTURE` varchar(100) DEFAULT NULL,
  `GENDER` varchar(10) DEFAULT NULL,
  `FIRSTNAME` varchar(20) DEFAULT NULL,
  `LASTNAME` varchar(20) DEFAULT NULL,
  `LANGUAGE` varchar(5) DEFAULT 'en',
  `BIRTHDATE` date DEFAULT NULL,
  PRIMARY KEY (`ID_USER`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`ID_USER`, `USERNAME`, `PASSWORD`, `EMAIL`, `USER_PICTURE`, `GENDER`, `FIRSTNAME`, `LASTNAME`, `LANGUAGE`, `BIRTHDATE`) VALUES
(1, 'oussama', '3910dd2d465bc1bc499d47c7ca86d435', 'oussamareguez@gmail.com', '/images/user/1861151386.jpg', 'Male', 'oussama', 'reguezzz', 'en', '1993-03-23'),
(2, 'ahmed', '3910dd2d465bc1bc499d47c7ca86d435', 'ahmed@gmail.com', '/images/user/800917568.jpg', 'Male', 'ahmed', 'ouaer', 'en', '1995-02-01'),
(3, 'karim', '3910dd2d465bc1bc499d47c7ca86d435', 'oussam@gmail.com', '/images/user/default.jpg', 'Male', 'dd', 'dd', 'en', NULL),
(4, '', 'kk', 'kyjk@mail.com', '/images/user/default.jpg', 'Male', 'kk', 'kk', 'en', NULL),
(5, '', 'qqq', 'sdfsd@mail.com', '/images/user/default.jpg', 'Male', 'sdq', 'sdq', 'en', NULL),
(6, '', 'aaaa', 'sdfsdf@mail.com', '/images/user/default.jpg', 'Male', 'aaaa', 'aaaa', 'en', NULL),
(7, '', 'xxxx', 'xxxx@mail.com', '/images/user/default.jpg', 'Male', 'xxxx', 'xxx', 'en', NULL),
(8, '', 'qqq', 'qsd@mail.com', '/images/user/default.jpg', 'Male', 'df', 'ds', 'en', NULL),
(9, 'sdf', 'sdf', 'sdfdfsd@mail.com', '/images/user/default.jpg', 'Male', 'sdf', 'sdf', 'en', NULL),
(10, 'mmm', 'sss', 'qsdqsd@mail.com', '/images/user/default.jpg', 'Male', 'mmm', 'mmm', 'en', NULL),
(11, 'mtlc', '789', 'mounir@gmail.com', '/images/user/default.jpg', 'Male', 'mounir', 'salem', 'en', '1962-05-21'),
(12, 'salim', '3910dd2d465bc1bc499d47c7ca86d435', 'salim@gmail.com', '/images/user/default.jpg', 'Male', 'salim', 'salim', 'en', '2015-05-19'),
(25, NULL, NULL, NULL, NULL, 'Male', NULL, NULL, 'en', '1993-03-23'),
(26, 'amine', '3910dd2d465bc1bc499d47c7ca86d435', 'amine@gmail.com', NULL, 'Male', 'amine', 'amine', 'en', '1997-03-23'),
(27, NULL, NULL, NULL, NULL, 'Male', NULL, NULL, 'en', '1991-03-23'),
(28, NULL, NULL, NULL, NULL, 'Male', NULL, NULL, 'en', '1993-03-23'),
(29, NULL, NULL, NULL, NULL, 'Male', NULL, NULL, 'en', '1993-03-23'),
(30, NULL, NULL, NULL, NULL, 'Male', NULL, NULL, 'en', '2000-03-23'),
(31, NULL, NULL, NULL, NULL, 'Male', NULL, NULL, 'en', '2000-03-23'),
(32, NULL, NULL, NULL, NULL, 'Male', NULL, NULL, 'en', '2001-03-23'),
(33, NULL, NULL, NULL, NULL, 'Male', NULL, NULL, 'en', '1995-03-23'),
(34, NULL, NULL, NULL, NULL, 'Male', NULL, NULL, 'en', '1989-03-23'),
(35, NULL, NULL, NULL, NULL, 'Male', NULL, NULL, 'en', '1989-03-23'),
(36, NULL, NULL, NULL, NULL, 'Female', NULL, NULL, 'en', '1989-03-23'),
(37, NULL, NULL, NULL, NULL, 'Female', NULL, NULL, 'en', '2002-03-23'),
(38, NULL, NULL, NULL, NULL, 'Female', NULL, NULL, 'en', '1993-03-23'),
(39, NULL, NULL, NULL, NULL, 'Female', NULL, NULL, 'en', '1993-03-23'),
(40, NULL, NULL, NULL, NULL, 'Female', NULL, NULL, 'en', '1996-03-23'),
(41, NULL, NULL, NULL, NULL, 'Female', NULL, NULL, 'en', '1996-03-23'),
(42, NULL, NULL, NULL, NULL, 'Female', NULL, NULL, 'en', '1996-03-23'),
(43, 'dadou', '4cb9749ed0deccc9927687401967a193', 'dadou@gmail.com', '/images/user/default.jpg', 'Male', 'dadou', 'dadou', 'en', '2015-06-10'),
(44, 'salim31', '9fab6755cd2e8817d3e73b0978ca54a6', 'salim16@gmail.com', '/images/user/default.jpg', 'Male', 'salim', 'reguez', 'en', '1993-06-15'),
(45, 'salim14', '9fab6755cd2e8817d3e73b0978ca54a6', 'salim45@gmail.com', '/images/user/default.jpg', 'Male', 'salim', 'mbarek', 'en', '1992-06-17');

-- --------------------------------------------------------

--
-- Structure de la table `value`
--

CREATE TABLE IF NOT EXISTS `value` (
  `ID_VALUE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_INPUT` int(11) DEFAULT NULL,
  `ID_SUBMITTED_FORM` int(11) DEFAULT NULL,
  `VALUE` char(100) DEFAULT NULL,
  PRIMARY KEY (`ID_VALUE`),
  KEY `FK_RELATION_10` (`ID_SUBMITTED_FORM`),
  KEY `FK_RELATION_3` (`ID_INPUT`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=142 ;

--
-- Contenu de la table `value`
--

INSERT INTO `value` (`ID_VALUE`, `ID_INPUT`, `ID_SUBMITTED_FORM`, `VALUE`) VALUES
(1, 138, 1, 'OUSSAMA'),
(3, 139, 1, 'cs  go'),
(4, 140, 1, 'sdfsfsfsfsfdf'),
(6, 143, 1, 'pulp fiction'),
(8, 138, 2, 'jjj'),
(9, 139, 2, 'cs go'),
(10, 140, 2, 'dfdfs'),
(11, 143, 2, 'pulp fiction'),
(12, 138, 3, 'd'),
(13, 139, 3, 'cs go'),
(14, 140, 3, 'd'),
(15, 143, 3, 'pulp fiction'),
(16, 138, 4, 'df'),
(17, 139, 4, 'cs go'),
(18, 140, 4, 'df'),
(19, 143, 4, 'forrest gump'),
(30, 171, NULL, 'test ahmed'),
(60, 187, 29, 'ok'),
(61, 187, 30, 'ok'),
(62, 190, 31, 'aaa'),
(64, 191, 31, 'ahmed'),
(65, 188, 31, 'para'),
(66, 195, 32, 'oui'),
(67, 196, 32, 'non'),
(68, 197, 32, 'oui'),
(69, 198, 32, 'pas de suggestion'),
(70, 195, 33, 'oui'),
(71, 196, 33, 'non'),
(72, 197, 33, 'oui'),
(73, 198, 33, 'pas de suggestion'),
(78, 195, 35, 'oui'),
(79, 196, 35, 'oui'),
(80, 197, 35, 'oui'),
(81, 198, 35, 'rien'),
(82, 195, 36, 'oui'),
(83, 196, 36, 'oui'),
(84, 197, 36, 'oui'),
(85, 198, 35, 'continuer'),
(86, 195, 37, 'non'),
(87, 196, 37, 'oui'),
(88, 197, 37, 'oui'),
(89, 198, 37, 'pas de commentaire'),
(90, 197, 38, 'oui'),
(91, 196, 38, 'oui'),
(92, 195, 38, 'oui'),
(93, 198, 38, 'enseignant intelligent'),
(94, 195, 39, 'oui'),
(95, 197, 39, 'non'),
(96, 198, 39, 'enseignant mechant'),
(97, 196, 39, 'oui'),
(98, 196, 40, 'oui'),
(99, 197, 40, 'oui'),
(100, 195, 40, 'non'),
(101, 198, 40, 'rien de special'),
(102, 197, 41, 'oui'),
(103, 196, 41, 'oui'),
(104, 198, 41, 'travaillez plus'),
(105, 195, 41, 'non'),
(106, 197, 42, 'oui'),
(107, 198, 42, 'pas de suggestion'),
(108, 195, 42, 'non'),
(109, 196, 42, 'oui'),
(110, 197, 43, 'non'),
(111, 198, 43, 'pas de suggestion'),
(112, 196, 43, 'oui'),
(113, 195, 43, 'oui'),
(114, 196, 44, 'non'),
(115, 197, 44, 'oui'),
(116, 198, 44, 'rien'),
(117, 195, 44, 'oui'),
(118, 197, 45, 'non'),
(119, 195, 45, 'non'),
(120, 198, 45, 'rien'),
(121, 196, 45, 'non'),
(122, 197, 46, 'oui'),
(123, 196, 46, 'oui'),
(124, 198, 46, 'rien'),
(125, 195, 46, 'non'),
(126, 198, 47, 'pas de suggestion'),
(127, 197, 47, 'oui'),
(128, 195, 47, 'oui'),
(129, 196, 47, 'oui'),
(130, 196, 48, 'oui'),
(131, 198, 48, 'pas de suggestion'),
(132, 195, 48, 'oui'),
(133, 197, 48, 'oui'),
(134, 195, 49, 'oui'),
(135, 198, 49, 'sdf'),
(136, 196, 49, 'oui'),
(137, 198, 50, 'pas de suggestion'),
(138, 197, 50, 'oui'),
(139, 197, 49, 'oui'),
(140, 196, 50, 'oui'),
(141, 195, 50, 'oui');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `form`
--
ALTER TABLE `form`
  ADD CONSTRAINT `FK_RELATION_1` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`);

--
-- Contraintes pour la table `input`
--
ALTER TABLE `input`
  ADD CONSTRAINT `FK_RELATION_2` FOREIGN KEY (`ID_FORM`) REFERENCES `form` (`ID_FORM`),
  ADD CONSTRAINT `FK_RELATION_6` FOREIGN KEY (`ID_TYPE`) REFERENCES `type` (`ID_TYPE`);

--
-- Contraintes pour la table `list_value`
--
ALTER TABLE `list_value`
  ADD CONSTRAINT `FK_RELATION_9` FOREIGN KEY (`ID_INPUT`) REFERENCES `input` (`ID_INPUT`);

--
-- Contraintes pour la table `submitted_form`
--
ALTER TABLE `submitted_form`
  ADD CONSTRAINT `FK_RELATION_7` FOREIGN KEY (`ID_FORM`) REFERENCES `form` (`ID_FORM`),
  ADD CONSTRAINT `FK_RELATION_8` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`);

--
-- Contraintes pour la table `value`
--
ALTER TABLE `value`
  ADD CONSTRAINT `FK_RELATION_10` FOREIGN KEY (`ID_SUBMITTED_FORM`) REFERENCES `submitted_form` (`ID_SUBMITTED_FORM`),
  ADD CONSTRAINT `FK_RELATION_3` FOREIGN KEY (`ID_INPUT`) REFERENCES `input` (`ID_INPUT`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
