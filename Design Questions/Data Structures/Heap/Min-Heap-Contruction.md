Implement a min heap that allows
- Building a min heap from input array of integers
- Inserting an Integer into the heap
- Removing the root value
- Peeking the root value
- Sifting up and Sifting down the values in the heap (helper method used in insertion and removal)


## Solution:
### Below are the important things to notice regarding a min heap
- Min heap is a complete binary tree. i.e, all the nodes are filled from left to right. Smallest element is at the peek.
- Heap is not sorted but all the nodes are smaller than the children
- Heap can be represented in an array with the below formula
  - Given a node at index `i` of the array, it's children are at `2i + 1` and `2i + 2`
  - Given a node at index `i` of the array, it's parent will be at `floor((i-1)/2)`

### Walkthrough each method needed to build heap
#### Insert: O(log(n))
- Add the new number to the end of the array
- Sift it up until it's in the correct position

#### Sift Up: O(log(n))
- Given the node and it's index, find it's parent using the formula above. Compare it to see if it's smaller than it's parent. If so, swap them.
- Repeat this until the node is at the right position

#### Remove: O(log(n))
- Swap the root with the last node
- Sift down the new root until it's in the correct position

#### Sift Down: O(log(n))
- Compare the node with both of it's children using the above formula. Compare to find it's smaller child and swap it.
- Repeat until the node is at the right position

#### Build Heap: Given an array, heapify it. O(n)
- Find the last parent node. i'e `lastIndex = arraySize()-1; parentIndex = (lastIndex-1)/2;`
- Sift Down the parent node and repeat until we reach index 0


### Code:
```
import java.util.*;


// Given a node at index i, it's children are at 2i+1 and 2i+2
class Program {
  static class MinHeap {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
      heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
      int firstParentIdx = (array.size() - 2)/2;
      for(int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx-- ) {
        siftDown(currentIdx, array.size()-1, array);
      }
      return array;
    }


    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
      // get the first child
      int childOneIdx = 2 * currentIdx + 1;
      // while it's a valid index identify which child to swap
      while(childOneIdx <= endIdx) {
        int childTwoIdx = 2 * currentIdx + 2 <= endIdx ? 2 * currentIdx + 2: -1;
        int idxToSwap;
        if(childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
          idxToSwap = childTwoIdx;
        } else {
          idxToSwap = childOneIdx;
        }

        if(heap.get(idxToSwap) < heap.get(currentIdx)) {
          swap(currentIdx, idxToSwap, heap);
          currentIdx = idxToSwap;
          childOneIdx = currentIdx * 2 + 1;
        } else {
          return;
        }
      }
    }

    public void siftUp(int currentIdx,  List<Integer> heap) {
      // get the parent of the current index
      int parentIdx = (currentIdx-1)/2;
      // if currentIdx is a valid index check if it's value is smaller that the parentIdx value
      while(currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
        swap(parentIdx, currentIdx, heap);
        currentIdx = parentIdx;
        parentIdx = (currentIdx-1)/2;
      }
    }

    public int peek() {
      return heap.get(0);
    }

    public int remove() {
      swap(0, heap.size()-1, heap);
      int val = heap.get(heap.size()-1);
      heap.remove(heap.size()-1);
      siftDown(0, heap.size()-1, heap);
      return val;
    }

    public void insert(int value) {
      heap.add(value);
      siftUp(heap.size()-1, heap);
    }

    public void swap(int i, int j, List<Integer> heap) {
      Integer tmp = heap.get(i);
      heap.set(i, heap.get(j));
      heap.set(j, tmp);
    }
  }
}
```
  
