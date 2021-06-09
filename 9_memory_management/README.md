Memory Management
==

## 1. Explain the difference between CMS and G1GC in java and discuss when it is appropriate to use each method.

Both are designed to minimize long pause when performing GC.

#### CMS GC: Concurrent Mark Sweep Garbage Collector
It's designed to eliminate the long pause associated with the full gc of previous parallel & serial collector. It uses one or more thread to scan the memory periodically and remove the unused objects, where pause time is minimal but cpu time is more. This collector is for applications that prefer shorter garbage collection pauses and can afford to share processor resources with the garbage collection. It's derepcated since Java 9 and removed since Java 14.

#### G1 GC: Garbage First Garbage Collector
G1GC – Similar to CMS, it uses multiple background gc threads to scan & clear heap. It divides old generation into parts and cleans old generation by copy from one part to another thus less prone to fragmentation. Since Java 9, this is the default for server class machine.

#### discussion
* For new projects using newer SDK, G1 is preferred as CMS deprecation is imminent
* In most cases, G1 can replace CMS
* For large heap (>4GB) use G1 GC
* In some cases where heap size and pause-time goal cannot be met with G1 but CMS then CMS should be used
