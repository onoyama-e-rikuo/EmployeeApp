package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
