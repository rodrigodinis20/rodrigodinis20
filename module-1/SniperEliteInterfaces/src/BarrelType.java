public enum BarrelType {
    PLASTIC(40, "Plastic"),
    WOOD(70, "Wood"),
    METAL(100, "Metal");

    private int maxDamage;
    private String material;

    BarrelType(int maxDamage, String material){
        this.maxDamage = maxDamage;
        this.material = material;
    }

    public int getMaxDamage () {
        return maxDamage;

    }

    @Override
    public String toString() {
        return material;
    }
}
