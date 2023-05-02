import java.util.Objects;

public record Monitor(int diagonal, String type, double weight) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Monitor) obj;
        return this.diagonal == that.diagonal &&
                Objects.equals(this.type, that.type) &&
                Double.doubleToLongBits(this.weight) == Double.doubleToLongBits(that.weight);
    }

    @Override
    public String toString() {
        return "Monitor[" +
                "diagonal=" + diagonal + ", " +
                "type=" + type + ", " +
                "weight=" + weight + ']';
    }

}
