/*
SQLyog Community Edition- MySQL GUI v6.54
MySQL - 5.5.57 : Database - happylab
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`happylab` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `happylab`;

/*Table structure for table `analyses` */

DROP TABLE IF EXISTS `analyses`;

CREATE TABLE `analyses` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `analyses` */

insert  into `analyses`(`id`,`name`,`code`) values (1,'АЭМ','aes');
insert  into `analyses`(`id`,`name`,`code`) values (2,'ПСА','psa');
insert  into `analyses`(`id`,`name`,`code`) values (3,'Санпин','sanpin');

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT '',
  `city` varchar(255) DEFAULT '',
  `remark` varchar(255) DEFAULT '',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=234 DEFAULT CHARSET=utf8;

/*Data for the table `customers` */

insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (73,'ТОО \"НИЦ \"BIOSPHERE KAZAKHSTAN\"','','',0);
insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (74,'ТОО \"ЦентрКазЭкоСервис\"','','',0);
insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (79,'ТОО \"Проектсервис\"','','',0);
insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (82,'ИП \"Выдрин Денис Евгеньевич\"','Караганда','',0);
insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (207,'ТОО \"Темиржолсу - Караганда\"','','',0);
insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (211,'ТОО \"Виста\"','','',0);
insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (215,'АО \"Темиртауский электрометаллургический комбинат\"','Темиртау','',0);
insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (217,'КГП \"Балхаш Су\"','','',0);
insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (219,'ТОО \"РЕМИКСЕР\"','','',0);
insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (228,'ТОО \"Медная компания Коунрад\"','','',0);
insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (229,'ТОО \"Сары-Казна\"','','',0);
insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (231,'Рога и копыта','Бобруйск','',0);
insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (232,'Золотое Руно','Улан-Батор','',0);
insert  into `customers`(`id`,`name`,`city`,`remark`,`deleted`) values (233,'Тяньши','Вавилон','',0);

/*Table structure for table `employees` */

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `lastname` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `positionId` int(11) unsigned NOT NULL,
  `assistant` tinyint(1) DEFAULT '0',
  `signature` tinyint(1) DEFAULT '0',
  `remark` varchar(255) DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `titleId_idx` (`positionId`),
  CONSTRAINT `position_id` FOREIGN KEY (`positionId`) REFERENCES `positions` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

/*Data for the table `employees` */

insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (3,'Чен','Алла','Яковлевна',4,-1,0,NULL,0);
insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (16,'Хасянова','Татьяна','Владимировна',19,-1,0,NULL,0);
insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (18,'Воробьев','Виталий','Юрьевич',7,-1,0,'',0);
insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (66,'Пензикова','Любовь','Ивановна',4,-1,0,NULL,0);
insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (72,'Стукалова','Тамара','Васильевна',23,0,0,NULL,0);
insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (76,'Федотовская','Ирина','Ивановна',26,0,0,'',0);
insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (85,'Москальцова','Марина','Викторовна',5,0,0,'',0);
insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (93,'Баранов','Антон','Юрьевич',29,-1,0,'',0);
insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (94,'Гамзина','Анастасия','Петровна',19,-1,0,'',0);
insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (96,'Курамаева','Марина','Александровна',7,0,0,'',0);
insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (97,'Лапенкова','Кристина','Владимировна',24,-1,0,'',0);
insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (99,'Улитенкова','Елена','Юрьевна',23,0,0,'',0);
insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (100,'Александрова','Ирина','Владимировна',1,0,-1,'',0);
insert  into `employees`(`id`,`lastname`,`name`,`surname`,`positionId`,`assistant`,`signature`,`remark`,`deleted`) values (101,'Медведев','Дмитрий','Анатольевич',7,0,0,'',0);

/*Table structure for table `journal_aes` */

DROP TABLE IF EXISTS `journal_aes`;

CREATE TABLE `journal_aes` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `probeId` int(11) unsigned NOT NULL,
  `date` date DEFAULT NULL,
  `employeeId` int(11) NOT NULL DEFAULT '0',
  `Ag` double(5,4) DEFAULT '0.0000',
  `Al` double(4,3) DEFAULT '0.000',
  `As` double(5,4) DEFAULT '0.0000',
  `B` double(4,3) DEFAULT '0.000',
  `Ba` double(5,4) DEFAULT '0.0000',
  `Be` double(6,5) DEFAULT '0.00000',
  `Bi` double(4,3) DEFAULT '0.000',
  `Ca` double(4,3) DEFAULT '0.000',
  `Cd` double(6,5) DEFAULT '0.00000',
  `Co` double(5,4) DEFAULT '0.0000',
  `Cr` double(5,4) DEFAULT '0.0000',
  `Cu` double(5,4) DEFAULT '0.0000',
  `Fe` double(4,3) DEFAULT '0.000',
  `K` double(4,3) DEFAULT '0.000',
  `Li` double(4,3) DEFAULT '0.000',
  `Mg` double(4,3) DEFAULT '0.000',
  `Mn` double(5,4) DEFAULT '0.0000',
  `Mo` double(5,4) DEFAULT '0.0000',
  `Na` double(3,2) DEFAULT '0.00',
  `Ni` double(5,4) DEFAULT '0.0000',
  `P` double(4,3) DEFAULT '0.000',
  `Pb` double(5,4) DEFAULT '0.0000',
  `S` double(4,3) DEFAULT '0.000',
  `Sb` double(5,4) DEFAULT '0.0000',
  `Se` double(5,4) DEFAULT '0.0000',
  `Si` double(4,3) DEFAULT '0.000',
  `Sn` double(5,4) DEFAULT '0.0000',
  `Sr` double(5,4) DEFAULT '0.0000',
  `Ti` double(5,4) DEFAULT '0.0000',
  `Tl` double(5,4) DEFAULT '0.0000',
  `V` double(5,4) DEFAULT '0.0000',
  `W` double(4,3) DEFAULT '0.000',
  `Zn` double(5,4) DEFAULT '0.0000',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id_idx` (`probeId`),
  CONSTRAINT `probes_id` FOREIGN KEY (`probeId`) REFERENCES `probes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `journal_aes` */

