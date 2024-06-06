DROP DATABASE IF EXISTS bodybuddy_db;
CREATE DATABASE IF NOT EXISTS bodybuddy_db;
USE bodybuddy_db;

CREATE TABLE `users` (
	`user_id` VARCHAR(20) PRIMARY KEY,
	`password` VARCHAR(20)  NOT NULL,
    `name` VARCHAR(20) NOT NULL,
	`nickname` VARCHAR(20) UNIQUE NOT NULL,
	`email` VARCHAR(30) NOT NULL
)ENGINE=InnoDB;

CREATE TABLE `routines` (
    `routine_id`  INT AUTO_INCREMENT PRIMARY KEY,
	`user_id` VARCHAR(20) NOT NULL,
    `routine_title` VARCHAR(50) DEFAULT '제목 없음',
    `date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `description` TEXT,
	FOREIGN KEY(user_id) REFERENCES users(user_id) ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE `exercises` (
	`exercise_id`  INT AUTO_INCREMENT PRIMARY KEY,
	`routine_id` INT NOT NULL,
	`exercise_name` VARCHAR(30) NOT NULL,
	`exercise_part` VARCHAR(20) NOT NULL,
	`set_cnt` INT NOT NULL,
	`weight` INT NOT NULL,
	`repetitions` INT NOT NULL,
	`day_of_the_week` SET('월', '화', '수', '목', '금', '토', '일'),
	`time` VARCHAR(20) NOT NULL,
	FOREIGN KEY(routine_id) REFERENCES routines(routine_id) ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE `wishes` (
	`wish_id` INT AUTO_INCREMENT PRIMARY KEY,
	`user_id` VARCHAR(20)  NOT NULL,
	`routine_id` INT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users(user_id),
	FOREIGN KEY (routine_id) REFERENCES routines(routine_id) ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE `reviews` (
	`review_id` INT AUTO_INCREMENT PRIMARY KEY,
	`routine_id` INT NOT NULL,
	`user_id` VARCHAR(20) NOT NULL,
    `nickname` VARCHAR(20) NOT NULL,
	`content` TEXT NOT NULL,
	`date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY(nickname) REFERENCES users(nickname) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(routine_id) REFERENCES routines(routine_id) ON DELETE CASCADE,
	FOREIGN KEY(user_id) REFERENCES users(user_id) ON DELETE CASCADE
)ENGINE=InnoDB;

SELECT * FROM users;
SELECT * FROM routines;
SELECT * FROM exercises;
SELECT * FROM wishes;
SELECT * FROM reviews;