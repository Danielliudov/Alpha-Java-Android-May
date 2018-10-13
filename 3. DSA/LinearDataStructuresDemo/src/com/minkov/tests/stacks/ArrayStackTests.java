package com.minkov.tests.stacks;

import com.minkov.app.stacks.ArrayStack;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayStackTests {

    @Test
    public void pushing5Elements_shouldPopInReversedOrder() {
        int[] elements = {1, 2, 3, 4, 5};
        ArrayStack stack = new ArrayStack();
        Arrays.stream(elements)
            .forEach(stack::push);

        int[] expected = {5, 4, 3, 2, 1};
        int[] actual = new int[5];
        int index = 0;

        while (stack.size() > 0) {
            actual[index] = stack.pop();
            ++index;
        }

        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void popFromEmptyStack_shouldThrow() {
        ArrayStack stack = new ArrayStack();
        stack.pop();
    }
}
