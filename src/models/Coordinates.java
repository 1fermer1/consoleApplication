package models;

public class Coordinates {
    private long x;
    private Integer y; // Значение поля должно быть больше -807, Поле не может быть null



    public long getX() {
        return x;
    }
    public Integer getY() {
        return y;
    }

    public void setX(long x) {
        this.x = x;
    }
    public void setY(Integer y) {
        this.y = y;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinates c = (Coordinates) obj;
        return c.x == this.x && (c.y).equals(this.y);
    }
    @Override
    public int hashCode() {
        return y.hashCode() + (int)x;
    }
    @Override
    public String toString() {
        return "Coordinates: {\n\t\tx: " + x + ",\n\t\ty: " + y + "\n\t\t}";
    }
}
