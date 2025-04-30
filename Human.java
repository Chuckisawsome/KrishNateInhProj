public class Human{
    protected int money;
    protected int hunger;
    protected String name;
    protected int age;

    public Human (int m, int h, String n, int a){
        money = m;
        hunger = h;
        name = n;
        age = a;
    }

    public int getmoney(){
        return money;
    }
    public int getHunger(){
        return hunger;
    }
    public String getName(){
        return name;    
    }
    public int getAge(){
        return age;
    }
    public void setMoney(int cash){
        money=cash;
    }
    public void setHunger(int level){
        hunger=level;
    }
    public void setName(String n){
        name=n;
    }
    public void setAge(int old){
        age=old;
    }

}
