package com._Perals.fullstack_backend.service;

import com._Perals.fullstack_backend.model.ResetPasswordRequest;
import com._Perals.fullstack_backend.model.User;
import com._Perals.fullstack_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean changePassword(ResetPasswordRequest request) {
        User user = userRepository.findByEmail(request.getEmail().trim());
        if (user != null) {
            user.setPassword(request.getNewPassword().trim());
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
