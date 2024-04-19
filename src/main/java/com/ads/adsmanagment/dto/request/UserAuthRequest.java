package com.ads.adsmanagment.dto.request;


public record UserAuthRequest(
        String username,
        String password
) {
}
