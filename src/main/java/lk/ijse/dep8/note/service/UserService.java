package lk.ijse.dep8.note.service;

import lk.ijse.dep8.note.dto.UserDTO;
import lk.ijse.dep8.note.service.exception.DuplicateEmailException;
import lk.ijse.dep8.note.service.exception.NotFoundException;

public interface UserService {

    UserDTO registerUser(UserDTO user) throws DuplicateEmailException;

    void updateUser(UserDTO user) throws NotFoundException;

    UserDTO getUserInfo(String userId) throws NotFoundException;

    void deleteUser(String userId) throws NotFoundException;
}
