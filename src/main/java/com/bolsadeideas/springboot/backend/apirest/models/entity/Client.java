package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Client implements Serializable {

	private static final long serialVersionUID = -1137151609667901678L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotNull(message = "cannot be empty")
	@Size(min = 4, max = 20, message = "must contain between 4 and 20 characters")
	private String name;

	@NotNull(message = "cannot be empty")
	private String surname;

	@Column(nullable = false, unique = true)
	@NotNull(message = "cannot be empty")
	@Email(message = " is not a valid email")
	private String email;

	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@Column(name = "birthdate")
	@Temporal(TemporalType.DATE)
	private Date birthdate;

	@PrePersist
	public void beforeCreate() {
		createdAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthday) {
		this.birthdate = birthday;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", createdAt="
				+ createdAt + ", birthdate=" + birthdate + "]";
	}

}
