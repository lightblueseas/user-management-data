package de.alpharogroup.user.management.service.util;

import java.util.Date;

import de.alpharogroup.user.management.entities.Contactmethods;
import de.alpharogroup.user.management.entities.Permissions;
import de.alpharogroup.user.management.entities.RuleViolations;
import de.alpharogroup.user.management.entities.Users;
import de.alpharogroup.user.management.enums.ContactmethodType;
import de.alpharogroup.user.management.enums.RuleViolationReason;

public class HqlStringCreator {

	public static String forRuleViolations(Users detector, Users violator,
			RuleViolationReason reason, String description) {
		StringBuilder sb = new StringBuilder();
		sb.append("select rv from " + RuleViolations.class.getSimpleName()
				+ " rv");
		boolean detectorIsNotNull = detector != null;
		if (detectorIsNotNull) {
			sb.append(" ");
			sb.append("where rv.detector=:detector");
		}
		boolean violatorIsNotNull = violator != null;
		if (violatorIsNotNull) {
			sb.append(" ");
			if (detectorIsNotNull) {
				sb.append("and rv.violator=:violator");
			} else {
				sb.append("where rv.violator=:violator");
			}
		}
		boolean reasonIsNotNull = reason != null;
		if (reasonIsNotNull) {
			sb.append(" ");
			if (!detectorIsNotNull && !violatorIsNotNull) {
				sb.append("where rv.reason=:reason");
			} else {
				sb.append("and rv.reason=:reason");
			}
		}
		boolean descriptionTypeIsNotNull = description != null
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

	public static String forPermissions(String description,
			String permissionName, String shortcut) {
		StringBuilder sb = new StringBuilder();
		sb.append("select p from " + Permissions.class.getSimpleName() + " p");
		boolean descriptionIsNotNull = description != null
				&& !description.isEmpty();
		if (descriptionIsNotNull) {
			sb.append(" ");
			sb.append("where p.description=:description");
		}
		boolean permissionNameIsNotNull = permissionName != null
				&& !permissionName.isEmpty();
		if (permissionNameIsNotNull) {
			sb.append(" ");
			if (descriptionIsNotNull) {
				sb.append("and p.permissionName=:permissionName");
			} else {
				sb.append("where p.permissionName=:permissionName");
			}
		}
		boolean shortcutIsNotNull = shortcut != null && !shortcut.isEmpty();
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

	public static String forContactmethods(ContactmethodType contactmethod, String contactvalue) {
		StringBuilder sb = new StringBuilder();
		sb.append("select cm from " + Contactmethods.class.getSimpleName() + " cm");
		boolean contactmethodIsNotNull = contactmethod != null;
		if (contactmethodIsNotNull) {
			sb.append(" ");
			sb.append("where cm.contactmethod=:contactmethod");
		}
		boolean contactvalueIsNotNull = contactvalue != null
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
	
	public static String forRelationPermissions(Users provider, Users subscriber, Permissions permission) {
		StringBuilder sb = new StringBuilder();
		sb.append("select rp from RelationPermissions rp");
		boolean providerIsNotNull = provider != null;
		if(providerIsNotNull) {
			sb.append(" ");
			sb.append("where rp.provider=:provider");
		}
		boolean subscriberIsNotNull = subscriber != null;
		if( subscriberIsNotNull ){
			sb.append(" ");
			if(providerIsNotNull) {
				sb.append("and rp.subscriber=:subscriber");
			} else {
				sb.append("where rp.subscriber=:subscriber");
			}						
		}
		boolean permissionIsNotNull = permission != null;
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
	
	public static String forRecommendations(Users user, Users recommended,  String email) {
		StringBuilder sb = new StringBuilder();
		sb.append("select r from Recommendations r");
		boolean userIsNotNull = user != null;
		if(userIsNotNull) {
			sb.append(" ");
			sb.append("where r.user=:user");
		}
		boolean recommendedIsNotNull = recommended != null;
		if( recommendedIsNotNull ){
			sb.append(" ");
			if(userIsNotNull) {
				sb.append("and r.recommended=:recommended");
			} else {
				sb.append("where r.recommended=:recommended");
			}						
		}
		boolean emailIsNotNull = email != null && !email.isEmpty();
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
	
	public static String forResetPasswords(Users user, String generatedPassword, Date expiryDate, Date starttime) {
		StringBuilder sb = new StringBuilder();
		sb.append("select r from ResetPasswords r");
		boolean userIsNotNull = user != null;
		if(userIsNotNull) {
			sb.append(" ");
			sb.append("where r.user=:user");
		}
		boolean generatedPasswordIsNotNull = generatedPassword != null && !generatedPassword.isEmpty();
		if( generatedPasswordIsNotNull ){
			sb.append(" ");
			if(userIsNotNull) {
				sb.append("and r.generatedPassword=:generatedPassword");
			} else {
				sb.append("where r.generatedPassword=:generatedPassword");
			}						
		}
		boolean expiryDateIsNotNull = expiryDate != null;
		if(expiryDateIsNotNull) {
			sb.append(" ");
			if (!userIsNotNull && !generatedPasswordIsNotNull) {
				sb.append("where r.expiryDate=:expiryDate");
			} else {
				sb.append("and r.expiryDate=:expiryDate");				
			}				
		}

		boolean starttimeIsNotNull = starttime != null;
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
