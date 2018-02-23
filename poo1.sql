/*
Navicat MySQL Data Transfer

Source Server         : MYSQLLOCAL
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : poo1

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2017-02-25 01:44:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for equipos
-- ----------------------------
DROP TABLE IF EXISTS `equipos`;
CREATE TABLE `equipos` (
  `codi_equi` int(11) NOT NULL AUTO_INCREMENT,
  `nomb_equi` varchar(255) DEFAULT NULL,
  `desc_equi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codi_equi`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jugadores
-- ----------------------------
DROP TABLE IF EXISTS `jugadores`;
CREATE TABLE `jugadores` (
  `codi_juga` int(11) NOT NULL AUTO_INCREMENT,
  `codi_equi` int(11) DEFAULT NULL,
  `nomb_juga` varchar(255) DEFAULT NULL,
  `edad_juga` varchar(255) DEFAULT NULL,
  `altu_juga` int(11) DEFAULT NULL,
  `peso_juga` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codi_juga`),
  KEY `codi_equi` (`codi_equi`) USING BTREE,
  CONSTRAINT `JUGADORES_ibfk_1` FOREIGN KEY (`codi_equi`) REFERENCES `equipos` (`codi_equi`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
