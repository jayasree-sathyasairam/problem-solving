import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class SortArrayTest {
    SortArray sortArray = new SortArray();

    @Test
    public void testConstructInput(){
        ArrayList<Integer> numArray;

        //test with positive Integer
        numArray = sortArray.constructInput("1,2,3");
        assertEquals(numArray.toString(), "[1, 2, 3]");

        //test with least digit in array
        numArray = sortArray.constructInput("0");
        assertEquals(numArray.toString(), "[0]");

        //test with greatest integer in a array.. integer is 32 bit max number is 2147483647
        numArray = sortArray.constructInput("2147483647");
        assertEquals(numArray.toString(), "[2147483647]");

        //test with alphabets
        try {
            sortArray.constructInput("a,b,c");
        } catch(Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }

        //test with special character as space after comma
        try {
            sortArray.constructInput("1, 2, 3");
        } catch(Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }

        //test with long numbers
        try {
            sortArray.constructInput("1,2,3676384296572647582364");
        } catch(Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }

        //test with negative numbers
        try {
            sortArray.constructInput("1,-2,3");
        } catch(Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }

        //test with float numbers
        try {
            sortArray.constructInput("1,2.7,3");
        } catch(Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }

        //test with empty array
        try {
            sortArray.constructInput("");
        } catch(Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void quickSortTest(){
        ArrayList<Integer> numArray;

        //test with single digit positive numbers
        numArray = sortArray.constructInput("0,9,3");
        sortArray.quickSort(numArray, 0, numArray.size()-1);
        assertEquals(numArray.toString(), "[9, 3, 0]");

        //test with variable digits
        numArray = sortArray.constructInput("10,9,8,7,4,29,81");
        sortArray.quickSort(numArray, 0, numArray.size()-1);
        assertEquals(numArray.toString(), "[9, 8, 81, 7, 4, 29, 10]");

        //test with big Integer
        numArray = sortArray.constructInput("90,214748364,2147483647");
        sortArray.quickSort(numArray, 0, numArray.size()-1);
        assertEquals(numArray.toString(), "[90, 2147483647, 214748364]");
    }
}
