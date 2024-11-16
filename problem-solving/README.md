## String Facts in Java

- For String, StringBuffer, and StringBuilder, charAt() is a constant-time operation because String class uses an array to store the characters.
- For StringBuffer and StringBuilder, deleteCharAt() is a linear-time operation.
- StringBuffer and StringBuilder have very similar performance characteristics. The primary difference is that the former is synchronized (so is thread-safe) while the latter is not.