package com.pfe.ebankapp.role.services;

import java.util.List;

import com.pfe.ebankapp.res.Response;
import com.pfe.ebankapp.role.entity.Role;

/**
 * Interface définissant les opérations métiers liées aux rôles.
 * 
 * Chaque méthode retourne un objet standardisé {@link Response<T>} 
 * pour uniformiser les réponses vers le controller.
 */
public interface RoleService {

    /**
     * Crée un nouveau rôle.
     * 
     * @param roleRequest L'objet Role contenant les informations du rôle à créer.
     * @return Response<Role> contenant le rôle créé et un message de succès.
     * @throws BadRequestException si un rôle avec le même nom existe déjà.
     */
    Response<Role> createRole(Role roleRequest);

    /**
     * Met à jour un rôle existant.
     * 
     * @param roleRequest L'objet Role contenant les nouvelles informations du rôle.
     * @return Response<Role> contenant le rôle mis à jour et un message de succès.
     * @throws NotFoundException si le rôle à mettre à jour n'existe pas.
     */
    Response<Role> updateRole(Role roleRequest);

    /**
     * Récupère la liste de tous les rôles présents dans la base de données.
     * 
     * @return Response<List<Role>> contenant la liste complète des rôles et un message de succès.
     */
    Response<List<Role>> getAllRoles();

    /**
     * Supprime un rôle existant par son ID.
     * 
     * @param id L'identifiant du rôle à supprimer.
     * @return Response<?> confirmant la suppression du rôle.
     * @throws NotFoundException si le rôle à supprimer n'existe pas.
     */
    Response<?> deleteRole(Long id);

   /* The
    deleteRole(Long id) method, typically used in REST APIs or backend services,
    deletes a specific role identified by its unique ID, usually returning 
    a generic response (Response<?>) indicating success or failure. It */

    
}
