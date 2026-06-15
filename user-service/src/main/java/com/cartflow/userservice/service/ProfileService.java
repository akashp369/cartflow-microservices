package com.cartflow.userservice.service;

import com.cartflow.userservice.dto.ProfileResponse;
import com.cartflow.userservice.dto.UpdateProfileRequest;
import com.cartflow.userservice.entity.Profile;
import com.cartflow.userservice.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileResponse getProfile(Long userId) {
        Profile profile = getOrCreate(userId);
        return ProfileResponse.from(profile);
    }

    @Transactional
    public ProfileResponse updateProfile(Long userId, UpdateProfileRequest request) {
        Profile profile = getOrCreate(userId);

        if (request.getPhone() != null && !request.getPhone().isBlank()) {
            profile.setPhone(request.getPhone());
        }

        return ProfileResponse.from(profileRepository.save(profile));
    }

    private Profile getOrCreate(Long userId) {
        return profileRepository.findByUserId(userId)
                .orElseGet(() -> profileRepository.save(
                        Profile.builder().userId(userId).build()
                ));
    }
}
