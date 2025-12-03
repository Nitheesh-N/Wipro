SELECT e.firstname, e.lastname, d.departmentname, e.salary
FROM employees e
JOIN departments d ON e.departmentid = d.departmentid
JOIN (
  SELECT departmentid, AVG(salary) AS averageSalary
  FROM employees
  GROUP BY departmentid
) dept_avg ON e.departmentid = dept_avg.departmentid
WHERE e.salary > dept_avg.averageSalary
ORDER BY e.salary ASC;