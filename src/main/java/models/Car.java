package models;

public class Car {
    private String location;
    private String manufacture;
    private String model;
    private String year;
    private String fuel;
    private int seats;
    private String carClass;
    private String carRegNumber;
    private double price;
    private String about;

    public String getLocation() {
        return location;
    }

    public Car setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getManufacture() {
        return manufacture;
    }

    public Car setManufacture(String manufacture) {
        this.manufacture = manufacture;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public String getYear() {
        return year;
    }

    public Car setYear(String year) {
        this.year = year;
        return this;
    }

    public String getFuel() {
        return fuel;
    }

    public Car setFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public String getCarClass() {
        return carClass;
    }

    public Car setCarClass(String carClass) {
        this.carClass = carClass;
        return this;
    }

    public int getSeats() {
        return seats;
    }

    public Car setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    public String getCarRegNumber() {
        return carRegNumber;
    }

    public Car setCarRegNumber(String carRegNumber) {
        this.carRegNumber = carRegNumber;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Car setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getAbout() {
        return about;
    }

    public Car setAbout(String about) {
        this.about = about;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "location='" + location + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", fuel='" + fuel + '\'' +
                ", seats=" + seats +
                ", carClass='" + carClass + '\'' +
                ", carRegNumber='" + carRegNumber + '\'' +
                ", price=" + price +
                ", about='" + about + '\'' +
                '}';
    }
}