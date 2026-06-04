package com.pfe.ebankapp.role.controller;

// Import des classes nécessaires pour gérer les requêtes HTTP et la sécurité
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ebankapp.res.Response;
import com.pfe.ebankapp.role.entity.Role;
import com.pfe.ebankapp.role.services.RoleService;

import lombok.RequiredArgsConstructor;

// Annotation pour déclarer cette classe comme un contrôleur REST
@RestController
// Définition du chemin de base pour toutes les routes de ce contrôleur
@RequestMapping("/api/roles")
// Lombok : génère automatiquement un constructeur pour toutes les propriétés finales
@RequiredArgsConstructor
// Autorise uniquement les utilisateurs avec le rôle 'ADMIN' à accéder à toutes les méthodes du contrôleur
@PreAuthorize("hasAuthority('ADMIN')")
public class RoleController {

    // Injection du service RoleService pour déléguer la logique métier
    private final RoleService roleService;

    // Endpoint POST pour créer un nouveau rôle
    @PostMapping
    public ResponseEntity<Response<Role>> createRole(@RequestBody Role roleRequest ){
        // Appel du service pour créer le rôle et renvoie la réponse HTTP 200 avec l'objet Response<Role>
        return ResponseEntity.ok(roleService.createRole(roleRequest));
    }

    // Endpoint PUT pour mettre à jour un rôle existant
    @PutMapping
    public ResponseEntity<Response<Role>> updateRole(@RequestBody Role roleRequest ){
        // Appel du service pour mettre à jour le rôle et renvoie la réponse HTTP 200 avec l'objet Response<Role>
        return ResponseEntity.ok(roleService.updateRole(roleRequest));
    }

    // Endpoint GET pour récupérer la liste de tous les rôles
    @GetMapping
    public ResponseEntity<Response<List<Role>>> getAllRoles(){
        // Appel du service pour obtenir tous les rôles et renvoie la réponse HTTP 200 avec l'objet Response<List<Role>>
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    // Endpoint DELETE pour supprimer un rôle par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<?>> deleteRole(@PathVariable Long id){
        // Appel du service pour supprimer le rôle et renvoie la réponse HTTP 200 avec l'objet Response
        return ResponseEntity.ok(roleService.deleteRole(id));
    }

}





