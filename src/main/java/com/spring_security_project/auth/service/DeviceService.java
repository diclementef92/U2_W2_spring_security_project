package com.spring_security_project.auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_security_project.auth.entity.Device;
import com.spring_security_project.auth.entity.EDeviceState;
import com.spring_security_project.auth.entity.EDeviceType;
import com.spring_security_project.auth.entity.User;
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


	public Device insertDevice(Device d) {
		return repo.save(d);
	}

	public void updateDevice(Device d) {
		repo.save(d);
	}

	public void removeDevice(Device d) {
		repo.deleteById(d.getId());
	}

	public Optional<List<Device>> getDevicesByType(EDeviceType type) {
		return repo.findByType(type);
	}

	public Optional<List<Device>> getDevicesByState(EDeviceState state) {
		return repo.findByState(state);
	}

	public Optional<List<Device>> getAvailableDevices() {
		return repo.findByState(EDeviceState.Available);
	}

	public boolean isAvailable(Long id) {
		if (repo.existsById(id)) {
			Device d = repo.findById(id).get();
			if (d.getState().equals(EDeviceState.Available))
				return true;
		}
		// se non esiste o non è Available
		return false;
	}

	public void assignUser(Device d, User u) {
		d.setUser(u);
	}

}
