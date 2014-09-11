// Meta elements?

public interface Set {

    // Get information

    public abstract Boolean empty();
    public abstract Boolean equals(Set set);
    public abstract Boolean isSubsetOf(Set set);
    public abstract Boolean containsElement(Object element);

    // Construct new sets

    public abstract Set getUnion(Set set);
    public abstract Set getUnion(Object elementInSet);
    public abstract Set getIntersection(Set set);
    public abstract Set getSetDifference(Set set);
    public abstract Set getSetDifference(Object elementInSet);

    // Misc

    public abstract Object[] toArray();
    public abstract void printElements();
    public abstract String toString();

}