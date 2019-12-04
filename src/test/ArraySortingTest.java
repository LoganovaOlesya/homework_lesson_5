package test;

import com.company.main.Main;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class ArraySortingTest {

    Main sorting = new Main();

    @Test(expected = NullPointerException.class)
    public void testNull() {
        Main sort = new Main();
        sort.sortArray(0, 0, null);
    }

    @Test
    public void testEmpty() {
        int[] orig = new int[0];
        int[] array = orig.clone();
        sorting.sortArray(0, 0, array);
        assertTrue(Arrays.equals(orig, array));
    }

    @Test
    public void testSame() {
        int[] expect = new int[] { 1, 1, 1, 1, 1, 1, 1 };
        int[] array = expect.clone();
        sorting.sortArray(0, 0, array);
        assertTrue(Arrays.equals(expect, array));
    }
}
