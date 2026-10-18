# Design patterns and DSA in Java

My working notebook for object-oriented design and data-structures practice: the classic design patterns written as small runnable examples, plus solutions to common interview problems grouped by topic. Most solutions have the problem statement and the approach written as a comment above the code.

**Stack:** Java 21 · Gradle · Lombok

## Design patterns

| Pattern | Package | Example |
|---|---|---|
| Singleton | `Singleton` | eager, synchronized, and double-checked locking versions |
| Factory | `factoryPattern` | `ShapeFactory` creating circles and rectangles |
| Abstract factory | `abstractFactoryPattern` | Mac and Windows UI widget families |
| Builder | `Builder` | building a `Computer` step by step |
| Decorator | `DecoratorDesignPattern` | coffee with milk and sugar decorators |
| Observer | `ObserverDesignPattern` | a YouTube channel notifying subscribers |
| Strategy | `strategyPattern` | card, UPI and wallet payments |
| SOLID | `solidPrinciples` | Liskov substitution |
| Immutability | `immutable`, `ImmutableClassPerson` | writing immutable classes |

## Problems by topic

| Topic | Package | Examples |
|---|---|---|
| Arrays | `array` | Two Sum, 4Sum, Container With Most Water, rotated arrays |
| Strings | `string` | Minimum Window Substring, Longest Palindromic Substring, Group Anagrams |
| Linked lists | `linkedlist` | reverse, reorder, merge k sorted lists, cycle detection |
| Trees | `tree` | k-th smallest / largest in a BST |
| Intervals | `interval` | merge, insert, non-overlapping intervals |
| Heaps | `Heap` | top-k frequent elements |
| Caching | `leastRecentlyUsed` | LRU cache with a hash map and doubly linked list |
| Recursion | `recursion` | file search, recursive and queue-based |
| Comparators & equality | `comparator`, `equality` | sorting and `equals`/`hashCode` |

## Run an example

Every class has its own `main` method. Needs JDK 21.

```bash
./gradlew compileJava
java -cp build/classes/java/main strategyPattern.PaymentMain
java -cp build/classes/java/main leastRecentlyUsed.LRUCache
```
