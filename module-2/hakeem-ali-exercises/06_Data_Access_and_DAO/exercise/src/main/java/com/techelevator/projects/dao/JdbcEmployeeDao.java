package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM employee";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			employees.add(MapRowToEmployee(results));
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<>();
		String sql;
		SqlRowSet results;
		if (firstNameSearch.isBlank() && lastNameSearch.isBlank()) {
			return getAllEmployees();
		} else if (firstNameSearch.isBlank() && !lastNameSearch.isBlank()) {
			sql = "SELECT * FROM employee WHERE last_name ILIKE ?";
			results = jdbcTemplate.queryForRowSet(sql, "%" + lastNameSearch + "%");
		} else if (!firstNameSearch.isBlank() && lastNameSearch.isBlank()) {
			sql = "SELECT * FROM employee WHERE first_name ILIKE ?";
			results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%");
		} else {
			sql = "SELECT * FROM employee WHERE first_name ILIKE ? AND last_name ILIKE ?";
			results = jdbcTemplate.queryForRowSet(sql, "%" + firstNameSearch + "%", "%" + lastNameSearch + "%");
		}
		while (results.next()) {
			employees.add(MapRowToEmployee(results));
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM employee " +
					"JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
					"WHERE project_employee.project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		while (results.next()) {
			employees.add(MapRowToEmployee(results));
		}
		return employees;
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id) " +
					"VALUES (?, ?) RETURNING project_id";
		jdbcTemplate.queryForObject(sql, new Object[]{projectId, employeeId}, String.class);
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DELETE FROM project_employee WHERE employee_id = ?";
		jdbcTemplate.update(sql, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM employee " +
					"LEFT OUTER JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
					"WHERE project_id IS NULL";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			employees.add(MapRowToEmployee(results));
		}
		return employees;
	}

	private Employee MapRowToEmployee(SqlRowSet rowSet) {
		Employee employee = new Employee();
		employee.setId(rowSet.getLong("employee_id"));
		employee.setDepartmentId(rowSet.getLong("department_id"));
		employee.setFirstName(rowSet.getString("first_name"));
		employee.setLastName(rowSet.getString("last_name"));
		employee.setBirthDate(rowSet.getDate("birth_date").toLocalDate());
		employee.setHireDate(rowSet.getDate("hire_date").toLocalDate());
		return employee;
	}
}
