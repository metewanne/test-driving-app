import java.util.ArrayList;

public class Brand {

    private String brandName;
    private ArrayList<CarModel> carModelList;

    public Brand() {
    }

    public Brand(String brandName){
        this.brandName = brandName;
    }

    public Brand(String brandName, ArrayList<CarModel> carModelList) {
        this.brandName = brandName;
        this.carModelList = carModelList;
    }

    //Brand variable
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public ArrayList<CarModel> getCarModelList() {
        return carModelList;
    }

    public void setCarModelList(ArrayList<CarModel> carModelList) {
        this.carModelList = carModelList;
    }

    public String toString(){
       return getBrandName() + " " + getCarModelList();
    }

    //     void printCarModels() {
//
//     for (CarModel c : this.carModelList) {
//          System.out.println(c);
//      }
//     }
}
