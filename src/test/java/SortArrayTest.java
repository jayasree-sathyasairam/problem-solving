import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SortArrayTest {


    @Test
    public void shouldReturnLargestPossibleNumberForGivenSingleDigitNumbers() {
        SortArray sortArray = new SortArray();
        assertEquals(sortArray.findLargestConcatenatedInt("1,2,3,4,5").toString(), "[5, 4, 3, 2, 1]");
    }

    @Test
    public void shouldReturnLargestPossibleNumberForGivenVariableDigitNumbers() {
        SortArray sortArray = new SortArray();
        assertEquals(sortArray.findLargestConcatenatedInt("10,9,8,7,4,29,81").toString(), "[9, 8, 81, 7, 4, 29, 10]");
    }

    @Test
    public void shouldReturnLargestPossibleNumberForGivenBigNumbers() {
        SortArray sortArray = new SortArray();
        //Integers biggest number is 2147483647
        assertEquals(sortArray.findLargestConcatenatedInt("90,2147483647,2147483647").toString(), "[90, 2147483647, 2147483647]");
    }

    @Test
    public void shouldReturnNumberFormatExceptionForFloatNumbers() {
        SortArray sortArray = new SortArray();
        try {
            sortArray.findLargestConcatenatedInt("1,2.7,3");
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void shouldReturnNumberFormatExceptionForEmptyArray() {
        SortArray sortArray = new SortArray();
        try {
            sortArray.findLargestConcatenatedInt("");
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void shouldReturnNumberFormatExceptionForNegativeNumbers() {
        SortArray sortArray = new SortArray();
        try {
            sortArray.findLargestConcatenatedInt("1,-2,3");
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void shouldReturnNumberFormatExceptionForAlphabets() {
        SortArray sortArray = new SortArray();
        try {
            sortArray.findLargestConcatenatedInt("a,b,c");
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void shouldReturnNumberFormatExceptionForSpecialCharactersAsSpace() {
        SortArray sortArray = new SortArray();
        try {
            sortArray.findLargestConcatenatedInt("1, 2, 3");
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void shouldReturnNumberFormatExceptionForLongNumbers() {
        SortArray sortArray = new SortArray();
        try {
            sortArray.findLargestConcatenatedInt("1,2,3676384296572647582364");
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }
}
