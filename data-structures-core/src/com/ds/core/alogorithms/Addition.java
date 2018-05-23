package com.ds.core.alogorithms;

import java.util.LinkedList;
import java.util.List;

public class Addition {

    public List<Integer> addTwoNumbersByLinkedLists(LinkedList<Integer> input1,
                                                    LinkedList<Integer> input2) throws Exception {

        if ((input1 == null || input1.isEmpty()) && (input2 == null || input2.isEmpty())) {
            throw new Exception("Invalid input");
        }

        if (input1 == null || input1.isEmpty()) {
            return input2;
        }

        if (input2 == null || input2.isEmpty()) {
            return input1;
        }
        List<Integer> output = new LinkedList<>();
        while (!input1.isEmpty() && !input2.isEmpty()) {
            Integer x = input1.getFirst();
            Integer y = input2.getFirst();
            Integer add = x + y;
            if (add > 9 && input1.size() > 1) {
                add = add - 9 - 1;
                ((LinkedList<Integer>) output).addFirst(add);
                input1.removeFirst();
                input2.removeFirst();
                Integer carryOn = input1.getFirst() + 1;
                input1.set(0, carryOn);
            } else {
                ((LinkedList<Integer>) output).addFirst(add);
                input1.removeFirst();
                input2.removeFirst();
            }
        }

        return output;
    }
}
