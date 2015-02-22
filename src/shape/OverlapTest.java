package src.shape;

import static org.junit.Assert.*;
import org.junit.Test;

public class OverlapTest{
    /**
     * Testing overlap method for two circles.
     */
    @Test
    public void testCircles(){
        Circle c1 = new Circle(2,2,2);
        Circle c2 = new Circle(5,5,2);
        assertEquals(true, Shape.overlaps(c1, c2));
        c1 = new Circle(2,2,2);
        c2 = new Circle(5.999,5.999,2);
        assertEquals(true, Shape.overlaps(c1, c2));
        c1 = new Circle(2,2,2);
        c2 = new Circle(6.01,6.01,2);
        assertEquals(false, Shape.overlaps(c1, c2));
        c1 = new Circle(6.01,6.01,2);
        c2 = new Circle(2,2,2);
        assertEquals(false, Shape.overlaps(c1, c2));
    }

    @Test
    public void testSquares(){
        Square s1 = new Square(0, 0, 2);
        Square s2 = new Square(1, 1, 2);
        assertEquals(true, Shape.overlaps(s1, s2));
        s1 = new Square(-2, -2, 2);
        s2 = new Square(1, 1, 2);
        assertEquals(true, Shape.overlaps(s1, s2));
        s1 = new Square(-2, -2, 2);
        s2 = new Square(1.99, 1.99, 2);
        assertEquals(true, Shape.overlaps(s1, s2));
        s1 = new Square(10, 10, 9.98);
        s2 = new Square(0, 0, 0.01);
        assertEquals(false, Shape.overlaps(s1, s2));
    }

    @Test
    public void testSquaresCircles(){
        Square s1 = new Square(0, 0, 2);
        Circle c1 = new Circle(1, 1, 3);
        assertEquals(true, Shape.overlaps(s1, c1));
        s1 = new Square(0, 0, 2);
        c1 = new Circle(5, 5, 3.0001);
        assertEquals(true, Shape.overlaps(s1, c1));
        s1 = new Square(0,0,2);
        c1 = new Circle(0, 100, 2);
        assertFalse(Shape.overlaps(s1, c1));
    }


    public static void main(String[] args){
        jh61b.junit.textui.runClasses(OverlapTest.class); // using package from CS61b
    }
    
}