import java.util.Objects;

public record CPU(int frequency, int coreNumbers, String vendor, double weight) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CPU) obj;
        return this.frequency == that.frequency &&
                this.coreNumbers == that.coreNumbers &&
                Objects.equals(this.vendor, that.vendor) &&
                Double.doubleToLongBits(this.weight) == Double.doubleToLongBits(that.weight);
    }

    @Override
    public String toString() {
        return "CPU[" +
                "frequency=" + frequency + ", " +
                "coreNumbers=" + coreNumbers + ", " +
                "vendor=" + vendor + ", " +
                "weight=" + weight + ']';
    }

}
