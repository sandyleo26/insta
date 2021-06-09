Concurrency Programming
==

Disclaimer: I have to read up some tutorial before coding as my Java knowledge is outdated. Therefore I'm not sure if this is the idiomatic way to do this using Java today. I'll be much more comfortable using Go's goroutine and channel for this kind of task.

Note: I've uploaded projects: `hello` and `hello2`. The first one is based on Stream API and this is the first solution coming to my mind. It's declarative and simple. However, I made the second `hello2` project which is based on `ExecuationService` because I re-read the requirements and notice the following:

> The threads that generate the random numbers.`

I thought maybe I'm expected to make the "thread" more explicit by using a thread pool hence submitting both projects.


Except the difference in generating threads, the 2 solutions are very similar: the critical section includes:

* a deque, which serves as a sliding window to track the last 30 numbers.
* a counter, which tracks the occurances of last 30 numbers

Then I use a mutex to control access to the critical section therefore avoid race condition.

The algorithm works as below

1. when a number is generated, i first append it to the end of the deque, and update the counter
2. if the deque length is > 30, then I pop the head of deque and meanwhile decrease the corresponding counter
3. calculate metrics using counter and print results

I've added some unit tests but due to time limit I haven't tested the number generation and multi-threading part. If I had more time, I'll probably make the random source configurable and expose the `counter` and `deque` so it's more testable. As for multi-threading, I haven't researched if Java has something like Go's built-in race detector? If so that'll help detecting potential race condition.
