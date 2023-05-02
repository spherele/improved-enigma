public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("zxc", 1, 1, 1.09090);
        basket.add("cxz", 3, 2, 1.2323);
        basket.print("123");
        Basket basket1 = new Basket();
        basket1.add("ghoul", 6, 10, 322);
        basket1.print("Tokyo ghoul");
        Basket.printTotal();
    }
}
