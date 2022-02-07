package com.example.demo.access.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <code>Profile</code> is the class that will give transaction to the user.
 * 
 * @see Available
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
@Table(name = "profile", uniqueConstraints = @UniqueConstraint(name = "uk_profile_description_descriptionEN", columnNames = {
		"description", "descriptionEN" }))
public class Profile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "descriptionen", nullable = false)
	private String descriptionEN;

	@ManyToMany()
	@JoinTable(name = "profile_transactions", joinColumns = @JoinColumn(name = "profile_id"), inverseJoinColumns = @JoinColumn(name = "transaction_id"))
	private List<Transaction> transactions;

	private boolean active;

}