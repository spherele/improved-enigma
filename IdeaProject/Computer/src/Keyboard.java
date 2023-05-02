import java.util.Objects;

public record Keyboard(String type, boolean backlight, double weight) {

    public String isBacklight() {
        return backlight ? "Да" : "Нет";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Keyboard) obj;
        return Objects.equals(this.type, that.type) &&
                this.backlight == that.backlight &&
                Double.doubleToLongBits(this.weight) == Double.doubleToLongBits(that.weight);
    }

    @Override
    public String toString() {
        return "Keyboard[" +
                "type=" + type + ", " +
                "backlight=" + backlight + ", " +
                "weight=" + weight + ']';
    }

}
