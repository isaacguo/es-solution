package com.keysight.es.services;

import com.keysight.es.dto.ObfuscationRequestObject;
import com.keysight.es.entities.RequestApprovalEntity;

public interface ObfuscationRequestService {

    RequestApprovalEntity requestApproval(ObfuscationRequestObject request);


}
