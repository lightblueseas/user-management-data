package de.alpharogroup.user.management.application.models;

import java.io.File;

import de.alpharogroup.resource.system.application.model.ModelSynchronizer;
import de.alpharogroup.resource.system.application.model.ResourcesModel;
import de.alpharogroup.resource.system.entities.Resources;

/**
 * The Class ModelConverter.
 * @deprecated use instead {@link ModelSynchronizer}
 */
@Deprecated
public class UserModelConverter {

	/**
	 * Convert the given FileModel object to an Resources object.
	 *
	 * @param resourcesModel
	 *            the upload file model
	 * @return the resources
	 */
	public static Resources convert(final ResourcesModel resourcesModel) {
		return ModelSynchronizer.convert(resourcesModel);
	}

	/**
	 * Equalizes the given image with the resourcesModel object so the resourcesModel
	 * object sets the values from resources object.
	 *
	 * @param resources
	 *            the resources
	 * @param resourcesModel
	 *            the file model
	 */
	public static void equalise(final Resources resources, final ResourcesModel resourcesModel) {
		ModelSynchronizer.equalise(resources, resourcesModel);
	}

	/**
	 * Converts the given File object to a ResourceModel object.
	 *
	 * @param file the file
	 * @param contentType the content type
	 * @param description the description
	 * @return the ResourceModel
	 */
	public static ResourcesModel toResourceModel(final File file, final String contentType, final String description) {
		return ModelSynchronizer.toResourceModel(file, contentType, description);
	}

}