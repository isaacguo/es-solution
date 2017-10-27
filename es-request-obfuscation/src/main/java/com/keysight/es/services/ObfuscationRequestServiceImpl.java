package com.keysight.es.services;

import com.keysight.es.dto.ObfuscationRequestObject;
import com.keysight.es.entities.RequestApprovalEntity;
import com.keysight.es.repositories.RequestApprovalRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ObfuscationRequestServiceImpl implements ObfuscationRequestService {

    private final RequestApprovalRepository requestApprovalRepository;


    @Override
    public RequestApprovalEntity requestApproval(ObfuscationRequestObject request) {
        RequestApprovalEntity rae = request.convertToRequestApprovalEntity();
        if (validateRequest(request)) {
            rae.setApproved(true);
            return this.requestApprovalRepository.save(rae);
        } else {
            rae.setApproved(false);
        }
        return rae;
    }

    private boolean validateRequest(ObfuscationRequestObject request) {
        if (!request.isChkObfuscateAll()) return false;
        else
            return true;
    }
}
