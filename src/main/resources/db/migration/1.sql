CREATE TABLE `mhis`.`doctor` (
  `doctor_id` BIGINT NOT NULL,
  `doctor_name` VARCHAR(45) NOT NULL,
  `doctor_number` BIGINT NOT NULL,
  `doctor_sex` INT NULL,
  `dector_level` VARCHAR(45) NULL,
  `department` VARCHAR(45) NULL,
  `education` VARCHAR(45) NULL,
  PRIMARY KEY (`doctor_id`));

ALTER TABLE `mhis`.`doctor`
CHANGE COLUMN `doctor_id` `doctor_id` BIGINT(20) NOT NULL AUTO_INCREMENT ;

//新建user表
