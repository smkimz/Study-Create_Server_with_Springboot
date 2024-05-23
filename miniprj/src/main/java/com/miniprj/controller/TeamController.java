package com.miniprj.controller;

import com.miniprj.dto.request.TeamRequest;
import com.miniprj.dto.response.TeamResponse;
import com.miniprj.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamController {

	private final TeamService teamService;

	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}

	@GetMapping("/teams")
	public List<TeamResponse> getAllTeams() {
		return teamService.getAllTeams();
	}

	@PostMapping("/team")
	public void createTeam(@RequestBody TeamRequest request) {
		teamService.createTeam(request);
	}
}
