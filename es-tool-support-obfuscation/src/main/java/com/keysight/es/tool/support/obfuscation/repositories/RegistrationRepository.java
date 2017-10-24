package com.keysight.es.tool.support.obfuscation.repositories;


import com.keysight.es.tool.support.obfuscation.entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
