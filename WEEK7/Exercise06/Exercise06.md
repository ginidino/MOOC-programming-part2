# Exercise 6 is about Promissory Note
    Create the class PromissoryNote with the following functionality:
     - the constructor public PromissoryNote() creates a new promissory note
     - the method public void setLoan(String toWhom, double value) which stores the information about loans to specific people.
     - the method public double howMuchIsTheDebt(String whose) which returns the entity of the debt held by the parameter person

  The class can be used in the following way:
  
```java
PromissoryNote mattisNote = new PromissoryNote();
mattisNote.setLoan("Arto", 51.5);
mattisNote.setLoan("Mikael", 30);

System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
System.out.println(mattisNote.howMuchIsTheDebt("Joel"));
```        

 The example above would print:
 ```
51.5
0
``` 

    Be careful in a situation where you ask for the debt of a person who hasn't got debts.   

    Attention! The promissory note does not need to take into account old loans. 
    When you set a new debt to a person who has an old one, the old one is canceled.
    
```java
PromissoryNote mattisNote = new PromissoryNote();
mattisNote.setLoan("Arto", 51.5);
mattisNote.setLoan("Arto", 10.5);

System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
```    
  * output     
```       
10.5
```
