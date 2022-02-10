package io.jzheaux.springsecurity.resolutions;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ResolutionInitializer implements SmartInitializingSingleton {
	private final ResolutionRepository resolutions;
	private final UserRepository users;


	public ResolutionInitializer(ResolutionRepository resolutions, UserRepository users) {
		this.resolutions = resolutions;
		this.users = users;
	}



	@Override
	public void afterSingletonsInstantiated() {
		this.resolutions.save(new Resolution("Read War and Peace", "user"));
		this.resolutions.save(new Resolution("Free Solo the Eiffel Tower", "user"));
		this.resolutions.save(new Resolution("Hang Christmas Lights", "user"));

		User user = new User("user", "test123");
		user.grantAuthority("resolution:read");
		user.grantAuthority("resolution:write");

		User hasread = new User("hasread", "test123");
		hasread.grantAuthority("resolution:read");

		User haswrite = new User("haswrite", "test123");
		haswrite.grantAuthority("resolution:write");

		this.users.save(user);
		this.users.save(hasread);
		this.users.save(haswrite);

	}
}
