
public enum BrandTypes {
    BMW("bmw"),
    TESLA("tesla"),
    MERCEDES("mercedes"),
    AUDI("audi"),
    FERRARI("ferrari"),
    PORSCHE("porsche");

    private String name;


    BrandTypes(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}

//EnumMap<BrandTypes, String> carBrands


