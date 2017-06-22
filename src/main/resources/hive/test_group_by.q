DROP TABLE IF EXISTS test_table;
CREATE TABLE IF NOT EXISTS test_table (type String, type_count BIGINT,execute_dept BIGINT);
INSERT INTO TABLE test_table
SELECT fy_leibie as type, count(fy_leibie_type) as type_count, sum(execute_dept) as dep_sum
 FROM  ${hiveconf:TABLE}  WHERE fy_leibie_type IS NOT NULL
  and create_time >= '${hiveconf:START_DATE}'
  and create_time <= '${hiveconf:END_DATE}'
GROUP BY fy_leibie;