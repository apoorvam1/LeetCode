To enable parallelism we can use
- Threads
- ThreadPool
- Requires more than 1 CPU

Concurrency
Scenario: Threads t1 & t2 are updating a shared variable and CPU has only 1 core. 
Scheduler has schedule threads 1 at a time. It's called threads interleaving. Time given by scheduler to each thread is undeterministic. 
Scheduler might remove t1 from execution before it finishes all instructions. This might cause problem. 

Solution: Introduce a lock. Each thread should use same lock before executing instructions. 

 - locks
 - synchronised
 - concurrent DS
 - CountdownLatch/Semaphonres
