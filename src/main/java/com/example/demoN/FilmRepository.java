package com.example.demoN;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FilmRepository extends JpaRepository<Film,Integer> {

}