package org.shaliu.hello;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static double getAverage(int[] counter) {
        if (counter.length == 0) {
            return 0;
        }
        double sum = 0;
        int count = 0;
        for (int i = 0; i < counter.length; i++) {
            sum += (i+1) * counter[i];
            count += counter[i];
        }

        return sum / count;
    }

    static int getMin(int[] counter) {
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return i+1;
            }
        }
        return -1;
    }

    static int getMax(int[] counter) {
        for (int i = counter.length-1; i >= 0; i--) {
            if (counter[i] != 0) {
                return i+1;
            }
        }
        return Integer.MAX_VALUE;
    }

    // returns the most frequent. Pick the first one if different numbers having same occurances
    static int getMostFrequent(int[] counter) {
        int ans = -1;
        int maxCount = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > maxCount) {
                maxCount = counter[i];
                ans = i+1;
            }
        }

        return ans;
    }

    private static void run(int numberOfThreads) {
        Object mutex = new Object();
        Deque<Integer> deque = new LinkedList<>();
        int[] counter = new int[10];

        IntStream
                .range(0, numberOfThreads)
                .flatMap(i -> new Random().ints(1, 11))
                .parallel()
                .forEach(number -> {
                    String threadName = Thread.currentThread().getName();

                    synchronized (mutex) {
                        deque.offerLast(number);
                        counter[number-1]++;
                        if (deque.size() > 30) {
                            int head = deque.pollFirst();
                            counter[head-1]--;
                        }

                        System.out.printf("(thread name=%s) avg=%f min=%d max=%d most_frequent=%d counter=%s number=%d deque=%s\n",
                                threadName, getAverage(counter), getMin(counter), getMax(counter), getMostFrequent(counter), Arrays.toString(counter), number, deque.toString());
                    }
                });
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Number of threads: ");
        int numberOfThreads = scan.nextInt();

        System.out.printf("Processing random numbers using %s of threads...\n", numberOfThreads);
        run(numberOfThreads);

        scan.close();
    }
}
