import java.util.Objects;

public class CarModel {

    private String carModelName;
    private int mileage;
    private double price;
    private int year;
    private String brand;


    public CarModel() {
    }

    public CarModel(String carModelName, int mileage, double price, int year) {
        this.carModelName = carModelName;
        setMileage(mileage);
        setPrice(price);
        this.year = year;
    }

    public CarModel(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarModel() {
        return carModelName;
    }


    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getMileage() {
        return mileage;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return Objects.equals(carModelName, carModel.carModelName);
    }

    @Override
    public String toString() {
        return "model: " + carModelName +
                ", mileage: " + mileage +
                ", year: " + year +
                ", price: £" + price;
    }
}
