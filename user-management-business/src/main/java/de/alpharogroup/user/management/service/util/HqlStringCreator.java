package de.alpharogroup.user.management.service.util;

import java.util.Date;

import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Permissions;
import de.alpharogroup.user.management.entities.Recommendations;
import de.alpharogroup.user.management.entities.RelationPermissions;
import de.alpharogroup.user.management.entities.ResetPasswords;
import de.alpharogroup.user.management.entities.RuleViolations;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.enums.RuleViolationReason;

public class HqlStringCreator {

	public static String forRuleViolations(final Users detector, final Users violator,
			final RuleViolationReason reason, final String description) {
		final StringBuilder sb = new StringBuilder();
		sb.append("select rv from " + RuleViolations.class.getSimpleName()
				+ " rv");
		final boolean detectorIsNotNull = detector != null;
		if (detectorIsNotNull) {
			sb.append(" ");
			sb.append("where rv.detector=:detector");
		}
		final boolean violatorIsNotNull = violator != null;
		if (violatorIsNotNull) {
			sb.append(" ");
			if (detectorIsNotNull) {
				sb.append("and rv.violator=:violator");
			} else {
				sb.append("where rv.violator=:violator");
			}
		}
		final boolean reasonIsNotNull = reason != null;
		if (reasonIsNotNull) {
			sb.append(" ");
			if (!detectorIsNotNull && !violatorIsNotNull) {
				sb.append("where rv.reason=:reason");
			} else {
				sb.append("and rv.reason=:reason");
			}
		}
		final boolean descriptionTypeIsNotNull = description != null
				&& !description.isEmpty();
		if (descriptionTypeIsNotNull) {
			sb.append(" ");
			if (!detectorIsNotNull && !violatorIsNotNull && !reasonIsNotNull) {
				sb.append("where rv.description=:description");
			} else {
				sb.append("and rv.description=:description");
			}
		}
		return sb.toString();
	}

	public static String forPermissions(final String description,
			final String permissionName, final String shortcut) {
		final StringBuilder sb = new StringBuilder();
		sb.append("select p from " + Permissions.class.getSimpleName() + " p");
		final boolean descriptionIsNotNull = description != null
				&& !description.isEmpty();
		if (descriptionIsNotNull) {
			sb.append(" ");
			sb.append("where p.description=:description");
		}
		final boolean permissionNameIsNotNull = permissionName != null
				&& !permissionName.isEmpty();
		if (permissionNameIsNotNull) {
			sb.append(" ");
			if (descriptionIsNotNull) {
				sb.append("and p.permissionName=:permissionName");
			} else {
				sb.append("where p.permissionName=:permissionName");
			}
		}
		final boolean shortcutIsNotNull = shortcut != null && !shortcut.isEmpty();
		if (shortcutIsNotNull) {
			sb.append(" ");
			if (!descriptionIsNotNull && !permissionNameIsNotNull) {
				sb.append("where p.shortcut=:shortcut");
			} else {
				sb.append("and p.shortcut=:shortcut");
			}
		}
		return sb.toString();
	}

	public static String forContactmethods(final ContactmethodType contactmethod, final String contactvalue) {
		final StringBuilder sb = new StringBuilder();
		sb.append("select cm from " + Contactmethods.class.getSimpleName() + " cm");
		final boolean contactmethodIsNotNull = contactmethod != null;
		if (contactmethodIsNotNull) {
			sb.append(" ");
			sb.append("where cm.contactmethod=:contactmethod");
		}
		final boolean contactvalueIsNotNull = contactvalue != null
				&& !contactvalue.isEmpty();
		if (contactvalueIsNotNull) {
			sb.append(" ");
			if (contactmethodIsNotNull) {
				sb.append("and cm.contactvalue=:contactvalue");
			} else {
				sb.append("where cm.contactvalue=:contactvalue");
			}
		}
		return sb.toString();
	}

	public static String forRelationPermissions(final Users provider, final Users subscriber, final Permissions permission) {
		final StringBuilder sb = new StringBuilder();
		sb.append("select rp from " + RelationPermissions.class.getSimpleName() + " rp");
		final boolean providerIsNotNull = provider != null;
		if(providerIsNotNull) {
			sb.append(" ");
			sb.append("where rp.provider=:provider");
		}
		final boolean subscriberIsNotNull = subscriber != null;
		if( subscriberIsNotNull ){
			sb.append(" ");
			if(providerIsNotNull) {
				sb.append("and rp.subscriber=:subscriber");
			} else {
				sb.append("where rp.subscriber=:subscriber");
			}
		}
		final boolean permissionIsNotNull = permission != null;
		if(permissionIsNotNull) {
			sb.append(" ");
			if (!providerIsNotNull && !subscriberIsNotNull) {
				sb.append("where :permission in elements(rp.permissions)");
			} else {
				sb.append("and :permission in elements(rp.permissions)");
			}

		}
		return sb.toString();
	}

	public static String forRecommendations(final Users user, final Users recommended,  final String email) {
		final StringBuilder sb = new StringBuilder();
		sb.append("select r from " + Recommendations.class.getSimpleName() + " r");
		final boolean userIsNotNull = user != null;
		if(userIsNotNull) {
			sb.append(" ");
			sb.append("where r.user=:user");
		}
		final boolean recommendedIsNotNull = recommended != null;
		if( recommendedIsNotNull ){
			sb.append(" ");
			if(userIsNotNull) {
				sb.append("and r.recommended=:recommended");
			} else {
				sb.append("where r.recommended=:recommended");
			}
		}
		final boolean emailIsNotNull = email != null && !email.isEmpty();
		if(emailIsNotNull) {
			sb.append(" ");
			if (!userIsNotNull && !recommendedIsNotNull) {
				sb.append("where r.email=:email");
			} else {
				sb.append("and r.email=:email");
			}
		}
		return sb.toString();
	}

	public static String forResetPasswords(final Users user, final String generatedPassword, final Date expiryDate, final Date starttime) {
		final StringBuilder sb = new StringBuilder();
		sb.append("select r from " + ResetPasswords.class.getSimpleName() + " r");
		final boolean userIsNotNull = user != null;
		if(userIsNotNull) {
			sb.append(" ");
			sb.append("where r.user=:user");
		}
		final boolean generatedPasswordIsNotNull = generatedPassword != null && !generatedPassword.isEmpty();
		if( generatedPasswordIsNotNull ){
			sb.append(" ");
			if(userIsNotNull) {
				sb.append("and r.generatedPassword=:generatedPassword");
			} else {
				sb.append("where r.generatedPassword=:generatedPassword");
			}
		}
		final boolean expiryDateIsNotNull = expiryDate != null;
		if(expiryDateIsNotNull) {
			sb.append(" ");
			if (!userIsNotNull && !generatedPasswordIsNotNull) {
				sb.append("where r.expiryDate=:expiryDate");
			} else {
				sb.append("and r.expiryDate=:expiryDate");
			}
		}

		final boolean starttimeIsNotNull = starttime != null;
		if (starttimeIsNotNull) {
			sb.append(" ");
			if (!userIsNotNull && !generatedPasswordIsNotNull && !expiryDateIsNotNull) {
				sb.append("where rv.starttime=:starttime");
			} else {
				sb.append("and rv.starttime=:starttime");
			}
		}
		return sb.toString();
	}
}
