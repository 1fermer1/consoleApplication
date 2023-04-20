package models;

import java.time.ZonedDateTime;

public class Route {
    private int id; // Значение поля должно быть больше 0, Значение этого поля должно быть уникальным,
                    // Значение этого поля должно генерироваться автоматически
    private String name; // Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; // Поле не может быть null
    private ZonedDateTime creationDate; // Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; // Поле может быть null
    private Location to; // Поле может быть null
    private int distance; // Значение поля должно быть больше 1



    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }
    public Location getFrom() {
        return from;
    }
    public Location getTo() {
        return to;
    }
    public int getDistance() {
        return distance;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public void setFrom(Location from) {
        this.from = from;
    }
    public void setTo(Location to) {
        this.to = to;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Route r = (Route)obj;
        return (r.name).equals(this.name) && (r.coordinates).equals(this.coordinates)
                && (r.creationDate.toLocalDate()).equals(this.creationDate.toLocalDate()) && (r.from).equals(this.from)
                && (r.to).equals(this.to) && r.distance == this.distance;
    }
    @Override
    public int hashCode() {
        return id + name.hashCode() + coordinates.hashCode() + creationDate.toLocalDate().hashCode()
                + from.hashCode() + to.hashCode() + distance;
    }
    @Override
    public String toString() {
        return "Route: {\n\tid: " + id + ",\n\tname: " + name + ",\n\tcoordinates: " + coordinates
                + ",\n\tcreationDate: " + creationDate.toLocalDate() + ",\n\tfrom: " + from + ",\n\tto: " + to
                + ",\n\tdistance: " + distance + "\n\t}";
    }
    // TODO: @Override CompareTo
}
