package com.ads.adsmanagment.service;
import com.ads.adsmanagment.dto.request.SurgeryRequest;
import com.ads.adsmanagment.dto.response.SurgeryResponse;
import com.ads.adsmanagment.model.Surgery;

public interface SurgeryService {
    public SurgeryResponse addSurgery(SurgeryRequest surgery);
}
