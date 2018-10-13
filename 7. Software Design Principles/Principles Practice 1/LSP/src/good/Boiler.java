package good;

abstract public class Boiler {
    private double desirableTemperature;

    public double getDesirableTemperature() {
        return desirableTemperature;
    }

    public void setDesirableTemperature(double desirableTemperature) {
        this.desirableTemperature = desirableTemperature;
    }

    abstract public void initializeDevice();

    abstract public double getWaterTemperature();

    abstract public void heatWater();
}
