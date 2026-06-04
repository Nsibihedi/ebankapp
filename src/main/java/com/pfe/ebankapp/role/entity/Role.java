package com.pfe.ebankapp.role.entity;

// Import des annotations JPA et validation
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indique que cette classe est une entité JPA (sera mappée à une table DB)
@Data   // Lombok : génère getters, setters, toString, equals, hashCode
@Builder // Lombok : permet de créer des objets avec le pattern Builder
@Table(name = "roles") // Spécifie le nom de la table dans la base de données
@AllArgsConstructor // Lombok : constructeur avec tous les champs
@NoArgsConstructor  // Lombok : constructeur vide
public class Role {

    @Id // Clé primaire de la table
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // Auto-incrémentation du champ id dans la DB
    private Long id;

    @Column(unique = true) 
    // Colonne unique : pas deux rôles avec le même nom
    @NotBlank(message = "Role Name is required") 
    // Validation : le nom du rôle ne peut pas être vide
    private String name; // Nom du rôle, ex : CUSTOMER, AUDITOR, ADMIN
}