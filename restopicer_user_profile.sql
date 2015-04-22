-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015-04-22 11:18:58
-- 服务器版本： 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `restopicer_user_profile`
--

-- --------------------------------------------------------

--
-- 表的结构 `preference_keyword`
--

CREATE TABLE IF NOT EXISTS `preference_keyword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `keyword` varchar(1500) NOT NULL,
  `type` int(11) NOT NULL DEFAULT '1',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `preference_paper`
--

CREATE TABLE IF NOT EXISTS `preference_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `item_ut` char(15) NOT NULL,
  `rating` int(11) NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `subject_category`
--

CREATE TABLE IF NOT EXISTS `subject_category` (
  `sc_code` varchar(2) NOT NULL,
  `subject_category` varchar(100) NOT NULL,
  PRIMARY KEY (`sc_code`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `subject_category`
--

INSERT INTO `subject_category` (`sc_code`, `subject_category`) VALUES
('DI', 'BUSINESS'),
('EP', 'COMPUTER SCIENCE, ARTIFICIAL INTELLIGENCE'),
('ET', 'COMPUTER SCIENCE, INFORMATION SYSTEMS'),
('EW', 'COMPUTER SCIENCE, SOFTWARE ENGINEERING'),
('NU', 'INFORMATION SCIENCE & LIBRARY SCIENCE'),
('PC', 'MANAGEMENT'),
('PE', 'OPERATIONS RESEARCH & MANAGEMENT SCIENCE');

-- --------------------------------------------------------

--
-- 表的结构 `user_filter_category`
--

CREATE TABLE IF NOT EXISTS `user_filter_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `sc_code` varchar(2) NOT NULL,
  `selected` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `user_filter_category`
--

INSERT INTO `user_filter_category` (`id`, `user_id`, `sc_code`, `selected`) VALUES
(1, 2, 'DI', 1),
(2, 2, 'EP', 1),
(3, 2, 'ET', 1),
(4, 2, 'EW', 1),
(5, 2, 'NU', 1),
(6, 2, 'PC', 1),
(7, 2, 'PE', 1);

-- --------------------------------------------------------

--
-- 表的结构 `user_info`
--

CREATE TABLE IF NOT EXISTS `user_info` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `beginning_year` year(4) NOT NULL DEFAULT '1955',
  `ending_year` year(4) NOT NULL DEFAULT '2015',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `userid` (`user_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `user_info`
--

INSERT INTO `user_info` (`user_id`, `beginning_year`, `ending_year`) VALUES
(2, 1955, 2015);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
