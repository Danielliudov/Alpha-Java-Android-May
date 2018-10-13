package good;

public class BrandCBoiler extends Boiler {
    @Override
    public void initializeDevice() {
        /*use API BrandC for init*/
        //pass required temperature from this.getDesirableTemperature() to API
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
