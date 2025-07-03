
import java.util.*;
class Phone{ v 
    int price;
    static int model;

    public static void setModel(Phone phone ) {
        System.out.println(phone.price+"Setting model to: " + model);
    }

    public void setModel() {
       System.out.println("Setting model to: " + model);
    }

}



class thread1 extends Thread {
    public void run() {


        for (int i = 0; i < 5; i++) {
            System.out.println("Thread1 is running " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class thread2 extends Thread {
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println("Thread2 is running " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


public class Test{

    public static void main(String[] args) {


        Comparator<Integer> integerComperator = new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2; // Ascending order
            }
        };


        List<Integer> arr = Arrays.asList(5, 2, 4, 3, 1);


    Collections.sort(arr, integerComperator);

        System.out.println(arr); // Outputs: [1, 2, 3, 4, 5]
//        String str=new String("Hello World");
//        System.out.println(str.substring(6, 11)); // Outputs: World
//
//
//
//        Phone obj1=new Phone();
//        Phone obj2=new Phone();
//        obj1.price = 1000;
//        obj2.price = 2000;
        // System.out.println(obj1.price); // Outputs: 1000
        // System.out.println(obj2.price); // Outputs: 2000
        // System.out.println(Phone.model); // Outputs: 0 (default value of static int)
        // Phone.model = 5;
        // System.out.println(Phone.model); // Outputs: 5

//        Phone.setModel(obj1); // Outputs: 1000Setting model to: 0
//        obj1.setModel(); // Outputs: Setting model to: 0


//            thread1 t1 = new thread1();
//        thread2 t2 = new thread2();
//            t1.start();
//            t2.start();



    }
}