public class Lion extends Animal {
    private boolean hasMane;

    public Lion(String name, int age, boolean hasMane) {
        super(name, age, "Lion");
        this.hasMane = hasMane;
    }

    public boolean hasMane() {
        return hasMane;
    }

    public void setHasMane(boolean hasMane) {
        this.hasMane = hasMane;
    }

    @Override
    public String uniqueFeature() {
        return hasMane ? "Male lion with a mane." : "Female lion without a mane.";
    }
}
