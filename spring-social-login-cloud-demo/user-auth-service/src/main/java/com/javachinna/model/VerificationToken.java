package com.javachinna.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("tokens")
public class VerificationToken extends AbstractToken {

	private static final long serialVersionUID = -6551160985498051566L;

	public VerificationToken(final String token, final User user) {
		super(token, user);
	}
}
