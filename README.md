# Cowboy Bike API Client

This is a Java client for the [Cowboy Bike API](https://app-api.cowboy.bike). The Cowboy Bike API is not public, so it
is possible that this client will stop working in the future.

## Usage

Include the library in your project:

### Maven

```xml

<dependency>
  <groupId>io.huggler</groupId>
  <artifactId>cowboy-bike-api-client</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Gradle

```groovy
implementation 'io.huggler:cowboy-bike-api-client:1.0.0'
```

### How to use in Code

Create an instance of `AuthenticationProvider`. You need to pass in your email and password for your Cowboy Bike
account.

```java
var authenticationProvider = new AuthenticationProvider("<email>","<password>");
```

Create an instance of CowboyClient and pass the authentication provider to the constructor.

```java
var cowboyClient = new CowboyClient(authenticationProvider);
```

Now you can use the client to get information about your bike.

```java
// Retrieve the user's information
var user = cowboyClient.getUser();

// Get the bike connected to the user's account
var bike = user.getBike();

// Retrieve various information about the bike 
// such as the battery level or location
var stateOfCharge = bike.getStateOfCharge();
var location = bike.getLocation();
```

## Author

This library was created by Yannick Huggler

## License

Apache 2.0