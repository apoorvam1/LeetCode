Question:
The goal is to identify a crashing or exception bug and provide a fix in the following pseudo code. 
There is a single producer and multiple consumers. The producer puts items on the queue, 
while the consumers remove items from queue and process them. condition.signal() will wake up one of the 
blocked consumers waiting on the condition. While waiting in blocked state, wait() will release the mutex. 
Upon receiving the signal, wait() will unblock and re-acquire the mutex. 
There are sufficient consumers to process the items where the queue will not build up. 
Context switch can occur anywhere in the code. Please describe how the bug can occur and provide a fix. 

Producer
`while (true) {
       item = generate_item()
       mutex.lock()
       fifo_queue.push(item)
       mutex.unlock()
       condition.signal()
}`

Consumers
`while(true) {
       mutex.lock()
       if (fifo_queue.empty()) {
             condition.wait(mutex)
       }
       item = fifo_queue.remove()
       mutex.unlock()
       process_item(item)
}`


Solution: 
The bug is that, 
It is possible that after the producer produces and releases the lock any consumer can acquire the lock and consume the data. Once the producer signals the sleeping thread, the sleeping thread
re-aquires the lock and tries to consume. But the data might have been already consumed by another consumer who was waiting for the lock. This action of the sleeping thread results in an exception .

Changing the if condition check to while in the consumer would solve this issue. When the sleeping thread wakes up, it goes back to check if the queue has data. since the other consumer already 
consumed the data this consumer will go back to sleep again.

Since it is mentioned that there are sufficient consumers to process the records and the buffer is unbounded we will not need the producer to wait on the condition.

Producer
`while (true) {
       item = generate_item()
       mutex.lock()
       fifo_queue.push(item)
       mutex.unlock()
       condition.signal()
}`

Consumers
`while(true) {
       mutex.lock()
       while (fifo_queue.empty()) {
             condition.wait(mutex)
       }
       item = fifo_queue.remove()
       mutex.unlock()
       process_item(item)
}`

Reference: 

http://pages.cs.wisc.edu/~remzi/OSTEP/threads-cv.pdf (Page 9, 10, 11)
