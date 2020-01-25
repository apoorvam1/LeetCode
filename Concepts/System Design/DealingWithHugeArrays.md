Array does not fit in memory

Below are the possible operations to be performed on them

1. Sort the array (of size say 900MB using 100MB RAM)
   a. Read a chunk of data (say 100MB) into memory and sort it
   b. Write each such sorted chunk into a file
   c. Similar to merge sort which merges 2 sorted arrays perform K-way merge to merge all these chunks. Use input buffer and output buffer to read and write the data. 
   
   Reference: https://en.wikipedia.org/wiki/External_sorting#External_merge_sort
