INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com');
INSERT INTO users (name, email) VALUES ('Jane Smith', 'jane@example.com');


INSERT INTO forecasts(name, created_date, updated_date, unit, quantity ) VALUES ('forecast1', '2024-10-11 06:21', '2024-10-11 06:21', 'k/m', 3);
INSERT INTO forecasts(name, created_date, updated_date, unit, quantity ) VALUES ('forecast2', '2024-10-12 06:21', '2024-10-12 06:21', 'Date', 20231215);
INSERT INTO forecasts(name, created_date, updated_date, unit, quantity ) VALUES ('forecast3', '2024-10-13 06:21', '2024-10-13 06:21', 'Date', 20231225);
INSERT INTO forecasts(name, created_date, updated_date, unit, quantity ) VALUES ('forecast4', '2024-10-14 06:21', '2024-10-14 06:21', 'Datetime', 202412151210);
INSERT INTO forecasts(name, created_date, updated_date, unit, quantity ) VALUES ('forecast5', '2024-10-15 06:21', '2024-10-15 06:21', 'Datetime', 202512121010);
INSERT INTO forecasts(name, created_date, updated_date, unit, quantity ) VALUES ('forecast6', '2024-10-16 06:21', '2024-10-16 06:21', 'hours', 15.55);
INSERT INTO forecasts(name, created_date, updated_date, unit, quantity ) VALUES ('forecast7', '2024-10-17 06:21', '2024-10-17 06:21', 'dollars', 1600);
INSERT INTO forecasts(name, created_date, updated_date, unit, quantity ) VALUES ('forecast8', '2024-10-18 06:21', '2024-10-18 06:21', 'yen', 20000);
INSERT INTO forecasts(name, created_date, updated_date, unit, quantity ) VALUES ('forecast9', '2024-10-19 06:21', '2024-10-19 06:21', 'yen', 10000000000);


INSERT INTO results(name, parent_id, created_date, updated_date, unit, quantity ) VALUES ('result1', 1 , '2024-10-11 06:21', '2024-10-11 06:21', 'k/m', 3);
