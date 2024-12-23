package com.example.demo.controller;

import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {

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
    @PostMapping("/contact/send")
    public String sendContactForm(
            @RequestParam("nom") String nom,
            @RequestParam("email") String email,
            @RequestParam("message") String message,
            @RequestParam(value = "file", required = false) MultipartFile file,
            RedirectAttributes redirectAttributes) {

        // Préparation du sujet et du contenu de l'email
        String subject = "Nouveau message de " + nom;
        String emailContent = "Nom: " + nom + "\n" +
                              "Email: " + email + "\n\n" +
                              "Message:\n" + message;

        try {
            // Vérifie si un fichier est attaché et envoie l'email en conséquence
            if (file != null && !file.isEmpty()) {
                emailService.sendEmailWithAttachment("mehdi0harrar@gmail.com", subject, emailContent, file);
            } else {
                emailService.sendSimpleMessage("mehdi0harrar@gmail.com", subject, emailContent);
            }

            // Message de succès
            redirectAttributes.addFlashAttribute("successMessage", "Votre message a été envoyé avec succès!");
        } catch (Exception e) {
            // Gestion des erreurs et retour d'un message d'erreur
            System.err.println("Erreur lors de l'envoi de l'email : " + e.getMessage());
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de l'envoi de l'email : " + e.getMessage());
        }

        // Redirection vers la page de contact
        return "redirect:/contact";
    }
}
