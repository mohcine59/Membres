package fr.membres.controllers;

import java.io.IOException;
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
import fr.membres.entities.User;
import fr.membres.entities.UserRoles;
import fr.membres.metier.MembreMetier;
import fr.membres.metier.UserMetier;

@Controller
public class ConnexionController {

	@Autowired
	private MembreMetier membreMetier;

	@Autowired
	private UserMetier userMetier;

	@RequestMapping(value = "/login")
	public String accueil(final Model model) {
		model.addAttribute("inscriptionDto", new InscriptionDto());
		return "accueil";
	}

	@RequestMapping(value = "saveMembre")
	public String saveMembre(@ModelAttribute("inscriptionDto") @Valid final InscriptionDto iDto,
			final BindingResult bindingResult, final Model model) throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("membres", this.membreMetier.getMembres());
			return "accueil";
		}

		

		if (!bindingResult.hasErrors()) {

			final Membre mDto = new Membre(iDto.getNom(), iDto.getPrenom(), iDto.getEmail(), iDto.getTel());
			final User uDto = new User(iDto.getEmail(), iDto.getPassword());

			// CREATION DU ROLE
			final UserRoles userRole = new UserRoles();
			userRole.setRoleName("ROLE_ADMIN");
			userRole.setUser(uDto);

			uDto.setRoles(Arrays.asList(userRole));
			mDto.setUser(uDto);
			// userMetier.setUser(uDto);

			// r.setRoleID(userMetier.addUser(uDto));
			this.membreMetier.addMembre(mDto);
			// roleMetier.attribuerRole(r, uDto.getUserID());
		}
		
		model.addAttribute("membre", new Membre());

		System.out.println("============ SAVE JOUEUR =========");
		model.addAttribute("membres", this.membreMetier.getMembres());
		return "redirect:/login";
	}
	
	@RequestMapping(value="saveMembree")
	public String saveMembre2(@ModelAttribute("inscriptionDto") @Valid InscriptionDto iDto, BindingResult bindingResult, Model model) throws IOException{
		if(bindingResult.hasErrors()){
			model.addAttribute("membres", membreMetier.getMembres());
			return "accueil";
		}
		
		
		
		if(!bindingResult.hasErrors()){
			
			Membre mDto = new Membre(iDto.getNom(), iDto.getPrenom(), iDto.getEmail(), iDto.getTel());
			User uDto = new User(iDto.getEmail(), iDto.getPassword());
			
			//CREATION DU ROLE
			UserRoles userRole = new UserRoles();
			userRole.setRoleName("ROLE_ADMIN");
			userRole.setUser(uDto);
			
			uDto.setRoles(Arrays.asList(userRole));
			mDto.setUser(uDto);
			userMetier.setUser(uDto);
			
			//r.setRoleID(userMetier.addUser(uDto));
			membreMetier.addMembre(mDto);
			//roleMetier.attribuerRole(r, uDto.getUserID());
		}
		
		model.addAttribute("membre", new Membre());
		model.addAttribute("membres", membreMetier.getMembres());
		System.out.println("============ SAVE JOUEUR =========");
		return "redirect:/accueil";
	}

}
