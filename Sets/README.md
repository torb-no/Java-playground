# Sets in Java

Just an attempt at creating really simple set structure in Java. Intended to match definitions from [this book](http://www.universitetsforlaget.no/nettbutikk/logiske-metoder.html).

Currently have a Array-based implementation that have:
 - Add and remove elements, replace contents
 - Basic queries like is empty set, is subset of, is equal to, contains element
 - Basic operations like union, intersect and set difference
 
 
Would be interesting to do:
  
- Implement infinite sets. For example, be able create a set of all numbers above 5. This will probably have be stored as metadata, not individual elements internally.