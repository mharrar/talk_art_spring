package com.example.demo.controller;

import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@RestController
public class FormController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/submitForm")
    public String handleFormSubmission(@RequestParam("nom") String nom,
                                       @RequestParam("prenom") String prenom,
                                       @RequestParam("email") String email,
                                       @RequestParam("telephone") String telephone,
                                       @RequestParam("adresse") String adresse,
                                       @RequestParam("cadreSize") String cadreSize,
                                       @RequestParam("image") MultipartFile image,
                                       RedirectAttributes redirectAttributes) {

        // Créer un contenu pour l'email
        String emailContent = "Nom: " + nom + "\n" +
                              "Prénom: " + prenom + "\n" +
                              "Email: " + email + "\n" +
                              "Téléphone: " + telephone + "\n" +
                              "Adresse: " + adresse + "\n" +
                              "Taille du cadre: " + cadreSize;

        try {
            // Envoyer l'email avec le fichier joint
            emailService.sendEmailWithAttachment(email, "Formulaire soumis", emailContent, image);
            redirectAttributes.addFlashAttribute("message", "Formulaire soumis avec succès !");
            return "Formulaire soumis avec succès !";
        } catch (IOException e) {
            return "Erreur lors de l'envoi de l'email : " + e.getMessage();
        }
    }
}
