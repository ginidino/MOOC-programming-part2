package application;

// Exercise 20: Sensors and Temperature Measurement
// Exercise 20.1: Constant Sensor
public class ConstantSensor implements Sensor {
	private int parameter;
	
	public ConstantSensor(int parameter) {
		this.parameter = parameter;
	}
	
	@Override
	public int measure() {
		// returns the sensor reading if the sensor is on
        // if the sensor is off, it throws an IllegalStateException
		return this.parameter;
	}

	@Override
	public boolean isOn() {
		// returns true if the sensor is on
		return true;
	}

	@Override
	public void on() {
		// switches the sensor on
	}

	@Override
	public void off() {
		// switches the sensor off
	}
}
