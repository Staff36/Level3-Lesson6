import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

class ArrayOptimizerTest {

    ArrayOptimizer arrayOptimizer = new ArrayOptimizer();

    @Test
    void getArrayAfterLastSearchingValue_Positive_Case() {
        //given
        int [] givenArray = new int[]{
                2,3,5,6,4,1,2,3
        };
        int searchingValue = 4;
        //expected array
        int[] expectedArray = new int[]{
                1,2,3
        };
        //assert
        assertArrayEquals(expectedArray, arrayOptimizer.getArrayAfterLastSearchingValue(givenArray, searchingValue));
    }

    @Test
    void getArrayAfterLastSearchingValue_SingleValue_Equals_shouldReturn_Null() {
        //given
        int [] givenArray = new int[]{1};
        int searchingValue = 1;
        //assert
        assertNull(arrayOptimizer.getArrayAfterLastSearchingValue(givenArray, searchingValue));
    }

    @Test
    void getArrayAfterLastSearchingValue_SingleValue_notEquals_shouldReturn_Null() {
        //given
        int [] givenArray = new int[] {1};
        int searchingValue = 3;
        //assert
        assertNull(arrayOptimizer.getArrayAfterLastSearchingValue(givenArray, searchingValue));
    }

    @Test
    void getArrayAfterLastSearchingValue_NegativeCase_shouldThrow_RuntimeException(){
        //given
        int [] givenArray = new int[]{
                2,3,5,6,4,1,2,3
        };
        int searchingValue = 9;
        //assert
         assertThrows( RuntimeException.class , ()->
                 arrayOptimizer.getArrayAfterLastSearchingValue(givenArray, searchingValue));
    }
    @Test
    void getArrayAfterLastSearchingValue_LastValue_Equals_shouldReturn_Null() {
        //given
        int [] givenArray = new int[]{
                2,3,5,6,4,1,2,1
        };
        int searchingValue = 1;
        //assert
        assertNull(arrayOptimizer.getArrayAfterLastSearchingValue(givenArray, searchingValue));
    }


    @CsvSource({
                "1,7",
                "9,7",
                "7,9"})
    @ParameterizedTest
    void isContainTwoValues_PositiveCase_shouldReturn_True(int firstValue, int secondValue) {
        //given
        int [] givenArray = new int[]{
                1,3,7,6,4,1,2,3
        };
        //expect
        assertTrue(arrayOptimizer.isContainTwoValues(givenArray, firstValue, secondValue));
    }
    @Test
    void isContainTwoValues_PositiveCase_shouldReturn_False(){
    //given
    int [] givenArray = new int[]{
            1,3,7,6,4,1,2,3
    };
    int firstValue = 5;
    int secondValue = 8;
    //expect
        assertFalse(arrayOptimizer.isContainTwoValues(givenArray, firstValue, secondValue));
    }

    @Test
    void isContainOnlyTwoValues_positiveCase(){
        //given
        int [] givenArray = new int[]{
                1,1,4,1,4,4,4,1
        };
        int firstValue = 4;
        int secondValue = 1;
        //expect
        assertTrue(arrayOptimizer.isContainOnlyTwoValues(givenArray, firstValue, secondValue));
    }

    @Test
    void isContainOnlyTwoValues_negativeCase_firstValue_outOfArraysRange(){
        //given
        int [] givenArray = new int[]{
                1,1,4,1,4,4,4,1
        };
        int firstValue = 5;
        int secondValue = 1;
        //expect
        assertFalse(arrayOptimizer.isContainOnlyTwoValues(givenArray, firstValue, secondValue));
    }

    @Test
    void isContainOnlyTwoValues_negativeCase_incorrectArray(){
        //given
        int [] givenArray = new int[]{
                1,1,4,1,4,4,3,1
        };
        int firstValue = 4;
        int secondValue = 1;
        //expect
        assertFalse(arrayOptimizer.isContainOnlyTwoValues(givenArray, firstValue, secondValue));
    }


}