//JDBC CallableStatement Stored procedure IN parameter example.

CREATE OR REPLACE PROCEDURE insertEMPLOYEE(
	   e_id IN EMPLOYEE.EMPLOYEE_ID%TYPE,
	   e_name IN EMPLOYEE.NAME%TYPE,
	   e_salary IN EMPLOYEE.SALARY%TYPE)
IS
BEGIN
 
  INSERT INTO EMPLOYEE ("EMPLOYEE_ID", "NAME", "SALARY") 
  VALUES (e_id, e_name, e_salary);
 
  COMMIT;
 
END;