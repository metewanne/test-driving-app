import java.util.ArrayList;
import java.util.Objects;

public class Brand {

    private String brandName;
    //private ArrayList<CarModel> carModelList;

    public Brand() {
    }

    public Brand(String brandName){
        this.brandName = brandName;
    }

//    public Brand(String brandName, ArrayList<CarModel> carModelList) {
//        this.brandName = brandName;
//        //this.carModelList = carModelList;
//    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    //Brand variable
    public String getBrandName() {
        return brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(brandName, brand.brandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandName);
    }

    //
//    public void setCarModelList(ArrayList<CarModel> carModelList) {
//        this.carModelList = carModelList;
//    }
//
//    public ArrayList<CarModel> getCarModelList() {
//        return carModelList;
//    }


//    public String toString(){
//       return getBrandName() + " " + getCarModelList();
//    }

    //     void printCarModels() {
//
//     for (CarModel c : this.carModelList) {
//          System.out.println(c);
//      }
//     }
}
