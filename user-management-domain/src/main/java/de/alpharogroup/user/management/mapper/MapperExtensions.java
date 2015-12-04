package de.alpharogroup.user.management.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;
import org.dozer.MappingException;

/**
 * The class {@link MapperExtensions}.
 * @deprecated use instead the synonym class from domain-api in version 3.9 project.
 */
@Deprecated
public class MapperExtensions
{

	/**
	 * Constructs new instance of destinationClass and performs mapping between from source.
	 *
	 * @param <T>
	 *            the generic type of the destinationClass
	 * @param <S>
	 *            the generic type of the source
	 * @param mapper
	 *            the dozer mapper object
	 * @param source
	 *            the source
	 * @param destinationClass
	 *            the destination class
	 * @return the new instance of destinationClass mapped to source object.
	 * @throws MappingException
	 *             is thrown if something goes wrong with the mapping process.
	 */
	public static <T, S> T map(final Mapper mapper, final S source, final Class<T> destinationClass)
		throws MappingException
	{
		return mapper.map(source, destinationClass);
	};

	/**
	 * Constructs new instances of destinationClass and performs mapping between from source.
	 *
	 * @param <T>
	 *            the generic type of the destinationClass
	 * @param <S>
	 *            the generic type of the source
	 * @param mapper
	 *            the dozer mapper object
	 * @param sources
	 *            the collection of source objects
	 * @param destinationClass
	 *            the destination class
	 * @return the new instance of destinationClass mapped to source object.
	 * @throws MappingException
	 *             is thrown if something goes wrong with the mapping process.
	 */
	public static <T, S> List<T> map(final Mapper mapper, final Collection<S> sources,
		final Class<T> destinationClass) throws MappingException
	{
		final List<T> destination = new ArrayList<>();
		if ((sources != null) && !sources.isEmpty())
		{
			for (final S source : sources)
			{
				destination.add(MapperExtensions.map(mapper, source, destinationClass));
			}
		}
		return destination;
	};

}