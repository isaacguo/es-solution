package com.keysight.es.restcontrollers;

import com.keysight.es.dto.ObfuscationRequestObject;
import com.keysight.es.entities.RequestApprovalEntity;
import com.keysight.es.services.ObfuscationRequestService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
@Data
public class RequestRestController {

    private final ObfuscationRequestService obfuscationRequestService;


    @PostMapping
    public RequestApprovalEntity requestApproval(@RequestBody ObfuscationRequestObject request) {
        return this.obfuscationRequestService.requestApproval(request);
    }
}
