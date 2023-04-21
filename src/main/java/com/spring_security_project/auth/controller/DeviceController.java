package com.spring_security_project.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security_project.auth.service.DeviceService;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

//
//    // Build Login REST API
//    @PostMapping(value = {"/login", "/signin"})
//    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
//           	
//    	String token = authService.login(loginDto);
//
//        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
//        jwtAuthResponse.setUsername(loginDto.getUsername());
//        jwtAuthResponse.setAccessToken(token);
//
//        return ResponseEntity.ok(jwtAuthResponse);
//    }
//
//    // Build Register REST API
//    @PostMapping(value = {"/register", "/signup"})
//    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
//        String response = authService.register(registerDto);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
}