insert  into `journal_aes`(`id`,`probeId`,`date`,`employeeId`,`Ag`,`Al`,`As`,`B`,`Ba`,`Be`,`Bi`,`Ca`,`Cd`,`Co`,`Cr`,`Cu`,`Fe`,`K`,`Li`,`Mg`,`Mn`,`Mo`,`Na`,`Ni`,`P`,`Pb`,`S`,`Sb`,`Se`,`Si`,`Sn`,`Sr`,`Ti`,`Tl`,`V`,`W`,`Zn`,`deleted`) values (29,1,'2017-09-01',3,0.0060,0.005,0.0060,0.000,0.0060,0.00600,0.004,0.001,0.00700,0.0000,0.0060,0.0010,0.008,0.001,0.002,0.004,0.0000,0.0000,0.00,0.0080,0.007,0.0030,0.009,0.0030,0.0050,0.006,0.0080,0.0000,0.0090,0.0000,0.0090,0.001,0.0020,0);
insert  into `journal_aes`(`id`,`probeId`,`date`,`employeeId`,`Ag`,`Al`,`As`,`B`,`Ba`,`Be`,`Bi`,`Ca`,`Cd`,`Co`,`Cr`,`Cu`,`Fe`,`K`,`Li`,`Mg`,`Mn`,`Mo`,`Na`,`Ni`,`P`,`Pb`,`S`,`Sb`,`Se`,`Si`,`Sn`,`Sr`,`Ti`,`Tl`,`V`,`W`,`Zn`,`deleted`) values (30,1,'2017-10-10',93,0.0090,0.010,0.0020,0.009,0.0070,0.00100,0.000,0.007,0.00300,0.0010,0.0050,0.0100,0.010,0.003,0.010,0.008,0.0090,0.0080,0.00,0.0090,0.010,0.0100,0.009,0.0010,0.0030,0.000,0.0010,0.0100,0.0090,0.0080,0.0080,0.006,0.0040,0);
insert  into `journal_aes`(`id`,`probeId`,`date`,`employeeId`,`Ag`,`Al`,`As`,`B`,`Ba`,`Be`,`Bi`,`Ca`,`Cd`,`Co`,`Cr`,`Cu`,`Fe`,`K`,`Li`,`Mg`,`Mn`,`Mo`,`Na`,`Ni`,`P`,`Pb`,`S`,`Sb`,`Se`,`Si`,`Sn`,`Sr`,`Ti`,`Tl`,`V`,`W`,`Zn`,`deleted`) values (31,2,NULL,16,0.0050,0.005,0.0030,0.001,0.0010,0.01000,0.006,0.000,0.00400,0.0100,0.0070,0.0060,0.010,0.001,0.009,0.008,0.0100,0.0070,0.01,0.0030,0.004,0.0010,0.006,0.0090,0.0030,0.004,0.0000,0.0070,0.0010,0.0010,0.0100,0.001,0.0060,0);
insert  into `journal_aes`(`id`,`probeId`,`date`,`employeeId`,`Ag`,`Al`,`As`,`B`,`Ba`,`Be`,`Bi`,`Ca`,`Cd`,`Co`,`Cr`,`Cu`,`Fe`,`K`,`Li`,`Mg`,`Mn`,`Mo`,`Na`,`Ni`,`P`,`Pb`,`S`,`Sb`,`Se`,`Si`,`Sn`,`Sr`,`Ti`,`Tl`,`V`,`W`,`Zn`,`deleted`) values (32,3,'2017-09-11',18,0.0000,0.002,0.0030,0.004,0.0000,0.00700,0.006,0.000,0.01000,0.0000,0.0070,0.0040,0.002,0.005,0.003,0.003,0.0080,0.0060,0.00,0.0070,0.004,0.0060,0.010,0.0060,0.0030,0.001,0.0090,0.0080,0.0080,0.0050,0.0040,0.005,0.0010,0);
insert  into `journal_aes`(`id`,`probeId`,`date`,`employeeId`,`Ag`,`Al`,`As`,`B`,`Ba`,`Be`,`Bi`,`Ca`,`Cd`,`Co`,`Cr`,`Cu`,`Fe`,`K`,`Li`,`Mg`,`Mn`,`Mo`,`Na`,`Ni`,`P`,`Pb`,`S`,`Sb`,`Se`,`Si`,`Sn`,`Sr`,`Ti`,`Tl`,`V`,`W`,`Zn`,`deleted`) values (33,4,'2017-09-01',66,0.0070,0.006,0.0050,0.005,0.0030,0.00400,0.009,0.003,0.00700,0.0100,0.0040,0.0060,0.000,0.000,0.004,0.003,0.0080,0.0000,0.00,0.0060,0.004,0.0080,0.010,0.0070,0.0000,0.008,0.0100,0.0040,0.0070,0.0080,0.0010,0.002,0.0030,0);
insert  into `journal_aes`(`id`,`probeId`,`date`,`employeeId`,`Ag`,`Al`,`As`,`B`,`Ba`,`Be`,`Bi`,`Ca`,`Cd`,`Co`,`Cr`,`Cu`,`Fe`,`K`,`Li`,`Mg`,`Mn`,`Mo`,`Na`,`Ni`,`P`,`Pb`,`S`,`Sb`,`Se`,`Si`,`Sn`,`Sr`,`Ti`,`Tl`,`V`,`W`,`Zn`,`deleted`) values (34,5,NULL,93,0.0000,0.000,0.0040,0.006,0.0090,0.00800,0.008,0.003,0.00400,0.0000,0.0060,0.0020,0.005,0.000,0.004,0.009,0.0090,0.0070,0.00,0.0030,0.001,0.0040,0.005,0.0010,0.0080,0.002,0.0060,0.0060,0.0010,0.0100,0.0000,0.008,0.0060,0);

