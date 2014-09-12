public class Main {

    public static void main(String[] args) {

        FiniteSet setA = new FiniteSet(new Object[]{ 1, 2, 3 });
        FiniteSet setLikeA = new FiniteSet(setA);
        FiniteSet setB = new FiniteSet(new Object[]{ 3, 4, 5 });

        setLikeA.print();
        FiniteSet setAB = new FiniteSet(setA.getUnion(setB));
        setAB.print();

        FiniteSet setAiB = new FiniteSet(setA.getIntersection(setB));
        setAiB.print();

        FiniteSet setAdiffB = new FiniteSet(setA.getSetDifference(setB));
        setAdiffB.print();
    }

}
