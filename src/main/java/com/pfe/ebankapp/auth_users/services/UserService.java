package com.pfe.ebankapp.auth_users.services;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.pfe.ebankapp.auth_users.dtos.UpdatePasswordRequest;
import com.pfe.ebankapp.auth_users.dtos.UserDTO;
import com.pfe.ebankapp.auth_users.entity.User;
import com.pfe.ebankapp.res.Response;


public interface UserService {

    User getCurrentLoggedInUser();

    Response<UserDTO> getMyProfile();

    Response<Page<UserDTO>> getAllUsers(int page, int size);

    Response<?> updatePassword(UpdatePasswordRequest updatePasswordRequest);

    Response<?> uploadProfilePicture(MultipartFile file);

    Response<?> uploadProfilePictureToS3(MultipartFile file);

}
