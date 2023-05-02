public class PC {
    CPU cpu;
    Monitor monitor;
    RAM ram;
    Disk disk;
    Keyboard keyboard;

    public PC(CPU cpu, Monitor monitor, RAM ram, Disk disk, Keyboard keyboard) {
        this.cpu = cpu;
        this.monitor = monitor;
        this.ram = ram;
        this.disk = disk;
        this.keyboard = keyboard;
    }

    public void print(){
        System.out.println(
                "Процессор: " + cpu.vendor() + " с частотой " + cpu.frequency() + " МГц, кол-во ядер: " + cpu.coreNumbers() + " " + " " + cpu.weight() + "\n" +
                        "Оперативная память: " + ram.type() + " " + ram.space() + " Гб " + ram.weight() + "\n" +
                        "Диск: " + disk.type() + " " + disk.space() + " Гб " + disk.weight() + "\n" +
                        "Монитор: " + monitor.type()  + " " + monitor.diagonal() + " дюймов " + monitor.weight() + "\n" +
                        "Клавиатура: " + keyboard.type() + " " + keyboard.isBacklight() + " " + keyboard.weight()
        );
    }
}