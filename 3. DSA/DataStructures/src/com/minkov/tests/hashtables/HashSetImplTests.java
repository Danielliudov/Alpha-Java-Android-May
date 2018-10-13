package com.minkov.tests.hashtables;

import com.minkov.app.hashtables.HashSetImpl;
import org.junit.Assert;
import org.junit.Test;

public class HashSetImplTests {
    @Test
    public void initialSize_shouldBe0() {
        HashSetImpl<Integer> set = new HashSetImpl<>();
        Assert.assertEquals(0, set.size());
    }

    @Test
    public void add2UniqueElements_shouldHaveSize2() {
        HashSetImpl<Integer> set = new HashSetImpl<>();
        set.add(1);
        set.add(2);
        Assert.assertEquals(2, set.size());
    }

    @Test
    public void add2IdenticalElements_shouldHaveSize1() {
        HashSetImpl<Integer> set = new HashSetImpl<>();
        set.add(1);
        set.add(1);
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void add2IdenticalAnd10UniqueElements_shouldHaveSize11() {
        HashSetImpl<Integer> set = new HashSetImpl<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }

        set.add(100);
        set.add(100);

        Assert.assertEquals(11, set.size());
    }

    @Test
    public void containsElement_whenElementIsAdded_shouldReturnTrue() {
        HashSetImpl<Integer> set = new HashSetImpl<>();

        set.add(100);

        Assert.assertTrue(set.contains(100));
    }

    @Test
    public void containsElement_whenElementIsNotAdded_shouldReturnFalse() {
        HashSetImpl<Integer> set = new HashSetImpl<>();

        set.add(100);

        Assert.assertFalse(set.contains(101));
    }

    @Test
    public void containsElement_whenElementIsAddedThenDeleted_shouldReturnFalse() {
        HashSetImpl<Integer> set = new HashSetImpl<>();

        set.add(100);
        set.remove(100);

        Assert.assertFalse(set.contains(100));
    }

    @Test
    public void deleteElement_whenElementIsNotPresent_shouldHappenNothing() {
        HashSetImpl<Integer> set = new HashSetImpl<>();

        set.remove(100);
    }
}
