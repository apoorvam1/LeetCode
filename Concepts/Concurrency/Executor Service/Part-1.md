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

If there are more tasks the same code above can be extented as follows

```
public void static main(String[] args) {
  for(int i = 0; i < 10; i++) {
    Thread t = new Thread(new Task());
    t.run();
  }
  System.out.println("Printed from the main thread");
}

public static class Task implements Runnable {
  @Override
  public void run() {
    System.out.println("Printed from the child thread");
  }
}
```

Java will create new threads and execute the task with each of those as shown below: 
![Creating multiple threads](https://github.com/apoorvam1/LeetCode/blob/master/Concepts/Concurrency/Screen%20Shot%202020-02-20%20at%202.21.09%20PM.png)

What if you need to run 1000 tasks? Will creating 1000 threads be feasibile? 
- No! Thread creation operation itself is time consuming and 1 java thread corresponds to 1 OS threads. It's limited by the CPU cores. 

Instead, what we need is a pool of threads that are created before hand. They pick up the tasks one after the other and execute. 

```
public void static main(String[] args) {
  ExecutorService service = Executors.newFixedThreadPool(10);
  for(int i = 0; i < 10; i++) {
    service.execute(new Task());
  }
  System.out.println("Printed from the main thread");
}

public static class Task implements Runnable {
  @Override
  public void run() {
    System.out.println("Printed from the child thread");
  }
}
```

Here, at any point in time there are only 10 threads running. Any excess tasks are queued up in a blocking queue. Since multiple threads try to access tasks from the queue it has to be thread safe. Blocking queue serves this purpose. 


**What is the ideal number of threads for an application?**

- If the run method is CPU intensive and application has a lot of threads the threads scheduler will keep swapping threads execution on CPU. This might hinder the application performance. The solution would be to have number of threads = number of CPU cores. 

- If the run method is IO intensive, all the threads might go to waiting state at some point. That will leave all CPUs unutilized and no threads left in the pool. In such cases it might be ideal to keep the thread pool size high. Exact number depends on the average wait time.  





