class GoodDog {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int s) {
        size = s;
    }

    void bark() {
        if (size > 60) {
            System.out.println(" Woof, woof");
        } else {
            System.out.println("chip chip");
        }
    }
}
