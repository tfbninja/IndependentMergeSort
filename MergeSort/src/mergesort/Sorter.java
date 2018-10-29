package mergesort;

import java.util.ArrayList;

/**
 *
 * @author Tim Barber
 */
public class Sorter {

    private ArrayList<Integer> original;
    private int origLength;

    public Sorter() {
        this.original = new ArrayList<Integer>();
        this.origLength = 0;
    }

    public Sorter(ArrayList<Integer> unsorted) {
        this.original = unsorted;
        this.origLength = this.original.size();
    }

    public void setArray(ArrayList<Integer> unsorted) {
        this.original = unsorted;
        this.origLength = this.original.size();
    }

    public Integer smaller(ArrayList<Integer> unsorted) {
        //ASSUMES SIZE OF 2
        if (unsorted.get(0) < unsorted.get(1)) {
            return unsorted.get(0);
        }
        return unsorted.get(1);
    }

    public Integer bigger(ArrayList<Integer> unsorted) {
        //ASSUMES SIZE OF 2
        if (unsorted.get(1) < unsorted.get(0)) {
            return unsorted.get(0);
        }
        return unsorted.get(1);
    }

    public ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        if (list1.size() == 1 && list2.size() == 1) {
            ArrayList<Integer> merged = new ArrayList<>();
            ArrayList<Integer> tempHolder = new ArrayList<>(2);
            tempHolder.add(list1.get(0));
            tempHolder.add(list2.get(0));
            merged.add(smaller(tempHolder));
            merged.add(bigger(tempHolder));
            return merged;
        } else if (list1.size() == 1 && list2.size() == 2) {
            ArrayList<Integer> merged = new ArrayList<>(3);
            ArrayList<Integer> tempHolder = new ArrayList<>(3);

        }
    }

    public ArrayList<Integer> sort(ArrayList<Integer> unsorted) {
        int midPoint = unsorted.size() / 2;
        int size = unsorted.size();
        if (size < 2) {
            return unsorted;
        } else if (size == 2) {
            ArrayList<Integer> sorted = new ArrayList<>();
            sorted.add(smaller(unsorted));
            sorted.add(bigger(unsorted));
            return sorted;
        }
        ArrayList<Integer> sublist1 = new ArrayList<>();
        ArrayList<Integer> sublist2 = new ArrayList<>();
        for (int i = 0; i < midPoint; i++) {
            sublist1.add(unsorted.get(i));
        }
        for (int i = 0; i < size - midPoint; i++) {
            sublist2.add(unsorted.get(midPoint + i));
        }
        sublist1 = sort(sublist1);
        for (Integer i : sort(sublist2)) {
            sublist1.add(i);
        }
        //System.out.println(sublist1);
        return sublist1;
    }

    @Override
    public String toString() {
        ArrayList<Integer> sorted = sort(this.original);
        return sorted.toString();
    }

}


/*
 * The MIT License
 *
 * Copyright (c) 2018 Tim Barber.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
