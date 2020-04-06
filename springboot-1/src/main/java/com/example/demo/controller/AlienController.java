package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AlienRepo;
import com.example.demo.exception.AlienNotFound;
import com.example.demo.modal.Alien;

@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;

	/*
	 * @RequestMapping("/") public String home() { return "home.jsp"; }
	 */

	// insert through jsp page
	/*
	 * @RequestMapping("/addalien") public String addAlien(Alien alien) {
	 * repo.save(alien); return "home.jsp"; }
	 */

	// insert through rest api
	@PostMapping(path = "/alien", consumes = { "application/json" })
	public Alien addAlien(@Valid @RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}

	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien obj = repo.getOne(aid);
		repo.delete(obj);
		return "data deleted";
	}

	@PutMapping(path = "/alien", consumes = { "application/json" })
	public Alien saveorupdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}

	// search by id in jsp page
	/*
	 * @RequestMapping("/fetchalien") public ModelAndView fetchalien(@RequestParam
	 * int aid) { ModelAndView mv = new ModelAndView("showalien.jsp"); Alien alien =
	 * repo.findById(aid).orElse(new Alien()); mv.addObject(alien); return mv; }
	 */

	// show all record
	@GetMapping("/alien")
	public List<Alien> getallaliens() {
		return (List<Alien>) repo.findAll();
	}

	@RequestMapping("alien/{aid}")
	public Optional<Alien> getdetailbyaid(@PathVariable("aid") int aid) {
		Optional<Alien> optionalalien = repo.findById(aid);
		if (!optionalalien.isPresent())
			throw new AlienNotFound("No such alien is found on planet");
		return optionalalien;
	}

//	@RequestMapping("/delalien")x
//	public void del(@RequestParam int aid)
//	{
//		repo.deleteById(aid);
//	}

}
