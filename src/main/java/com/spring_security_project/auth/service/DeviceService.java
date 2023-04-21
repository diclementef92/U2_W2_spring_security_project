package com.spring_security_project.auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_security_project.auth.entity.Device;
import com.spring_security_project.auth.entity.EDeviceState;
import com.spring_security_project.auth.entity.EDeviceType;
import com.spring_security_project.auth.repository.DeviceRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DeviceService {
	@Autowired
	private DeviceRepository repo;

	public Optional<Device> findById(Long id) {
		return repo.findById(id);

	}
	public List<Device> getAllDevices() {
		return repo.findAll();
	}

	public Optional<Device> getAvailableDevices() {
		return repo.findByState(EDeviceState.Available.toString());
	}

	public Device insertDevice(Device d) {
		return repo.save(d);
	}

	public void updateDevice(Device d) {
		repo.save(d);
	}

	public void removeDevice(Device d) {
		repo.deleteById(d.getId());
	}

	public Optional<Device> getDevicesByType(EDeviceType type) {
		return repo.findByState(type.toString());
	}

	public boolean isAvailable(Long id) {
		return repo.isAvailable(id);

	}
}
