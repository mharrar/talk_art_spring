package com.example.demo.controller;
import jakarta.servlet.http.HttpSession;

//Ajouter l'image

import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Controller
public class FormController {

    @Autowired
    private EmailService emailService;

    // Chemin du répertoire d'upload
    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/submitForm")
    public String handleFormSubmission(@RequestParam("nom") String nom,
                                       @RequestParam("prenom") String prenom,
                                       @RequestParam("email") String email,
                                       @RequestParam("telephone") String telephone,
                                       @RequestParam("adresse") String adresse,
                                       @RequestParam("cadreSize") String cadreSize,
                                       @RequestParam("image") MultipartFile image,
                                       Model model,
                                       RedirectAttributes redirectAttributes) {

        // Créer un contenu pour l'email
        String emailContent = "Nom: " + nom + "\n" +
                              "Prénom: " + prenom + "\n" +
                              "Email: " + email + "\n" +
                              "Téléphone: " + telephone + "\n" +
                              "Adresse: " + adresse + "\n" +
                              "Taille du cadre: " + cadreSize;

        try {
            // Vérifiez si l'image n'est pas vide
            if (!image.isEmpty()) {
                // Convertir l'image en tableau de bytes
                byte[] imageBytes = image.getBytes();
                // Convertir en Base64 pour l'affichage
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                String imageDataUri = "data:image/jpeg;base64," + base64Image;

                // Envoyer l'email avec l'image en tant que pièce jointe
                emailService.sendEmailWithAttachment("mehdi0harrar@gmail.com", "Nouvelle soumission de formulaire", emailContent, image);

                // Ajouter l'image encodée en Base64 au modèle pour la page petitimage
                model.addAttribute("image", imageDataUri);

                // Redirection en fonction de la taille du cadre sélectionnée
                switch (cadreSize) {
                    case "25-40":
                        return "petitimage"; // Essayer une redirection explicite
                    case "50-65":
                        return "accueil";      // Vue pour une taille de cadre moyenne
                    case "75-100":
                        return "accueil";      // Vue pour une grande taille de cadre
                    default:
                        redirectAttributes.addFlashAttribute("errorMessage", "Taille de cadre invalide.");
                        return "redirect:/accueil"; // Redirige vers la page d'erreur si aucune taille valide n'est sélectionnée
                }
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Le fichier image est vide !");
                return "redirect:/accueil";
            }
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors du traitement de l'image : " + e.getMessage());
            return "redirect:/accueil";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de l'envoi de l'email : " + e.getMessage());
            return "redirect:/accueil";
        }
    }

 

    // Méthode pour afficher l'image téléchargée en Base64
    @GetMapping("/petitimage")
    public String showUploadedPage(Model model) {
        // L'image a déjà été ajoutée au modèle lors de la soumission du formulaire
        return "petitimage"; // Redirige vers la page "petitimage" pour afficher l'image
    }
}
