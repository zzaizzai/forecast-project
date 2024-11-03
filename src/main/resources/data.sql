INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com');
INSERT INTO users (name, email) VALUES ('Jane Smith', 'jane@example.com');

INSERT INTO forecasts_group(name, created_date, updated_date, deleted) VALUES ('group1', '2024-10-11 06:21', '2024-10-11 06:21', false);

INSERT INTO forecasts(name, forecast_group_id, created_date, updated_date, unit, quantity, deleted ) VALUES ('forecast1', 1, '2024-10-11 06:21', '2024-10-11 06:21', 'k/m', 3, false);
INSERT INTO forecasts(name, forecast_group_id, created_date, updated_date, unit, quantity, deleted ) VALUES ('forecast2', 1,'2024-10-12 06:21', '2024-10-12 06:21', 'Date', 20231215, false);
INSERT INTO forecasts(name, forecast_group_id, created_date, updated_date, unit, quantity, deleted ) VALUES ('forecast3', 1,'2024-10-13 06:21', '2024-10-13 06:21', 'Date', 20231225, false);
INSERT INTO forecasts(name, forecast_group_id, created_date, updated_date, unit, quantity, deleted ) VALUES ('forecast4', 1,'2024-10-14 06:21', '2024-10-14 06:21', 'Datetime', 202412151210, false);
INSERT INTO forecasts(name, forecast_group_id, created_date, updated_date, unit, quantity, deleted ) VALUES ('forecast5', 1,'2024-10-15 06:21', '2024-10-15 06:21', 'Datetime', 202512121010, false);
INSERT INTO forecasts(name, forecast_group_id, created_date, updated_date, unit, quantity , deleted) VALUES ('forecast6', 1,'2024-10-16 06:21', '2024-10-16 06:21', 'hours', 15.55, false);
INSERT INTO forecasts(name, forecast_group_id, created_date, updated_date, unit, quantity, deleted ) VALUES ('forecast7', 1,'2024-10-17 06:21', '2024-10-17 06:21', 'dollars', 1600, false);
INSERT INTO forecasts(name, forecast_group_id, created_date, updated_date, unit, quantity , deleted) VALUES ('forecast8', 1,'2024-10-18 06:21', '2024-10-18 06:21', 'yen', 20000, false);
INSERT INTO forecasts(name, forecast_group_id, created_date, updated_date, unit, quantity, deleted ) VALUES ('forecast9', 1,'2024-10-19 06:21', '2024-10-19 06:21', 'yen', 10000000000, false);
INSERT INTO forecasts(name, forecast_group_id, created_date, updated_date, unit, quantity, deleted ) VALUES ('forecast9-deleted', 1,'2024-10-19 06:21', '2024-10-19 06:21', 'yen', 10000000000, true);

INSERT INTO results(name, parent_id, created_date, updated_date, unit, quantity , deleted) VALUES ('result1', 1 , '2024-10-11 06:21', '2024-10-11 06:21', 'k/m', 3, false);
INSERT INTO results(name, parent_id, created_date, updated_date, unit, quantity , deleted) VALUES ('result1-2', 1 , '2024-10-11 06:21', '2024-10-11 06:21', 'k/m', 10.5, false);
INSERT INTO results(name, parent_id, created_date, updated_date, unit, quantity , deleted) VALUES ('result2', 2 , '2024-10-12 06:21', '2024-12-11 06:21', 'Date', 20231225, false);
INSERT INTO results(name, parent_id, created_date, updated_date, unit, quantity, deleted ) VALUES ('result2-2', 2 , '2024-10-12 06:21', '2024-12-11 06:21', 'Date', 20241225, false);
INSERT INTO results(name, parent_id, created_date, updated_date, unit, quantity, deleted ) VALUES ('result4', 4 , '2024-10-12 06:21', '2024-12-11 06:21', 'Date', 202210201210, false);
INSERT INTO results(name, parent_id, created_date, updated_date, unit, quantity , deleted) VALUES ('result4-2', 4 , '2024-10-12 06:21', '2024-12-11 06:21', 'Date', 202412251215, false);
INSERT INTO results(name, parent_id, created_date, updated_date, unit, quantity , deleted) VALUES ('result4-2-deleted', 4 , '2024-10-12 06:21', '2024-12-11 06:21', 'Date', 202412251215, true);
