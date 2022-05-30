package application;

import java.util.Random;

// Exercise 20: Sensors and Temperature Measurement
// Exercise 20.2: Thermometer
public class Thermometer implements Sensor {
	private boolean onOff;
	private Random random;
	
	public Thermometer() {
		this.onOff = false;
		this.random = new Random();
	}
	
	@Override
	public int measure() {
		// returns the sensor reading if the sensor is on
        // if the sensor is off, it throws an IllegalStateException
		if (this.onOff) {
			int ranNum = this.random.nextInt(61) - 30;
			return ranNum;
		} else {
			throw new IllegalStateException("Thermometer is off, switch on and try again!");
		}
	}

	@Override
	public boolean isOn() {
		if (this.onOff) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void on() {
		this.onOff = true;
	}

	@Override
	public void off() {
		this.onOff = false;
	}
}
