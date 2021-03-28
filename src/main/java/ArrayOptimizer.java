import java.util.Arrays;

public class ArrayOptimizer {

    public int[] getArrayAfterLastSearchingValue(int[] array, int searchingValue){
    if(array.length < 2){
        return null;
    }
        for (int i = array.length - 1; i >= 0; i--) {
           if (array[i] == searchingValue){
               if (i + 1 >= array.length) {
                   return null;
               }
               int[] resultArray = new int[array.length - 1 - i];
               System.arraycopy(array,i + 1, resultArray, 0, array.length - 1 - i);
               return resultArray;
           }
        }
        throw new RuntimeException("Array doesn't contain " + searchingValue);
    }


    public boolean isContainTwoValues(int[] array, int firstSearchingValue, int secondSearchingValue){
         return Arrays.stream(array).anyMatch(x -> x == firstSearchingValue || x == secondSearchingValue);
    }


    public boolean isContainOnlyTwoValues(int[] array, int firstSearchingValue, int secondSearchingValue){
        return Arrays.stream(array).allMatch(x -> x == firstSearchingValue || x == secondSearchingValue);
    }
}
