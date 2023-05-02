public class Exampleprg {
    /*
     * Exampleprg(String... person)
     * {
     * for(String name: person)
     * {
     * System.out.println("Hello"+name);
     * }
     * }
     * public static void main(String[] args) {
     * Exampleprg exp=new Exampleprg();
     * Exampleprg("John","david","suhel");
     * }
     * /*
     */
    public static void main(String[] args) {
        try {
            int a = 0;
            int d = 5 / a;
            System.out.println("This will cause an exception");
        } catch (Exception e) {

            // TODO: handle exception
            System.out.println("Dekho Chutiya zero se divide kr rha hai LOL\n" + e);

        }
        System.out.println("Out of Catch");

    }

}