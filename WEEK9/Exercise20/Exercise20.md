# Exercise 20: Sensors and Temperature Measurement

All the code in our application has to be placed into the package application.

  We have got the following interface available for our use:
```java
public interface Sensor {
    boolean isOn();  // returns true if the sensor is on
    void on();       // switches the sensor on
    void off();      // switches the sensor off
    int measure();   // returns the sensor reading if the sensor is on
                     // if the sensor is off, it throws an IllegalStateException
}
```
 
## Exercise 20.1: Constant Sensor
Create the class Constant Sensor which implements the interface Sensor.

The constant sensor is online all the time. The methods on() and off() do not do anything. The constant sensor has a constructor with an int parameter. The measure method call returns the number received as constructor parameter.

For instance:
```java
public static void main(String[] args) {
  ConstantSensor ten = new ConstantSensor(10);
  ConstantSensor minusFive = new ConstantSensor(-5);

  System.out.println( ten.measure() );
  System.out.println( minusFive.measure() );

  System.out.println( ten.isOn() );
  ten.off();
  System.out.println( ten.isOn() );
}
```     
Prints:
```
10
-5
true
true
```      
## Exercise 20.2: Thermometer
Create the class Thermometer which implements the interface Sensor.

At first, the thermometer is off. When the measure method is called, if the thermometer is on it returns a random number between -30 and 30. If the thermometer is off, it throws an IllegalStateException.

## Exercise 20.3: AverageSensor
Create the class AverageSensor which implements the interface Sensor.

An average sensor contains many sensors. In addition to the methods defined by the interface Sensor, the class has the method public void addSensor(Sensor additional) which adds a new sensor to the AverageSensor.

The average sensor is on when all its sensors are on. When the average sensor is switched on, all its sensors have to be switched on if they were not on already. When the average sensor is closed, at least one of its sensors has to be switched off. It's also possible that all its sensors are switched off.

The measure method of our AverageSensor returns the average of the readings of all its sensors (because the return value is int, the readings are rounded down as it is for integer division). If the measure method is called when the average sensor is off, or if the average sensor was not added any sensor, the method throws an IllegalStateException.

Below, you find an example of a sensor program (note that both the Thermometer and the AverageSensor constructors are without parameter):
```java
public static void main(String[] args) {
    Sensor kumpula = new Thermometer();
    kumpula.on();
    System.out.println("the temperature in Kumpula is "+kumpula.measure() + " degrees");

    Sensor kaisaniemi = new Thermometer();
    Sensor helsinkiVantaa = new Thermometer();

    AverageSensor helsinkiArea = new AverageSensor();
    helsinkiArea.addSensor(kumpula);
    helsinkiArea.addSensor(kaisaniemi);
    helsinkiArea.addSensor(helsinkiVantaa);

    helsinkiArea.on();
    System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");
}
```
Prints (the printed readings depend on the random temperature readings):
```
the temperature in Kumpula is -7 degrees
the temperature in Helsinki area is -10 degrees
Note: you'd better use a ConstantSensor object to test your average sensor!
```
## Exercise 20.4: All Readings
Add the method public List<Integer> readings() to your AverageSensor; it returns a list of the reading results of all the measurements executed through your AverageSensor. Below is an example of how the method works:
  
```java
public static void main(String[] args) {
    Sensor kumpula = new Thermometer();
    Sensor kaisaniemi = new Thermometer();
    Sensor helsinkiVantaa = new Thermometer();

    AverageSensor helsinkiArea = new AverageSensor();
    helsinkiArea.addSensor(kumpula);
    helsinkiArea.addSensor(kaisaniemi);
    helsinkiArea.addSensor(helsinkiVantaa);

    helsinkiArea.on();
    System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");
    System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");
    System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");

    System.out.println("readings: "+helsinkiArea.readings());
}
```
  
Prints (again, the printed readings depend on the random temperature readings):
```
the temperature in Helsinki area is -10 degrees
the temperature in Helsinki area is -4 degrees
the temperature in Helsinki area is -5 degrees

readings: [-10, -4, 5]
```
