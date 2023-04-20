package models;

public class Location {
    private Double x; // Поле не может быть null
    private Double y; // Поле не может быть null
    private String name; // Строка не может быть пустой, Поле может быть null



    public Double getX() {
        return x;
    }
    public Double getY() {
        return y;
    }
    public String name() {
        return name;
    }

    public void setX(Double x) {
        this.x = x;
    }
    public void setY(Double y) {
        this.y = y;
    }
    private void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Location l = (Location) obj;
        return (l.x).equals(this.x) && (l.y).equals(this.y) && (l.name).equals(this.name);
    }
    @Override
    public int hashCode() {
        return x.hashCode() + y.hashCode() + name.hashCode();
    }
    @Override
    public String toString() {
        return "Location: {\n\t\tname: " + name + ",\n\t\tx: " + x + ",\n\t\ty: " + y + "\n\t\t}";
    }
}