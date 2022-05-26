# Exercise 18: Moving
> Before moving, you pack your things and put them into boxes trying to keep the number of boxes needed as small as possible. In this exercise we simulate packing things into boxes. Each thing has a volume, and boxes have got a maximum capacity.

## Exercise 18.1: Things and Items
> The removers will later on move your things to a track (which is not implemented here); therefore, we first implement the interface Thing, which represents all things and boxes.
> 
> The Thing interface has to determine the method int getVolume(), which is needed to understand the size of a thing. Implement the interface Thing in the package moving.domain.
> 
> Next, implement the class Item in the package moving.domain. The class receives the item name (String) and volume (int) as parameter. The class has to implement the interface Thing.
> 
> Add the method public String getName() to Item, and replace the method public String toString() so that it returns strings which follow the pattern "name (volume dm^3)". Item should now work like the following

```java
Thing item = new Item("toothbrash", 2);
System.out.println(item);
```
  output
```
toothbrash (2 dm^3)
``` 

## Exercise 18.2: Comparable Item
> When we pack our items into boxes, we want to start in order from the first items. Implement the interface Comparable in the class Item; the item natural order must be ascending against volume. When you have implemented the interface Comparable, the sort method of class Collection has to work in the following way:.
```java
List<Item> items = new ArrayList<Item>();
items.add(new Item("passport", 2));
items.add(new Item("toothbrash", 1));
items.add(new Item("circular saw", 100));

Collections.sort(items);
System.out.println(items);
```
```
[toothbrash (1 dm^3), passport (2 dm^3), circular saw (100 dm^3)]
```
## Exercise 18.3: Moving Box
> Implement now the class Box in the package moving.domain. At first, implement the following method for your Box:
  - the constructor public Box(int maximumCapacity)   
    - receives the box maximum capacity as parameter;   
  - the method public boolean addThing(Thing thing)   
    - adds an item which implements the interface Thing to the box. If it does not fit in the box, the method returns false, otherwise true. The box must store the things into a list.

> Also, make your Box implement the Thing interface. The method getVolume has to return the current volume of the things inside the box.

## Exercise 18.4: Packing Items
> Implement the class Packer in the package moving.logic. The constructor of the class Packer is given the parameter int boxesVolume, which determines how big boxes the packer should use.
>    
> Afterwards, implement the method public List<Box> packThings(List<Thing> things), which packs things into boxes.
>
> The method should move all the things in the parameter list into boxes, and these boxes should be contained by the list the method returns. You don't need to pay attention to such situations where the things are bigger than the boxes used by the packer. The tests do not check the way the packer makes use of the moving boxes.   

  The example below shows how our packer should work:

```java
// the things we want to pack
List<Thing> things = new ArrayList<Thing>();
things.add(new Item("passport", 2));
things.add(new Item("toothbrash", 1));
things.add(new Item("book", 4));
things.add(new Item("circular saw", 8));

// we create a packer which uses boxes whose valume is 10
Packer packer = new Packer(10);

// we ask our packer to pack things into boxes
List<Box> boxes = packer.packThings( things );

System.out.println("number of boxes: "+boxes.size());

for (Box box : boxes) {
    System.out.println("  things in the box: "+box.getVolume()+" dm^3");
}
```        
Prints:
```
number of boxes: 2
  things in the box: 7 dm^3
  things in the box: 8 dm^3
```        

> The packer has packed the things into two boxes, the first box has the firts three things, whose total volume was 7, and the last thing in the list -- the circular saw, whose volume was 8 -- has gone to the third box. The tests do not set a limit to the number of boxes used by the packer; each thing could have been packed into a different box, and the output would have been:

```
number of boxes: 4
  things in the box: 2 dm^3
  things in the box: 1 dm^3
  things in the box: 4 dm^3
  things in the box: 8 dm^3
```
  
> Note: to help testing, it would be convinient to create a toString method for the class Box, for instance; this would help printing the content of the box.
