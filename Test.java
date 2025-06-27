

class Phone{
    int price;
    static int model;

    public static void setModel(Phone phone ) {
        System.out.println(phone.price+"Setting model to: " + model);
    }

    public void setModel() {
       System.out.println("Setting model to: " + model);
    }

}

public class Test{

    public static void main(String[] args) {
        String str=new String("Hello World");
        System.out.println(str.substring(6, 11)); // Outputs: World



        Phone obj1=new Phone();
        Phone obj2=new Phone();
        obj1.price = 1000;
        obj2.price = 2000;
        // System.out.println(obj1.price); // Outputs: 1000
        // System.out.println(obj2.price); // Outputs: 2000
        // System.out.println(Phone.model); // Outputs: 0 (default value of static int)
        // Phone.model = 5;
        // System.out.println(Phone.model); // Outputs: 5

        Phone.setModel(obj1); // Outputs: 1000Setting model to: 0
        obj1.setModel(); // Outputs: Setting model to: 0


    }
}