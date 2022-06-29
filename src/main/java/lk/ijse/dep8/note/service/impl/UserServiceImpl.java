package lk.ijse.dep8.note.service.impl;

import lk.ijse.dep8.note.dto.UserDTO;
import lk.ijse.dep8.note.entity.User;
import lk.ijse.dep8.note.repository.UserRepository;
import lk.ijse.dep8.note.service.UserService;
import lk.ijse.dep8.note.service.exception.DuplicateEmailException;
import lk.ijse.dep8.note.service.exception.NotFoundException;
import lk.ijse.dep8.note.service.util.EntityDTOTransformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EntityDTOTransformer transformer;

    public UserServiceImpl(UserRepository userRepository, EntityDTOTransformer transformer) {
        this.userRepository = userRepository;
        this.transformer = transformer;
    }

    @Override
    public UserDTO registerUser(UserDTO user) throws DuplicateEmailException {
        if (userRepository.existsUserByEmail(user.getEmail()))
            throw new DuplicateEmailException("Email Already Exists");
        user.setId(UUID.randomUUID().toString());
        return transformer.getUserDTO(userRepository.save(transformer.getUserEntity(user)));
    }

    @Override
    public void updateUser(UserDTO user) throws NotFoundException {
        Optional<User> optUser = userRepository.findById(user.getId());
        if (!optUser.isPresent()) throw new NotFoundException("invalid User Id");
        optUser.get().setFullName(user.getFullName());
        optUser.get().setPassword(user.getPassword());
    }

    @Override
    public UserDTO getUserInfo(String userId) throws NotFoundException {
        return userRepository.findById(userId).map(transformer::getUserDTO)
                .orElseThrow(() -> new NotFoundException("invalid User Id"));
    }

    @Override
    public void deleteUser(String userId) throws NotFoundException {
        if (!userRepository.existsById(userId)) throw new NotFoundException("Invalid User Id");
        userRepository.deleteById(userId);
    }
}