package com.miniprj.repository;

import com.miniprj.domain.Employee;
import com.miniprj.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	long countByTeam(Team team);
}
