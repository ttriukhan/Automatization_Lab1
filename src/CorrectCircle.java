import java.util.Objects;

/*
3) Створити 2 власні класи з визначеними equals() i hashCode().
Один з них має коректні функції, другий некоретні(equals завжди true або false, hash не відповідає принципам).
Продемонструвати поведінку і результат через сценарій у main методі з використанням HashMap.
 */

public class CorrectCircle extends Circle {

    public CorrectCircle(int radius, String color) {
        super(radius, color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return (radius == ((CorrectCircle) o).getRadius() && color.equals(((CorrectCircle) o).getColor()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, color);
    }

}
