class Dog {
    String name;
    public static void main (String[] args) {

        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Bart";

        Dog[] myDogs = new Dog[3];

        //create references for Dog objects
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        myDogs[0].name = "fred";
        myDogs[1].name = "Marge";

        System.out.println(" last dogs name is ");
        System.out.println(myDogs[2].name);

        int x = 0;
        while(x< myDogs.length) {
            myDogs[x].bark();
            x = x + 1;
        }
    }

    public void bark() {
        System.out.println(name + " says ruff");
    }
}
