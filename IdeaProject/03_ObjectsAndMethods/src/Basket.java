public class Basket {

    private String items = "";
    public static int allCountItems = 0;
    public static int allBasketsPrices = 0;
    public static int basketCount = 0;

    Basket(){
        basketCount++;
    }

    public void add(String name, int price, int count, double weight) {
        if (contains(name)) return;

        allCountItems = allCountItems + count;
        allBasketsPrices = allBasketsPrices + count * price;

        items = items + name + " - "
                + count + " шт. - "
                + price + " руб. - "
                + weight + " кг.\n";
    }
    public static double getAverageItemPrice() {
        return  (double) allBasketsPrices / allCountItems;
    }
    public static double getAverageBasketsPrice() {
        return (double) allBasketsPrices / basketCount;
    }
    public void clear() {
        items = "";
        allBasketsPrices = 0;
        allCountItems = 0;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
    public static void printTotal(){
        System.out.println(
                "Общая стоимость всех позиций: " + allBasketsPrices + "\n" +
                "Общее количество позиций: " + allCountItems + "\n" +
                "Средняя стоимость продукта: " + getAverageItemPrice() + "\n" +
                "Средняя стоимость корзин: " + getAverageBasketsPrice() + "\n"
        );
    }
}
