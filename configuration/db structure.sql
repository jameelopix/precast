-- MySQL dump 10.13  Distrib 5.7.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: precastdb
-- ------------------------------------------------------
-- Server version	5.7.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accountdetails`
--

DROP TABLE IF EXISTS `accountdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accountdetails` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `accountName` varchar(255) DEFAULT NULL,
  `accountNumber` varchar(255) DEFAULT NULL,
  `accountType` varchar(255) DEFAULT NULL,
  `bankName` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk78ycgjei5vr3j9m344ugkss2` (`company_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accountdetails`
--

LOCK TABLES `accountdetails` WRITE;
/*!40000 ALTER TABLE `accountdetails` DISABLE KEYS */;
INSERT INTO `accountdetails` VALUES (72,NULL,NULL,0,'mape','123456789','CASH','AXIS',51),(73,NULL,NULL,0,'mape','4567890-','CASH','ICICI',51),(74,NULL,NULL,1,'mm','11111111111','CASH','AXIS',51),(77,NULL,NULL,0,'dfdff','3333','CASH','ICICI',51);
/*!40000 ALTER TABLE `accountdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accounthead`
--

DROP TABLE IF EXISTS `accounthead`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accounthead` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounthead`
--

LOCK TABLES `accounthead` WRITE;
/*!40000 ALTER TABLE `accounthead` DISABLE KEYS */;
INSERT INTO `accounthead` VALUES (44,NULL,NULL,1,'Repairs and Maintenance'),(45,NULL,NULL,0,'Salary'),(46,NULL,NULL,0,'Retention');
/*!40000 ALTER TABLE `accounthead` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bankaccount`
--

DROP TABLE IF EXISTS `bankaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bankaccount` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `accountNo` varchar(255) DEFAULT NULL,
  `defaultAccount` bit(1) DEFAULT NULL,
  `disabled` bit(1) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmim47f9gr77d1h4ltf08oe5co` (`company_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankaccount`
--

LOCK TABLES `bankaccount` WRITE;
/*!40000 ALTER TABLE `bankaccount` DISABLE KEYS */;
INSERT INTO `bankaccount` VALUES (9,NULL,NULL,NULL,NULL,19,'1111111','','',7),(10,NULL,NULL,NULL,NULL,2,'5678908790','','\0',6);
/*!40000 ALTER TABLE `bankaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cashtransfer`
--

DROP TABLE IF EXISTS `cashtransfer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cashtransfer` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `checknumber` varchar(255) DEFAULT NULL,
  `receiverAccountNo` varchar(255) DEFAULT NULL,
  `receiverName` varchar(255) DEFAULT NULL,
  `senderAccountNo` varchar(255) DEFAULT NULL,
  `senderName` varchar(255) DEFAULT NULL,
  `transferBy` int(11) DEFAULT NULL,
  `transferType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cashtransfer`
--

LOCK TABLES `cashtransfer` WRITE;
/*!40000 ALTER TABLE `cashtransfer` DISABLE KEYS */;
/*!40000 ALTER TABLE `cashtransfer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `castingactivity`
--

DROP TABLE IF EXISTS `castingactivity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `castingactivity` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `actualConcentreQuantity` double DEFAULT NULL,
  `castedDate` datetime DEFAULT NULL,
  `element` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `castingactivity`
--

LOCK TABLES `castingactivity` WRITE;
/*!40000 ALTER TABLE `castingactivity` DISABLE KEYS */;
/*!40000 ALTER TABLE `castingactivity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `disabled` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `selfCompany` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (66,NULL,NULL,NULL,NULL,0,NULL,'New Company',NULL),(51,NULL,NULL,NULL,NULL,1,NULL,'VME Precast',NULL);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `costcentre`
--

DROP TABLE IF EXISTS `costcentre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costcentre` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costcentre`
--

LOCK TABLES `costcentre` WRITE;
/*!40000 ALTER TABLE `costcentre` DISABLE KEYS */;
INSERT INTO `costcentre` VALUES (36,NULL,NULL,0,'Seemaati'),(37,NULL,NULL,0,'AnnaLakshmi'),(38,NULL,NULL,2,'ELA');
/*!40000 ALTER TABLE `costcentre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dcitem`
--

DROP TABLE IF EXISTS `dcitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dcitem` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `dcRegister_id` bigint(20) DEFAULT NULL,
  `deductionQuantity` double DEFAULT NULL,
  `netQuantity` double DEFAULT NULL,
  `orderItem_id` bigint(20) DEFAULT NULL,
  `vendorQuantity` double DEFAULT NULL,
  `weighBridgeQuantity` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4qm4vnm2m7wipfsh736iwqrf5` (`dcRegister_id`),
  KEY `FKy10wpwqm6a0o5y9or1j1xth1` (`orderItem_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dcitem`
--

LOCK TABLES `dcitem` WRITE;
/*!40000 ALTER TABLE `dcitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `dcitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dcregister`
--

DROP TABLE IF EXISTS `dcregister`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dcregister` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `dcNo` varchar(255) DEFAULT NULL,
  `grnNo` varchar(255) DEFAULT NULL,
  `vendor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2v7dnqy7a3xnk273croe8qqdu` (`vendor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dcregister`
--

LOCK TABLES `dcregister` WRITE;
/*!40000 ALTER TABLE `dcregister` DISABLE KEYS */;
/*!40000 ALTER TABLE `dcregister` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `element`
--

DROP TABLE IF EXISTS `element`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `element` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `billingConcreteQuantity` double DEFAULT NULL,
  `breadth` double DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `length` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `theoryArea` double DEFAULT NULL,
  `theoryQuantity` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `mixture_id` bigint(20) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  `elementType_id` bigint(20) DEFAULT NULL,
  `floor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj2tehoo596d9p7m815jus3nj2` (`mixture_id`),
  KEY `FKsj3whjcpaksqykcd0w9y4w0ko` (`elementType_id`),
  KEY `FKcq7ns0wy0qy9ktkyshk1ep0i1` (`project_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `element`
--

LOCK TABLES `element` WRITE;
/*!40000 ALTER TABLE `element` DISABLE KEYS */;
/*!40000 ALTER TABLE `element` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elementdetails`
--

DROP TABLE IF EXISTS `elementdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elementdetails` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `element_id` bigint(20) DEFAULT NULL,
  `length` varchar(255) DEFAULT NULL,
  `mixDesignName` varchar(255) DEFAULT NULL,
  `thickness` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `width` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoj34eoit3pn41tnicvwedr0cr` (`element_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elementdetails`
--

LOCK TABLES `elementdetails` WRITE;
/*!40000 ALTER TABLE `elementdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `elementdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elementtype`
--

DROP TABLE IF EXISTS `elementtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elementtype` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq1g357f09wn8x1b1fjjg6eppb` (`project_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elementtype`
--

LOCK TABLES `elementtype` WRITE;
/*!40000 ALTER TABLE `elementtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `elementtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (78),(78),(78),(78),(78),(78),(78),(78),(78),(78),(78);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `unitType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `labouractivity`
--

DROP TABLE IF EXISTS `labouractivity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `labouractivity` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `natureOfWork` varchar(255) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `castingActivity_id` bigint(20) DEFAULT NULL,
  `subContractor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn0cxrjwp6bnoh3yy69rlb2x5d` (`castingActivity_id`),
  KEY `FKs4kkh0hign0r1pm5te7n2uxju` (`subContractor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `labouractivity`
--

LOCK TABLES `labouractivity` WRITE;
/*!40000 ALTER TABLE `labouractivity` DISABLE KEYS */;
/*!40000 ALTER TABLE `labouractivity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `labourrate`
--

DROP TABLE IF EXISTS `labourrate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `labourrate` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `elementType` tinyblob,
  `natureOfWork` varchar(255) DEFAULT NULL,
  `project` tinyblob,
  `rate` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `workDesc` varchar(255) DEFAULT NULL,
  `workType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `labourrate`
--

LOCK TABLES `labourrate` WRITE;
/*!40000 ALTER TABLE `labourrate` DISABLE KEYS */;
/*!40000 ALTER TABLE `labourrate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mixture`
--

DROP TABLE IF EXISTS `mixture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mixture` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mixture`
--

LOCK TABLES `mixture` WRITE;
/*!40000 ALTER TABLE `mixture` DISABLE KEYS */;
/*!40000 ALTER TABLE `mixture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mixtureitem`
--

DROP TABLE IF EXISTS `mixtureitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mixtureitem` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `mixture_id` bigint(20) DEFAULT NULL,
  `rawMaterial_id` bigint(20) DEFAULT NULL,
  `rawMaterialName` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK32sxxkx9d14id6054f4nk978v` (`rawMaterial_id`),
  KEY `FKe6bqr8k760s8d0rknyxp3ys05` (`mixture_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mixtureitem`
--

LOCK TABLES `mixtureitem` WRITE;
/*!40000 ALTER TABLE `mixtureitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `mixtureitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderitem` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `itemName` varchar(255) DEFAULT NULL,
  `purchase_order_id` bigint(20) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `unitType` varchar(255) DEFAULT NULL,
  `purchaseOrder_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl2ulshqywld9fx8og9slb4mge` (`purchaseOrder_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
INSERT INTO `orderitem` VALUES (28,NULL,NULL,2,'Cement',NULL,123456,333,'KG',27),(26,NULL,NULL,1,'zzzz',NULL,1111,22,'TONNE',16),(31,NULL,NULL,1,'Cement',NULL,50,1000,'KG',30),(32,NULL,NULL,0,'Admixture',NULL,20,100,'KG',30),(34,NULL,NULL,0,'Cement',NULL,4.511,802,'TONNE',33);
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partymaster`
--

DROP TABLE IF EXISTS `partymaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partymaster` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partymaster`
--

LOCK TABLES `partymaster` WRITE;
/*!40000 ALTER TABLE `partymaster` DISABLE KEYS */;
INSERT INTO `partymaster` VALUES (48,NULL,NULL,1,'ACC Limited','Project'),(49,NULL,NULL,0,'Aloukik Agencies','Vendor'),(63,NULL,NULL,0,'mape','Vendor');
/*!40000 ALTER TABLE `partymaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `area` double DEFAULT NULL,
  `estimatedAmount` double DEFAULT NULL,
  `projectCode` varchar(255) DEFAULT NULL,
  `projectName` varchar(255) DEFAULT NULL,
  `ratePerSquare` double DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_master`
--

DROP TABLE IF EXISTS `project_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_master` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `erectionAmount` double DEFAULT NULL,
  `erectionRate` double DEFAULT NULL,
  `logisticsAmount` double DEFAULT NULL,
  `logisticsRate` double DEFAULT NULL,
  `miscAmount` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `productionAmount` double DEFAULT NULL,
  `productionRate` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `totalAmount` double DEFAULT NULL,
  `unitType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_master`
--

LOCK TABLES `project_master` WRITE;
/*!40000 ALTER TABLE `project_master` DISABLE KEYS */;
INSERT INTO `project_master` VALUES (11,NULL,NULL,NULL,NULL,3,'1010',NULL,NULL,NULL,NULL,NULL,'Project_1010',198,100,1.98,NULL,1);
/*!40000 ALTER TABLE `project_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchaseorder`
--

DROP TABLE IF EXISTS `purchaseorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseorder` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `closed` bit(1) DEFAULT NULL,
  `issued` bit(1) DEFAULT NULL,
  `purchaseDate` date DEFAULT NULL,
  `purchaseOrderNo` varchar(255) DEFAULT NULL,
  `purchaseOrderStatus` varchar(255) DEFAULT NULL,
  `vendor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKluqo43agu8ggt9ldlumsoj1so` (`vendor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaseorder`
--

LOCK TABLES `purchaseorder` WRITE;
/*!40000 ALTER TABLE `purchaseorder` DISABLE KEYS */;
INSERT INTO `purchaseorder` VALUES (33,NULL,NULL,1,NULL,NULL,'2019-04-30','asdsda','ISSUED',NULL),(27,NULL,NULL,3,NULL,NULL,'2019-04-10','PO_100','OPEN',NULL),(29,NULL,NULL,1,NULL,NULL,'2019-04-20','PO_299','OPEN',NULL),(30,NULL,NULL,1,NULL,NULL,'2019-04-16','PO_JAMEEL','ISSUED',NULL);
/*!40000 ALTER TABLE `purchaseorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchaseorderitem`
--

DROP TABLE IF EXISTS `purchaseorderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseorderitem` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `itemName` varchar(255) DEFAULT NULL,
  `purchaseOrder_id` bigint(20) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa1gpm5jpqcsfjjyt03cf70c3q` (`purchaseOrder_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaseorderitem`
--

LOCK TABLES `purchaseorderitem` WRITE;
/*!40000 ALTER TABLE `purchaseorderitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchaseorderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchaseregister`
--

DROP TABLE IF EXISTS `purchaseregister`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseregister` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `vendorName` varchar(255) DEFAULT NULL,
  `weighBridgeNo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaseregister`
--

LOCK TABLES `purchaseregister` WRITE;
/*!40000 ALTER TABLE `purchaseregister` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchaseregister` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchaseregisteritem`
--

DROP TABLE IF EXISTS `purchaseregisteritem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseregisteritem` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `dcQuantity` double DEFAULT NULL,
  `dcUnit` varchar(255) DEFAULT NULL,
  `deductionQuantity` double DEFAULT NULL,
  `deductionUnit` varchar(255) DEFAULT NULL,
  `netQuantity` double DEFAULT NULL,
  `netUnit` varchar(255) DEFAULT NULL,
  `purchaseOrderItem_id` bigint(20) DEFAULT NULL,
  `weighBridgeQuantity` double DEFAULT NULL,
  `weighBridgeUnit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcul1nhlw9gqku0ss5t47x0hxx` (`purchaseOrderItem_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaseregisteritem`
--

LOCK TABLES `purchaseregisteritem` WRITE;
/*!40000 ALTER TABLE `purchaseregisteritem` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchaseregisteritem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rawmaterial`
--

DROP TABLE IF EXISTS `rawmaterial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rawmaterial` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rawmaterial`
--

LOCK TABLES `rawmaterial` WRITE;
/*!40000 ALTER TABLE `rawmaterial` DISABLE KEYS */;
INSERT INTO `rawmaterial` VALUES (1,NULL,NULL,NULL,NULL,0,'Cement','Concrete','Kg'),(2,NULL,NULL,NULL,NULL,1,'Admixture','Concrete','Tonne');
/*!40000 ALTER TABLE `rawmaterial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `steeldetails`
--

DROP TABLE IF EXISTS `steeldetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `steeldetails` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `actualQuantity` double DEFAULT NULL,
  `element_id` bigint(20) DEFAULT NULL,
  `rawMaterialName` varchar(255) DEFAULT NULL,
  `theoriticalQuantity` double DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbdknjor077yb8bgkhjjgltp35` (`element_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `steeldetails`
--

LOCK TABLES `steeldetails` WRITE;
/*!40000 ALTER TABLE `steeldetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `steeldetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `steelitem`
--

DROP TABLE IF EXISTS `steelitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `steelitem` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `actualQuantity` double DEFAULT NULL,
  `rawMaterial` tinyblob,
  `theoryQuantity` double DEFAULT NULL,
  `element_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo2jil1kv440a30mk6wnejlr8l` (`element_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `steelitem`
--

LOCK TABLES `steelitem` WRITE;
/*!40000 ALTER TABLE `steelitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `steelitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_master`
--

DROP TABLE IF EXISTS `student_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_master` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `erectionAmount` double DEFAULT NULL,
  `erectionRate` double DEFAULT NULL,
  `logisticsAmount` double DEFAULT NULL,
  `logisticsRate` double DEFAULT NULL,
  `miscAmount` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `productionAmount` double DEFAULT NULL,
  `productionRate` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `totalAmount` double DEFAULT NULL,
  `unitType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_master`
--

LOCK TABLES `student_master` WRITE;
/*!40000 ALTER TABLE `student_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcontractor`
--

DROP TABLE IF EXISTS `subcontractor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcontractor` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `panNumber` varchar(255) DEFAULT NULL,
  `retentionPercent` double DEFAULT NULL,
  `tdsPercent` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcontractor`
--

LOCK TABLES `subcontractor` WRITE;
/*!40000 ALTER TABLE `subcontractor` DISABLE KEYS */;
/*!40000 ALTER TABLE `subcontractor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `id` bigint(20) NOT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES (53,NULL,NULL,2,'Anna'),(57,NULL,NULL,0,'MAPE'),(58,NULL,NULL,0,'CATO');
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workdetail`
--

DROP TABLE IF EXISTS `workdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workdetail` (
  `id` bigint(20) NOT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(255) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `elementType_id` bigint(20) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  `workDesc` varchar(255) DEFAULT NULL,
  `workNature` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKimyau91ptphkmofpuseluh67c` (`elementType_id`),
  KEY `FKr9gealx8i2e1bbiup2p01l5lj` (`project_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workdetail`
--

LOCK TABLES `workdetail` WRITE;
/*!40000 ALTER TABLE `workdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `workdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'precastdb'
--

--
-- Dumping routines for database 'precastdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-26 12:15:32
