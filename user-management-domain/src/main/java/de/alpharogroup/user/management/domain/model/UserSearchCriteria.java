package de.alpharogroup.user.management.domain.model;

import de.alpharogroup.user.management.enums.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The class {@link UserSearchCriteria}.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSearchCriteria {
	
	/** The from. */
	private Integer from; 
	
	/** The search gender. */
	private GenderType searchGender; 
	
	/** The until. */
	private Integer until;
	
	/** The geohash. */
	private String geohash;
}
