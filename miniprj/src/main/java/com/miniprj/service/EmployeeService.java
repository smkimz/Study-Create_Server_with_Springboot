package com.miniprj.service;

import com.miniprj.domain.Employee;
import com.miniprj.domain.Role;
import com.miniprj.domain.Team;
import com.miniprj.dto.request.EmployeeCreateRequest;
import com.miniprj.dto.response.EmployeeResponse;
import com.miniprj.repository.EmployeeRepository;
import com.miniprj.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final TeamRepository teamRepository;
	private final TeamService teamService;

	public EmployeeService(EmployeeRepository employeeRepository, TeamRepository teamRepository, TeamService teamService) {
		this.employeeRepository = employeeRepository;
		this.teamRepository = teamRepository;
		this.teamService = teamService;
	}

	@Transactional
	public List<EmployeeResponse> getAllEmployees() {
		return employeeRepository.findAll().stream().map(employee -> new EmployeeResponse(employee.getName(), employee.getTeam() == null ? null : employee.getTeam().getName(), employee.getRole(), employee.getBirthday(), employee.getWorkStartDate())).toList();
	}

	@Transactional
	public void createEmployee(EmployeeCreateRequest request) {
		Employee employee;
		Team team = null;

		if (request.getTeamName() != null) {
			team = teamService.getTeam(request.getTeamName());
		}

		if (team == null) {
			employee = new Employee(request.getName(), request.getWorkStartDate(), request.getBirthday());
			employeeRepository.save(employee);
			return;
		}

		employee = new Employee(request.getName(), team, request.getRole(), request.getWorkStartDate(), request.getBirthday());
		if (request.getRole() == Role.Manager) {
			if (team.getManager() != null) {
				Employee currentManager = team.getManager();
				currentManager.setRole(Role.Member);
				employeeRepository.save(currentManager);
			}
			team.setManager(employee);
		}

		employeeRepository.save(employee);
		teamRepository.save(team);
	}
}
