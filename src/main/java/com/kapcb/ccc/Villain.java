public class Villain {
    private String name;

    protected void set(String name) {
        this.name = name;
    }

    public Villain(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "I am a Villain and my name is " + name;
    }
}
