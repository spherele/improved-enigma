public class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU(6000, 16, "Ryzen 9 7950X", 0.1);
        RAM ram = new RAM("DDR5", 32768, 0.2);
        Disk disk = new Disk("SSD", 2000, 0.2);
        Monitor monitor = new Monitor(25, "IPS", 9.4);
        Keyboard keyboard = new Keyboard("Mechanical", true, 0.8);

        PC pc = new PC(cpu, monitor, ram, disk, keyboard);
        pc.print();
    }
}
