INSERT INTO LOCATION (NAME, LATITUDE, LONGITUDE)
VALUES ('Pune, India', '7.13111', '-61.54801');

INSERT INTO LOCATION (NAME, LATITUDE, LONGITUDE)
VALUES ('Mumbai, India', '8.13111', '-71.54801');

INSERT INTO WAREHOUSE (NAME, LOCATION_ID)
VALUES ('Warehouse A', 1);

INSERT INTO WAREHOUSE (NAME, LOCATION_ID)
VALUES ('Warehouse A', 2);

INSERT INTO CAR(WAREHOUSE_ID, MAKE, MODEL, YEAR_MODEL, PRICE, LICENCED, DATE_ADDED)
VALUES (1, 'TATA', 'NANO', 2011, 100000.00, true, '2020-10-10');

INSERT INTO CAR(WAREHOUSE_ID, MAKE, MODEL, YEAR_MODEL, PRICE, LICENCED, DATE_ADDED)
VALUES (1, 'Maruti', 'DZire', 2011, 100000.00, true, '2020-10-10');

INSERT INTO CAR(WAREHOUSE_ID, MAKE, MODEL, YEAR_MODEL, PRICE, LICENCED, DATE_ADDED)
VALUES (2, 'Mahindra', 'Scorpio', 2011, 100000.00, true, '2020-10-10');