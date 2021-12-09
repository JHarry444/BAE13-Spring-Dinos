DROP TABLE IF EXISTS `dinosaur` CASCADE;

CREATE TABLE `dinosaur` (
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT, 
	`diet` VARCHAR(255) NOT NULL, 
	`height` INTEGER, 
	`num_teeth` INTEGER, 
	`type` VARCHAR(255)
);