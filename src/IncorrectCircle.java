/*
3) Створити 2 власні класи з визначеними equals() i hashCode().
Один з них має коректні функції, другий некоретні(equals завжди true або false, hash не відповідає принципам).
Продемонструвати поведінку і результат через сценарій у main методі з використанням HashMap.
 */
public class IncorrectCircle extends Circle {

    public IncorrectCircle(int radius, String color) {
        super(radius, color);
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 42;
    }

}