/*Table structure for table `journal_psa` */

DROP TABLE IF EXISTS `journal_psa`;

CREATE TABLE `journal_psa` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `probeId` int(11) unsigned NOT NULL,
  `date` date DEFAULT NULL,
  `employeeId` int(11) DEFAULT '0',
  `Ag` double(5,4) DEFAULT '0.0000',
  `Al` double(4,3) DEFAULT '0.000',
  `As` double(5,4) DEFAULT '0.0000',
  `Au` double(4,3) DEFAULT '0.000',
  `B` double(4,3) DEFAULT '0.000',
  `Ba` double(5,4) DEFAULT '0.0000',
  `Be` double(6,5) DEFAULT '0.00000',
  `Bi` double(4,3) DEFAULT '0.000',
  `Cd` double(6,5) DEFAULT '0.00000',
  `Ce` double(4,3) DEFAULT '0.000',
  `Co` double(5,4) DEFAULT '0.0000',
  `Cr` double(5,4) DEFAULT '0.0000',
  `Cu` double(5,4) DEFAULT '0.0000',
  `Fe` double(4,3) DEFAULT '0.000',
  `Ga` double(4,3) DEFAULT '0.000',
  `Ge` double(4,3) DEFAULT '0.000',
  `Hf` double(5,4) DEFAULT '0.0000',
  `In` double(4,3) DEFAULT '0.000',
  `La` double(5,4) DEFAULT '0.0000',
  `Li` double(4,3) DEFAULT '0.000',
  `Mn` double(5,4) DEFAULT '0.0000',
  `Mo` double(5,4) DEFAULT '0.0000',
  `Nb` double(5,4) DEFAULT '0.0000',
  `Ni` double(5,4) DEFAULT '0.0000',
  `P` double(4,3) DEFAULT '0.000',
  `Pb` double(5,4) DEFAULT '0.0000',
  `Pt` double(4,3) DEFAULT '0.000',
  `Sb` double(5,4) DEFAULT '0.0000',
  `Sc` double(6,5) DEFAULT '0.00000',
  `Sn` double(5,4) DEFAULT '0.0000',
  `Sr` double(5,4) DEFAULT '0.0000',
  `Ta` double(4,3) DEFAULT '0.000',
  `Te` double(6,5) DEFAULT '0.00000',
  `Th` double(5,4) DEFAULT '0.0000',
  `Ti` double(5,4) DEFAULT '0.0000',
  `Tl` double(5,4) DEFAULT '0.0000',
  `U` double(3,2) DEFAULT '0.00',
  `V` double(5,4) DEFAULT '0.0000',
  `W` double(4,3) DEFAULT '0.000',
  `Y` double(5,4) DEFAULT '0.0000',
  `Yb` double(6,5) DEFAULT '0.00000',
  `Zn` double(5,4) DEFAULT '0.0000',
  `Zr` double(5,4) DEFAULT '0.0000',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `probes_id_idx` (`probeId`),
  KEY `id_idx` (`probeId`),
  CONSTRAINT `id` FOREIGN KEY (`probeId`) REFERENCES `probes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `journal_psa` */

insert  into `journal_psa`(`id`,`probeId`,`date`,`employeeId`,`Ag`,`Al`,`As`,`Au`,`B`,`Ba`,`Be`,`Bi`,`Cd`,`Ce`,`Co`,`Cr`,`Cu`,`Fe`,`Ga`,`Ge`,`Hf`,`In`,`La`,`Li`,`Mn`,`Mo`,`Nb`,`Ni`,`P`,`Pb`,`Pt`,`Sb`,`Sc`,`Sn`,`Sr`,`Ta`,`Te`,`Th`,`Ti`,`Tl`,`U`,`V`,`W`,`Y`,`Yb`,`Zn`,`Zr`,`deleted`) values (30,1,'2017-08-10',97,0.0030,0.009,0.0030,0.002,0.010,0.0090,0.00000,0.008,0.00900,0.006,0.0030,0.0090,0.0020,0.007,0.006,0.003,0.0090,0.008,0.0070,0.009,0.0040,0.0030,0.0050,0.0060,0.001,0.0060,0.005,0.0080,0.00800,0.0010,0.0100,0.010,0.00700,0.0100,0.0050,0.0040,0.01,0.0080,0.003,0.0030,0.00600,0.0090,0.0030,0);
insert  into `journal_psa`(`id`,`probeId`,`date`,`employeeId`,`Ag`,`Al`,`As`,`Au`,`B`,`Ba`,`Be`,`Bi`,`Cd`,`Ce`,`Co`,`Cr`,`Cu`,`Fe`,`Ga`,`Ge`,`Hf`,`In`,`La`,`Li`,`Mn`,`Mo`,`Nb`,`Ni`,`P`,`Pb`,`Pt`,`Sb`,`Sc`,`Sn`,`Sr`,`Ta`,`Te`,`Th`,`Ti`,`Tl`,`U`,`V`,`W`,`Y`,`Yb`,`Zn`,`Zr`,`deleted`) values (31,3,'2017-08-19',94,0.0000,0.005,0.0060,0.000,0.008,0.0090,0.00100,0.004,0.01000,0.008,0.0010,0.0010,0.0010,0.006,0.002,0.003,0.0070,0.000,0.0030,0.004,0.0080,0.0010,0.0010,0.0040,0.010,0.0070,0.006,0.0010,0.00900,0.0100,0.0020,0.002,0.00200,0.0020,0.0010,0.0040,0.00,0.0030,0.003,0.0030,0.00500,0.0050,0.0070,0);
insert  into `journal_psa`(`id`,`probeId`,`date`,`employeeId`,`Ag`,`Al`,`As`,`Au`,`B`,`Ba`,`Be`,`Bi`,`Cd`,`Ce`,`Co`,`Cr`,`Cu`,`Fe`,`Ga`,`Ge`,`Hf`,`In`,`La`,`Li`,`Mn`,`Mo`,`Nb`,`Ni`,`P`,`Pb`,`Pt`,`Sb`,`Sc`,`Sn`,`Sr`,`Ta`,`Te`,`Th`,`Ti`,`Tl`,`U`,`V`,`W`,`Y`,`Yb`,`Zn`,`Zr`,`deleted`) values (32,5,NULL,97,0.0080,0.006,0.0010,0.008,0.007,0.0050,0.00100,0.010,0.00200,0.001,0.0030,0.0070,0.0040,0.008,0.003,0.007,0.0060,0.007,0.0050,0.001,0.0070,0.0050,0.0100,0.0030,0.005,0.0070,0.010,0.0090,0.01000,0.0030,0.0050,0.000,0.00100,0.0010,0.0070,0.0040,0.01,0.0090,0.001,0.0090,0.00000,0.0010,0.0020,-1);

/*Table structure for table `journal_sanpin` */

DROP TABLE IF EXISTS `journal_sanpin`;

CREATE TABLE `journal_sanpin` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `probeId` int(11) unsigned NOT NULL,
  `date` date DEFAULT NULL,
  `employeeId` int(11) DEFAULT '0',
  `Ag` double(5,4) DEFAULT '0.0000',
  `Al` double(4,3) DEFAULT '0.000',
  `As` double(5,4) DEFAULT '0.0000',
  `B` double(4,3) DEFAULT '0.000',
  `Ba` double(5,4) DEFAULT '0.0000',
  `Be` double(6,5) DEFAULT '0.00000',
  `Bi` double(4,3) DEFAULT '0.000',
  `Cd` double(6,5) DEFAULT '0.00000',
  `Co` double(5,4) DEFAULT '0.0000',
  `Cr6` double(5,4) DEFAULT '0.0000',
  `Cr` double(5,4) DEFAULT '0.0000',
  `Cu` double(5,4) DEFAULT '0.0000',
  `Fe` double(4,3) DEFAULT '0.000',
  `Li` double(4,3) DEFAULT '0.000',
  `Mn` double(5,4) DEFAULT '0.0000',
  `Mo` double(5,4) DEFAULT '0.0000',
  `Nb` double(5,4) DEFAULT '0.0000',
  `Na+Ka` double(4,3) DEFAULT '0.000',
  `Ni` double(5,4) DEFAULT '0.0000',
  `NH3` double(4,3) DEFAULT '0.000',
  `NO2` double(5,4) DEFAULT '0.0000',
  `Pb` double(5,4) DEFAULT '0.0000',
  `Sb` double(5,4) DEFAULT '0.0000',
  `Se` double(5,4) DEFAULT '0.0000',
  `SiAcid` double(4,3) DEFAULT '0.000',
  `Si` double(4,3) DEFAULT '0.000',
  `Sr` double(5,4) DEFAULT '0.0000',
  `Te` double(4,3) DEFAULT '0.000',
  `Rodanide` double(4,3) DEFAULT '0.000',
  `Tl` double(5,4) DEFAULT '0.0000',
  `V` double(5,4) DEFAULT '0.0000',
  `W` double(4,3) DEFAULT '0.000',
  `Zn` double(5,4) DEFAULT '0.0000',
  `odour` double(2,0) DEFAULT '0',
  `flavor` double(2,0) DEFAULT '0',
  `chromaticity` double(2,1) DEFAULT '0.0',
  `turbidity` double(3,2) DEFAULT '0.00',
  `hydrogenIndex` double(3,2) DEFAULT '0.00',
  `mineralization` double(3,2) DEFAULT '0.00',
  `dryResidue` double(2,1) DEFAULT '0.0',
  `anion` double(4,3) DEFAULT '0.000',
  `stiffness` double(5,4) DEFAULT '0.0000',
  `oilProduct` double(5,4) DEFAULT '0.0000',
  `nitrate` double(5,4) DEFAULT '0.0000',
  `permaganate` double(5,4) DEFAULT '0.0000',
  `mercury` double(5,4) DEFAULT '0.0000',
  `sulfate` double(5,4) DEFAULT '0.0000',
  `fluoride` double(5,4) DEFAULT '0.0000',
  `phenolicIndex` double(5,4) DEFAULT '0.0000',
  `chloride` double(5,4) DEFAULT '0.0000',
  `cyanide` double(4,3) DEFAULT '0.000',
  `dissolvedOxygen` double(4,3) DEFAULT '0.000',
  `biologicalOxygenDemand` double(4,3) DEFAULT '0.000',
  `chemicalOxygenDemand` double(4,3) DEFAULT '0.000',
  `suspendedSolid` double(4,3) DEFAULT '0.000',
  `pesticideLindane` double(4,3) DEFAULT '0.000',
  `pesticideIsomer` double(4,3) DEFAULT '0.000',
  `radioactivityA` double(4,3) DEFAULT '0.000',
  `radioactivityB` double(4,3) DEFAULT '0.000',
  `polyphosphate` double(4,3) DEFAULT '0.000',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `probeId_idx` (`probeId`),
  CONSTRAINT `probeId` FOREIGN KEY (`probeId`) REFERENCES `probes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `journal_sanpin` */

