package com.cruzeiro.icust.controllers;

import com.cruzeiro.icust.configuration.CustomUserDetailsService;
import com.cruzeiro.icust.configuration.JwtGenerator;
import com.cruzeiro.icust.model.UserType;
import com.cruzeiro.icust.model.dto.auth.*;
import com.cruzeiro.icust.model.entities.user.AdminEntity;
import com.cruzeiro.icust.model.entities.user.ClienteEntity;
import com.cruzeiro.icust.model.entities.user.PrestadorEntity;
import com.cruzeiro.icust.repositories.AdminRepository;
import com.cruzeiro.icust.repositories.ClienteRepository;
import com.cruzeiro.icust.repositories.PrestadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AdminRepository adminRepository;
	private final PrestadorRepository prestadorRepository;
	private final ClienteRepository clienteRepository;

	private final AuthenticationManager authenticationManager;
	private final CustomUserDetailsService customUserDetailsService;
	private final PasswordEncoder passwordEncoder;
	private final JwtGenerator jwtGenerator;

	@PostMapping("/admin-register")
	public ResponseEntity<String> adminRegister(@RequestBody AdminAuthDto adminAuthDto) {
		if (adminRepository.existsByUsername(adminAuthDto.getUsername())) {
			return new ResponseEntity<>("Username is taken !! ", HttpStatus.CONFLICT);
		}
		AdminEntity adminEntity = new AdminEntity();
		adminEntity.setUsername(adminAuthDto.getUsername());
		adminEntity.setPassword(passwordEncoder.encode(adminAuthDto.getPassword()));

		adminRepository.save(adminEntity);
		return new ResponseEntity<>("User Register successfully !! ", HttpStatus.CREATED);
	}

	@PostMapping("/admin-login")
	public ResponseEntity<AdminLoginResponseDto> adminLogin(@RequestBody AdminAuthDto adminAuthDto) {
		System.out.println("adminLogin");
		customUserDetailsService.setUserType(UserType.ADMIN);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(adminAuthDto.getUsername(), adminAuthDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		AdminEntity admin = adminRepository.findByUsername(adminAuthDto.getUsername()).orElseThrow();
		String token = jwtGenerator.generateToken(authentication, UserType.ADMIN.toString(), admin);
		AdminLoginResponseDto responseDto = new AdminLoginResponseDto();
		responseDto.setSuccess(true);
		responseDto.setMessage("login successful !!");
		responseDto.setToken(token);
		responseDto.setAdmin(admin.getUsername(), admin.getIdAdmin());
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PostMapping("/prestador-register")
	public ResponseEntity<SuccessandMessageDto> prestadorRegister(
			@RequestBody PrestadorRegisterDto prestadorRegisterDto
	) {
		SuccessandMessageDto response = new SuccessandMessageDto();
		if (prestadorRepository.existsByEmail(prestadorRegisterDto.getEmail())) {
			response.setMessage("Email is already registered !!");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
		PrestadorEntity prestadorEntity = new PrestadorEntity();
		prestadorEntity.setNome(prestadorRegisterDto.getNome());
		prestadorEntity.setSobrenome(prestadorRegisterDto.getSobrenome());
		prestadorEntity.setPassword(passwordEncoder.encode(prestadorRegisterDto.getPassword()));
		prestadorEntity.setEmail(prestadorRegisterDto.getEmail());
		prestadorEntity.setStatus(true);
		prestadorRepository.save(prestadorEntity);
		response.setMessage("Profile Created Successfully !!");
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/prestador-login")
	public ResponseEntity<PrestadorLoginResponseDto> prestadorLogin(@RequestBody PrestadorLoginDto prestadorLoginDto) {
		System.out.println("prestadorLogin");
		customUserDetailsService.setUserType(UserType.PRESTADOR);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(prestadorLoginDto.getEmail(), prestadorLoginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		PrestadorEntity prestador = prestadorRepository.findByEmail(prestadorLoginDto.getEmail()).orElseThrow();
		String token = jwtGenerator.generateToken(authentication, UserType.PRESTADOR.toString(), prestador);
		PrestadorLoginResponseDto responseDto = new PrestadorLoginResponseDto();
		responseDto.setSuccess(true);
		responseDto.setMessage("login successful !!");
		responseDto.setToken(token);
		responseDto.setTeacher(prestador.getNome(), prestador.getEmail(), prestador.getIdPrestador());
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PostMapping("/cliente-register")
	public ResponseEntity<SuccessandMessageDto> clienteRegister(@RequestBody ClienteRegisterDto clienteRegisterDto) {
		System.out.println("clienteRegister");
		SuccessandMessageDto response = new SuccessandMessageDto();
		if (clienteRepository.existsByEmail(clienteRegisterDto.getEmail())) {
			response.setMessage("Email is already registered !!");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setNome(clienteRegisterDto.getNome());
		clienteEntity.setSobrenome(clienteRegisterDto.getSobrenome());
		clienteEntity.setPassword(passwordEncoder.encode(clienteRegisterDto.getPassword()));
		clienteEntity.setEmail(clienteRegisterDto.getEmail());
		clienteEntity.setStatus(true);
		clienteRepository.save(clienteEntity);
		response.setMessage("Profile Created Successfully !!");
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/cliente-login")
	public ResponseEntity<ClienteLoginResponseDto> clienteLogin(@RequestBody ClienteLoginDto clienteLoginDto) {
		System.out.println("clienteLogin");
		customUserDetailsService.setUserType(UserType.CLIENTE);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(clienteLoginDto.getEmail(), clienteLoginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		ClienteEntity cliente = clienteRepository.findByEmail(clienteLoginDto.getEmail()).orElseThrow();
		String token = jwtGenerator.generateToken(authentication, UserType.CLIENTE.toString(), cliente);
		ClienteLoginResponseDto responseDto = new ClienteLoginResponseDto();
		responseDto.setSuccess(true);
		responseDto.setMessage("login successful !!");
		responseDto.setToken(token);
		responseDto.setCliente(cliente.getNome(), cliente.getEmail(), cliente.getIdCliente());
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
}
