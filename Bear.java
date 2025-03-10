public class Bear extends Animal {
    private boolean isHibernating;

    public Bear(String name, int age, boolean isHibernating) {
        super(name, age, "Bear");
        this.isHibernating = isHibernating;
    }

    public boolean isHibernating() {
        return isHibernating;
    }

    public void setHibernating(boolean hibernating) {
        isHibernating = hibernating;
    }

    @Override
    public String uniqueFeature() {
        return isHibernating ? "Is currently hibernating." : "Is awake and active.";
    }
}
