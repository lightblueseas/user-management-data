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
	 * Gets the all genders without the gender type {@link GenderType#UNDEFINED}.
	 *
	 * @return the valid gender types
	 */
	public static List<GenderType> getValidGenders() {
		final GenderType[] genderValues = GenderType.values();
		final List<GenderType> genders = new ArrayList<GenderType>();
		for (int i = 0; i < genderValues.length; i++) {
			if (!genderValues[i].equals(GenderType.UNDEFINED)) {
				genders.add(genderValues[i]);
			}
		}
		return genders;
	}

	/**
	 * Gets the all genders without the gender type {@link GenderType#UNDEFINED} and {@link GenderType#INCORPORATION}.
	 *
	 * @return the valid gender types
	 */
	public static List<GenderType> getHumanGenders() {
		final GenderType[] genderValues = GenderType.values();
		final List<GenderType> genders = new ArrayList<GenderType>();
		for (int i = 0; i < genderValues.length; i++) {
			if (!genderValues[i].equals(GenderType.UNDEFINED)&& !genderValues[i].equals(GenderType.INCORPORATION)) {
				genders.add(genderValues[i]);
			}
		}
		return genders;
	}

}
