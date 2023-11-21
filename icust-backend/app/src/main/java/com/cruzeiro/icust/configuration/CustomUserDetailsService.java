package com.cruzeiro.icust.configuration;

import com.cruzeiro.icust.model.entities.user.AdminEntity;
import com.cruzeiro.icust.model.entities.user.ClienteEntity;
import com.cruzeiro.icust.model.entities.user.PrestadorEntity;
import com.cruzeiro.icust.model.UserType;
import com.cruzeiro.icust.repositories.AdminRepository;
import com.cruzeiro.icust.repositories.ClienteRepository;
import com.cruzeiro.icust.repositories.PrestadorRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final AdminRepository adminRepository;
	private final ClienteRepository clienteRepository;
	private final PrestadorRepository prestadorRepository;

	private UserType userType;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(userType);
		if (userType == UserType.ADMIN) {

			AdminEntity adminEntity = adminRepository.findByUsername(username).orElseThrow(
					() -> new UsernameNotFoundException("Admin Username " + username + "not found"));

			SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(UserType.ADMIN.toString());
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(adminAuthority);
			return new User(adminEntity.getUsername(), adminEntity.getPassword(), authorities);
		} else if (userType == UserType.PRESTADOR) {
			PrestadorEntity prestadorEntity = prestadorRepository.findByEmail(username).orElseThrow(
					() -> new UsernameNotFoundException("Teacher Email " + username + "not found"));

			SimpleGrantedAuthority teacherAuthority = new SimpleGrantedAuthority(UserType.PRESTADOR.toString());
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(teacherAuthority);
			return new User(prestadorEntity.getEmail(), prestadorEntity.getPassword(), authorities);
		} else if (userType == UserType.CLIENTE) {
			ClienteEntity studentEntity = clienteRepository.findByEmail(username).orElseThrow(
					() -> new UsernameNotFoundException("Student Email " + username + "not found"));

			SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(UserType.CLIENTE.toString());
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(adminAuthority);
			return new User(studentEntity.getEmail(), studentEntity.getPassword(), authorities);
		}
		return null;
	}

}
