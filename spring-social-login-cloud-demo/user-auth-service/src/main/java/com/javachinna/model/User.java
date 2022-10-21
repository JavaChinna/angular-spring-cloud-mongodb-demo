package com.javachinna.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the user database table.
 * 
 */
@NoArgsConstructor
@Getter
@Setter
@Document("users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 65981149772133526L;

	private String id;

	private String providerUserId;

	private String email;

	private boolean enabled;

	private String displayName;

	protected Date createdDate;

	protected Date modifiedDate;

	private String password;

	private String provider;

	private boolean using2FA;

	private String secret;

	@JsonIgnore
	private Set<Role> roles;
}