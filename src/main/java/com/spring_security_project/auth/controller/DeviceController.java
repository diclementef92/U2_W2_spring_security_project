package com.spring_security_project.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security_project.auth.entity.Device;
import com.spring_security_project.auth.service.DeviceService;
import com.spring_security_project.auth.service.UserService;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

	Logger logger = LoggerFactory.getLogger(DeviceController.class);

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(deviceService.getAllDevices(), HttpStatus.OK);
	}

	@GetMapping("/{id_device}")
	public ResponseEntity<?> getDeviceById(@PathVariable Long id_device) {
		return new ResponseEntity<>(deviceService.findById(id_device), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> insertDevice(@RequestBody Device d) {
		return new ResponseEntity<>(deviceService.insertDevice(d), HttpStatus.CREATED);
	}

	@GetMapping("/availables")
	public ResponseEntity<?> getAvailablesDevices() {
		return new ResponseEntity<>(deviceService.getAvailableDevices(), HttpStatus.OK);
	}


//	@GetMapping("/availables/{id}")
//	public ResponseEntity<?> isAvailable(@RequestParam Long id) {
//		if (deviceService.isAvailable(id))
//			return new ResponseEntity<>(HttpStatus.OK);
//		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//	}

	@PostMapping(path = "/assign/{id_device}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@PostMapping("/assign/{id_device}")
	@ResponseBody
	public ResponseEntity<?> assignDevice(@PathVariable Long id_device, @RequestBody String username) {

		if (deviceService.isAvailable(id_device) && deviceService.findById(id_device).isPresent()
				&& userService.existsByUserName(username)) {
			deviceService.assignUser(deviceService.findById(id_device).get(),
					userService.findByUserName(username).get());
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		logger.info(deviceService.isAvailable(id_device) + "");
		logger.info(deviceService.findById(id_device).isPresent() + "");
		logger.info(userService.existsByUserName(username) + "");
		logger.info(username);
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}

}
