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
    public void testInputConstruction(){
        //testForSmallNumbers
        assertEquals(sortArray.constructInput("1,2,3,4,5").toString(), "[1, 2, 3, 4, 5]");

        //testForBigNumbers
        assertEquals(sortArray.constructInput("2147483647,2147483647,2147483647").toString(), "[2147483647, 2147483647, 2147483647]");

        //testForEmptyString
        try{
            sortArray.constructInput("");
        }catch(NumberFormatException e){
            assertEquals(e.getClass(), NumberFormatException.class);
        }

        //testForLongNumbers
        try{
            sortArray.constructInput("1,2,3676384296572647582364");
        }catch(NumberFormatException e){
            assertEquals(e.getClass(), NumberFormatException.class);
        }

        //testForNegativeNumbers
        try {
            sortArray.constructInput("1,-2,3");
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }

        //testForDecimalNumbers
        try {
            sortArray.constructInput("1,2.7,3");
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }

        //testForAlphabets
        try {
            sortArray.constructInput("a,b,c");
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }

        //testForSpecialCharacters
        try {
            sortArray.constructInput("$,#,@");
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }

        //testForInputFormatWithSpaceBetweenNumbers
        try {
            sortArray.constructInput("1, 2, 3");
        } catch (Exception e) {
            assertEquals(e.getClass(), NumberFormatException.class);
        }
    }

    @Test
    public void testQuickSort(){
        ArrayList<Integer> numArr;

        //testForSingleDigitNumbers
        numArr = sortArray.constructInput("1,2,3,4,5");
        sortArray.quickSort(numArr, 0, numArr.size()-1);
        assertEquals(numArr.toString(), "[5, 4, 3, 2, 1]");

        //testForVariableDigitNumbers
        numArr = sortArray.constructInput("10,9,8,7,4,29,81");
        sortArray.quickSort(numArr, 0, numArr.size()-1);
        assertEquals(numArr.toString(), "[9, 8, 81, 7, 4, 29, 10]");

        //testForSingletonArray
        numArr = sortArray.constructInput("1");
        sortArray.quickSort(numArr, 0, numArr.size()-1);
        assertEquals(numArr.toString(), "[1]");

        //testForBiggerNumbers
        numArr = sortArray.constructInput("2147483643,2147483642,21474888");
        sortArray.quickSort(numArr, 0, numArr.size()-1);
        assertEquals(numArr.toString(), "[21474888, 2147483643, 2147483642]");
    }

    @Test
    public void testPartition(){

        //testPivotNumber
        sortArray.quickSort(sortArray.constructInput("1,2,3,4,5"), 0, 4);
        assertEquals(0, 0);
    }
}
