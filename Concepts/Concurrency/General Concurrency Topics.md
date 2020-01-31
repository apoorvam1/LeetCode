**Process and Threads**

http://stackoverflow.com/questions/200469/what-is-the-difference-between-a-process-and-a-thread?rq=1

What is a Process?
- A process is an instance of executing program
- Its an abstract container entity for running threads
- Every process gets its own memory space, system resources like network sockets, file handles etc

What is a Thread? 
- Thread is a set of instruction that can be executed.
  * Ex: JVM works with multiple threads : JIT, Garbage collector
- Thread resides within the process that is scheduled for execution
- Threads within the same process share the process's memory space
- Every thread gets its own stack, registers
 -Every thread has an execution context (CPU register values)  which it can use to resume its operation
 
**Inter thread communication and Inter process communication**

http://stackoverflow.com/questions/2527847/java-inter-process-communication-and-inter-thread-communication

Inter thread communication 
- Coordinating the execution within a process through mechanisms like wait(), notify(), notifyAll()
- It’s about coordinating the access to the shared resources, passing reference objects

Inter process communication
- Processes can communicate with other processes through sockets, files, pipes, shared memory, semaphores

**Difference Between wait() and sleep()**
- When a thread calls wait() it releases lock but sleep() doesn’t
- wait() is used for inter-thread communication while sleep() is used to pause the execution
- Waiting thread can be woken up by notify() but sleeping thread can’t be woken up from notify() but it can be interrupted.
- wait() and notify() must happen within the synchronized block, but sleep() need not be
- sleep() is for time-synchronization and wait() is for thread synchronization
- wait() operates on Object and is defined in Object class and sleep() operates on current thread is defined in the Thread class

**Running Process In The Background**

Options for concurrency API

*ThreadPoolExecutor*
      
Why thread pool? 
	- Spawning a separate thread to perform same task again and again takes 4 times more than using the same thread to perform the task again and again. 

It provides an abstraction layer around the management of asynchronous task. It maintains a pool of threads. The thread reference is held for some time once it completes an execution during which time it can be reused. This saves time.

Types of thread pools
- Cached : used for lightweight asynchronous tasks
		* Threads are automatically created if no thread is available for the task
		* Idle threads are reused and will terminate after 60 sec of inactivity
- Fixed : Used for heavy, long running tasks
	  * Fixed number of threads are constantly maintained
 	  * Threads are active until they are shut down

- ForkJoinPool
  * Parent process usually waits in idle state until child finishes. 
  * Threads are daemon threads, the main execution thread will not wait for these when JVM shuts down
  * The thread that’s blocked by a child could keep itself busy by doing something else in the meantime
  * Used for nested concurrency and recursion

- Blocking Queue
  * Tasks are put in the blocking queue from where worker threads pickup the task
  * It provides inbuilt synchronization techniques to access the queue along with consumer-producer pattern.
  
  
**Scheduler**

In a single core CPU it can perform only operation at a given time. In a multicore CPU we can perform ‘number of core’ operations at the same time. 
Thread Scheduler is responsible for CPU time share among the threads

**Race Condition**

When two different threads are trying to read and write same resource at the same time. A code section that leads to race conditions is called a critical section.

Example of Race Condition through Singleton Pattern:

```
public class Singleton {
	private Singleton instance  = null;
	private Singleton() { }

	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance; 
	}
}
```

What happens when two threads call getInstance() at the same time? 

![Race Condition] (https://github.com/apoorvam1/LeetCode/blob/master/Concepts/Concurrency/Screen%20Shot%202020-01-30%20at%2010.46.36%20PM.png)


*Preventing Race Condition*
- The critical section must be executed as an atomic instruction, i.e through thread synchronization.
- It could be through Synchronized blocks, locks or using atomic variables. 







