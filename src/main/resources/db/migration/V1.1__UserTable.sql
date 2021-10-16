CREATE TABLE User_def (
    ID UUID NOT NULL PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL,
    LAST_NAME VARCHAR(100) NOT NULL,
    CODE VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    BIRTHDATE TIMESTAMP DEFAULT NULL,
    PASSWORD VARCHAR(100),
    PASSWORD_HISTORY json
 );