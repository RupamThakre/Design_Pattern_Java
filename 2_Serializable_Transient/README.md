# What is Serialization?
Serialization is the process of converting an object into a byte stream, so it can be:

- Saved to a file
- Transmitted over a network
- Stored in a database
- Cached or logged

The opposite process — converting the byte stream back into an object — is called deserialization.

# Why Use Serializable?
By implementing the Serializable interface, you're telling the Java Virtual Machine (JVM) and tools like ObjectOutputStream/ObjectInputStream that this class can safely be converted to and from a byte stream.

Example use cases:
- Storing session data in web applications
- Sending objects over a socket in client-server applications
- Caching complex objects to disk or memory

# What is Serializable?

```java
public interface Serializable {
// It's a marker interface – it has no methods.
}
```
It’s called a marker interface, which means it doesn’t contain any methods. It's used only to mark a class as being serializable.

**Example**
````java
import java.io.Serializable;
public class Person implements Serializable {
private String name;
private int age;

    // constructor, getters, setters...
}
````
Now, instances of Person can be serialized like this:

````java
ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"));
out.writeObject(new Person("Alice", 30));
out.close();
````
And deserialized like this:

```java
ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"));
Person p = (Person) in.readObject();
in.close();
```

**Things to Keep in Mind**

- All fields of the class must be serializable (or marked transient to skip them).
- If a non-serializable object is a field, it will throw NotSerializableException.

- You can define a serialVersionUID to ensure compatibility between versions of the class.

```java
private static final long serialVersionUID = 1L;
```
✅ Summary

- implements Serializable makes a class eligible for serialization.
- It’s used for storing, transmitting, or persisting object state.
- It’s a marker interface — no methods to implement.

# Transient

The transient keyword in Java is used to prevent a field from being serialized when an object is converted into a byte stream.

**Why Use transient?**

When you serialize an object (e.g., write it to a file or send it over a network), all non-transient fields are saved. But sometimes, you don't want to serialize certain fields, such as:

- Sensitive data (e.g., passwords, credit card numbers)
- Large objects you can reload later
- Temporary or derived values (e.g., cached data)

By marking a field as transient, you tell Java's serialization mechanism to ignore that field.

🔹 Example

````java
import java.io.Serializable;

public class User implements Serializable {
private String username;
private transient String password;  // This won't be serialized

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
````


When serialized, only the username is saved. password will be null when deserialized.

**Example Output**

````java
User u = new User("alice", "secret123");

// Serialize
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"));
oos.writeObject(u);
oos.close();
````


````java
// Deserialize
ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"));
User deserialized = (User) ois.readObject();
System.out.println(deserialized.username);  // alice
System.out.println(deserialized.password);  // null (because it was transient)

````

**✅ Use transient When:**

- You have sensitive information that shouldn't be saved/transmitted.
- You have non-serializable objects you want to skip (e.g., open connections, threads).
- The field can be recalculated after deserialization.

