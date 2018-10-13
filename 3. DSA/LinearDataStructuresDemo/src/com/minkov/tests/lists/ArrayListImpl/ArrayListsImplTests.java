package com.minkov.tests.lists.ArrayListImpl;

import com.minkov.app.lists.ArrayListImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayListsImplTests {
    @Test
    public void add5Elemenst_shouldSizeToBe5() {
        ArrayListImpl list = new ArrayListImpl();

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        Assert.assertEquals(5, list.size());
    }

    @Test
    public void initialSize_shouldBe0() {
        ArrayListImpl list = new ArrayListImpl();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void insertAt2_shouldSizeBePlus1() {
        ArrayListImpl list = new ArrayListImpl();
        int size = list.size();
        list.insert(0, 1);

        Assert.assertEquals(size + 1, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertAtNegativeValue_ShouldThrow() {
        ArrayListImpl list = new ArrayListImpl();
        list.insert(-1, 0);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void insertAtIndexGreaterThanSize_ShouldThrow() {
        ArrayListImpl list = new ArrayListImpl();
        list.insert(list.size() + 1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteAtNegativeValue_ShouldThrow() {
        ArrayListImpl list = new ArrayListImpl();
        list.deleteAtIndex(-1);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteAtIndexGreaterThanSize_ShouldThrow() {
        ArrayListImpl list = new ArrayListImpl();
        list.deleteAtIndex(list.size() + 1);
    }

    @Test
    public void adding5Elements_shouldBePresentAtIndices0to4() {
        ArrayListImpl list = new ArrayListImpl();
        int[] values = {1, 2, 3, 4, 5};

        Arrays.stream(values)
            .forEach(list::add);

        int[] actual = new int[values.length];
        for (int i = 0; i < list.size(); i++) {
            actual[i] = list.get(i);
        }

        Assert.assertArrayEquals(values, actual);
    }
}
