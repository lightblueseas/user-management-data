package de.alpharogroup.user.management.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the Gender enumeration.
 */
public enum Gender {

	/** The male. */
	MALE,
	/** The female. */
	FEMALE, 
	/** represents a company. */
	INCORPORATION,
	/** The undefined. */
	UNDEFINED;

	/**
	 * Gets the all genders without the gender constant UNDEFINED.
	 * 
	 * @return the valid genders
	 */
	public static List<Gender> getValidGenders() {
		Gender[] genderValues = Gender.values();
		List<Gender> genders = new ArrayList<Gender>();
		for (int i = 0; i < genderValues.length; i++) {
			if (!genderValues[i].equals(Gender.UNDEFINED)) {
				genders.add(genderValues[i]);
			}
		}
		return genders;
	}

}
