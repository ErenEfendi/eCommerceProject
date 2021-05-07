package eCommerceProject.core;

import eCommerceProject.entities.concretes.User;

public interface InputVerificationService {
	boolean isValid(User user);
}
