-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.51-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema marryme
--

CREATE DATABASE IF NOT EXISTS marryme;
USE marryme;

--
-- Definition of table `picture`
--

DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `pic_id` int(11) NOT NULL AUTO_INCREMENT,
  `pic_name` varchar(45) DEFAULT NULL,
  `favour_count` int(20) DEFAULT '0',
  `pic_title` varchar(45) NOT NULL DEFAULT '空',
  `pic_descript` varchar(200) DEFAULT NULL,
  `pic_size` int(11) DEFAULT NULL,
  `pic_create_time` datetime DEFAULT NULL,
  `pic_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `picture`
--

/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` (`pic_id`,`pic_name`,`favour_count`,`pic_title`,`pic_descript`,`pic_size`,`pic_create_time`,`pic_update_time`) VALUES 
 (1,'picname',0,'空',NULL,NULL,NULL,NULL),
 (3,'1380105543156.jpg',0,'我可要开始装逼了.jpg',NULL,6,'2013-09-25 18:39:03','2013-09-25 18:39:03');
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
