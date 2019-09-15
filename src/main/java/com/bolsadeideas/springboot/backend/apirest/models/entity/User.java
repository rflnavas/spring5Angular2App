package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "User")
@Table(name="dusers")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private boolean enabled;
	
	@NotNull
	@Column(length=100)
	private String password;
	
	@NotNull
	@Column(unique=true, length=24)
	@Size(min=4,max=24)
	private String username;
	
	private String name;
	
	@Email
	private String email;
	
	/**
	 * In order to be able to save new users with existing rules we must use this kind of cascade. 
	 * Otherwise, we will bump into PersistentObjectException.
	 * Spring Data's getXXXX methods returns detached objects by default.
	 */
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name="dusers_roles", 
		joinColumns=@JoinColumn(name="user_id", nullable=false),
		inverseJoinColumns=@JoinColumn(name="role_id", nullable=false)
		//uniqueConstraints= {@UniqueConstraint(columnNames= {"user_id", "role_id"})}
	)
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User( @NotNull @Size(min = 4, max = 24) String username,
		@NotNull String password,String name,
		@Email String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.enabled = true;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}
	
	public void addRole(Role role) {
		roles.add(role);
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", enabled=" + enabled + ", password=" + password + ", username=" + username + "]";
	}
	
}
