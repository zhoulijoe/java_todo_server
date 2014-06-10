package hello;

import org.joda.time.LocalTime;

public class HelloWorld {
   public static void main(String[] args) {
      LocalTime now = new LocalTime();
      System.out.println("Current time is: " + now);

      Greeter greeter = new Greeter();
      System.out.println(greeter.sayHello());
   }
}

