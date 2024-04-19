package com.ads.adsmanagment.dto.response;

public record UserAuthResponse(
        String jwtToken,
        String firstName,
        String lastName
) {
}
