create table notes (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         description VARCHAR(300) NOT NULL,
                         status ENUM('NOT_STARTED', 'IN_PROGRESS', 'COMPLETED') NOT NULL,
                         created_at DATETIME
);
--                          status ENUM('не начата', 'в процессе', 'завершена') NOT NULL,
--                          createdAt DATETIME
