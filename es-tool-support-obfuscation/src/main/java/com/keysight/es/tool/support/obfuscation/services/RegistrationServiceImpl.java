package com.keysight.es.tool.support.obfuscation.services;

import com.keysight.es.tool.support.obfuscation.dto.DotfuscatorRegObject;
import com.keysight.es.tool.support.obfuscation.entities.Registration;
import com.keysight.es.tool.support.obfuscation.repositories.RegistrationRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;


    @Override
    public boolean registration(DotfuscatorRegObject regObject) {

        Registration registration = new Registration();
        registration.setEmail(regObject.getEmail());
        registration.setOrganization(regObject.getOrganization());
        registration.setUserAccount(regObject.getUserAccount());

        registrationRepository.save(registration);
        return true;
    }
}
