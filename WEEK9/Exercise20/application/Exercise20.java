package application;

// Exercise 20: Sensors and Temperature Measurement
public class Exercise20 {
	public static void main(String[] args) {
		// Exercise 20.1: Constant Sensor
		ConstantSensor ten = new ConstantSensor(10);
		ConstantSensor minusFive = new ConstantSensor(-5);

		System.out.println(ten.measure());
		System.out.println(minusFive.measure());

		System.out.println(ten.isOn());
		ten.off();
		System.out.println(ten.isOn());
		System.out.println();
		
		/*// Exercise 20.2: Thermometer
		Thermometer thermometer = new Thermometer();
		System.out.println(thermometer.measure());

		System.out.println(thermometer.isOn());
		thermometer.on();
		System.out.println(thermometer.isOn());
		System.out.println();*/
		
		// Exercise 20.3: AverageSensor
		Sensor incheon = new Thermometer();
		incheon.on();
	    System.out.println("the temperature in incheon is " + incheon.measure() + " degrees");

	    Sensor seoul = new Thermometer();
	    Sensor incheonAirport = new Thermometer();

	    AverageSensor seoulArea = new AverageSensor();
	    seoulArea.addSensor(incheon);
	    seoulArea.addSensor(seoul);
	    seoulArea.addSensor(incheonAirport);

	    seoulArea.on();
	    System.out.println("the temperature in seoul area is " + seoulArea.measure() + " degrees");
	    System.out.println();
	    
	    // Exercise 20.4: All Readings
	    Sensor Seoul = new Thermometer();
	    Sensor Incheon = new Thermometer();
	    Sensor IncheonAirport = new Thermometer();

	    AverageSensor SeoulArea = new AverageSensor();
	    SeoulArea.addSensor(Seoul);
	    SeoulArea.addSensor(Incheon);
	    SeoulArea.addSensor(IncheonAirport);

	    SeoulArea.on();
	    System.out.println("the temperature in Seoul area is " + SeoulArea.measure() + " degrees");
	    System.out.println("the temperature in Seoul area is " + SeoulArea.measure() + " degrees");
	    System.out.println("the temperature in Seoul area is " + SeoulArea.measure() + " degrees");

	    System.out.println("readings: " + SeoulArea.readings());
	}
}