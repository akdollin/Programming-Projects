import static org.junit.Assert.*;

import org.junit.Test;


public class StackTest {

	@Test
	public void testCase() {
//		fail("Not yet implemented");
//		String s = "hello";
		Stack stack = new Stack(5);
		
		assertEquals(-1, stack.top1);
		
		stack.push('s');
		
		assertEquals(0, stack.top1);
		assertEquals(stack.arr[stack.top1], 's');

		stack.push('a');
		
		assertEquals(1, stack.top1);
		assertEquals(stack.arr[stack.top1], 'a');
		
		char a = stack.pop();
		
		assertEquals(a, 'a');
		assertEquals(0, stack.top1);
		
		char b = stack.pop();
		
		assertEquals(b, 's');
		assertEquals(-1, stack.top1);
		
	}

}
