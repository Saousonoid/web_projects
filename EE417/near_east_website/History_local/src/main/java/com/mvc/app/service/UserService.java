package com.mvc.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mvc.app.entity.ArticleEntity;
import com.mvc.app.entity.RoleEntity;
import com.mvc.app.entity.UserEntity;
import com.mvc.app.mapper.UserMapper;
import com.mvc.app.model.ArticleModel;
import com.mvc.app.model.UserModel;
import com.mvc.app.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final UserMapper mapper;

	public UserService(UserRepository userRepository, UserMapper mapper) {
		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity existingUser = userRepository.findUserByEmailOrUsername(username,username)
				.orElseThrow(() -> new UsernameNotFoundException("UserEntity not found"));
		  return new org.springframework.security.core.userdetails.User(
	                existingUser.getEmail(), existingUser.getPassword(), getAuthorities(existingUser.getRole()));
	}

	public UserEntity findByLogin(String username) {
		UserEntity existingUser = userRepository.findUserByEmailOrUsername(username, username)
				.orElseThrow(() -> new UsernameNotFoundException("UserEntity not found"));
//		return mapper.entityToDto(existingUser);
		return existingUser;
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(RoleEntity role) {
	    List<GrantedAuthority> authority = new ArrayList<>();
	    authority.add(new SimpleGrantedAuthority("ROLE_" + role.getName().name()));
	    
	    
	    return authority;
	}
	
	public List<UserModel> listUsers() {
		List<UserEntity> users = userRepository.findAll();
		return users.stream()
				.map(l -> mapper.entityToDto(l))
				.collect(Collectors.toList());
	}
	
	
	
	public UserModel addUser(UserModel user) {
		UserEntity created = userRepository.save(mapper.toEntity(user));
		return mapper.entityToDto(created);

	}
	


}
