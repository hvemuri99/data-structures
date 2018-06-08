import com.ds.core.sorting.SelectionSort;

public class Core {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] input = {64, 25, 12, 22, 11};
        selectionSort.selectionSort(input);
    }
}
