package oops;

public class StaticKeyword {

    static {
        System.out.println("in block 1");
    }
    static {
        System.out.println("in block 2");
    }


    public static void main(String[] args) {

        System.out.println("inside main");
    }

    static {
        System.out.println("in block 3");
    }

//        System.out.println(Math.PI);
//        System.out.println(Math.max(23, 12));
//        System.out.println(Math.E);

        A objA = new A();
        A.B objB = objA.new B();

        A.C objC = new A.C();



}
