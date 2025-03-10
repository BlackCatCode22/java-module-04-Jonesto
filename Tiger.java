public class Tiger extends Animal {
    private boolean isWhite;

    public Tiger(String name, int age, boolean isWhite) {
        super(name, age, "Tiger");
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    @Override
    public String uniqueFeature() {
        return isWhite ? "White tiger." : "Regular tiger.";
    }
}
