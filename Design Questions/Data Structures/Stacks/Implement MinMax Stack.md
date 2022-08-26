Design a stack that supports push, pop, top, and retrieving the minimum element and maximum element in constant time.

Implement the MinMaxStack class:

MinMaxStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
int pop() removes the element on the top of the stack.
int peek() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
int getMax() retrieves the maximum element in the stack.
You must implement a solution with O(1) time complexity for each function.


```
import java.util.*;

class Program {
  static class MinMaxStack {
    private Stack stack;
    public int peek() {
      return stack.data;
    }

    public int pop() {
      int ret = stack.data;
      stack = stack.next;
      return ret;
    }

    public void push(Integer number) {
      if(stack == null) {
        stack = new Stack(number, number, number, null);
      } else {
        stack = new Stack(number, Math.min(number, stack.min), Math.max(number, stack.max), stack);
      }
    }

    public int getMin() {
      return stack.min;
    }

    public int getMax() {
      return stack.max;
    }

    class Stack {
      int data;
      int min;
      int max;
      Stack next;

      private Stack(int data, int min, int max, Stack next) {
        this.data = data;
        this.min = min;
        this.max = max;
        this.next = next;
      }
    }
  }
}

```
