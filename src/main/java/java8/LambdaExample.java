package java8;

public class LambdaExample {
    public static void main(String[] args) {
        /*Notification e1 = ()->{
            System.out.println("HEllo ");
        };*/
      /*  Notification e2 = p1->{
            System.out.println("HEllo "+p1);
        };*/
        Notification e2 = p1-> LambdaExample.contCat("Mr", "Rajesh","Chokkalingam",p1);
       // e1.send();
        String message = e2.send("Hello");
        System.out.println(message);
        e2.shink("welcom", "java8");
        Notification.display("Hello World");

    }

    public static String contCat(String title, String firstName, String lastName, String msg){
        return title+":"+firstName+":"+lastName+":"+msg;

    }
}