insert  into `journal_sanpin`(`id`,`probeId`,`date`,`employeeId`,`Ag`,`Al`,`As`,`B`,`Ba`,`Be`,`Bi`,`Cd`,`Co`,`Cr6`,`Cr`,`Cu`,`Fe`,`Li`,`Mn`,`Mo`,`Nb`,`Na+Ka`,`Ni`,`NH3`,`NO2`,`Pb`,`Sb`,`Se`,`SiAcid`,`Si`,`Sr`,`Te`,`Rodanide`,`Tl`,`V`,`W`,`Zn`,`odour`,`flavor`,`chromaticity`,`turbidity`,`hydrogenIndex`,`mineralization`,`dryResidue`,`anion`,`stiffness`,`oilProduct`,`nitrate`,`permaganate`,`mercury`,`sulfate`,`fluoride`,`phenolicIndex`,`chloride`,`cyanide`,`dissolvedOxygen`,`biologicalOxygenDemand`,`chemicalOxygenDemand`,`suspendedSolid`,`pesticideLindane`,`pesticideIsomer`,`radioactivityA`,`radioactivityB`,`polyphosphate`,`deleted`) values (31,1,'2017-09-10',93,0.0070,0.006,0.0020,0.004,0.0040,0.00600,0.009,0.00700,0.0070,0.0060,0.0030,0.0090,0.007,0.009,0.0090,0.0100,0.0080,0.010,0.0010,0.010,0.0020,0.0020,0.0040,0.0060,0.009,0.001,0.0070,0.007,0.007,0.0030,0.0030,0.001,0.0030,1,0,0.0,0.01,0.01,0.01,0.0,0.007,0.0000,0.0040,0.0000,0.0100,0.0010,0.0060,0.0100,0.0030,0.0100,0.001,0.005,0.001,0.006,0.010,0.010,0.005,0.004,0.010,0.001,0);
insert  into `journal_sanpin`(`id`,`probeId`,`date`,`employeeId`,`Ag`,`Al`,`As`,`B`,`Ba`,`Be`,`Bi`,`Cd`,`Co`,`Cr6`,`Cr`,`Cu`,`Fe`,`Li`,`Mn`,`Mo`,`Nb`,`Na+Ka`,`Ni`,`NH3`,`NO2`,`Pb`,`Sb`,`Se`,`SiAcid`,`Si`,`Sr`,`Te`,`Rodanide`,`Tl`,`V`,`W`,`Zn`,`odour`,`flavor`,`chromaticity`,`turbidity`,`hydrogenIndex`,`mineralization`,`dryResidue`,`anion`,`stiffness`,`oilProduct`,`nitrate`,`permaganate`,`mercury`,`sulfate`,`fluoride`,`phenolicIndex`,`chloride`,`cyanide`,`dissolvedOxygen`,`biologicalOxygenDemand`,`chemicalOxygenDemand`,`suspendedSolid`,`pesticideLindane`,`pesticideIsomer`,`radioactivityA`,`radioactivityB`,`polyphosphate`,`deleted`) values (32,2,'2017-09-10',93,0.0040,0.006,0.0040,0.001,0.0100,0.00800,0.008,0.00300,0.0000,0.0090,0.0100,0.0070,0.000,0.006,0.0000,0.0100,0.0010,0.003,0.0040,0.006,0.0000,0.0030,0.0070,0.0070,0.007,0.007,0.0010,0.010,0.003,0.0090,0.0040,0.008,0.0100,2,0.,0.0,0.01,0.01,0.01,0.0,0.003,0.0040,0.0000,0.0020,0.0070,0.0000,0.0010,0.0060,0.0010,0.0040,0.002,0.004,0.008,0.007,0.010,0.004,0.009,0.008,0.000,0.008,0);
insert  into `journal_sanpin`(`id`,`probeId`,`date`,`employeeId`,`Ag`,`Al`,`As`,`B`,`Ba`,`Be`,`Bi`,`Cd`,`Co`,`Cr6`,`Cr`,`Cu`,`Fe`,`Li`,`Mn`,`Mo`,`Nb`,`Na+Ka`,`Ni`,`NH3`,`NO2`,`Pb`,`Sb`,`Se`,`SiAcid`,`Si`,`Sr`,`Te`,`Rodanide`,`Tl`,`V`,`W`,`Zn`,`odour`,`flavor`,`chromaticity`,`turbidity`,`hydrogenIndex`,`mineralization`,`dryResidue`,`anion`,`stiffness`,`oilProduct`,`nitrate`,`permaganate`,`mercury`,`sulfate`,`fluoride`,`phenolicIndex`,`chloride`,`cyanide`,`dissolvedOxygen`,`biologicalOxygenDemand`,`chemicalOxygenDemand`,`suspendedSolid`,`pesticideLindane`,`pesticideIsomer`,`radioactivityA`,`radioactivityB`,`polyphosphate`,`deleted`) values (33,3,'2017-09-10',93,0.0100,0.004,0.0040,0.002,0.0030,0.01000,0.003,0.00300,0.0010,0.0060,0.0000,0.0100,0.000,0.002,0.0000,0.0070,0.0040,0.008,0.0040,0.000,0.0040,0.0100,0.0090,0.0060,0.010,0.001,0.0040,0.005,0.004,0.0070,0.0030,0.008,0.0060,3,0.,0.0,0.01,0.00,0.00,0.0,0.006,0.0100,0.0040,0.0070,0.0020,0.0030,0.0050,0.0030,0.0040,0.0040,0.008,0.010,0.000,0.010,0.003,0.005,0.003,0.001,0.006,0.005,0);

