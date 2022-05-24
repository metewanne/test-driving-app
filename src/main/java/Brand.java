import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Brand {

    private String brandName;

    public Brand() {
    }

    public Brand(String brandName){
        this.brandName = brandName;
    }

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

    public static void printBrands(List<String> brands) {
        for(String brand : brands){
            System.out.println(brand);
        }
    }
}
