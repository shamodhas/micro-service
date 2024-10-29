package lk.ijse.userservice.service.impl;

import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.exception.DuplicateException;
import lk.ijse.userservice.repo.UserRepo;
import lk.ijse.userservice.service.UserService;
import lk.ijse.userservice.util.DataTypeConvertor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 11/24/2023
 * Time : 10:17 AM
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final DataTypeConvertor convertor;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        if (userRepo.findById(userDTO.getId()).isPresent())
            throw new DuplicateException("Duplicate User Id");
        return convertor.getUserDTO(userRepo.save(convertor.getUser(userDTO)));
    }
}
