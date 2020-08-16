import java.util.ArrayList;


public class SortArray {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            SortArray obj = new SortArray();
            try {
                System.out.println(obj.findLargestConcatenatedInt(args[i]).toString());
            } catch (NumberFormatException e){
                System.out.println("Input type is not supported.");
            }
        }
    }
    public ArrayList<Integer> findLargestConcatenatedInt(String input){
        ArrayList<Integer> numArr;
        try {
            numArr = constructInput(input);
        } catch(NumberFormatException e){
            throw new NumberFormatException();
        }
        quickSort(numArr, 0, numArr.size()-1);
        return numArr;
    }
    public ArrayList<Integer> constructInput(String input) {
        String[] array = input.split(",");
        ArrayList<Integer> numArray = new ArrayList<Integer>();
        try {
            for (int j = 0; j < array.length; j++) {
                if(Integer.parseInt(array[j])>=0)
                    numArray.add(Integer.parseInt(array[j]));
                else
                    throw new NumberFormatException();
            }
            return numArray;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
    public void quickSort(ArrayList<Integer> arrayList, int low, int high) {
        if (low < high)
        {
            int pivot = partition(arrayList, low, high);
            quickSort(arrayList, low, pivot-1);
            quickSort(arrayList, pivot+1, high);
        }
    }
    public int partition(ArrayList<Integer>  arrayList, int low, int high) {
        int pivot = arrayList.get(high);
        int i = (low-1);
        for (int j=low; j<high; j++) {
            long AB = Long.parseLong((arrayList.get(j).toString()) + pivot);
            long BA = Long.parseLong(pivot + arrayList.get(j).toString());

            if (BA < AB) {
                i++;
                int temp = arrayList.get(i);
                arrayList.set(i, arrayList.get(j));
                arrayList.set(j, temp);
            }
        }

        int temp = arrayList.get(i+1);
        arrayList.set(i+1, arrayList.get(high));
        arrayList.set(high, temp);
        return i+1;
    }
}
