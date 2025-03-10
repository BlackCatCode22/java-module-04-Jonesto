public class Hyena extends Animal {
    private boolean isSpotted;

    public Hyena(String name, int age, boolean isSpotted) {
        super(name, age, "Hyena");
        this.isSpotted = isSpotted;
    }

    public boolean isSpotted() {
        return isSpotted;
    }

    public void setSpotted(boolean spotted) {
        this.isSpotted = spotted;
    }

    @Override
    public String uniqueFeature() {
        return isSpotted ? "Has spotted fur." : "Plain fur.";
    }
}
