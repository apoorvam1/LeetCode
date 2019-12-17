* Creating an index on a field in a table creates another data structure which holds the field value, and a pointer to the record on the disc it relates to.
* This index structure is then sorted, allowing Binary Searches to be performed on it.
* The Query looks for the specific row in the index, the index refers to the pointer which will find the rest of the information.



* The downside to indexing is that these indices require additional space on the disk since the indices are stored together in a table
* This file can quickly reach the size limits of the underlying file system if many fields within the same table are indexed.



