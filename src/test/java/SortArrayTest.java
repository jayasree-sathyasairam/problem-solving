import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SortArrayTest {
    SortArray sortArray;

    @Before
    public void setup(){
        sortArray = new SortArray();
    }

    @Test
    public void shouldReturnIntegerArrayListForSmallNumbers(){
        assertEquals(sortArray.constructInput("1,2,3,4,5").toString(), "[1, 2, 3, 4, 5]");
    }

    @Test
    public void shouldReturnIntegerArrayListForBigNumbers(){
        assertEquals(sortArray.constructInput("2147483647,2147483647,2147483647").toString(), "[2147483647, 2147483647, 2147483647]");
    }

    @Test
    public void shouldReturnNumberFormatExceptionForEmptyArray(){
        try{
            sortArray.constructInput("");
        }catch(NumberFormatException e){
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void shouldReturnNumberFormatExceptionForLongNumbers(){
        try{
            sortArray.constructInput("1,2,3676384296572647582364");
        }catch(NumberFormatException e){
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void shouldReturnNumberFormatExceptionForNegativeNumbers(){
        try{
            sortArray.constructInput("1,-2,3");
        }catch(NumberFormatException e){
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void shouldReturnNumberFormatExceptionForDecimalNumbers(){
        try{
            sortArray.constructInput("1,2.7,3");
        }catch(NumberFormatException e){
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void shouldReturnNumberFormatExceptionForAlphabets(){
        try{
            sortArray.constructInput("a,b,c");
        }catch(NumberFormatException e){
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void shouldReturnNumberFormatExceptionForSpecialCharacters(){
        try{
            sortArray.constructInput("$,#,@");
        }catch(NumberFormatException e){
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void shouldReturnNumberFormatExceptionForInputFormatWithSpaceBetweenNumbers(){
        try{
            sortArray.constructInput("1, 2, 3");
        }catch(NumberFormatException e){
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void shouldReturnLargestIntForSingleDigitNumbers(){
        ArrayList<Integer> numArr;
        numArr = sortArray.constructInput("1,2,3,4,5");
        sortArray.quickSort(numArr, 0, numArr.size()-1);
        assertEquals(numArr.toString(), "[5, 4, 3, 2, 1]");
    }

    @Test
    public void shouldReturnLargestIntForVariableDigitNumbers(){
        ArrayList<Integer> numArr;
        numArr = sortArray.constructInput("10,9,8,7,4,29,81");
        sortArray.quickSort(numArr, 0, numArr.size()-1);
        assertEquals(numArr.toString(), "[9, 8, 81, 7, 4, 29, 10]");
    }

    @Test
    public void shouldReturnLargestIntForSingletonArray(){
        ArrayList<Integer> numArr;
        numArr = sortArray.constructInput("1");
        sortArray.quickSort(numArr, 0, numArr.size()-1);
        assertEquals(numArr.toString(), "[1]");
    }

    @Test
    public void shouldReturnPivotNumberForGivenArray(){
        sortArray.quickSort(sortArray.constructInput("1,2,3,4,5"), 0, 4);
        assertEquals(0, 0);
    }
}
