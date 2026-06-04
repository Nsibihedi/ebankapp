package com.pfe.ebankapp.role.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pfe.ebankapp.exceptions.BadRequestException;
import com.pfe.ebankapp.exceptions.NotFoundException;
import com.pfe.ebankapp.res.Response;
import com.pfe.ebankapp.role.entity.Role;
import com.pfe.ebankapp.role.repo.RoleRepo;

import lombok.RequiredArgsConstructor;

// Annotation Spring pour déclarer cette classe comme un service métier
@Service
// Lombok : génère automatiquement un constructeur pour toutes les propriétés finales (ici roleRepo)
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    // Injection du repository RoleRepo pour interagir avec la base de données
    private final RoleRepo roleRepo;

    // Méthode pour créer un nouveau rôle
    @Override
    public Response<Role> createRole(Role roleRequest) {

        // Vérifie si un rôle avec le même nom existe déjà dans la base
        if(roleRepo.findByName(roleRequest.getName()).isPresent()){
            // Si oui, lance une exception pour indiquer une mauvaise requête (400)
            throw new BadRequestException("Role already exists");
        }

        // Sauvegarde le nouveau rôle dans la base de données
        Role saveedRole = roleRepo.save(roleRequest);

        // Retourne une réponse standardisée avec le rôle créé et un message de succès
        return Response.<Role>builder()
                .statusCode(HttpStatus.OK.value())  // Code HTTP 200
                .message("Role saved successfully")  // Message d'information
                .data(saveedRole)                   // Données retournées (le rôle créé)
                .build();
    }

    // Méthode pour mettre à jour un rôle existant
    @Override
    public Response<Role> updateRole(Role roleRequest) {

        // Recherche le rôle par son ID, sinon lance une exception NotFound (404)
        Role role = roleRepo.findById(roleRequest.getId())
                .orElseThrow(() -> new NotFoundException("Role not found"));

        // Met à jour le nom du rôle avec la valeur de la requête
        role.setName(roleRequest.getName());

        // Sauvegarde le rôle mis à jour
        Role updatedRole = roleRepo.save(role);

        // Retourne une réponse standardisée avec le rôle mis à jour
        return Response.<Role>builder()
                .statusCode(HttpStatus.OK.value())          // Code HTTP 200
                .message("Role updated successfully")       // Message d'information
                .data(updatedRole)                          // Données retournées (le rôle mis à jour)
                .build();
    }

    // Méthode pour récupérer tous les rôles de la base
    @Override
    public Response<List<Role>> getAllRoles() {

        // Récupère tous les rôles via le repository
        List<Role> roles = roleRepo.findAll();

        // Retourne une réponse standardisée avec la liste des rôles
        return Response.<List<Role>>builder()
                .statusCode(HttpStatus.OK.value())          // Code HTTP 200
                .message("Roles retreived successfully")    // Message d'information
                .data(roles)                                // Données retournées (liste des rôles)
                .build();
    }

    // Méthode pour supprimer un rôle par son ID
    @Override
    public Response<?> deleteRole(Long id) {

        // Vérifie si le rôle existe avant de le supprimer
        if (!roleRepo.existsById(id)){
            // Si le rôle n'existe pas, lance une exception NotFound (404)
            throw new NotFoundException("Role Not Found");
        }

        // Supprime le rôle de la base de données
        roleRepo.deleteById(id);

        // Retourne une réponse standardisée confirmant la suppression
        return Response.builder()
                .statusCode(HttpStatus.OK.value())          // Code HTTP 200
                .message("Role deleted successfully")       // Message d'information
                .build();
    }
}