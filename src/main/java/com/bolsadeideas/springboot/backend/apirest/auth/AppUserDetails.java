package com.bolsadeideas.springboot.backend.apirest.auth;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Role;
import com.bolsadeideas.springboot.backend.apirest.models.entity.User;

public class AppUserDetails implements UserDetails{

	private static final long serialVersionUID = 7231049864809407905L;
	private Collection<? extends GrantedAuthority> authorities;
	private String username;
	private String password;
	
	public AppUserDetails(final User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.authorities = translate(user.getRoles());
	}
	
	private Collection<? extends GrantedAuthority> translate(Set<Role> roles) {
		Set<GrantedAuthority> authorities= new HashSet<>();
		roles.stream().forEach(r -> {
			String roleName = r.getRolename();
			if (!roleName.startsWith("ROLE_")) { 
				roleName = "ROLE_" + roleName; 
			}
			authorities.add(new SimpleGrantedAuthority(roleName));
		});
		return authorities;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
