CREATE TABLE Company(
    id INT PRIMARY KEY AUTO_INCREMENT,
    companyName VARCHAR(255) NOT NULL,
    employeesNumber INT NOT NULL
) engine=InnoDB DEFAULT CHARSET = gbk;

CREATE TABLE Employee(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10),
    companyId INT NOT NULL,
    salary INT NOT NULL
) engine=InnoDB DEFAULT CHARSET = utf8;

