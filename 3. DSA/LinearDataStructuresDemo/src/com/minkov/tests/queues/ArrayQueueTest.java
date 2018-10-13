package com.minkov.tests.queues;

import com.minkov.app.queues.ArrayQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayQueueTest {
    @Test
    public void enqueue5Elements_shouldHaveSize5() {
        ArrayQueue queue = new ArrayQueue();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        Assert.assertEquals(5, queue.size());
    }

    @Test
    public void enqueue5Elements_shouldBeDequeuedInSameOrder() {
        int[] actual = {1, 2, 3, 4, 5};
        ArrayQueue queue = new ArrayQueue();
        Arrays.stream(actual)
            .forEach(queue::enqueue);

        int[] expected = new int[actual.length];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = queue.dequeue();
        }

        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void enqueue5Elements_dequeue2_enqueue5More_shouldBeDequeuedInSameOrder() {
        int[] values = {1, 2, 3, 4, 5};
        ArrayQueue queue = new ArrayQueue();
        Arrays.stream(values)
            .forEach(queue::enqueue);

        queue.dequeue();
        queue.dequeue();

        Arrays.stream(values)
            .forEach(queue::enqueue);

        int[] actual = {3, 4, 5, 1, 2, 3, 4, 5};
        int[] expected = new int[actual.length];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = queue.dequeue();
        }

        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void enqueue5Elements_dequeueUntilEmpty_enqueue5More_shouldDequeueTheSecond5Elements() {
        int[] values = {1, 2, 3, 4, 5};
        ArrayQueue queue = new ArrayQueue();
        Arrays.stream(values)
            .forEach(queue::enqueue);

        while (!queue.isEmpty()) {
            queue.dequeue();
        }

        Arrays.stream(values)
            .forEach(queue::enqueue);

        int[] actual = {1, 2, 3, 4, 5};
        int[] expected = new int[actual.length];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = queue.dequeue();
        }

        Assert.assertArrayEquals(expected, actual);
    }
}
