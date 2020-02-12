Suppose you are given the following code:
```
class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
```
The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.

 
```
Example 1:

Input: n = 1
Output: "foobar"
Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
Example 2:

Input: n = 2
Output: "foobarfoobar"
Explanation: "foobar" is being output 2 times.
```

**Solution**

```
class FooBar {
    private int n;
    private boolean printfoo = true; // set value to true so we can assure that foo() will be called first

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized (this) {
                /*
                   If the first thread is here, that means it's already acquired
                   this object's lock, so the second thread (or any other) gets blocked
                   until the lock is released.
                 */
                while (!printfoo) {
                    /*
                        If wait() is called, the first thread releases the lock (VERY IMPORTANT)
                        and waits until the other thread calls notifyAll() inside the bar() method.
                        That guarantees our code won't deadlock.
                     */
                    wait();
                }
                printFoo.run(); // print "foo"
                
                /*
                    Here we set printFoo to false in order to assure that if the thread scheduler
                    chooses this thread again, it will stop on the while loop and wait for the second
                    one.
                 */
                printfoo = false;

                /*
                    When notifyAll() is called, the second thread will get out of the while loop
                    inside bar() and continue its job (to print "bar")
                 */
                notifyAll();
            }
        }
    }

    // the whole process is the same with the bar method
    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized (this) {
                while (printfoo) {
                    wait();
                }
                printBar.run(); // print "bar"
                
                printfoo = true;
                notifyAll(); // wake up the first thread
            }
			// lock is released
        }
    }
}
```
