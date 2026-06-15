package com.cartflow.userservice.dto;

import com.cartflow.userservice.entity.Profile;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ProfileResponse {

    private Long id;
    private Long userId;
    private String phone;
    private LocalDateTime createdAt;

    public static ProfileResponse from(Profile profile) {
        return ProfileResponse.builder()
                .id(profile.getId())
                .userId(profile.getUserId())
                .phone(profile.getPhone())
                .createdAt(profile.getCreatedAt())
                .build();
    }
}
