# Exercise 19: Method Argument Validation

> Let's train method argument validation with the help of the IllegalArgumentException. The excercise layout shows two classes Person and Calculator. Change the class in the following way:

## Exercise 19.1: Person Validation
> The constructor of Person has to make sure its parameter's Name variable is not null, empty, or longer than 40 characters. The age has also to be between 0-120. If one of the conditions above are not satisfied, the constructor has to throw an IllegalArgumentException.

## Exercise 19.2: Calculator Validation
> The Calculator methods have to be changed in the following way: the method multiplication has to work only if its parameter is not negative (greater than or equal to 0). The method binomialCoefficient has to work only if the parameters are not negative and the size of a subset is smaller than the set's size. If one of the methods receives invalid arguments when they are called, they have to throw a IllegalArgumentException.
