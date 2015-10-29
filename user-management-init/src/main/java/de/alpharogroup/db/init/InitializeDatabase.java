package de.alpharogroup.db.init;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import de.alpharogroup.lang.PropertiesUtils;
import de.alpharogroup.user.management.db.init.DatabaseInitialization;

public class InitializeDatabase {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws ClassNotFoundException
	 *             occurs if a class has not been found
	 * @throws SQLException
	 *             Signals that an sql error has occurred.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(final String[] args) throws ClassNotFoundException,
			SQLException, IOException {
		Properties dbProperties = PropertiesUtils.loadProperties("jdbc.properties");
		new DatabaseInitialization(dbProperties).initializeDatabase();
	}

}
