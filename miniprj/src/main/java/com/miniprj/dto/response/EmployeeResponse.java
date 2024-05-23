package com.miniprj.dto.response;

import com.miniprj.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class EmployeeResponse {

	private String name;
	private String teamName;
	private Role role;
	private LocalDate birthday;
	private LocalDate workStartDate;

}
