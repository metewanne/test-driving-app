public class CarModel {

    private String carModelName;
    private int mileage;


    public CarModel() {
    }

    public CarModel(String carModelName, int mileage) {
        this.carModelName = carModelName;
        setMileage(mileage);
    }


    public CarModel(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarModel() {
        return carModelName;
    }


    public void setCarModelName(String carModelName){
        this.carModelName = carModelName;
    }

    public String getCarModelName(){
        return carModelName;
    }


    public static void main(String[] args){

    }

//    public String toString() {
//        return getCarModel();
//    }


    @Override
    public String toString() {
        return "model='" + carModelName + '\'' +
                ", mileage=" + mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getMileage(){
        return mileage;
    }

}
