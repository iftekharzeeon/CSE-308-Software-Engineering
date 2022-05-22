public class C1 {
    public static void main(String[] args) {
        C1 ob = new C1();

        Object o1 = ob;

        System.out.println(o1 instanceof  Object);
        System.out.println(o1 instanceof C1);
    }
}
