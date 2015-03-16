// Meta elements?

public abstract class Set {

    // Get information

    public abstract Boolean empty();
    public Boolean equals(Set set) {
        return isSubsetOf(set) && set.isSubsetOf(this);
    }
    public abstract Boolean isSubsetOf(Set set);
    public abstract Boolean containsElement(Object element);
    public abstract Boolean finite();
    public abstract Object[] toArray(); //throw error if invalid

    // Misc
    public abstract String toString();

    public void print() {
        System.out.println(toString());
    }

}