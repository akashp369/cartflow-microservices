package com.cartflow.userservice.controller;

import com.cartflow.userservice.dto.ApiResponse;
import com.cartflow.userservice.dto.ProfileResponse;
import com.cartflow.userservice.dto.UpdateProfileRequest;
import com.cartflow.userservice.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    public ResponseEntity<ApiResponse<ProfileResponse>> getProfile(
            @RequestHeader("X-User-Id") Long userId) {
        return ResponseEntity.ok(ApiResponse.ok("Profile fetched", profileService.getProfile(userId)));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<ProfileResponse>> updateProfile(
            @RequestHeader("X-User-Id") Long userId,
            @Valid @RequestBody UpdateProfileRequest request) {
        return ResponseEntity.ok(ApiResponse.ok("Profile updated", profileService.updateProfile(userId, request)));
    }
}
