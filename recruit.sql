/*
Navicat MySQL Data Transfer

Source Server         : lww
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : recruit

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-01-07 20:32:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `candidate`
-- ----------------------------
DROP TABLE IF EXISTS `candidate`;
CREATE TABLE `candidate` (
  `candidateId` int(11) NOT NULL AUTO_INCREMENT,
  `candidateName` varchar(255) NOT NULL,
  `candidateGender` char(10) NOT NULL,
  `candidateAge` int(10) NOT NULL,
  `candidatePhone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `candidateIdCard` varchar(20) NOT NULL,
  `candidateEmail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `candidateAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `candidateMajor` varchar(255) NOT NULL,
  `candidateEducationed` varchar(255) NOT NULL,
  `candidateJobObjective` varchar(255) NOT NULL,
  `candidateWorkExperience` varchar(255) NOT NULL,
  `candidateAccount` varchar(255) NOT NULL,
  `candidatePassword` varchar(255) NOT NULL,
  PRIMARY KEY (`candidateId`)
) ENGINE=InnoDB AUTO_INCREMENT=667 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of candidate
-- ----------------------------
INSERT INTO `candidate` VALUES ('1', '李旺旺', '男', '22', '15587379525', '341223199711101939', '2458581040@qq.com', '安徽', ' 软件工程', '二本', '无', '无', '111', '123');
INSERT INTO `candidate` VALUES ('2', '邱璐', '女', '18', '17616152016', '1522232199711101939', '549687018@qq.com', '上海', '网络工程', '二本', '无', '无', '222', '123');
INSERT INTO `candidate` VALUES ('3', '周靖怡', '女', '19', '17616154083', '330203199711101939', '1814956792@qq.com', '浙江', '网络工程', '二本', '无', '无', '333', '123');
INSERT INTO `candidate` VALUES ('4', '穆正阳', '男', '20', '18853711558', '370826199711101939', '971557875@qq.com', '山东', '软件工程', '二本', '无', '无', '444', '123');
INSERT INTO `candidate` VALUES ('5', '周天乐', '男', '20', '17616152468', '430181199711101939', '1771240731@qq.com', '湖南', '软件工程', '二本', '无', '无', '555', '123');
INSERT INTO `candidate` VALUES ('6', '李华', '男', '20', '15587379525', '341223199711101939', '2458581040@qq.com', '上海', '材料工程', '本科', '月薪2万+', '3年工作经验', '666', '123');
INSERT INTO `candidate` VALUES ('24', '李旺旺', '男', '20', '15587379525', '341223199711101939', '2458581040@qq.com', '上海', '软件工程', '本科', '月薪5万+', '3年工作经验', '777', '123');

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `companyId` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(255) NOT NULL,
  `companyAddress` varchar(255) NOT NULL,
  `companyType` varchar(255) NOT NULL,
  `companyLegalPerson` varchar(255) NOT NULL,
  `companyEmail` varchar(255) NOT NULL,
  `companyPhone` varchar(255) NOT NULL,
  `companyCaptial` varchar(255) NOT NULL,
  `companyAccount` varchar(255) NOT NULL,
  `companyPassword` varchar(255) NOT NULL,
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB AUTO_INCREMENT=667 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '腾讯控股', '深圳', '互联网综合服务', '马化腾', '111', '111', '100万', '111', '123');
INSERT INTO `company` VALUES ('2', '百度公司', '北京', '互联网综合服务', '李彦宏', '222', '222', '100万', '222', '123');
INSERT INTO `company` VALUES ('3', '阿里巴巴', '杭州', '互联网移动支付', '马云', '333', '333', '100万', '333', '123');
INSERT INTO `company` VALUES ('4', '恒大地产', '深圳', '地产、文化、百货', '许家印', '444', '444', '101万', '444', '123');
INSERT INTO `company` VALUES ('5', '碧桂园控股', '顺德', '房地产', '杨惠妍', '555', '555', '90万', '555', '123');
INSERT INTO `company` VALUES ('6', '顺丰控股', '深圳', '物流', '王卫', '666', '666', '80万', '666', '123');

-- ----------------------------
-- Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `positionId` int(11) NOT NULL AUTO_INCREMENT,
  `positionName` varchar(255) NOT NULL,
  `companyId` int(11) NOT NULL,
  `positionIntroduction` varchar(10000) NOT NULL,
  `positionDiploma` varchar(255) NOT NULL,
  `positionLightspot` varchar(255) NOT NULL,
  PRIMARY KEY (`positionId`),
  KEY `companyId` (`companyId`),
  CONSTRAINT `position_ibfk_1` FOREIGN KEY (`companyId`) REFERENCES `company` (`companyid`)
) ENGINE=InnoDB AUTO_INCREMENT=3334 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('1', '软件工程师', '1', '开发软件', '本科及以上', '能干活、吃苦');
INSERT INTO `position` VALUES ('2', '嵌入式工程师', '1', '嵌入式开发', '本科及以上', '年轻、会学习');
INSERT INTO `position` VALUES ('3', '门卫', '1', '看大门', '本科及以上', '身体素质很好');
INSERT INTO `position` VALUES ('4', '软件工程师', '2', '开发软件', '本科及以上', '年轻、技术好');
INSERT INTO `position` VALUES ('5', '嵌入式开发工程师', '2', '嵌入式开发', '本科及以上', '吃苦、技术好');
INSERT INTO `position` VALUES ('6', '经理', '2', '未知', '研究生及以上学历', '技术高、对经济敏感');
INSERT INTO `position` VALUES ('7', '经理', '2', '未知', '研究生及以上学历', '技术高、对经济敏感');
INSERT INTO `position` VALUES ('8', '老总', '5', '管理公司', '博士生及以上', '技术好、学历高');
INSERT INTO `position` VALUES ('9', '嵌入式开发工程师', '5', '管理公司', '研究生及以上学历', '技术好、学历高');
INSERT INTO `position` VALUES ('10', '嵌入式开发工程师', '4', '管理公司', '研究生及以上学历', '技术好、学历高');
INSERT INTO `position` VALUES ('11', '嵌入式开发工程师', '5', '管理公司', '研究生及以上学历', '吃苦、技术好');
INSERT INTO `position` VALUES ('12', '嵌入式开发工程师', '4', '管理公司', '研究生及以上学历', '吃苦、技术好');
INSERT INTO `position` VALUES ('13', '嵌入式开发工程师', '5', '管理公司', '研究生及以上学历', '吃苦、技术好');

-- ----------------------------
-- Table structure for `resume`
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `candidateId` int(11) NOT NULL,
  `positionId` int(11) NOT NULL,
  `isInterview` int(4) DEFAULT NULL,
  PRIMARY KEY (`candidateId`,`positionId`),
  KEY `positionId` (`positionId`),
  CONSTRAINT `resume_ibfk_1` FOREIGN KEY (`candidateId`) REFERENCES `candidate` (`candidateid`),
  CONSTRAINT `resume_ibfk_2` FOREIGN KEY (`positionId`) REFERENCES `position` (`positionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES ('1', '1', '0');
INSERT INTO `resume` VALUES ('1', '2', '0');
INSERT INTO `resume` VALUES ('1', '3', '0');
INSERT INTO `resume` VALUES ('1', '4', '0');
INSERT INTO `resume` VALUES ('1', '5', '0');
INSERT INTO `resume` VALUES ('1', '6', '0');
INSERT INTO `resume` VALUES ('1', '10', '0');
INSERT INTO `resume` VALUES ('1', '12', '0');
INSERT INTO `resume` VALUES ('2', '1', '0');
INSERT INTO `resume` VALUES ('2', '4', '0');
INSERT INTO `resume` VALUES ('3', '3', '0');
INSERT INTO `resume` VALUES ('4', '3', '0');
