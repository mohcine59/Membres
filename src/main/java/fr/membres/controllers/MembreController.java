package fr.membres.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.membres.dto.InscriptionDto;
import fr.membres.entities.Membre;
import fr.membres.entities.UserRoles;
import fr.membres.entities.User;
import fr.membres.metier.MembreMetier;
import fr.membres.metier.RoleMetier;
import fr.membres.metier.UserMetier;

@Controller
@RequestMapping(value="/membre")
public class MembreController {

	@Autowired
	private MembreMetier membreMetier;
	
	@Autowired
	private UserMetier userMetier;
	
	@Autowired
	private RoleMetier roleMetier;
	
	@RequestMapping(value="/myProfil")
	public String myProfil(Principal principal, Model model){
		
		model.addAttribute("membre",membreMetier.getMembre(principal.getName()));
		return "myProfil";
	}
	
	@RequestMapping(value="/login")
	public String accueil(Model model){
		model.addAttribute("inscriptionDto", new InscriptionDto());
		model.addAttribute("membres",membreMetier.getMembres());
		model.addAttribute("membre", new Membre());
		return "accueil";
	}
	
	
	
	
	@RequestMapping(value="editMembre")
	public String editMembre(Long membreID, Model model){
		
		Membre editMembre = membreMetier.getMembre(membreID);
		InscriptionDto iDto = new InscriptionDto(editMembre);
		
		model.addAttribute("editMembre", editMembre);
		model.addAttribute("inscriptionDto", iDto );
		model.addAttribute("membres", membreMetier.getMembres());
		
		return "accueil";
	}
	
	@RequestMapping(value="deleteMembre")
	public String deleteMembre(Long membreID, Model model){
		Membre deleteMembre = membreMetier.getMembre(membreID);
		System.out.println("voici le membre ---> "+deleteMembre.getMembreID());
		membreMetier.deleteMembre(membreID);
		model.addAttribute("inscriptionDto", new InscriptionDto());
		model.addAttribute("membres", membreMetier.getMembres());
		return "accueil";
	}
}
