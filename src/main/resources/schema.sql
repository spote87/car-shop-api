DROP TABLE IF EXISTS ORDERS;
DROP TABLE IF EXISTS CAR;
DROP TABLE IF EXISTS WAREHOUSE;
DROP TABLE IF EXISTS LOCATION;

CREATE TABLE LOCATION
(
    LOCATION_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR NOT NULL ,
    LATITUDE    VARCHAR NOT NULL,
    LONGITUDE   VARCHAR NOT NULL
);

CREATE TABLE WAREHOUSE
(
    WAREHOUSE_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME         VARCHAR NOT NULL,
    LOCATION_ID  BIGINT,
    FOREIGN KEY (LOCATION_ID) REFERENCES LOCATION (LOCATION_ID)
);

CREATE TABLE CAR
(
    CAR_ID       BIGINT AUTO_INCREMENT     NOT NULL,
    WAREHOUSE_ID INT NOT NULL ,
    MAKE         VARCHAR NOT NULL,
    MODEL        VARCHAR NOT NULL,
    YEAR_MODEL   INT,
    PRICE        DECIMAL NOT NULL,
    LICENCED     BOOLEAN NOT NULL,
    DATE_ADDED   DATE    NOT NULL,
    PRIMARY KEY (CAR_ID),
    FOREIGN KEY (WAREHOUSE_ID) REFERENCES WAREHOUSE (WAREHOUSE_ID)
);

CREATE TABLE ORDERS
(
    ORDER_ID     BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_ID      VARCHAR NOT NULL,
    CAR_ID       INT,
    WAREHOUSE_ID INT,
    TOTAL_AMOUNT DECIMAL NOT NULL,
    FOREIGN KEY (CAR_ID) REFERENCES CAR (CAR_ID),
    FOREIGN KEY (WAREHOUSE_ID) REFERENCES WAREHOUSE (WAREHOUSE_ID)
);