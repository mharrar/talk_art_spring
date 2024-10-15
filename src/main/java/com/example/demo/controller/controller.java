package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class controller {

	@GetMapping("/")
	public String redirectToAccueil() {
		return "redirect:/accueil";}
	@GetMapping("/accueil")
	public String acceuil() {
		return "accueil"; // Nom du fichier HTML sans l'extension .html
		}
	
	@GetMapping("/nous_découvrir")
	public String découvrir() {
		return "nous_découvrir"; // Nom du fichier HTML sans l'extension .html
		}
	@GetMapping("/formulaire")
	public String formulaire() {
		return "formulaire"; // Nom du fichier HTML sans l'extension .html
		}
}
