
/*
* Eager Initialization - The instance is created at the time of class loading
*
* ✅ Pros:
Simple and thread-safe.

❌ Cons:
Instance is created even if it might not be used.
* */

public class Singleton_Eager_Initialization {
    private static final Singleton_Eager_Initialization instance = new Singleton_Eager_Initialization();

    private Singleton_Eager_Initialization() {
        // private constructor - no one would be able to directly instantiate
    }

    public static Singleton_Eager_Initialization getInstance() {
        return instance;
    }
}