package com.miniprj.service;

import com.miniprj.domain.Team;
import com.miniprj.dto.request.TeamRequest;
import com.miniprj.dto.response.TeamResponse;
import com.miniprj.repository.EmployeeRepository;
import com.miniprj.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

	private final TeamRepository teamRepository;
	private final EmployeeRepository employeeRepository;

	public TeamService(TeamRepository teamRepository, EmployeeRepository employeeRepository) {
		this.teamRepository = teamRepository;
		this.employeeRepository = employeeRepository;
	}

	@Transactional
	public List<TeamResponse> getAllTeams() {
		return teamRepository.findAll().stream().map(team -> new TeamResponse(team.getName(), team.getManager() == null ? null : team.getManager().getName(), employeeRepository.countByTeam(team))).toList();
	}

	@Transactional
	public Team getTeam(String name) {
		Optional<Team> findTeam = teamRepository.findByName(name);
		if (findTeam.isEmpty()) {
			return null;
		}
		return findTeam.get();
	}

	@Transactional
	public void createTeam(TeamRequest request) {
		boolean isTeamExist = teamRepository.existsByName(request.getName());
		if (isTeamExist) {
			throw new IllegalArgumentException();
		}
		Team team = new Team(request.getName());
		teamRepository.save(team);
	}
}
