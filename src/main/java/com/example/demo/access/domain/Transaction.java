package com.example.demo.access.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * <code>Transaction</code> is the class that will allow the profile
 * have many task.
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
@Table(name = "transaction", uniqueConstraints = @UniqueConstraint(name = "uk_transaction_description_descriptionEN", columnNames = {
		"description", "descriptionEN" }))
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY/*, generator = "transaction_id"*/)
	/*@SequenceGenerator(name = "transaction_id", initialValue = 1, allocationSize = 1, sequenceName = "transaction_id_seq")*/
	private Long id;

	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "descriptionen", nullable = false)
	private String descriptionEN;
}
