import java.util.EnumMap;

public enum BrandTypes {
    BMW("Bmw"),
    TESLA("Tesla"),
    MERCEDES("Mercedes"),
    AUDI("Audi"),
    FERRARI("Ferrari"),
    PORSCHE("Porsche");

    private String name;


    BrandTypes(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}

//EnumMap<BrandTypes, String> carBrands


