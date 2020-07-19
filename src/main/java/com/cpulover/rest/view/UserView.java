package com.cpulover.rest.view;

public class UserView {
	public interface Id {
	}

	public interface Name {
	}

	public interface Birthdate {
	}

	public interface Password {
	}

	public interface NameBirthdate extends Name, Birthdate {

	}
	
	public interface NameBirthdatePassword extends Name, Birthdate, Password {

	}

}