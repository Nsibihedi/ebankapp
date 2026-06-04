package com.pfe.ebankapp.config;

// Import des classes nécessaires pour la configuration Spring, Thymeleaf et ModelMapper
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

// Annotation indiquant que cette classe contient des beans de configuration Spring
@Configuration
public class AppConfig {

    // Déclaration d'un bean Spring pour le moteur de templates Thymeleaf
    @Bean
    public SpringTemplateEngine templateEngine() {
        // Création d'une instance de SpringTemplateEngine
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();

        // Configuration du résolveur de templates (où chercher les fichiers HTML)
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");          // Dossier où se trouvent les fichiers HTML
        templateResolver.setSuffix(".html");               // Extension des fichiers templates
        templateResolver.setCharacterEncoding("UTF-8");   // Encodage des fichiers

        // On assigne le résolveur de templates au moteur Thymeleaf
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine; // On retourne le bean pour qu'il soit injecté partout
    }

    // Déclaration d'un bean Spring pour ModelMapper (mapping DTO ↔ entités)
    @Bean
    public ModelMapper modelMapperConfig() {
        // Création d'une instance de ModelMapper
        ModelMapper modelMapper = new ModelMapper();

        // Configuration du ModelMapper
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)                                // Active le mapping automatique des champs
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE) // Accède aux champs privés
                .setMatchingStrategy(MatchingStrategies.STANDARD);           // Stratégie de correspondance standard

        return modelMapper; // On retourne le bean pour pouvoir l'utiliser dans tout le projet
    }
}