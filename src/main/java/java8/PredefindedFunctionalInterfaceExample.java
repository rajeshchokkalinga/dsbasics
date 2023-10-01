package java8;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredefindedFunctionalInterfaceExample {

    SmsConsumerExample sms = new SmsConsumerExample();
    static String product = "Android";

    PredefindedFunctionalInterfaceExample(String message){
        System.out.println("Print message:"+message);
    }
    PredefindedFunctionalInterfaceExample(){
        System.out.println("Print test message");
    }

    static void printMessage(String message){
        System.out.println("message = " + message);
    }
    
    static void printValue(String message, int n){
        System.out.println(message+" " + n);
        new PredefindedFunctionalInterfaceExample().sms.accept("Rajesh", "9442400049");
    }

    public static Integer getTwoDigitRandom() {
        int random = new Random().nextInt(100);
        if(random < 10)
            return 10;
        return random;
    }

    static boolean checkAge(int age){
        return (age >18)? true:false;
    }

    static boolean checkSum(Integer a, Integer b){
        return (a+b >18)? true:false;
    }


    public static void main(String[] args) {
        Consumer<String> consumer = PredefindedFunctionalInterfaceExample::printMessage;

        consumer.accept("hello");

        //BiConsumer<String, Integer> biConsumer =(a, b)->PredefindedFunctionalInterfaceExample.printValue(a,b);
        BiConsumer<String, Integer> biConsumer = PredefindedFunctionalInterfaceExample::printValue;
              biConsumer.accept("Hello", 420);

        Consumer<String> newConsumer = PredefindedFunctionalInterfaceExample::new;
        newConsumer.accept("test");

        Predicate<Integer> pr = PredefindedFunctionalInterfaceExample::checkAge;
        System.out.println(pr.test(10));

        pr = PredefindedFunctionalInterfaceExample::checkAge;
        System.out.println(pr.test(21));


       // BiPredicate<Integer, Integer> biPr = (a, b) ->PredefindedFunctionalInterfaceExample.checkSum(a,b);
        BiPredicate<Integer, Integer> biPr = PredefindedFunctionalInterfaceExample::checkSum;
        System.out.println(biPr.test(5,4));

        Function<Integer, Integer> function = p1 ->{
            return p1+p1;
        };

        //function = function.andThen(a->a*a);
        function = function.compose(a->a*a);
        System.out.println(function.apply(3));

        BiFunction<Integer, Integer, String> biFunction = PredefindedFunctionalInterfaceExample::getSum;
        System.out.println(biFunction.apply(100, 200));

        Supplier<Boolean> boolSupplier = () -> product.length() == 10;
        Supplier<Integer> intSupplier = () -> product.length() - 2;
        Supplier<String> strSupplier = () -> product.toUpperCase();


        System.out.println(boolSupplier.get());
        System.out.println(intSupplier.get());
        System.out.println(strSupplier.get());


        Supplier<Integer> supplier = PredefindedFunctionalInterfaceExample::getTwoDigitRandom;
        System.out.println(supplier.get());


    }

    private static String getSum(int a, int b){
        return (a+b)+"test";
    }


    class SmsConsumerExample implements BiConsumer<String, String>{
        @Override
        public void accept(String name, String phone) {
            System.out.println(name+" sent sms to = " + phone);
        }
    }
}
