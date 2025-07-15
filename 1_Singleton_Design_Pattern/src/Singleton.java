public class Singleton {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

/*
* Why Use static in Singleton?
Let's break it down:

1. Static Variables Belong to the Class, Not the Object
In Singleton, the key idea is only one instance of the class should exist.

private static Singleton instance;
Declaring instance as static means it's shared across all possible references to the class.

Without static, each object would get its own copy — defeating the whole purpose.

2. Access Without Instantiation

public static Singleton getInstance()
The getInstance() method is static so it can be called without creating an object of the Singleton class.

This allows clients to retrieve the instance like:

Singleton s = Singleton.getInstance();
If getInstance() were non-static, you would need to do:

Singleton s = new Singleton(); // ❌ Not allowed in Singleton

* 3. Ensures Global Access Point
Because the method and instance are static, they are accessible globally through the class name:

Singleton.getInstance().doSomething();
This aligns with the Singleton pattern's intent: to provide a single, globally accessible instance.

🧪 Without static, What Happens?
If you remove static from instance and getInstance():

You can't access getInstance() without an object.

Each object might have its own version of instance (not a singleton).

You risk multiple instantiations.
* */