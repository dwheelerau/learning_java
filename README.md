## Learning Java from the head first book  

Each chapter is a branch, with c1 -chapter 1 etc.  

To install the jdk use the following:  
`apt-get install default-jdk`  

To compile:  
`javac MyFile.java`  

To run:  
`java MyFile`  

### Syntax examples and OOP concepts
#### Ecapsulation  
Data types (classes) are only modified by their own methods. Other objects use
interfaces (which act like contracts) to interact with other objects.  

**Getters and setters**  
```java
class GoodDog {
    //private field (ie instance variable/data member of a class)
    private int size;
    // getter
    public int getSize() {
        return size;
    }
    //setter
    public void setSize(int s) {
        size = s;
    }
}

class GoodDogTester {

    public static void main(String[] args) { //command line params
        GoodDog fred = new GoodDog();
        fred.setSize(5);
        System.out.println(fred.getSize());
    }
}
```
### Inheritance and polymorphism   
Use inheritance with great caution and some new languages restrict its usage.  

Animal is a superclass of Mammal. Mammal is a subclass or child of Animal. If
Mammal inherits from Animal then it inherits all its methods and fields.
Subclasses can *override* superclass methods, this usually occurs when you want
to make the method more specific for the subclass. If you override a method
then you need to stick to the contract, that is the subclass method must return
the same type and the arguments must be the same, in otherwords to the outside
world these two methods behave the same.   

```java
class Animal {
    String colour;

    public int getColour() {
        return colour;
    }
    //setter
    public void setColour(int s) {
        colour = s;
    }
    public void makeNoise(String noise) {
        System.out.println(noise);
    }
}

class Mammal extends Animal {
    // inheritance
    setColour("red");
    // override takes same arguments returns same type but more specilised
    public void makeNoise(String noise) {
        System.out.println("bark " + noise);
    }
}

```
#### Is-A  
Use inheritance when the *is-a* rule applies. Unicycle is-a Bike.  Mammal is-a
Animal.  

#### Has-A  
Use *composition* when they have *has-a* relationship.  Bike has-a Wheel, a
bike is composed of [2] wheels.  

#### Polymorphism  
Using a reference declared as a superclass to access a subclass.  

In the below example, in every place you would expect a Mammal object you can
use the Hamster; m is still a reference to a Mammal and only has access to
Mammal methods (think of the remote control being the reference type). The
example below is a case of *up casting* and this can happen by default. If you
want to *down cast* you need to explicitly do this (see second example).  
```java
// example of up cast
Hamster h = new Hampster();
Mammal m = h; // Mammal reference to a Hamster subclass

//example of down cast
Mammal m = new Mammal();
Hamster h = (Hamster) m; //cast it to a Hamster
```
You can't cast a Dog into a Tree, they need to be part of the same inheritance
tree.

#### Overloading methods  
Simple means that you have multiple methods with the same name, but each takes
a different list of paramaters (the return type can be anything).  The type and
order of paramaters is how the compiler knows which method to implement. This
is in contrast to *override* where the paramaters and return type must match
the superclass method.  

#### Interface and abstract classes  
Abstract classes should never be *Instantiated* (ie Animal a = new Animal();).
Abstract classes must be extended, and abstract methods must be overriden. This
is like a contract again, we can use abstract classes and methods to set up
interfaces that enforce a certain type of behaviour.  

```java
// example abstract  
abstract class Canine extends Animal {
    public void roam() {}
}
// example interface
public interface Pet {
    public abstract void beFriendly(); // abstract methods have no body
    public abstract void play(); // abstract methods have no body
}

public class Dog extends Canine implements Pet {
    public abstract void beFriendly(){ //code }// must override  
    public abstract void play(){//code} // must override
}
```
#### Static methods  
Used for methods that act like functions, you don't need to Instantiate the
class to use it.  

```java
// static method in Math class
public static int min(int a, int b) {
    //returns less of a and b
}
//call static method using the class name rather than reference variable.  
Math.min(43,31);
```
*Static methods* can only use static variables or ie you can't use instance
varables or instance methods because the compliler does not know what object
you are referring too. In the case of a *static varible* its value will be the
same for all instances of that class. 

```java
public static int value = 1;
public static final int names = 1;
```
You can also mark methods as *final* as well if you don't want them to be
overriden. 

## Some notes from the book 

### Chapter 2  

-  Look for features that all classes have in common and *abstract* these out to
  a new class.  
-  Parent class is called the *superclass* and children are *subclasses*  
-  If you need specilised behaviour in a function you can *override* the method
   in question.  
-  Things that an object *knows* are *instance variable*, which repressent the
   objects *state*.   
-  Things that an object *does* are *methods*.  
-  A *class* is a blueprint for an *object*. 

#### Creating objects

