package bad;

public class BrandCBoiler extends Boiler {

    public double getDesirableTemperature() {
        // receiving desirable temperature from BrandCBoiler
        return 0;
    }

    public void setDesirableTemperature(double desirableTemperature) {
        // setting desirable temperature to BrandCBoiler
    }

    @Override
    public void initializeDevice() {
        /*use API BrandC*/
    }

    @Override
    public double getWaterTemperature() {/*use API BrandA*/
        return 0;
    }

    @Override
    public void heatWater() {
        /*use API BrandC*/
    }
}
