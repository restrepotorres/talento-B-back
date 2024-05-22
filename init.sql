-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema scriptgestor
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema scriptgestor
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `scriptgestor` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema scriptgestor
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema scriptgestor
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `scriptgestor` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `scriptgestor` ;

-- -----------------------------------------------------
-- Table `scriptgestor`.`genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scriptgestor`.`genre` (
  `idgenre` INT NOT NULL AUTO_INCREMENT,
  `genreName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idgenre`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `scriptgestor`.`script`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scriptgestor`.`script` (
  `idscript` INT NOT NULL AUTO_INCREMENT,
  `scriptName` VARCHAR(45) NULL,
  `idgenre` INT NOT NULL,
  PRIMARY KEY (`idscript`),
  INDEX `idgenre_idx` (`idgenre` ASC) VISIBLE,
  CONSTRAINT `idgenre`
    FOREIGN KEY (`idgenre`)
    REFERENCES `scriptgestor`.`genre` (`idgenre`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `scriptgestor`.`pose`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scriptgestor`.`pose` (
  `idpose` INT NOT NULL AUTO_INCREMENT,
  `poseName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idpose`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `scriptgestor`.`dialogLine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `scriptgestor`.`dialogLine` (
  `iddialogLine` INT NOT NULL AUTO_INCREMENT,
  `text` TEXT(1024) NULL,
  `idpose` INT NULL,
  `idscript` INT NOT NULL,
  `actor` VARCHAR(45) NOT NULL,
  `x` INT NULL,
  `y` INT NULL,
  `z` INT NULL,
  `xr` INT NULL,
  `yr` INT NULL,
  `zr` INT NULL,
  PRIMARY KEY (`iddialogLine`),
  INDEX `idscript_idx` (`idscript` ASC) VISIBLE,
  INDEX `idpose_idx` (`idpose` ASC) VISIBLE,
  CONSTRAINT `idscript`
    FOREIGN KEY (`idscript`)
    REFERENCES `scriptgestor`.`script` (`idscript`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idpose`
    FOREIGN KEY (`idpose`)
    REFERENCES `scriptgestor`.`pose` (`idpose`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `scriptgestor` ;
USE `scriptgestor`;

DELIMITER $$
USE `scriptgestor`$$
CREATE DEFINER = CURRENT_USER TRIGGER `scriptgestor`.`script_BEFORE_DELETE` BEFORE DELETE ON `script` FOR EACH ROW
BEGIN
	delete from scriptgestor.dialogline where scriptgestor.dialogline.idscript = old.idscript;
END;$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into scriptgestor.genre (genrename) values("comedy");
insert into scriptgestor.genre (genrename) values("anime");
insert into scriptgestor.genre (genrename) values("drama");
insert into scriptgestor.genre (genrename) values("animation");
insert into scriptgestor.genre (genrename) values("terror");
insert into scriptgestor.genre (genrename) values("thriller");

insert into scriptgestor.pose (poseName) values("backwards");
insert into scriptgestor.pose (poseName) values("standing on head");
insert into scriptgestor.pose (poseName) values("sitting");
insert into scriptgestor.pose (poseName) values("Standing");
insert into scriptgestor.pose (poseName) values("levitating");
