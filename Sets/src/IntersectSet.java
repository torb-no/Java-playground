/**
 * Created with IntelliJ IDEA.
 * User: torbjorn
 * Date: 14.09.14
 * Time: 21:27
 * To change this template use File | Settings | File Templates.
 */
public class IntersectSet extends Set {

    private Set a, b;

    public Boolean empty() {
        if      (a.empty() && b.empty())   { return true; }
        else if (!a.empty() && a.finite()) { return checkEmpty(a, b); }
        else if (!b.empty() && b.finite()) { return checkEmpty(b, a); }
        else                               { return false; }
    }

    private Boolean checkEmpty(Set finiteSet, Set anySet) {
        Object[] elements = finiteSet.toArray();
        for (int i=0; i<elements.length; i++) {
            if (anySet.containsElement(elements[i])) {
                return false;
            }
        }
        return true;
    }

    public Boolean finite() {
        return a.finite() || b.finite();
    }

    /*

     public FiniteSet getIntersection(FiniteSet set) {
        Object[] result = this.toArray();
        for (int i = 0; i<result.length; i++) {
            if (!set.containsElement(result[i])) {
                result[i] = null;
            }
        }
        return new FiniteSet(ArrayHelpers.removeNulls(result));
    }

     */

    public Object[] toArray() {
        if (a.finite()) {

        }
        else if (b.finite()) {

        }
        else {
            System.out.println("ERROR: Cannot turn infinite set to array");
            return new Object[] { "ERROR" };
        }
    }

    private Object[] toArray(FiniteSet Set, )

    public Boolean containsElement(Object element) {
        return a.containsElement(element) && b.containsElement(element);
    }

}
