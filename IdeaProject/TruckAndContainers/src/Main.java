public class Main {
    public static void main(String[] args) {
        int boxes = TruckAndContainers.boxesCount();
        int containers = TruckAndContainers.containerCount(boxes);
        int cars = TruckAndContainers.carCount(containers);

        int b = 1;
        for (int truck = 1; truck <= cars; truck++){
            System.out.println("Грузовик: " + truck);

            for (int counteiner = 1; counteiner <= 12 && containers > 0; counteiner++, containers--){
                System.out.println("\tКонтейнер: " + counteiner);

                for (int i = 1; i <= 27 && boxes > 0; i++, boxes--, b++){
                    System.out.println("\t\tЯщик: " + b);
                }
            }
        }

        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + cars + " шт.");
        System.out.println("контейнеров - " + TruckAndContainers.containerCount(b) + " шт.");
    }
}
