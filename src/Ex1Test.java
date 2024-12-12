import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for(int i=0;i<good.length;i=i+1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for(int i=0;i<not_good.length;i=i+1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }
    @Test
    void int2NumberTest() {
        // implement this test
        String s = Ex1.int2Number(11,2);
        assertEquals("1011b2",s);
        String s2 = Ex1.int2Number(11,15);
        assertEquals("Bb15",s2);
        String s3 = Ex1.int2Number(12,17);
        assertEquals("",s3);
        String s4 = Ex1.int2Number(0,12);
        assertEquals("0",s4);
        String s5 = Ex1.int2Number(0,0);
        assertEquals("",s5);
        String s6 = Ex1.int2Number(-100,15);
        assertEquals("",s6);
        String s7 = Ex1.int2Number(7253725,16);
        assertEquals("6EAEDDb16",s7);
    }
    @Test
    void maxIndexTest() {
        // implement this test
        String[] arr ={"","21b3","3","21b3"};
        int result = Ex1.maxIndex(arr);
        assertEquals(1,result);
        String[] arr1 ={"null","","b2","2b"};
        result = Ex1.maxIndex(arr1);
        assertEquals(-1,result);
        String[] arr2 ={"1000b2","1000b3","1000b5","1000b5"};
        result = Ex1.maxIndex(arr2);
        assertEquals(2,result);
        String[] arr3 ={"1","2","3","4"};
        result = Ex1.maxIndex(arr3);
        assertEquals(-1,result);
        String[] arr4 ={"11b2","111b2","1b2","11b2"};
        result = Ex1.maxIndex(arr4);
        assertEquals(1,result);
        String[] arr5 ={"DDbE","CCbD","BBbC","AAbB"};
        result = Ex1.maxIndex(arr5);
        assertEquals(0,result);
        String[] arr6 ={null,"0b2","502","ABb17","","123B2","1 1b2"};
        result = Ex1.maxIndex(arr6);
        assertEquals(1,result);
        String[] arr7 ={"1ACbD","1ACbE","1ACbF","1ACbG"};
        result = Ex1.maxIndex(arr7);
        assertEquals(3,result);
        String[] arr8 ={"1AB2BG","0b2","123b3","A1FbF"};
        result = Ex1.maxIndex(arr8);
        assertEquals(1,result);
    }

    // Add additional test functions - test as much as you can.
    @Test
    void equalsTest() {
        assertTrue(Ex1.equals("10b2", "2bA"));
        assertTrue(Ex1.equals("123b4","1000b3"));
        assertTrue(Ex1.equals("110b4","18bC"));
        assertTrue(Ex1.equals("1A4bG","1D0bF"));

        assertFalse(Ex1.equals("10b2", "10b3"));
        assertFalse(Ex1.equals("","123b5"));
        assertFalse(Ex1.equals(null,"123b5"));
        assertFalse(Ex1.equals("123b5","123B5"));
        assertFalse(Ex1.equals("123b5","12 3B5"));
    }
    @Test
    void isNumberTest() {
        assertTrue(Ex1.isNumber("1011bA"));
        assertTrue(Ex1.isNumber("10A1bB"));
        assertTrue(Ex1.isNumber("1E0AbF"));

        assertFalse(Ex1.isNumber("1B CbD"));
        assertFalse(Ex1.isNumber("1B"));
        assertFalse(Ex1.isNumber(""));
        assertFalse(Ex1.isNumber(" "));
        assertFalse(Ex1.isNumber(null));
        assertFalse(Ex1.isNumber("1DAb1E"));
    }
    @Test
    void number2intTest() {
        assertEquals(10,Ex1.number2Int("1010b2"));
        assertEquals(420,Ex1.number2Int("1D0bF"));
        
        assertEquals(-1,Ex1.number2Int("123"));
        assertEquals(-1 ,Ex1.number2Int("1D BbG"));
        assertEquals(-1,Ex1.number2Int("12BbA"));
        assertEquals(-1,Ex1.number2Int("1b2b5"));
        assertEquals(-1,Ex1.number2Int("142bB5"));

    }
}
