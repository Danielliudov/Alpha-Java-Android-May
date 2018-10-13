package good;

public class BrandBBoiler extends Boiler {
    @Override
    public void initializeDevice() {
        /*use API BrandB*/
    }

    @Override
    public double getWaterTemperature() {/*use API BrandA*/
        return 0;
    }

    @Override
    public void heatWater() {
        /*use API BrandB*/
    }
}
