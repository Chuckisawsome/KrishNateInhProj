public class Eat extends Customer {
    private String sauce;

    public Eat(int m, int h, String n, int a, String f, String s) {
        super(m, h, n, a, f);
        sauce = s;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String dip) {
        sauce = dip;
    }

    public void eatFood() {
        System.out.println(getName() + " ate their " + getFood() + " with " + sauce + " sauce!");
        setHunger(getHunger() - 5);
    }
}
