
/*
Thread Safe - Thread-safe Singleton (Synchronized Method)

✅ Thread-safe.
❌ Slower due to method-level synchronization.

*/

public class Singleton_Thread_Safe {
   private static Singleton_Thread_Safe instance;

   private Singleton_Thread_Safe(){
       // private constructor
   }

   public static synchronized Singleton_Thread_Safe getInstance(){
       if(instance == null){
           instance = new Singleton_Thread_Safe();
       }
       return instance;
   }

}