package com.miniprj.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_NAME")
	private Team team;
	private Role role;
	private LocalDate workStartDate;
	private LocalDate birthday;

	public Employee() {
	}

	public Employee(String name, LocalDate workStartDate, LocalDate birthday) {
		this.name = name;
		this.workStartDate = workStartDate;
		this.birthday = birthday;
	}

	public Employee(String name, Team team, Role role, LocalDate workStartDate, LocalDate birthday) {
		this.name = name;
		this.team = team;
		this.role = role;
		this.workStartDate = workStartDate;
		this.birthday = birthday;
	}
}
