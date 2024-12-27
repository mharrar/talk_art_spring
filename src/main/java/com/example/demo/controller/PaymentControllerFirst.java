package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.EmailService;

@Controller
public class PaymentControllerFirst {
	 @Autowired
	    private EmailService emailService;

	    /**
	     * Traite le formulaire de contact et envoie un email.
	     *
	     * @param nom                Le nom de l'expéditeur
	     * @param email              L'adresse email de l'expéditeur
	     * @param message            Le contenu du message
	     * @param file               (Optionnel) Un fichier attaché au message
	     * @param redirectAttributes Pour transmettre des messages flash (succès/erreur)
	     * @return Redirige vers la page de contact avec un message de retour
	     */
	    @PostMapping("/firstgateway")
	    public String sendContactForm(
	           
	            @RequestParam("email") String email,
	            @RequestParam("telephone") String telephone,
	            @RequestParam("adresse") String adresse,
	            RedirectAttributes redirectAttributes) {

	        // Préparation du sujet et du contenu de l'email
	        String subject = "Nouveau message de " + email;
	        String emailContent ="Email: " + email + "\n\n" +
	                              "telephone:" + telephone + "\n\n"+
	                              "adresse:" + adresse ;
	        					  	

	        try {
	            
	            {
	                emailService.sendSimpleMessage("mehdi0harrar@gmail.com", subject, emailContent);
	            }

	            // Message de succès
	            redirectAttributes.addFlashAttribute("successMessage", "Votre message a été envoyé avec succès!");
	            return "redirect:https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=R6PKR3YC8TTY2";

	        } catch (Exception e) {
	            // Gestion des erreurs et retour d'un message d'erreur
	            System.err.println("Erreur lors de l'envoi de l'email : " + e.getMessage());
	            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de l'envoi de l'email : " + e.getMessage());
	        }

	        // Redirection vers la page de contact
	        return "redirect:/petitimage";
	    }
	    
	    @PostMapping("/secondgateway")
	    public String sendContactForme(
	           
	            @RequestParam("email") String email,
	            @RequestParam("telephone") String telephone,
	            @RequestParam("adresse") String adresse,
	            RedirectAttributes redirectAttributes) {

	        // Préparation du sujet et du contenu de l'email
	        String subject = "Nouveau message de " + email;
	        String emailContent ="Email: " + email + "\n\n" +
	                              "telephone:" + telephone + "\n\n"+
	                              "adresse:" + adresse ;
	        					  	

	        try {
	            
	            {
	                emailService.sendSimpleMessage("mehdi0harrar@gmail.com", subject, emailContent);
	            }

	            // Message de succès
	            redirectAttributes.addFlashAttribute("successMessage", "Votre message a été envoyé avec succès!");
	            return "redirect:https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=RV87NTTH69KZY";

	        } catch (Exception e) {
	            // Gestion des erreurs et retour d'un message d'erreur
	            System.err.println("Erreur lors de l'envoi de l'email : " + e.getMessage());
	            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de l'envoi de l'email : " + e.getMessage());
	        }

	        // Redirection vers la page de contact
	        return "redirect:/moyenimage";
	    }
	    @PostMapping("/thirdgateway")
	    public String sendContactForme3(
	           
	            @RequestParam("email") String email,
	            @RequestParam("telephone") String telephone,
	            @RequestParam("adresse") String adresse,
	            RedirectAttributes redirectAttributes) {

	        // Préparation du sujet et du contenu de l'email
	        String subject = "Nouveau message de " + email;
	        String emailContent ="Email: " + email + "\n\n" +
	                              "telephone:" + telephone + "\n\n"+
	                              "adresse:" + adresse ;
	        					  	

	        try {
	            
	            {
	                emailService.sendSimpleMessage("mehdi0harrar@gmail.com", subject, emailContent);
	            }

	            // Message de succès
	            redirectAttributes.addFlashAttribute("successMessage", "Votre message a été envoyé avec succès!");
	            return "redirect:https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=Q9ZG8LFN3GJLG";

	        } catch (Exception e) {
	            // Gestion des erreurs et retour d'un message d'erreur
	            System.err.println("Erreur lors de l'envoi de l'email : " + e.getMessage());
	            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de l'envoi de l'email : " + e.getMessage());
	        }

	        // Redirection vers la page de contact
	        return "redirect:/grandimage";
	    }
	}

