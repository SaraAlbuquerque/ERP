# Script das Tabelas

CREATE TABLE `despesas` (
  `expenseId` int NOT NULL AUTO_INCREMENT,
  `expenseAmount` decimal(10,2) NOT NULL,
  `spentOnDate` date NOT NULL,
  `note` varchar(25) DEFAULT NULL,
  `userId` int NOT NULL,
  `createdOn` datetime DEFAULT CURRENT_TIMESTAMP,
  `deletedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`expenseId`),
  KEY `expenseUserFore` (`userId`),
  CONSTRAINT `expenseUserFore` FOREIGN KEY (`userId`) REFERENCES `usuario` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `despesas_transacao` (
  `expenseTransactionId` int NOT NULL AUTO_INCREMENT,
  `expenseId` int NOT NULL,
  `transactionId` int NOT NULL,
  `createdOn` datetime DEFAULT CURRENT_TIMESTAMP,
  `deletedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`expenseTransactionId`),
  KEY `expenseForeign` (`expenseId`),
  KEY `transactionForeign` (`transactionId`),
  CONSTRAINT `expenseForeign` FOREIGN KEY (`expenseId`) REFERENCES `despesas` (`expenseId`),
  CONSTRAINT `transactionForeign` FOREIGN KEY (`transactionId`) REFERENCES `transacao` (`transactionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `endereco` (
  `addressId` int NOT NULL AUTO_INCREMENT,
  `street` varchar(25) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` char(2) DEFAULT NULL,
  `zipcode` int DEFAULT NULL,
  `createdOn` datetime DEFAULT CURRENT_TIMESTAMP,
  `deletedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `job` (
  `jobId` int NOT NULL AUTO_INCREMENT,
  `roleName` varchar(25) NOT NULL,
  `createdOn` datetime DEFAULT CURRENT_TIMESTAMP,
  `deletedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`jobId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `receitas` (
  `incomeId` int NOT NULL AUTO_INCREMENT,
  `incomeAmount` decimal(10,2) NOT NULL,
  `earnedDate` date NOT NULL,
  `note` varchar(25) DEFAULT NULL,
  `jobRole` varchar(25) NOT NULL,
  `userId` int NOT NULL,
  `createdOn` datetime DEFAULT CURRENT_TIMESTAMP,
  `deletedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`incomeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `receitas_transacao` (
  `incomeTransactionId` int NOT NULL AUTO_INCREMENT,
  `incomeId` int NOT NULL,
  `transactionId` int NOT NULL,
  `createdOn` datetime DEFAULT CURRENT_TIMESTAMP,
  `deletedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`incomeTransactionId`),
  KEY `incomeIncomeTxnF` (`incomeId`),
  KEY `transactionIncomeTxnF` (`transactionId`),
  CONSTRAINT `incomeIncomeTxnF` FOREIGN KEY (`incomeId`) REFERENCES `receitas` (`incomeId`),
  CONSTRAINT `transactionIncomeTxnF` FOREIGN KEY (`transactionId`) REFERENCES `transacao` (`transactionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `transacao` (
  `transactionId` int NOT NULL AUTO_INCREMENT,
  `netAmount` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `asOnDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userId` int NOT NULL,
  `isIncome` char(1) DEFAULT NULL,
  `createdOn` datetime DEFAULT CURRENT_TIMESTAMP,
  `deletedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`transactionId`),
  KEY `userTransaction` (`userId`),
  CONSTRAINT `userTransaction` FOREIGN KEY (`userId`) REFERENCES `usuario` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `usuario` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `recoveryAnswer` varchar(45) DEFAULT NULL,
  `recoveryEmail` varchar(30) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `lastUpdatedOn` datetime DEFAULT CURRENT_TIMESTAMP,
  `deletedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `usuario_endereco` (
  `userAddressId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `addressId` int NOT NULL,
  PRIMARY KEY (`userAddressId`),
  KEY `addressUserFore` (`addressId`),
  KEY `userIdAddFore` (`userId`),
  CONSTRAINT `addressUserFore` FOREIGN KEY (`addressId`) REFERENCES `endereco` (`addressId`),
  CONSTRAINT `userIdAddFore` FOREIGN KEY (`userId`) REFERENCES `usuario` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `usuarioinfo` (
  `userInfoId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `firstName` varchar(25) DEFAULT NULL,
  `middleName` varchar(25) DEFAULT NULL,
  `lastName` varchar(25) DEFAULT NULL,
  `phoneNumber` bigint DEFAULT NULL,
  `createdOn` datetime DEFAULT CURRENT_TIMESTAMP,
  `deletedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`userInfoId`),
  KEY `userInfoForeign` (`userId`),
  CONSTRAINT `userInfoForeign` FOREIGN KEY (`userId`) REFERENCES `usuario` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `usuariolog` (
  `userLogId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `lastLoggedIn` datetime DEFAULT CURRENT_TIMESTAMP,
  `lastLoggedOut` datetime DEFAULT NULL,
  `deletedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`userLogId`),
  KEY `userLogIDForeign` (`userId`),
  CONSTRAINT `userLogIDForeign` FOREIGN KEY (`userId`) REFERENCES `usuario` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
