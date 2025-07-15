# Design Patterns in Java
Design patterns in Java

**1. Singleton Design Pattern**

A singleton is object creational pattern that allows our application to create one and only one instance of 
a particular class, no matter how many times that class is used in our application.

- Ex. PropertyReader - read the properties from file and it is used multiple times in our application

**Intent of Singleton Pattern :**

- To restrict the instantiation of a class to one "single" instance.
- Useful when exactly one object is needed to coordinate actions across the system (e.g., Configuration settings, Logger, Cache, etc.).