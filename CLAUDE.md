# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project overview

A personal practice repository for **design patterns** and **DSA/interview problems** in Java. It's set up as a Spring Boot 3.3.3 Gradle project (Gradle 8.4 wrapper, Java 21, Lombok), but Spring is barely used: `com.DesignPattern.DesignPatternApplication` is an empty bootstrap. Nearly every other class is a standalone program with its own `public static void main`, run individually from the IDE.

## Layout (`src/main/java`)

- Design patterns, one package each: `Singleton`, `factoryPattern`, `abstractFactoryPattern`, `Builder`, `DecoratorDesignPattern`, `ObserverDesignPattern`, `strategyPattern`, `solidPrinciples.liskovSubstitutionPrinciple`, `immutable`. Each usually has a `*Main`/`*Demo` class that runs it.
- Problems are grouped by topic: `array`, `string`, `linkedlist`, `tree`, `interval`, `Heap`, `recursion`, `leastRecentlyUsed`. Company-specific prep is in `walmart` and `forwardNetworks`.
- Some files sit in the default package (e.g. `Anagrams`, `Practice`, `DutchFlag`, `CountingSort`, `ShipWithinDays`).
- Package names don't follow one convention (mixed case such as `Singleton` or `Heap`). Match the existing package when adding to a topic. Helper types like `ListNode` and `Node` are duplicated per package rather than shared.

Problem statements and approach notes are usually written as comments above the solution. Verification is done via `main` with sample inputs, not unit tests.

## Commands

```bash
./gradlew build
./gradlew test
```

To run a single standalone class without Spring (needs JDK 21 on PATH):

```bash
./gradlew compileJava && java -cp build/classes/java/main array.TwoSum
```

`bin/` is Eclipse's output folder and is (unfortunately) tracked in git. Don't hand-edit it.
