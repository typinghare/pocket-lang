# Pocket

## Overview

**Pocket** is positioned as an **objected-oriented** as well as a **functional programming** scripting language. It includes the following features

* **Easy to write**. You don't have to write a bunch of code for a simple script or application.
* **Strongly typed language**. Pocket is a strongly typed language like C++ and Java. However, it provides a series of features to avoid unnecessary declarations to expedite your development speed.
* **Pointerless**. Pocket doesn't have pointers. It follows the concept of "everything is an object" in Java.

## Get started

### Hello World

To write a hello-world-sample in Java is pretty easy.

~~~typescript
{
	Console.print("Hello World!");
}
~~~

### Print odd numbers from 1 to 100

~~~javascript
{
  i = 1;	// assign 1 to iterative variable `i`
  loop {
    Console.print(i);
    i += 2;
    if (i > 100) break;
  }
}
~~~

Or you can do like this:

~~~javascript
{
  printOddNumbers = (Int lower, Int upper) {
    i = lower;
    return {
      Console.print(i);
    	i += 2;
    	if (i > upper) break;
    }
  }
  
  loop printOddNumbers(1, 100);
}
~~~

## Syntax

### Data types

There are four **basic data types** in Pocket: `Int`, `Float`, `Bool`, and `Str`; three **structural data types**: `Array`, `List`, and `Map`; one special data basicDataType: `Func`. The declarations of different data types are as follows.

~~~java
Int myInt = 5;
Float myFloat = 2.5;
Bool myBool = true;
Str myStr = "String";

Array myArray = Array(5);
List myList = List();
Map myMap = Map();

Func myFunc = {
  Console.print("Hello World!");
};
~~~

