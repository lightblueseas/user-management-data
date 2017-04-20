# user-management-data

Parent project that holds module projects for the persistence of user data.

The project holds backend data for user management.

## License

The source code comes under the liberal MIT License, making user-management-data great for all types of applications with users or accounts.

# Build status and latest maven version
[![Build Status](https://travis-ci.org/lightblueseas/user-management-data.svg?branch=master)](https://travis-ci.org/lightblueseas/user-management-data)

## Maven Central

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/user-management-data/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/user-management-data)

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~user-management-data~~~) for latest snapshots and releases.

Add the following maven dependencies to your project `pom.xml` if you want to import the core functionality:

You can first define the version properties:

	<properties>
			...
		<!-- user-management-data version -->
		<user-management-data.version>3.11.0</user-management-data.version>
		<user-management-business.version>${user-management-data.version}</user-management-business.version>
		<user-management-domain.version>${user-management-data.version}</user-management-domain.version>
		<user-management-entities.version>${user-management-data.version}</user-management-entities.version>
		<user-management-init.version>${user-management-data.version}</user-management-init.version>
		<user-management-rest-api.version>${user-management-data.version}</user-management-rest-api.version>
		<user-management-rest-client.version>${user-management-data.version}</user-management-rest-client.version>
		<user-management-rest-web.version>${user-management-data.version}</user-management-rest-web.version>
			...
	</properties>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-management-business:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-management-business</artifactId>
				<version>${user-management-business.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-management-domain:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-management-domain</artifactId>
				<version>${user-management-domain.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-management-entities:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-management-entities</artifactId>
				<version>${user-management-entities.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-management-init:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-management-init</artifactId>
				<version>${user-management-init.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-management-rest-api:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-management-rest-api</artifactId>
				<version>${user-management-rest-api.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-management-rest-client:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-management-rest-client</artifactId>
				<version>${user-management-rest-client.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of user-management-rest-web:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>user-management-rest-web</artifactId>
				<version>${user-management-rest-web.version}</version>
			</dependency>
			...
		</dependencies>

## Want to Help and improve it? ###

The source code for user-management-data are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [lightblueseas/user-management-data/fork](https://github.com/lightblueseas/user-management-data/fork)

To share your changes, [submit a pull request](https://github.com/lightblueseas/user-management-data/pull/new/master).

Don't forget to add new units tests on your changes.

## Contacting the Developer

Do not hesitate to contact the user-management-data developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/lightblueseas/user-management-data/issues).

## Note

No animals were harmed in the making of this library.

# Donate

If you like this library, please consider a donation through 
<a href="https://flattr.com/submit/auto?fid=r7vp62&url=https%3A%2F%2Fgithub.com%2Flightblueseas%2Fuser-management-data" target="_blank">
<img src="http://button.flattr.com/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0">
</a>
