package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;


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
	@GetMapping("/Galerie")
	public String Galerie() {
		return "Galerie"; // Nom du fichier HTML sans l'extension .html
		}
	@GetMapping("/contact")
	public String contact() {
		return "contact"; // Nom du fichier HTML sans l'extension .html
		}

	
}
