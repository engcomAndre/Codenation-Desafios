package br.com.codenation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class StatisticUtilTest {

    @Test
    public void testAverage() {
        assertEquals(3, StatisticUtil.average(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testMode() {
        assertEquals(3, StatisticUtil.mode(new int[]{1, 2, 3, 3}));

    }

    @Test
    public void testMode2() {
        assertEquals(3, StatisticUtil.mode(new int[]{1, 2, 3, 3}));
        assertEquals(1, StatisticUtil.mode(new int[]{1}));
        assertFalse(1==StatisticUtil.mode(new int[]{ }));
        assertEquals(7, StatisticUtil.mode(new int[]{1, 1, 3, 3, 5, 7, 7, 7, 11, 13}));
        assertEquals(3, StatisticUtil.mode(new int[]{3, 5, 8, 11, 13, 18}));
        assertEquals(5, StatisticUtil.mode(new int[]{3, 5, 5, 5, 6, 6, 7, 7, 7, 11, 12}));
    }

    @Test
    public void testMedian() {
        assertEquals(3, StatisticUtil.median(new int[]{1, 2, 3, 4, 5}));
    }
}
