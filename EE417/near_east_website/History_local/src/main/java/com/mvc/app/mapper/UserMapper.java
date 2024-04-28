package com.mvc.app.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mvc.app.entity.RoleEntity;
import com.mvc.app.entity.UserEntity;
import com.mvc.app.model.UserModel;
import com.mvc.app.repository.RoleRepository;
import com.mvc.app.repository.UserRepository;
import com.mvc.app.repository.WebpageRepository;

//this class can be generated by org.mapstruct.ap.MappingProcessor
 
@Component
public class UserMapper {
	private final RoleRepository roleRepository;

	@Autowired
    public UserMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
	
	   public UserModel entityToDto(UserEntity entity) {
	        if ( entity == null ) {
	            return null;
	        }

	        UserModel user = new UserModel();

	        if ( entity.getId() != null ) {
	            user.setId( entity.getId() );
	        }
	        user.setUsername( entity.getUsername() );
	        user.setFname( entity.getFname() );
	        user.setLname( entity.getLname() );
	        user.setEmail( entity.getEmail() );
	        user.setPassword( entity.getPassword() );
	        user.setPhone( entity.getPhone() );
	        user.setRoleId( entity.getRole().getId() );


	        return user;
	    }
	   
	   
	   public UserEntity toEntity(UserModel model) {
		    if (model == null) {
		        return null;
		    }

		    UserEntity user = new UserEntity();

		    user.setId(model.getId());
		    user.setEmail(model.getEmail());
		    user.setUsername(model.getUsername());
		    user.setPassword(model.getPassword());
		    user.setFname(model.getFname());
		    user.setLname(model.getLname());
		    user.setPhone(model.getPhone());
		    
		    // Retrieve RoleEntity using userRepository
		    RoleEntity role = roleRepository.findById(model.getRoleId()).orElse(null);
		    user.setRole(role);

		    return user;
		}

	   
	   

}
