public class Car {

    private String carModel;

    public Car(String carModel) {
        this.carModel = carModel;
    }

    public Car() {
    }

    public String getCarModel() {
        return carModel;
    }

    public static void main(String[] args){

    }
    public String toString() {
        return getCarModel();
    }

}
