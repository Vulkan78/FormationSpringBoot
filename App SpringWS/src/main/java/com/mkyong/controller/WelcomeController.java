package com.mkyong.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.FormationRepository;
import com.mkyong.domaine.Formation;
import com.mkyong.service.FormationService;

@Controller 
@RequestMapping("/formationList") 
public class WelcomeController {

	private FormationRepository FormationRepository;
	  private FormationService formationservice;
	  
		@Autowired  
		public WelcomeController(FormationRepository FormationRepository) {    
			this.FormationRepository = FormationRepository;  
		}

		@RequestMapping(value="/{theme}", method=RequestMethod.GET)  
		public String listerLesFormations(@PathVariable("theme") String theme,  Model model) {
			List<Formation> listeFormation =  FormationRepository.findByTheme(theme);    
			if (listeFormation != null) {      
				model.addAttribute("listeFormation", listeFormation);    
				}    
			return "listeFormationParTheme";  
		}
		
		@RequestMapping(value="/{theme}", method=RequestMethod.POST)  
		public String addToFormation(@PathVariable("theme") String theme, Formation formation) {
			formation.setTheme(theme);    
			FormationRepository.save(formation);    
			return "redirect:/Formation/{theme}";  
		}
		
	    @RequestMapping({"/", "/index"})
	    public ModelAndView index (){
	        ModelAndView MAV = new ModelAndView();
	        MAV.setViewName("index");
	        MAV.addObject("formationList", this.formationservice.getAll());
	        return MAV;
	    }
	    
	    @RequestMapping("/form")
	    public ModelAndView showForm() {
	    	ModelAndView MAV = new ModelAndView();
	    	MAV.setViewName("form");
	        return MAV;
	    }
	    
	    @RequestMapping(value = "/form", method = RequestMethod.POST)
	    public String validateForm(@RequestParam Long id, @RequestParam String theme) {
			// Sauvegarder formation en BDD.
			final Formation newform = new Formation(id, theme);
			this.formationservice.create(newform);
			// Renvoyer vers la page de liste des articles.
			//return this.index();
			return "redirect:/index.html";
	    }
	    
	    @GetMapping("/delete")
		public String delete(Long id) {
			// Supprimer formation.
	    	this.formationservice.deletebyId(id);
			// Renvoyer vers la vue welcome.
	    	return "redirect:/index.html";
		}
	    
		@GetMapping("/edit")
		public ModelAndView displayEdit(Long id) {
			ModelAndView mav = new ModelAndView("form");
			Formation result = this.formationservice.findById(id);
			Hibernate.initialize(result);
			if (result!= null) {
				mav.addObject("editFormation", result);
			}
			return mav;
		}
		
		@PostMapping("/edit")
		public String validateUpdate(Formation formation) {
			this.formationservice.validateUpdate(formation);
			return "redirect:/index.html";
		}
		
		@RequestMapping("/search")
		public ModelAndView displaySearch(String search) {
			ModelAndView mav = new ModelAndView("search");
			return mav;
		}
		
		@PostMapping("/search")
		public ModelAndView search(String search) {
			ModelAndView mav = new ModelAndView("search");
			mav.addObject("resultList", this.formationservice.findByThemeContaining(search));
			return mav;
		}

}