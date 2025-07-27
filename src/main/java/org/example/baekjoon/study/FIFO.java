package org.example.baekjoon.study;

import java.util.*;

public class FIFO {

    static final int frameSize = 3;
    static int[] pageRef = {1, 2, 3, 4, 2, 5, 1, 2, 3, 4, 5, 1};
    static Queue<Integer> frame;
    static Set<Integer> inMemory;

    public static void main(String[] args) {
        frame = new LinkedList<>();
        inMemory = new HashSet<>();
        int pageFaults = 0;

        for (int page : pageRef) {
            if (!inMemory.contains(page)) {
                pageFaults++;

                if (frame.size() == frameSize) {
                    int remove = frame.poll();
                    inMemory.remove(remove);
                }

                frame.offer(page);
                inMemory.add(page);
            }
        }

        System.out.println(pageFaults);
    }
}
