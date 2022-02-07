package com.example.demo.access.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.example.demo.access.core.Language;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Claive Monteza
 * 
 * @version 1.0
 * @since 1.8
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(name = "uk_user_email", columnNames = {
		"email"}))
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "username")
	private String username;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	@Getter(onMethod_= {@JsonIgnore})
	private String password;

	@ManyToOne()
	@JoinColumn(name = "profile_id", foreignKey = @ForeignKey(name = "profile_id_fk"))
	@JsonIgnoreProperties({"transactions"})
	private Profile profile;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Language language;
	
	/*@Getter(onMethod_= {@JsonIgnore})*/
	private boolean active;

}
