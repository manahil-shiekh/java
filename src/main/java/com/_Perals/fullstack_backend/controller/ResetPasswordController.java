package com._Perals.fullstack_backend.controller;

import com._Perals.fullstack_backend.model.ResetPasswordRequest;
import com._Perals.fullstack_backend.service.UserService;
import com._Perals.fullstack_backend.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reset-password")
@CrossOrigin("http://localhost:3000")
public class ResetPasswordController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        try {
            boolean isPasswordChanged = userService.changePassword(resetPasswordRequest);

            if (isPasswordChanged) {
                return ResponseEntity.ok("Password changed successfully");
            } else {
                return ResponseEntity.status(404).body("User not found with the provided email");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Server error: " + e.getMessage());
        }
    }
}
