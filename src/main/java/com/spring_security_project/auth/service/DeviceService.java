package com.spring_security_project.auth.service;

import org.springframework.stereotype.Service;

import com.spring_security_project.auth.entity.Device;
import com.spring_security_project.auth.repository.DeviceRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DeviceService {
	private DeviceRepository repo;

	public void addDevice(Device d) {
		repo.save(d);
	}

	public void updateDevice(Device d) {
		repo.save(d);
	}

	public void removeDevice(Device d) {
		repo.deleteById(d.getId());
	}
}
