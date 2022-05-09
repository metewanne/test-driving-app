public class CarModel {

    private String carModelName;

    public CarModel(String carModelName) {
        this.carModelName = carModelName;

    }

    public CarModel() {
    }

    public String getCarModel() {
        return carModelName;
    }

    public static void main(String[] args){

    }
    public String toString() {
        return getCarModel();
    }

    public void setCarModel(String carModelName) {
        this.carModelName = carModelName;
    }

}
