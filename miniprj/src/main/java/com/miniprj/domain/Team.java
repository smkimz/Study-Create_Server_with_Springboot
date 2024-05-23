package com.miniprj.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Team {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "TEAM_NAME", unique = true)
	private String name;

	@OneToOne
	@JoinColumn(name = "MANAGER_ID")
	private Employee manager;

	public Team() {
	}

	public Team(String name) {
		this.name = name;
	}
}
