A variable declared as volatile is immiditely flushed to RAM when it is written. Once it is flushed to RAM it becomes available for other threads as well.

Ex:  
int value = 1;  
Thread t1 and Thread t2 perform value++.   
value might not increment one after the other here.  

Solution is to use AtomicInteger.   
AtomicInteger value = new AtomicInteger(1);  
t1.increment() & t2.increment() will behave as expected now.  


If only 1 thread is writing to a variable use volatile. If multiple threads are updating the variable use atomic.   

