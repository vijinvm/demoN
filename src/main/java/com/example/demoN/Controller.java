package com.example.demoN;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {

	@Autowired
	private FilmRepository f;
	
	
	
	@GetMapping("/film")
	public Page<Film>a1(@RequestParam(defaultValue="0")int page,
			@RequestParam(defaultValue="10")int size,
			@RequestParam(defaultValue="id")String sortBy){
		return f.findAll(PageRequest.of(page, size,Sort.by(sortBy)));
	}
	@GetMapping("/film/{id}")
	public Film a2(@PathVariable int id) {
		return f.findById(id).orElse(null);
	}
	@PostMapping("/film")
	public Film a3(@RequestBody Film film) {
		return f.save(film);
	}
	@PutMapping("/film/{id}")
	public Film a4(@PathVariable int id,@RequestBody Film film) {
		return f.findById(id).map(e->{e.setTitle(film.getTitle());
		return f.save(e);
	})
				.orElse(null);
	}
	@DeleteMapping("/film/{id}")
	public void a5(@PathVariable int id) {
		f.deleteById(id);
	}
	@Autowired
	private ActorRepository a;
	
	
	@GetMapping("/actors")
	public Page<Actor>g1(@RequestParam int page,
			@RequestParam int size){
		return a.findAll(PageRequest.of(page, size));
	}
	@GetMapping("/sorting")
	public List<Actor>a6(@RequestParam String sortBy){
		Sort sort =Sort.by(sortBy);
		return a.findAll(sort);
	}
	@GetMapping("/sorting1")
	public List<Actor>a7(@RequestParam String sortBy){
	//	Sort sort =Sort.by(sortBy);
		return a.findAll(Sort.by(sortBy));
	}
	@GetMapping("/actors/{id}")
	public Actor g2(@PathVariable int id) {
		return a.findById(id).orElse(null);
	}
	@PostMapping("/actors")
	public Actor g3(@RequestBody Actor actor) {
		return a.save(actor);
	}
	@PutMapping("/actors/{id}")
	public Actor g4(@PathVariable int id,@RequestBody Actor actor) {
		return a.findById(id).map(e->{e.setName(actor.getName());
		return a.save(e);
	})
				.orElse(null);
	}
	@DeleteMapping("/actors/{id}")
	public void g5(@PathVariable int id) {
		a.deleteById(id);
	}
}
