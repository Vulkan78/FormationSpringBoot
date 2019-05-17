package com.mkyong.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.FormationRepository;
import com.mkyong.domaine.Formation;


@Service
public class FormationService {

	@Autowired
	private FormationRepository FormationRepository;
	
	public List<Formation> getAll() {
		return FormationRepository.findAll();
	}
	
	public void create(Formation newform) {
		FormationRepository.save(newform);
	}
	
	public void deletebyId(Long id) {
		FormationRepository.deleteById(id);
	}

	public Formation findById(Long id) {
		return FormationRepository.getOne(id);
	}

	public void validateUpdate(Formation formation) {
		FormationRepository.save(formation);
	}

	public List<Formation> findByThemeContaining(String search) {
		String[] arrayOfString;
		List<Formation> listFormation = new ArrayList<Formation>(); 
		arrayOfString = search.split("[ -;,]");
		for(String word : arrayOfString) {
			listFormation.addAll(FormationRepository.findByThemeContaining(word));
		}
		return listFormation;
	}
	
}
