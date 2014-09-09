public interface Set {

    // Manipulate contents

    public abstract void add(Object element);
    public abstract void remove(Object element);
    public abstract void replaceSet(Set set);

    // Get information

    public abstract Boolean empty();
    public abstract Boolean equals(Set set);
    public abstract Boolean isSubsetOf(Set set);
    public abstract Boolean containsElement(Object element);

    // Construct new sets

    public abstract Set getUnion(Set set);
    public abstract Set getIntersection(Set set);
    public abstract Set getSetDifference(Set sebB);

    // Misc

    public abstract Object[] toArray();
    public abstract void printElements();
    public abstract String toString();

}