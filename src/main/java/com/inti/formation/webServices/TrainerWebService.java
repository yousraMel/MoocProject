package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Organism;
import com.inti.formation.entities.Trainer;
import com.inti.formation.enumeration.TrainerState;
import com.inti.formation.iservices.ITrainerService;

@RestController
@RequestMapping("/apiTrainer")
@CrossOrigin("*")
public class TrainerWebService {

	@Autowired
	private ITrainerService service;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Trainer saveTrainer (@RequestBody Trainer t) {
		return service.saveOrUpdateTrainer(t);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Trainer updateTrainer (@RequestBody Trainer t) {
		return service.saveOrUpdateTrainer(t);
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Trainer getByIdTrainer (@PathVariable Long id) {
		return service.getByIdTrainer(id);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void deleteTrainer (@PathVariable Long id) {
		service.deleteTrainer(id);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Trainer> findAllTrainer () {
		return service.getAllTrainer();
	}
	
//	@RequestMapping(value="/validate",method=RequestMethod.GET)
//	public Trainer validate(@PathVariable String trainerState){
//		return service.findByTrainerState(trainerState);
//	}
	

	@RequestMapping(value = "/getAllValidatedTrainer", method = RequestMethod.GET)
		public List<Trainer> findAllValide() {
		return service.findByTrainerState("alreadyValidated");
	}
	
	@RequestMapping(value = "/getAllNotValidatedTrainer", method = RequestMethod.GET)
	public List<Trainer> findAllNotValide() {
		return service.findByTrainerState("notYetValidated");
	}
	
	@RequestMapping(value="/trainerState", method=RequestMethod.GET)
	public Trainer validateTrainer(@PathVariable("id") Long idTrainer, @RequestBody Trainer t) {
//		Trainer trainer = new Trainer();
//		trainer = service.getByIdTrainer(idTrainer);
//		System.out.println(trainer);
//		trainer.setTrainerState("alreadyValidated");
//		System.out.println(trainer);
//		t.setFirstName("Mouhja");
		return service.saveOrUpdateTrainer(t);
	}
	

	
	
}
