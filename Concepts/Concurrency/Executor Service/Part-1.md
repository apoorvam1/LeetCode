In Java, running a task in a new thread goes as follows: 

```
public void static main(String[] args) {
  Thread t = new Thread(new Task());
  t.run();
  System.out.println("Printed from the main thread");
}

public static class Task implements Runnable {
  @Override
  public void run() {
    System.out.println("Printed from the child thread");
  }
}
```

What happens here is, during runtime Java creates a new thread sat thread-0. This thread will perform it's job and once done Java kills the thread. Main thread will continue to execute throught. 
