package Week10;

import containers.ProductContainer;
import containers.ProductContainerRecorder;

// Exercise 30: Container
public class Exercise30 {
	public static void main(String[] args) {
		// Exercise 30.1: Product Container, Phase 1
		ProductContainer juice = new ProductContainer("Juice", 1000.0);
        juice.addToTheContainer(1000.0);
        juice.takeFromTheContainer(11.3);
        System.out.println(juice.getName()); // Juice
        System.out.println(juice);			 // volume = 988.7, free space 11.3
        System.out.println();
        
        // Exercise 30.2: Product Container, Phase 2
        ProductContainer juices = new ProductContainer("Juice", 1000.0);
        juices.addToTheContainer(1000.0);
        juices.takeFromTheContainer(11.3);
        System.out.println(juice.getName()); // Juice
        juices.addToTheContainer(1.0);
        System.out.println(juice);    		 // Juice: volume = 989.7, space 10.299999999999955
        System.out.println();
        
        // Exercise 30.6: Product Container Recorder, Phase 1
        // Exercise 30.7: Product Container Recorder, Phase 2
        // Exercise 30.8: Product Container Recorder, Phase 3
        ProductContainerRecorder juiced = new ProductContainerRecorder("Juice", 1000.0, 1000.0);
        juiced.takeFromTheContainer(11.3);
        System.out.println(juiced.getName()); // Juice
        juiced.addToTheContainer(1.0);
        System.out.println(juiced);           // Juice: volume = 989.7, free space 10.3
        // history() does not work properly, yet:
        System.out.println(juiced.history()); // [1000.0]
           // in fact, we only retrieve the original value which was given to the constructor...
        System.out.println();
        
        juiced.printAnalysis();
	}
}
