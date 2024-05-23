package com.miniprj.dto.request;

import com.miniprj.domain.Role;
import com.miniprj.domain.Team;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeCreateRequest {

	private String name;
	private String teamName;
	private Role role;
	private LocalDate workStartDate;
	private LocalDate birthday;

}
