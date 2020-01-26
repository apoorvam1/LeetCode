### MD5
* MD5 is a widely used hashing function that produces a 128-bit hash value
* MD5 is uniformly distributed

### base 62 encoding
* Base 62 encodes to [a-zA-Z0-9] which works well for urls, eliminating the need for escaping special characters
* There is only one hash result for the original input and Base 62 is deterministic (no randomness involved)
* Base 64 is another popular encoding but provides issues for urls because of the additional + and / characters
