package com.learning.supermarket.freshmarket.entity;

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
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
/*@Getter
@Setter*/
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "user_id")
	    private long id;
	    
	    @Column(name = "user_name")
	    @Length(min = 5, message = "*Your user name must have at least 5 characters")
	    @NotEmpty(message = "*Please provide a user name")
	    private String userName;
	    
	    @Column(name = "email")
	    @Email(message = "*Please provide a valid Email")
	    @NotEmpty(message = "*Please provide an email")
	    private String email;
	    
	    @Column(name = "password")
	    @Length(min = 5, message = "*Your password must have at least 5 characters")
	    @NotEmpty(message = "*Please provide your password")
	    private String password;
	    
	    @Column(name = "name")
	    @NotEmpty(message = "*Please provide your name")
	    private String name;
	    
	    @Column(name = "last_name")
	    @NotEmpty(message = "*Please provide your last name")
	    private String lastName;
	    
	    @Column(name = "active")
	    private Boolean active;

	
	 @ManyToMany(cascade = CascadeType.MERGE)//
	    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	 //@JoinTable(name ="third table name" joinColumns = @JoinColumn(name = "first table column name", inverseJoinColumns = @JoinColumn(name = "second table column name"))
	    private Set<Role> roles;

}
