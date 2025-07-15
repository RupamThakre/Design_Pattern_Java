
/*
* Lazy Initialization - Instance is created only when requested.
*
*❌ Not Thread-safe:
If two threads call getInstance() simultaneously, more than one instance can be created.
* */

public class Singleton_Lazy_Initialization {
    private static Singleton_Lazy_Initialization instance;

    private Singleton_Lazy_Initialization() {
        // private constructor
    }

    public static Singleton_Lazy_Initialization getInstance() {
        if (instance == null) {
            instance = new Singleton_Lazy_Initialization();
        }
        return instance;
    }
}