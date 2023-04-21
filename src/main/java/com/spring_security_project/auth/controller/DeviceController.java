package com.spring_security_project.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security_project.auth.entity.Device;
import com.spring_security_project.auth.service.DeviceService;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(deviceService.getAllDevices(), HttpStatus.OK);
	}

	@GetMapping("/availables")
	public ResponseEntity<?> getAvailablesDevices() {
		return new ResponseEntity<>(deviceService.getAvailableDevices(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> insertDevice(@RequestBody Device d) {
		return new ResponseEntity<>(deviceService.insertDevice(d), HttpStatus.CREATED);
	}

	@PostMapping("/{}")
	public ResponseEntity<?> assignDevice(@RequestBody User u) {
		return new ResponseEntity<>(deviceService.insertDevice(d), HttpStatus.CREATED);
	}

}
