import java.util.Scanner;
public class TruckAndContainers {
    public static int containerCount(int boxes){
        int maxBoxesCount = 27;
        int containers = 1;
        for (int i = 0; i < boxes; i++){
            if (i % maxBoxesCount == 0 && i > 0){
                containers++;
            }
        }
        return containers;
    }
    public static int carCount(int containers){
        int maxContainersCount = 12;
        int cars = 1;
        for (int i = 0; i < containers; i++){
            if (i % maxContainersCount == 0 && i > 0){
                cars++;
            }
        }
        return cars;
    }
    public static int boxesCount(){
        int boxes = new Scanner(System.in).nextInt();
        return boxes;
    }
}

