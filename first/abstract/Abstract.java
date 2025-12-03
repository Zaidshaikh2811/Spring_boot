




  abstract class AbstractClass{

      abstract  void pressButton();
      abstract void moveJoystick();
}


 class ConcreteClass extends AbstractClass {



     public void pressButton() {
         System.out.println("PlayStation Button Pressed");
     }

     public void moveJoystick() {
         System.out.println("PlayStation Joystick Moved");
     }

     public void useTouchpad() {
         System.out.println("Using PlayStation touchpad");
     }
}


class A{
    public void a() {
        System.out.println("A");
    }
    class B extends A {
        public void b() {
            System.out.println("B");
        }
    }
}


interface C {
      void show();
}



public class Abstract {

    public static void main(String[] args) {

            //        A a = new A();
            //        A.B b = a.new B(){
            //            @Override
            //            public void b() {
            //                System.out.println("B overridden in anonymous class");
            //            }
            //        };
            //
            //        b.b();

//                    C c = ()->{
//
//                            System.out.println("C overridden in lambda expression");
//
//
//                            };
//
//                    c.show();

        int[] arr=new int[5];
        try{
            arr[5]=3;
        }
        catch (ArithmeticException e){
            System.out.println("Error: " + e);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
        finally {
            System.out.println("Finally block executed");
        }



    }
}