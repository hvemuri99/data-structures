import com.ds.core.alogorithms.Addition;

import java.util.LinkedList;
import java.util.List;

public class Core {

    public static void main(String[] args) throws Exception {
        LinkedList<Integer> input1 = new LinkedList<>();
        input1.addFirst(2);
        input1.add(1, 3);
        input1.addLast(4);
        LinkedList<Integer> input2 = new LinkedList<>();
        input2.add(0, 9);
        input2.add(1, 2);
        input2.add(2, 7);
        Addition addTwoNum = new Addition();
        List<Integer> output = addTwoNum.addTwoNumbersByLinkedLists(input1, input2);
    }
}
