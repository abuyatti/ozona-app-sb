INSERT INTO BRANDS (ID, NAME) VALUES (1, 'ZARA');

INSERT INTO PRODUCTS (ID, NAME) VALUES (35455, 'NEW JEANS MID RISE CROPPED FLARE');

INSERT INTO PRICES (FK_BRAND, START_DATE, END_DATE, PRICE_LIST, FK_PRODUCT, PRIORITY, FINAL_PRICE, CURR) VALUES (1, parsedatetime('2020-06-14-00.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-hh.mm.ss'), 1, 35455, 0, 35.50, 'EUR');
INSERT INTO PRICES (FK_BRAND, START_DATE, END_DATE, PRICE_LIST, FK_PRODUCT, PRIORITY, FINAL_PRICE, CURR) VALUES (1, parsedatetime('2020-06-14-15.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-06-14-18.30.00', 'yyyy-MM-dd-hh.mm.ss'), 2, 35455, 1, 25.45, 'EUR');
INSERT INTO PRICES (FK_BRAND, START_DATE, END_DATE, PRICE_LIST, FK_PRODUCT, PRIORITY, FINAL_PRICE, CURR) VALUES (1, parsedatetime('2020-06-15-00.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-06-15-11.00.00', 'yyyy-MM-dd-hh.mm.ss'), 3, 35455, 1, 30.50, 'EUR');
INSERT INTO PRICES (FK_BRAND, START_DATE, END_DATE, PRICE_LIST, FK_PRODUCT, PRIORITY, FINAL_PRICE, CURR) VALUES (1, parsedatetime('2020-06-15-16.00.00', 'yyyy-MM-dd-hh.mm.ss'), parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-hh.mm.ss'), 4, 35455, 1, 38.95, 'EUR');
