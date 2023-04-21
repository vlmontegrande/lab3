import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
	@Test 
	public void testReverseInPlace() {
    int[] input1 = { 3 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 3 }, input1);

    int[] input2 = {5, 4, 3, 2, 1};
    ArrayExamples.reverseInPlace(input2);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5}, input2);
	}


  @Test
  public void testReversed() {
    int[] input1 = { };
    assertArrayEquals(new int[]{ }, ArrayExamples.reversed(input1));

    int[] input2 = {1, 2, 3};
    assertArrayEquals(new int[]{3, 2, 1}, ArrayExamples.reversed(input2));
  }

  @Test
  public void testAverageWithoutLowest() {
    double[] input1 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
    assertEquals(4.0, ArrayExamples.averageWithoutLowest(input1), 0);
  }
}
