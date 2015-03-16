public class FiniteSet extends Set {

    Object[] elements;

    public FiniteSet() {
        elements = new Object[0];
    }

    public FiniteSet(FiniteSet set) {
        elements = set.toArray();
    }

    public FiniteSet(Object[] _elements) {
        elements = ArrayHelpers.duplicatesRemoved(_elements);
    }

    public String toString() {
        String s = "( ";
        for (int i = 0; i<elements.length; i++) {
            s += elements[i].toString();
            if (i != elements.length-1) { s += ", "; }
        }
        s += " )";
        return s;
    }

    // Manipulate contents


    // Queries about the set

    public Boolean empty() {
        return elements.length == 0;
    }

    public Boolean isSubsetOf(Set set) {
        for (Object element : elements) {
            if (!set.containsElement(element)) {
                return false;
            }
        }
        return true;
    }

    public Boolean containsElement(Object element) {
        for (Object o : elements) {
            if (o.equals(element)) { return true; }
        }
        return false;
    }

    public Boolean finite() {
        return true;
    }

    // Collection stuff

    public FiniteSet getUnion(FiniteSet set) {
        return new FiniteSet( ArrayHelpers.combinedAndDuplicatesRemoved( this.toArray(), set.toArray() ) );
    }

    public FiniteSet getUnion(Object element) {
        return getUnion( new FiniteSet(new Object[]{ element }) );
    }

    public FiniteSet getIntersection(FiniteSet set) {
        Object[] result = this.toArray();
        for (int i = 0; i<result.length; i++) {
            if (!set.containsElement(result[i])) {
                result[i] = null;
            }
        }
        return new FiniteSet(ArrayHelpers.removeNulls(result));
    }

    public FiniteSet getSetDifference(FiniteSet set) {
        Object[] result = this.toArray();
        for (int i = 0; i<result.length; i++) {
            if (set.containsElement(result[i])) {
                result[i] = null;
            }
        }
        return new FiniteSet(ArrayHelpers.removeNulls(result));
    }

    public FiniteSet getSetDifference(Object element) {
        return getSetDifference( new FiniteSet(new Object[]{ element }) );
    }

    public Object[] toArray() {
        return elements.clone();
    }

    // Debug stuff



}