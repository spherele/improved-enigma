public class Elevator {
    int currentFloor = 1;
    int minFloor;
    int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public void moveDown(){
        currentFloor--;
    }
    public void moveUp(){
        currentFloor++;
    }
    public void move (int floor) throws InterruptedException {
        if (floor <= maxFloor && floor >= minFloor) {
            if (floor > currentFloor){
                System.out.println(getCurrentFloor());
                while (currentFloor < floor){
                    if (currentFloor == -1) {currentFloor++;}
                    moveUp();
                    Thread.sleep(1000);
                    System.out.println(currentFloor);
                }
            } else if (floor < currentFloor){
                System.out.println(getCurrentFloor());
                while (currentFloor > floor){
                    if (currentFloor == 1) {currentFloor--;}
                    moveDown();
                    Thread.sleep(1000);
                    System.out.println(currentFloor);
                }
            }
        }
    }
}
