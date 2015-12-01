package de.alpharogroup.user.management.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the type of the gender.
 */
public enum GenderType {

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
	 * @return the valid gender types
	 */
	public static List<GenderType> getValidGenders() {
		GenderType[] genderValues = GenderType.values();
		List<GenderType> genders = new ArrayList<GenderType>();
		for (int i = 0; i < genderValues.length; i++) {
			if (!genderValues[i].equals(GenderType.UNDEFINED)) {
				genders.add(genderValues[i]);
			}
		}
		return genders;
	}

}