/*Table structure for table `limits` */

DROP TABLE IF EXISTS `limits`;

CREATE TABLE `limits` (
  `id` int(11) unsigned NOT NULL,
  `analysis` int(11) unsigned NOT NULL DEFAULT '0',
  `element` varchar(50) DEFAULT '',
  `limit` double DEFAULT NULL,
  `unit` varchar(50) DEFAULT '',
  `pdk` varchar(10) DEFAULT '',
  `nd` varchar(255) DEFAULT '',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `analysis_id_idx` (`analysis`),
  CONSTRAINT `analysis_id` FOREIGN KEY (`analysis`) REFERENCES `analyses` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `limits` */

insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (1,1,'Al',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (2,1,'Ba',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (3,1,'Be',0.0001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (4,1,'B',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (5,1,'V',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (6,1,'Bi',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (7,1,'W',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (8,1,'Fe',0.05,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (9,1,'Cd',0.0001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (10,1,'Co',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (11,1,'Li',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (12,1,'Mg',0.05,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (13,1,'Mn',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (14,1,'Cu',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (15,1,'Mo',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (16,1,'As',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (17,1,'Na',0.5,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (18,1,'Ni',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (19,1,'Se',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (20,1,'S',0.05,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (21,1,'Ag',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (22,1,'Sr',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (23,1,'Sb',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (24,1,'Ti',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (25,1,'P',0.02,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (26,1,'Cr',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (27,1,'Zn',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (28,1,'Pb',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (29,1,'Si',0.05,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (30,1,'Sn',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (31,1,'K',0.05,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (32,1,'Ca',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (33,1,'Tl',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (34,2,'Al',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (35,2,'Ba',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (36,2,'Be',0.0001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (37,2,'B',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (38,2,'V',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (39,2,'Bi',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (40,2,'W',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (41,2,'Ga',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (42,2,'Hf',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (43,2,'Ge',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (44,2,'Fe',0.05,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (45,2,'Au',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (46,2,'In',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (47,2,'Yb',0.0005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (48,2,'Y',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (49,2,'Cd',0.0001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (50,2,'Co',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (51,2,'La',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (52,2,'Li',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (53,2,'Mn',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (54,2,'Cu',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (55,2,'Mo',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (56,2,'As',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (57,2,'Ni',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (58,2,'Nb',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (59,2,'Sn',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (60,2,'Pt',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (61,2,'Pb',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (62,2,'Ag',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (63,2,'Sc',0.0005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (64,2,'Sr',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (65,2,'Sb',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (66,2,'Tl',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (67,2,'Ta',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (68,2,'Te',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (69,2,'Ti',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (70,2,'Th',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (71,2,'U',0.5,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (72,2,'P',0.02,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (73,2,'Cr',0.001,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (74,2,'Zn',0.005,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (75,2,'Ce',0.01,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (76,2,'Zr',0.003,'','','',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (77,3,'odour',0,'баллы','2','ГОСТ 3351-74',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (78,3,'flavor',0,'баллы','2','ГОСТ 3351-74',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (79,3,'chromaticity',0,'градусы','20(35)','ГОСТ 3351-74',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (80,3,'turbidity',0,'мг/дм<sup>3</sup','1,5 ( 2 )','СТ РК ИСО 7027-2007',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (81,3,'hydrogenIndex',0,'единицы рН','6 (9)','ГОСТ 26449.1-85 п. 4',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (82,3,'mineralization',0,'мг/дм<sup>3</sup','1000','ГОСТ 18164-72 ',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (83,3,'dryResidue',0,'мг/дм<sup>3</sup','1500','ГОСТ 18164-72 ',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (84,3,'anion',0,'мг/дм<sup>3</sup','0,5','ПНД Ф 14.1:2:4.158-2000',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (85,3,'Al',0.01,'мг/дм<sup>3</sup','0,5','СТ РК ГОСТ Р 51309-2003',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (86,3,'NH3',0.04,'мгN/дм<sup>3</sup','2','ГОСТ 4192-82',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (87,3,'B',0.01,'мг/дм<sup>3</sup','0,1','СТ РК ГОСТ Р 51309-2003',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (88,3,'Ba',0.001,'мг/дм<sup>3</sup','0,0002','СТ РК ГОСТ Р 51309-2003',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (89,3,'Be',0.0001,'мг/дм<sup>3</sup','0,5','ПНД Ф 14.1.2.4.36-95',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (90,3,'V',0.001,'мг/дм<sup>3</sup','0,1','ПНД Ф 14.1:2:4.135-98',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (91,3,'Bi',0.01,'мг/дм<sup>3</sup','0,1','ПНД Ф 14.1:2:4.135-98',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (92,3,'W',0.01,'мг/дм<sup>3</sup','0,05','ПНД Ф 14.1:2:4.135-98',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (93,3,'Fe',0.05,'мг/дм<sup>3</sup','0,3(1,0)','СТ РК ИСО 6332-2008',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (94,3,'stiffness',0,'ммоль/дм<sup><sup>3</sup</sup>','7 (10)','СТ РК 1514-2006',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (95,3,'Cd',0.0001,'мг/дм<sup>3</sup','0,001','СТ РК ГОСТ Р 51309-2003',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (96,3,'Co',0.001,'мг/дм<sup>3</sup','0,1','ПНД Ф 14.1:2:4.135-98',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (97,3,'SiAcid',0.05,'мг/дм<sup>3</sup','10','ГОСТ 26449.1-85 п.22',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (98,3,'Si',0.05,'мг/дм<sup>3</sup','10','ПНД Ф 14.1:2:4.135-98',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (99,3,'Li',0.01,'мг/дм<sup>3</sup','0,03','ПНД Ф 14.1:2:4.135-98',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (100,3,'Mn',0.001,'мг/дм<sup>3</sup','0,1 (0,5)','ПНД Ф 14.1.2.4.188-02',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (101,3,'Cu',0.001,'мг/дм<sup>3</sup','1','СТ РК ГОСТ Р 51309-2003',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (102,3,'Mo',0.001,'мг/дм<sup>3</sup','0,25','СТ РК ГОСТ Р 51309-2003',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (103,3,'As',0.005,'мг/дм<sup>3</sup','0,05','СТ РК ГОСТ Р 51309-2003',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (104,3,'Na+Ka',0,'мг/дм<sup>3</sup','200','ГОСТ 26449.1-85',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (105,3,'oilProduct',0,'мг/дм<sup>3</sup','0,1','ПНД Ф 14.1:2:4.128-98',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (106,3,'Ni',0.001,'мг/дм<sup>3</sup','0,1','СТ РК ГОСТ Р 51309-2003',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (107,3,'Nb',0.005,'мг/дм<sup>3</sup','0,01','ПНД Ф 14.1:2:4.135-98',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (108,3,'nitrate',0,'мг/дм<sup>3</sup','45','ГОСТ 18826-73 п. 3',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (109,3,'NO2',0.003,'мгNO<sup>2</sup>/дм<sup><sup>3</sup</sup','3','ГОСТ 4192-82',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (110,3,'permaganate',0,'мг/дм<sup>3</sup','5','ГОСТ 23268.12-78',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (111,3,'mercury',NULL,'мг/дм<sup>3</sup','0,0005','ПНД Ф 14.1:2:4.160-2000',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (112,3,'Rodanide',0.02,'мг/дм<sup>3</sup','0,1','ПНД Ф 14.1:2:4.146-99',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (113,3,'Pb',0.001,'мг/дм<sup>3</sup','0,03','СТ РК ГОСТ Р 51309-2003',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (114,3,'Se',0.005,'мг/дм<sup>3</sup','0,01','СТ РК ГОСТ Р 51309-2003',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (115,3,'Ag',0.005,'мг/дм<sup>3</sup','0,05','ПНД Ф 14.1:2:4.135-98',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (116,3,'sulfate',0,'мг/дм<sup>3</sup','500','ГОСТ 4389-72 п.4',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (117,3,'Sb',0.005,'мг/дм<sup>3</sup','0,05','ПНД Ф 14.1:2:4.135-98',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (118,3,'Sr',0.001,'мг/дм<sup>3</sup','7','СТ РК ГОСТ Р 51309-2003',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (119,3,'Tl',0.005,'мг/дм<sup>3</sup','0,0001','ПНД Ф 14.1:2:4.135-98',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (120,3,'Te',0.01,'мг/дм<sup>3</sup','0,01','ПНД Ф 14.1:2:4.135-98',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (121,3,'fluoride',0,'мг/дм<sup>3</sup','1,2-1,5','М 01-13-2007',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (122,3,'phenolicIndex',0,'мг/дм<sup>3</sup','0,25','ПНД Ф 14.1:2:4.182-02',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (123,3,'chloride',0,'мг/дм<sup>3</sup','350','ГОСТ 4245-72 п. 2',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (124,3,'Cr6',0.001,'мг/дм<sup>3</sup','0,05','М 01-41-2006',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (125,3,'Cr',0.001,'мг/дм<sup>3</sup','0,5','ПНД Ф 14.1:2:4.135-98',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (126,3,'Zn',0.005,'мг/дм<sup>3</sup','5','СТ РК ГОСТ Р 51309-2003',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (127,3,'cyanide',0,'мг/дм<sup>3</sup','0,035','ПНД Ф 14.1:2:4.146-99',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (128,3,'dissolvedOxygen',0,'мг/дм<sup>3</sup',' не менее ','РД 52.24.419-2006',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (129,3,'biologicalOxygenDemand',0,'мг/дм<sup>3</sup','3,0 (6,0)','РД 52.24.420-2006',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (130,3,'chemicalOxygenDemand',0,'мг/дм<sup>3</sup','15','ПНД Ф 14.1.2.4.190-03',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (131,3,'suspendedSolid',0,'мг/дм<sup>3</sup','0,25 (0,75','ГОСТ 26449.1-85 ',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (132,3,'pesticideLindane',0,'мг/дм<sup>3</sup','0,002','ПНД Ф 14.1:2:4.204-04',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (133,3,'pesticideIsomer',0,'мг/дм<sup>3</sup','0,002','ПНД Ф 14.1:2:4.204-04',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (134,3,'radioactivityA',0,'Бк/дм<sup>3</sup','0,1','Суммарная активность альфа- и бета- излучающих радионуклидов в природных водах (пресных и минерализованных). Подготовка проб и измерения',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (135,3,'radioactivityB',0,'Бк/дм<sup>3</sup','1','Суммарная активность альфа- и бета- излучающих радионуклидов в природных водах (пресных и минерализованных). Подготовка проб и измерения',0);
insert  into `limits`(`id`,`analysis`,`element`,`limit`,`unit`,`pdk`,`nd`,`deleted`) values (136,3,'polyphosphate',0,'мг/дм<sup>3</sup','3,5','ГОСТ 18309-72',0);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `number` int(11) unsigned DEFAULT '0',
  `customerId` int(11) unsigned NOT NULL,
  `date` date DEFAULT NULL,
  `remark` varchar(50) DEFAULT '',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `customerId_idx` (`customerId`),
  CONSTRAINT `customerId` FOREIGN KEY (`customerId`) REFERENCES `customers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1098 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (61,63,73,'2017-09-01',NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (186,367,82,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (193,404,82,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (241,674,79,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (290,672,79,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (337,671,79,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (496,588,211,NULL,'',0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (501,670,215,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (555,689,73,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (556,690,73,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (557,691,73,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (558,692,73,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (567,698,73,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (665,177,211,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (668,205,215,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (716,321,215,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (779,383,217,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (930,751,211,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (938,743,229,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (966,677,217,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (972,710,79,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (984,810,79,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1005,812,229,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1006,828,229,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1007,813,229,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1030,858,79,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1043,54,229,NULL,'',0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1058,70,215,NULL,NULL,0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1073,4,231,'2017-08-19','',0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1083,12,231,NULL,'',0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1086,245,219,NULL,'',0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1087,45,228,NULL,'',0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1088,23,82,NULL,'',0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1090,2,232,'2017-08-19','',0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1091,3,232,'2017-08-23','',0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1094,1544,73,NULL,'',0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1095,45,232,NULL,'',0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1096,456,232,NULL,'',0);
insert  into `orders`(`id`,`number`,`customerId`,`date`,`remark`,`deleted`) values (1097,345,232,NULL,'',0);

/*Table structure for table `positions` */

DROP TABLE IF EXISTS `positions`;

CREATE TABLE `positions` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `position` varchar(100) DEFAULT '',
  `remark` varchar(255) DEFAULT '',
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `positions` */

insert  into `positions`(`id`,`position`,`remark`,`deleted`) values (1,'Начальник лаборатории','',0);
insert  into `positions`(`id`,`position`,`remark`,`deleted`) values (4,'Инженер-химик 1 категории','',0);
insert  into `positions`(`id`,`position`,`remark`,`deleted`) values (5,'Инженер-химик','',0);
insert  into `positions`(`id`,`position`,`remark`,`deleted`) values (7,'Инженер-физик 1 категории','',0);
insert  into `positions`(`id`,`position`,`remark`,`deleted`) values (19,'Техник-лаборант','',0);
insert  into `positions`(`id`,`position`,`remark`,`deleted`) values (23,'Лаборант','',0);
insert  into `positions`(`id`,`position`,`remark`,`deleted`) values (24,'Инженер-химик 2 категории','',0);
insert  into `positions`(`id`,`position`,`remark`,`deleted`) values (26,'Инженер-физик','',0);
insert  into `positions`(`id`,`position`,`remark`,`deleted`) values (28,'Инженер-физик 2 категории','',0);
insert  into `positions`(`id`,`position`,`remark`,`deleted`) values (29,'Физик ядерщик','',0);

/*Table structure for table `probes` */

DROP TABLE IF EXISTS `probes`;

CREATE TABLE `probes` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `orderId` int(11) unsigned NOT NULL,
  `numberLab` int(11) DEFAULT NULL,
  `numberCustomer` int(11) DEFAULT NULL,
  `dateReceiving` date DEFAULT NULL,
  `pointSampling` varchar(255) DEFAULT '',
  `dateSampling` date DEFAULT NULL,
  `remark` varchar(255) DEFAULT '',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `orderId_idx` (`orderId`),
  CONSTRAINT `orderId` FOREIGN KEY (`orderId`) REFERENCES `orders` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `probes` */

insert  into `probes`(`id`,`orderId`,`numberLab`,`numberCustomer`,`dateReceiving`,`pointSampling`,`dateSampling`,`remark`,`deleted`) values (1,61,1123,341,'2017-09-17','Сарышаган','2017-10-01','',0);
insert  into `probes`(`id`,`orderId`,`numberLab`,`numberCustomer`,`dateReceiving`,`pointSampling`,`dateSampling`,`remark`,`deleted`) values (2,61,124,35,'2017-09-02','Сарышаган','2017-08-01','',0);
insert  into `probes`(`id`,`orderId`,`numberLab`,`numberCustomer`,`dateReceiving`,`pointSampling`,`dateSampling`,`remark`,`deleted`) values (3,668,12,2,'2017-09-16','Сарышаган','2017-08-17','',0);
insert  into `probes`(`id`,`orderId`,`numberLab`,`numberCustomer`,`dateReceiving`,`pointSampling`,`dateSampling`,`remark`,`deleted`) values (4,668,13,34,'2017-09-18','Сарышаган','2017-08-17','',0);
insert  into `probes`(`id`,`orderId`,`numberLab`,`numberCustomer`,`dateReceiving`,`pointSampling`,`dateSampling`,`remark`,`deleted`) values (5,1090,121,13,'2017-09-17','Сарышаган','2017-08-17','',0);
insert  into `probes`(`id`,`orderId`,`numberLab`,`numberCustomer`,`dateReceiving`,`pointSampling`,`dateSampling`,`remark`,`deleted`) values (6,1091,2,2,'2017-10-10','Сарышаган','2017-09-17','',0);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL DEFAULT '',
  `username` varchar(150) NOT NULL,
  `email` varchar(100) NOT NULL DEFAULT '',
  `password` varchar(100) NOT NULL,
  `usertype` varchar(255) DEFAULT '',
  `dateRegistration` date DEFAULT NULL,
  `block` tinyint(1) NOT NULL DEFAULT '0',
  `remark` varchar(255) DEFAULT '',
  `deleted` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1763 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`name`,`username`,`email`,`password`,`usertype`,`dateRegistration`,`block`,`remark`,`deleted`) values (1760,'Иван Иванович Иванов','admin','admin@happylab.kz','202cb962ac59075b964b07152d234b70','administrator','2017-09-12',0,'',0);
insert  into `users`(`id`,`name`,`username`,`email`,`password`,`usertype`,`dateRegistration`,`block`,`remark`,`deleted`) values (1761,'Сергей Сергеевич','assistant','assistant@happylab.kz','202cb962ac59075b964b07152d234b70','assistant','2017-09-12',0,'',0);
insert  into `users`(`id`,`name`,`username`,`email`,`password`,`usertype`,`dateRegistration`,`block`,`remark`,`deleted`) values (1762,'Татьяна','head','head@happylab.kz','202cb962ac59075b964b07152d234b70','head','2017-09-12',0,'',0);

/*Table structure for table `usertype` */

DROP TABLE IF EXISTS `usertype`;

CREATE TABLE `usertype` (
  `id` tinyint(11) unsigned NOT NULL AUTO_INCREMENT,
  `usertype` varchar(100) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `usertype` */

insert  into `usertype`(`id`,`usertype`) values (1,'administrator');
insert  into `usertype`(`id`,`usertype`) values (2,'head');
insert  into `usertype`(`id`,`usertype`) values (3,'assistant');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
