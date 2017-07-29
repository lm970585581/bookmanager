/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2017-07-29 21:09:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `ISBN` varchar(255) default NULL,
  `bookName` varchar(255) default NULL,
  `author` varchar(255) default NULL,
  `publisher` varchar(255) default NULL,
  `price` float(30,0) default NULL,
  `cnum` int(30) default NULL,
  `snum` int(30) default NULL,
  `summary` varchar(255) default NULL,
  `photo` blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of book
-- ----------------------------

-- ----------------------------
-- Table structure for `lend`
-- ----------------------------
DROP TABLE IF EXISTS `lend`;
CREATE TABLE `lend` (
  `bookId` varchar(255) default NULL,
  `readerId` varchar(255) default NULL,
  `ISBN` varchar(255) default NULL,
  `lTime` date default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of lend
-- ----------------------------

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `readerId` varchar(255) default NULL,
  `Name` varchar(255) default NULL,
  `sex` varchar(255) default NULL,
  `born` date default NULL,
  `spec` varchar(30) default NULL,
  `num` int(11) default NULL,
  `photo` blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Name` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `Role` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
