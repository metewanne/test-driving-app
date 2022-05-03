public class Brand {

    private String brandName;
    private Car carName;

    public Brand() {
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Car getCarName() {
        return carName;
    }

    public void setCarName(Car carName) {
        this.carName = carName;
    }
}
