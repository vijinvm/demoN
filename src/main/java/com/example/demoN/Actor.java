package com.example.demoN;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	 @ManyToMany
	    @JoinTable(
	        name = "actor_film",
	        joinColumns = @JoinColumn(name = "actor_id"),
	        inverseJoinColumns = @JoinColumn(name = "film_id")
	    )
	private List<Film>films;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

}
