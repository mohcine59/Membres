package fr.membres.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import fr.membres.entities.Membre;

public class InscriptionDto {

	@NotNull
	@Size(min = 1, max = 25, message = "Le nom doit être compris entre 1 et 25 caractères")
	private String nom;

	@NotNull
	@Size(min = 1, max = 25, message = "Le prenom doit être compris entre 1 et 25 caractères")
	private String prenom;

	@NotNull
	@Email(message = "veuillez entrer un email valide !")
	private String email;

	@NotNull
	@Size(min = 8, max = 15, message = "Le mot de passe doit être compris entre 8 et 15 caractères")
	private String password;

	private String tel;

	public String getTel() {
		return this.tel;
	}

	public void setTel(final String tel) {
		this.tel = tel;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public InscriptionDto(final String nom, final String prenom, final String email, final String password,
			final String tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.tel = tel;
	}

	public InscriptionDto(final Membre m) {
		this.nom = m.getNom();
		this.prenom = m.getPrenom();
		this.email = m.getEmail();
		this.password = m.getUser().getPassword();
		this.tel = m.getTel();
	}

	public InscriptionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
