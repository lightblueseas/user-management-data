/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.user.management.factories;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

import de.alpharogroup.address.book.entities.Addresses;
import de.alpharogroup.auth.models.BaseUsernameSignUpModel;
import de.alpharogroup.auth.models.UsernameSignUpModel;
import de.alpharogroup.user.management.enums.GenderType;
import de.alpharogroup.user.management.sign.up.UserModel;

public class UserManagementModelFactory implements Serializable {
	/** The Constant instance. */
	private static final UserManagementModelFactory instance = new UserManagementModelFactory();
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the single instance of UserManagementModelFactory.
	 * 
	 * @return single instance of UserManagementModelFactory
	 */
	public static UserManagementModelFactory getInstance() {
		return instance;
	}	
	private UserManagementModelFactory() {
	}

	public UserModel newUserModel(
			String birthname,
			Date dateOfBirth,
			String firstname,
			GenderType gender,
			String ipAddress,
			String lastname,
			Locale locale,
			String mobile,
			String telefon,
			String fax,
			Addresses address) {
		UserModel userModel = new UserModel();
		userModel.setBirthname(birthname);
		userModel.setDateofbirth(dateOfBirth);
		userModel.setFirstname(firstname);
		userModel.setGender(gender);
		userModel.setIpAddress(ipAddress);
		userModel.setLastname(lastname);
		userModel.setLocale(locale);
		userModel.setMobile(mobile);
		userModel.setTelefon(telefon);
		userModel.setFax(fax);
		userModel.setAddress(address);
		return userModel;
	}
	
	public UsernameSignUpModel newUsernameSignupModel(
			String email, 
			String pw, 
			String repeatPw, 
			Boolean termOfUseAccepted,
			String username) {
		UsernameSignUpModel model = new BaseUsernameSignUpModel();
		model.setEmail(email);
		model.setPassword(pw);
		model.setRepeatPassword(repeatPw);
		model.setTermOfUseAccepted(termOfUseAccepted);
		model.setUsername(username);
		return model;
	}
}
