## Learning Java from the head first book  

Each chapter is a branch, with c1 -chapter 1 etc.  

To install the jdk use the following:  
`apt-get install default-jdk`  

To compile:  
`javac MyFile.java`  

To run:  
`java MyFile`  

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



 

