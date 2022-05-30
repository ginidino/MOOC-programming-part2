package application;

import java.util.ArrayList;
import java.util.List;

// Exercise 20: Sensors and Temperature Measurement
// Exercise 20.3: AverageSensor
public class AverageSensor implements Sensor {
	private List<Sensor> sensors;
	private List<Integer> reading;
	
	public AverageSensor() {
		this.sensors = new ArrayList<Sensor>();     // Exercise 20.3: AverageSensor
		this.reading = new ArrayList<Integer>();	// Exercise 20.4: All Readings
	}
	
	public void addSensor(Sensor additional) {
		// adds a new sensor to the AverageSenso
		this.sensors.add(additional);
	}
	
	@Override
	public int measure() {
		// returns the average sensor reading of all the sensors in average sensor, if the sensor is on
        // if the sensor is off, or no sensors have been added to average sensor yet, it throws an IllegalStateException
		if (this.sensors.isEmpty() || !this.isOn()) {
			throw new IllegalStateException();
		} 
		
		int sum = 0;
		
		for (Sensor sensor : this.sensors) {
			sum += sensor.measure();
		}
		
		int average = sum / this.sensors.size();
		
		this.reading.add(average);		// Exercise 20.4: All Readings
		
		return average;
	}

	@Override
	public boolean isOn() {
		// returns true if all sensors are on
		boolean allOn = false;
		
		for (Sensor sensor : this.sensors) {
			if (sensor.isOn()) {
				allOn = true;
			} else {
				allOn = false;
			}
		}
		return allOn;
	}

	@Override
	public void on() {
		for (Sensor sensor : this.sensors) {
			sensor.on();
		}
	}

	@Override
	public void off() {
		for (Sensor sensor : this.sensors) {
			sensor.off();
		}
	}
	// Exercise 20.4: All Readings
	public List<Integer> readings() {
		return this.reading;
	}
}
