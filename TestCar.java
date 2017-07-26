public class TestCar {
    public static void main (String[] args) {
        String c = "pink";
        Car car = new Car();
        car.setColour(c); //will this work!
        System.out.println(car.getColour());
        car.setColour("red"); //will this work!
        System.out.println(car.getColour());
    }
}
