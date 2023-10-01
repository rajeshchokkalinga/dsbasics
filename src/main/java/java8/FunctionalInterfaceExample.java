package java8;

/**
 * An Interface that contains exactly one abstract method is known as functional interface. It can have any number of
 * default, static methods but can contain only one abstract method. It can also declare methods of object class.
 *
 * Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces. It is a new feature in
 * Java, which helps to achieve functional programming approach.
 */
@FunctionalInterface
interface Notification extends base{
    String send(String msg);
    // It can contain any number of Object class methods.
    int hashCode();
    String toString();
    boolean equals(Object obj);

    default void shink(String msg, String name){
        System.out.println(name +":"+msg);
    }
    default void shink1(String msg, String name){
        System.out.println(name +":"+msg);
    }
    static void display(String msg){
        System.out.println(msg);
    }
    static void display1(String msg){
        System.out.println(msg);
    }
}

interface base{
    default void append(String msg, String name){
        System.out.println(name +":"+msg);
    }
    default void concat(String msg, String name){
        System.out.println(name +":"+msg);
    }
    static void print(String msg){
        System.out.println(msg);
    }

    //void send1(String msg);
}
public class FunctionalInterfaceExample implements Notification {
    public String send(String msg){
        return msg;
    }
    public static void main(String[] args) {
        FunctionalInterfaceExample fie = new FunctionalInterfaceExample();
        System.out.println(fie.send("Hello there"));
    }
}