-  Use the syntax `Dog d = new Dog();` to create a Dog instance.  
-  You can access the instance variable using the dot `d.size = 40`.  
 

### Chapter 3

#### Primatives
**b**oolean **c**har **b**byte **s**hort **i**nt **f**loat **d**ouble.  
Be Careful bears Shouldnt Ingest Large Furry Dogs.  

#### Non primatives ie objects
There is no such thing as an object variable, just a reference to an object.
Think of an object reference as a remote control. In other words `Dog d = new
Dog();`, the reference variable `d` is a Dog remote control.  You use the
remote to get access to the object and make it do things.

Declare a reference variable: `Dog myDog;`  
Create a Dog object: `new Dog()`  
Link the object to a reference: `Dog myDog = new Dog();`  

 #### Arrays
Declare: `int[] nums;`  
Create new array: `nums = new int[7];`  
Assign: `nums[0] = 6;`  
Assign: `nums[1] = 8;`  

In this case the array object is holding primatives (ints), but they equally
could hold references ie `Dog pets;` and `pets[7] = new Dog[7]`, but remember this is just holding
a reference too a Dog, and not a Dog object (these are created elsewhere) ie
`pets[0] = new Dog();`.  Another way to do this is `Dog[] myDogs = new Dog[3]`
and then to add a Dog to teh array `myDogs[0] = new Dog();`.  


### Chapter 4  

State effects behavour, behaviour affects state. Method make use of instance
variables so that a instance of an object can behave in a specific kind of way.  

We can pass things to methods.  **A method uses parameters. A caller passes
arguments**.  

They have the following syntax: `void bark(int numOfBarks) {//do something}`.  
Likewise a method can return with the following syntax: `int giveSecret() {
return 42;}`. When we use this method we would: `int theSecret =
life.giveSecret();`. Note that the reference varibale *type* and the return
type of the method are match.  

#### Getters and setters (Accessors and Mutators)  
A *setters* job is to set an instance varibale, and a *getters* job is to
return that varible. This relates to encapsulation, that is not exposing your
data.  In otherwords we should not be able to do `Dog.name = "fido";`. By
forcing the programer to use a setter method we can control the changes that
are allowed to the instance variable. What we aim to do is make all instance
varibale *private* and use *public* getters and setters.  

Instance variables are declared inside a class but not whitn a method. Local
variables are declared within a method, and they must be initilized before they
are used  (these won't compile).  

### Inheritance  
public class Child extends Parent {}  

#### IsA and HasA  
Triangle IsA Shape  
Cat IsA Feline  
Tub ~~IsA~~ Bathroom  

If IsA works then it makes sense to inherit from a parent. Note that the IsA
only works in one direction.  Think of IsA relationships as more specific types
of an object, a cat is a more specific type of feline.    
In contrast:
Bathroom HasA Tub  
As the HasA works in this case then Bathroom has a reference to a Tub instance
var, but Bathroom does not extend Tub and *visa versa*.  A batheroom or a tub
are not more specilised versions of each other.   

`class Cat extends Feline {}`  
`class Bathroom {
    Tub tub = new Tub();
}`

If members are marked private they are not inherited.

#### The contract  
All subclasses of a superclass inherit methods from the same place, in
otherword all the members of the inheritance tree esablish a contract; a
protocol that all subtypes use.  

A subclass can override a superclass method, but the arguments the method takes and the return type must be the same (or at least compatible), this ensures that the subclass obayes the contract.  The access level must also be compatible, you can't override a superclass method with a private method if the superclass method is public.    

#### Polymorphism  
`Dog fido = new Dog();` 
#### using polymorhphism we can use an Animal reference for a Dog.  
`Animal fido = new Dog();`  
 
This is useful because an Animal array can hold all subclass objects. You can
also use this for arguments in methods, so the methods can take a range of
subobjects of the superclass.  

`
class Vet {  
public void giveShot(Animal a) {  
    //do something}  
}`  
`Vet v = new Vet();`  
`Dog d = new Dog();`  
`Hippo h = new Hippo();`  
`v.giveShot(d);`  
`v.giveShot(h);`  


What this means is that if you write a class using high level types then you
can make use of these methods simply by inheriting from the high level class.  

### Method overloading
This is not the same as polymorphism, all it is is providing multiple methods with the same name that take different argument lists. If only the return type changes the compiler will assume you are trying to override a method, and this will probably be illegal due to the return type contract requirment for overriding methods, thus the rule for overloading is that the arguments (what out pass) MUST be different (you can do what-ever to the return type).  

## Serious polymorphism  
### Interfaces  
Interfaces are 100% abstract classes. Abstract classes can't be instantiated.  In the case of our animal tree, the animal superclass sets the common protocol for all subclass animals that inherit it. 
