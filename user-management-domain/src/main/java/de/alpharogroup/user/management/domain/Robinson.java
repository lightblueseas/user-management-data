package de.alpharogroup.user.management.domain;

import de.alpharogroup.domain.BaseDomainObject;
import de.alpharogroup.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Robinson extends BaseDomainObject<Integer> {
	private static final long serialVersionUID = 1L;
	/**
     * The value associated with the column: robinson
	 */
	private User robinson;
}
