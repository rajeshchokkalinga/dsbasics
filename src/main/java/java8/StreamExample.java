package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    static String replaceFr(String s){
            if (s == "Lemon")
                return "SweetLime";
            return s;
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple","Banana", "Orange", "Orange", "Lemon", "Apple");

       // Stream filter(Predicate predicate)
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);
        Stream subStream = intStream.filter(value -> value>3);
        long count = subStream.count();
        System.out.println(count);

        // map() Operation - Stream map(Function mapper)
        Stream<String> subStream2 = fruits.stream().map(StreamExample::replaceFr);

        List frList = subStream2.collect(Collectors.toList());
        System.out.println(frList);


        //(5, 7, 11,13), (1, 3, 5)

        //flat map
        // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);

        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfListofInts =
              Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

        System.out.println("The Structure before flattening is : " +
              listOfListofInts);

        // Using flatMap for transformating and flattening.
        List<Integer> listofInts  = listOfListofInts.stream()
              .flatMap(list -> list.stream())
              .collect(Collectors.toList());

        System.out.println("The Structure after flattening is : " +
              listofInts);


        //Stream distinct()
        Stream distinctStream = fruits.stream().distinct();
        distinctStream.forEach(name -> System.out.print(name+"  "));


        System.out.println();


        //Stream sorted()

        Stream vegStream = Stream.of("tomoto", "Green Chilli", "Pototo", "Beet root");
        Stream sortedStream = vegStream.sorted();
        sortedStream.forEach(name -> System.out.print(name+"  "));


        // peek() Operation
        Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
              .peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
              .peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());


        //Stream limit(long maxSize)
        System.out.print("Limit:");
        Stream.of("one", "two", "three", "four").limit(2).forEach(item -> System.out.print(item+" "));
        System.out.println();


        //Skip
        System.out.print("skip:");
        Stream.of("one", "two", "three", "four", "five").skip(2).forEach(item -> System.out.print(item+" "));
        System.out.println();


        //Terminal operations
        //toArray()
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        Object[] objArray = stream.toArray();
        System.out.print("objArray length " + objArray.length);


        //Collect
        Stream<Integer> streamCOllect = Stream.of(1, 2, 3, 4, 5);

        List<Integer> intList = streamCOllect.collect(Collectors.toList());
        //Set<Integer> intSet = streamCOllect.collect(Collectors.toSet());
        //Long cnt = streamCOllect.collect(Collectors.counting());

        //Count
        Stream<Integer> streamCount = Stream.of(1, 2, 3, 4, 5);
        long cntt = streamCount.count();
        System.out.println("count :: " + cntt);

        // Stream forEach(Consumer<? super T> action) Method Example
        Stream<Integer> streamForEach = Stream.of(1, 2, 3, 4, 5);
        // Printing the values
        streamForEach.forEach(value -> System.out.println(value));


        //min
        //max
        //anymatch
        //allMatch
        //nonMatch
        //FindAny
        //findFirst
        // Stream findFirst() Method Example
        Stream<Integer> streamFindFirst = Stream.of(1, 2, 3, 4, 5).parallel();
        Predicate<Integer> findFirst = value -> value % 2 == 0;
        Optional<Integer> findFirstOpt = streamFindFirst.filter(findFirst).findFirst();
        System.out.println("Find first odd number : " + findFirstOpt.get());



        // find even number from list of integer
        //List<Integer> intList = Arrays.asList(1,2,3,4,5,6).stream().filter(i -> i%2==0).collect(Collectors.toList());
        List<Integer> intList1 = Stream.of(1,2,3,4,5,6).filter(i -> i%2==0).collect(Collectors.toList());
        System.out.println("Even Numbers:"+intList1);

        //find first character of each string in List<String>

        List charList = Stream.of("Rajesh", "Aravindha", "Vinoj", "Vinodhini").map(name->name.chars()
              .mapToObj(c ->(char)c).findFirst().get()).collect(Collectors.toList());
        System.out.println("First character:"+charList);

        // find number of occurence of each number
        List<Integer> counts = Arrays.asList(1,2,2,5,5,6,3,2).stream().collect(
                    Collectors.groupingBy(p -> p,
                          Collectors.summingInt(p -> 1)))
              .values().stream().collect(Collectors.toList());
        System.out.println("Number Occurences:"+counts);


        //lower case and upcase conversion
        System.out.println(fruits.stream().map(l->l.toString().toUpperCase()).collect(Collectors.toList()));

        String input = "Rajesh Vinoj Aravindha Vindhini Vigashini";
        //find first nonrepeatable character in string
        char c = input.chars()      //string stream
              .mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i))) //convert to lowercase & then to Character object
              .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //store in a map with the count
              .entrySet().stream()
              .filter(entry -> entry.getValue() == 1L)
              .map(entry -> entry.getKey())
              .findFirst().get();
        System.out.println("First Non Repeatable character:"+c);

        // Student class (Find in Collection in java 8)
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Rajesh","M", "Integration",399));
        studentList.add(new Student("Vinodhini","F", "Integration",410));
        studentList.add(new Student("Aravindha","M", "Integration",406));

        studentList.add(new Student("Vinoj","M", "Owner",699));
        studentList.add(new Student("Vigashini","F", "Owner",980));

        studentList.add(new Student("Vinoj","M", "Account",699));
        studentList.add(new Student("Vigashini","F", "Account",980));
        //Find average mark of all students
        studentList.stream().mapToInt(s -> s.mark).average().orElse(0.0);


        //Find all the male students mark above 400 from Integration department
        studentList.stream().filter(s ->s.department.equals("Integration")&& s.mark >400 && s.gender.equals("M")).forEach(
              student -> {
                  System.out.println(student.name);
              }
        );
    }

    static class Student{
        String name;
        String gender;
        String department;
        int mark;
        Student(String name, String gender, String department, int mark){
            this.name = name;
            this.gender = gender;
            this.department = department;
            this.mark = mark;
        }

    }
}
