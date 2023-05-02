import java.util.Objects;

public record Disk(String type, int space, double weight) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Disk) obj;
        return Objects.equals(this.type, that.type) &&
                this.space == that.space &&
                Double.doubleToLongBits(this.weight) == Double.doubleToLongBits(that.weight);
    }

    @Override
    public String toString() {
        return "Disk[" +
                "type=" + type + ", " +
                "space=" + space + ", " +
                "weight=" + weight + ']';
    }

}
