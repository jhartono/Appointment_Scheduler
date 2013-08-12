create database appointment;

use appointment;

create table `topic`
(
`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`text` VARCHAR(100) NOT NULL,
`description` VARCHAR (255),
`active` TINYINT(1) NULL DEFAULT 1,
`created_by` VARCHAR (45) NOT NULL,
`created_date` TIMESTAMP NOT NULL,
`last_modified_by` VARCHAR (45) NULL,
`last_modified_date` TIMESTAMP NULL DEFAULT NULL,
PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

create table `location`
(
`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL,
`description` VARCHAR (255),
`address1` VARCHAR(45) NOT NULL,
`address2` VARCHAR(45),
`address3` VARCHAR(45),
`city` VARCHAR(100) NOT NULL,
`state` VARCHAR(100) NOT NULL,
`zipcode` VARCHAR(10) NOT NULL,
`country` VARCHAR(100) NOT NULL,
`latitude` DECIMAL(18,15) NULL,
`longitude` DECIMAL(18,15) NULL,
`phone` VARCHAR(45),
`fax` VARCHAR(45),
`email` VARCHAR(255),
`start_date` DATE,
`end_date` DATE,
`created_by` VARCHAR (45) NOT NULL,
`created_date` TIMESTAMP NOT NULL,
`last_modified_by` VARCHAR (45),
`last_modified_date` TIMESTAMP NULL DEFAULT NULL,
PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

create table `employee`
(
`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`location_id` INT(11) UNSIGNED NOT NULL,
`external_id` VARCHAR(25),
`first_name` VARCHAR(50) NOT NULL,
`middle_name` VARCHAR(50),
`last_name` VARCHAR(50),
`phone` VARCHAR(45),
`mobile` VARCHAR(45),
`email` VARCHAR(255) NOT NULL,
`active` TINYINT(1) NULL DEFAULT 1,
`created_by` VARCHAR (45) NOT NULL,
`created_date` TIMESTAMP NOT NULL,
`last_modified_by` VARCHAR (45),
`last_modified_date` TIMESTAMP NULL DEFAULT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `employee_location_fk` FOREIGN KEY (`location_id`) REFERENCES `location`(`id`)
)
ENGINE = InnoDB;

create table `client`
(
`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`external_id` VARCHAR(25),
`first_name` VARCHAR(50) NOT NULL,
`middle_name` VARCHAR(50),
`last_name` VARCHAR(50),
`phone` VARCHAR(45),
`mobile` VARCHAR(45),
`email` VARCHAR(255) NOT NULL,
`active` TINYINT(1) NULL DEFAULT 1,
`created_by` VARCHAR (45) NOT NULL,
`created_date` TIMESTAMP NOT NULL,
`last_modified_by` VARCHAR (45),
`last_modified_date` TIMESTAMP NULL DEFAULT NULL,
PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

create table `appointment`
(
`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
`client_id` INT(11) UNSIGNED NOT NULL,
`employee_id` INT(11) UNSIGNED NOT NULL,
`location_id` INT(11) UNSIGNED NOT NULL,
`topic_id` INT(11) UNSIGNED NOT NULL,
`appt_date` DATE NOT NULL,
`start_time` TIME NOT NULL,
`end_time` TIME NOT NULL,
`details` VARCHAR(1000),
`created_by` VARCHAR (45) NOT NULL,
`created_date` TIMESTAMP NOT NULL,
`last_modified_by` VARCHAR (45),
`last_modified_date` TIMESTAMP NULL DEFAULT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `appointment_client_fk` FOREIGN KEY (`client_id`) REFERENCES `client`(`id`),
CONSTRAINT `appointment_employee_fk` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`),
CONSTRAINT `appointment_location_fk` FOREIGN KEY (`location_id`) REFERENCES `location`(`id`),
CONSTRAINT `appointment_topic_fk` FOREIGN KEY (`topic_id`) REFERENCES `topic`(`id`)
)
ENGINE = InnoDB;

create table `location_topic`
(
`location_id` INT(11) UNSIGNED NOT NULL,
`topic_id` INT(11) UNSIGNED NOT NULL,
PRIMARY KEY (`location_id`, `topic_id`),
CONSTRAINT `location_topic_location_fk` FOREIGN KEY (`location_id`) REFERENCES `location`(`id`),
CONSTRAINT `location_topic_topic_fk` FOREIGN KEY (`topic_id`) REFERENCES `topic`(`id`)
)
ENGINE = InnoDB;

create table `employee_topic`
(
`employee_id` INT(11) UNSIGNED NOT NULL,
`topic_id` INT(11) UNSIGNED NOT NULL,
PRIMARY KEY (`employee_id`, `topic_id`),
CONSTRAINT `employee_topic_employee_fk` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`),
CONSTRAINT `employee_topic_topic_fk` FOREIGN KEY (`topic_id`) REFERENCES `topic`(`id`)
)
ENGINE = InnoDB;

CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` char(3) NOT NULL DEFAULT '',
  `name` char(52) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_id` int(11) NOT NULL DEFAULT '0',
  `name` char(35) NOT NULL DEFAULT '',
  `district` char(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  CONSTRAINT `country_city_fk` FOREIGN KEY (`country_id`) REFERENCES `country`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



