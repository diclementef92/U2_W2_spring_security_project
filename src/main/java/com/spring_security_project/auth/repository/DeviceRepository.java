package com.spring_security_project.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_security_project.auth.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

	Optional<Device> findByType(String type);

	Optional<Device> findByState(String state);

	Optional<Device> findByModelDescription(String description);

}