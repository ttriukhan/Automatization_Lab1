public abstract class Circle {

    protected int radius;
    protected String color;

    public Circle(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return color + " circle of radius " + radius;
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

}
