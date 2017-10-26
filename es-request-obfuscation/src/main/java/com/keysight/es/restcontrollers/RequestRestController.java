package com.keysight.es.restcontrollers;

import com.keysight.es.entities.RequestApprovalEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public class RequestRestController {

    @PostMapping
    public RequestApprovalEntity requestApproval(@RequestBody RequestApprovalEntity request) {
        RequestApprovalEntity rae = new RequestApprovalEntity();
        rae.setApproved(true);
        return rae;
    }
}
