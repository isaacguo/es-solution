package com.keysight.es.tool.support.obfuscation.restcontrollers;

import com.keysight.es.tool.support.obfuscation.dto.DotfuscatorRegObject;
import com.keysight.es.tool.support.obfuscation.services.RegistrationService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
@Data
public class RegistrationRestController {

    private final RegistrationService registrationService;

    @PostMapping
    public boolean registration(DotfuscatorRegObject regObject)
    {
        return registrationService.registration(regObject);
    }

}
