# Design Patterns in Java

🧩 1. Creational Patterns - Focus on object creation mechanisms.

1. Singleton – Ensures a class has only one instance.
2. Factory Method – Creates objects without specifying exact class.
3. Abstract Factory – Produces families of related objects.
4. Builder – Constructs complex objects step by step.
5. Prototype – Clones existing objects.

⚙️ 2. Structural Patterns - Focus on how classes and objects are composed.

1. Adapter – Converts one interface to another.
2. Bridge – Separates abstraction from implementation.
3. Composite – Treats individual and groups of objects uniformly.
4. Decorator – Adds behavior to objects dynamically.
5. Facade – Provides a simplified interface to a complex system.
6. Flyweight – Shares common parts of object state to reduce memory.
Proxy – Provides a placeholder for another object.

🔄 3. Behavioral Patterns - Focus on communication between objects.

1. Observer – Notifies dependent objects when state changes.
2. Strategy – Defines a family of algorithms, interchangeable.
3. Command – Encapsulates a request as an object.
4. State – Allows an object to alter behavior based on state.
5. Template Method – Defines a skeleton of an algorithm in a method.
6. Mediator – Reduces communication complexity between objects.
7. Chain of Responsibility – Passes requests along a chain of handlers.
8. Iterator – Provides a way to access elements sequentially.
9. Memento – Saves and restores the previous state of an object.
10. Visitor – Separates an algorithm from an object structure.


# **1. Singleton Design Pattern**

A singleton is object creational pattern that allows our application to create one and only one instance of 
a particular class, no matter how many times that class is used in our application.

- Ex. PropertyReader - read the properties from file and it is used multiple times in our application

**Intent of Singleton Pattern :**

- To restrict the instantiation of a class to one "single" instance.
- Useful when exactly one object is needed to coordinate actions across the system (e.g., Configuration settings, Logger, Cache, etc.).

# **2. Factory Design Pattern**

The Factory Design Pattern is a creational design pattern. It provides a way to create objects without specifying the exact class of the object that will be created.

Instead of calling a constructor directly to create an object, you use a factory method that returns an instance of a class.

**🧠 Why Use It?**

- You want to decouple object creation from the client code.
- You want to return different types of objects based on input.
- Adding new types doesn't require changes in client code.

Follows the Open/Closed Principle (open for extension, closed for modification).

**🧱 Basic Structure**
````java

// 1. Product interface
public interface Shape {
    void draw();
}

// 2. Concrete Products
public class Circle implements Shape {
 public void draw() {
     System.out.println("Drawing a Circle");
 }
}

public class Square implements Shape {
 public void draw() {
     System.out.println("Drawing a Square");
 }
}

// 3. Factory Class
public class ShapeFactory {
  public Shape getShape(String shapeType) {
    if (shapeType == null) return null;
    if (shapeType.equalsIgnoreCase("CIRCLE")) return new Circle();
    else if (shapeType.equalsIgnoreCase("SQUARE")) return new Square();
    return null;
}
}

// 4. Client Code
public class FactoryPatternDemo {
public static void main(String[] args) {
ShapeFactory factory = new ShapeFactory();

        Shape shape1 = factory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = factory.getShape("SQUARE");
        shape2.draw();
    }
}
````

**Advantages**

- Loose coupling between client code and object creation logic.
- Easy to introduce new types without changing client code.
- Centralized object creation logic.

**Disadvantages**
- Can introduce too many classes.
- May become harder to maintain if not managed properly.