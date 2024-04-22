package com.example.demoN;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Film {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String title;

@ManyToMany(mappedBy = "films")
private List<Actor> actor;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public List<Actor> getActor(){
	return actor;
}
public void setActor(List<Actor> actor) {
	this.actor=actor;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
}
