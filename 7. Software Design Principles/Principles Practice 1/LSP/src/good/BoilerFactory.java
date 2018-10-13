package good;

public class BoilerFactory {
    public static Boiler getNextBoiler(double criteria) {
        if (criteria > 0.5)
            return new BrandABoiler();
        else
            return new BrandBBoiler();
    }
}
