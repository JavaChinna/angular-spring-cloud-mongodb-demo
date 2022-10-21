package com.javachinna.config;

import com.javachinna.dto.SocialProvider;
import com.javachinna.model.Role;
import com.javachinna.model.User;
import com.javachinna.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private boolean alreadySetup;

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		if (alreadySetup) {
			return;
		}
		// Create initial roles
		Role userRole = new Role(Role.ROLE_USER);
		Role adminRole = new Role(Role.ROLE_ADMIN);
		Role modRole = new Role(Role.ROLE_MODERATOR);
		createUserIfNotFound("admin@javachinna.com", Set.of(userRole, adminRole, modRole));
		alreadySetup = true;
	}

	private User createUserIfNotFound(final String email, Set<Role> roles) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			user = new User();
			user.setDisplayName("Admin");
			user.setEmail(email);
			user.setPassword(passwordEncoder.encode("admin@"));
			user.setRoles(roles);
			user.setProvider(SocialProvider.LOCAL.getProviderType());
			user.setEnabled(true);
			Date now = Calendar.getInstance().getTime();
			user.setCreatedDate(now);
			user.setModifiedDate(now);
			user = userRepository.save(user);
		}
		return user;
	}
}