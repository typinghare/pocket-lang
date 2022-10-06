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
  printOddNumbers = Fn (Int lower, Int upper) {
    i = lower;
    return {
      Console.print(i);
    	i += 2;
    	if (i > upper) break;
    }
  }
  
  loop printOddNumbers(1, 100);

	loop {
      Console.print(i);
    	i += 2;
    	if (i > 100) break;
   }
}
~~~

## Data types

There are four **basic data types** in Pocket: `Int`, `Float`, `Bool`, and `Str`; three **structural data types**: `Array`, `List`, and `Map`; one special data type: `Fn`. The declarations of different data types are as follows.

~~~java
Int myInt = 5;
Float myFloat = 2.5;
Bool myBool = true;
Str myStr = "String";

Array myArray = Array(5);
List myList = List();
Map myMap = Map();

Fn myFn = {
  Console.print("Hello World!");
};
~~~

### Array

~~~typescript
// declare an Int array of length 5
Array<Int> array = [5]();

// single assignment
array[0] = 5;

// range assignment, [from, to)
array[1, 5] = (10, 15, 20, 25);

// get the value of a specified index
Console.print(array[1]);	// >> 10

// array copy
Array<Int> array2 = [3]();
array2[0, 3] = array[0, 3];
~~~

Quick intiliazation.

~~~typescript
// create an array of fixed length
Array<Int> array = (5, 10, 15, 20, 25);
~~~

### List

The usage of `List` is similar to `Array`, but you do not have to specify a length when declare. It can automatically resize when adding elements.

~~~typescript
// declare a Str list
List<String> list = ();

// assignment
list[0] = "America";
list[1, 3] = ("China", "Japan");

// get the size of list
Console.print(list.size()); 	// >> 3

// remove an element
delete list[1];
Console.print(list[1]);	// >> null
~~~

### Map

~~~typescript
// declare a map
Map<String, String> captialMap = ();

// put an entry
capital["China"] = "Beijing";

// put multiple entries
capital += (
	"America" -> "Washington",
  "Japan" -> "Tokyo"
);

// update a value
capital["China"] = "Shanghai";	// 😅

// get a value
Console.print("Japan"); // >> Tokyo

// delete a key
delete capital["America"];

// test is a key exists
Console.print(capital.contain("Mexico"));	// >> false
Console.print(capital["Canada"]);	// >> null
~~~

#### Fn

#### Block Function

A function without any parameter is called a **block function.** Block functions acts like a code block rather than a normal function.

~~~typescript
// declare a block function
// `void` is the return type of the function, `void` can be omitted
Fn blockFunction = void {
  Console.print("I am a block function!");
}

// notice that the following functino is seen as a parametric function
// because a pair of parentheses is leading, even though it contains no parameter
Fn fn = () {
  Console.print("I am a parametric function!");
}
~~~

#### Parametric function

~~~typescript
// declare a parametric function
// the return type is written in-between `=` and `(`
Fn parametricFunction = void (Str message) {
  Console.print(message);
}
~~~

## Function Control

### Return keyword

Use the `return` keyword to stop the function at anywhere, and return a specified value. Unlike `break` and `continue`, the `return` keyword can **escape all block function**.

~~~typescript
fn = Int () {
  i = 5;
  loop {
    i += 3;
    if (i > 10) 
      return i;	// stop the loop and return the value
  };
}

Console.print(fn());	// >> 11
~~~

#### Break and continue keyword

Use the `break` keyword to stop the function at anywhere. If the function is looping, then it will exit the loop; the `continue` keyword can stop the function as well, but the loop will not exit. These two keywords only **escape the current function**.

### Static

The `static` keyword can mark a variable as static, and the variable will be initialized only once.

~~~typescript
fn = void () {
	static i = 5;
  i += 2;
  return i;
}

Console.print(fn());	// >> 7
Console.print(fn());	// >> 9
Console.print(fn());	// >> 11
~~~

### Export and import

The `export` keyword can export variables from a function, and `import` keyword can be used to import those variables.

~~~typescript
fn = void () {
  export static name = "James";
  export age = 23;
  static city = "Quincy"
}

import [name, age, city] = fn;
Console.print(name);	// >> James
Console.print(age);		// >> 23
Console.print(city);	// >> null
~~~

How it works: The VM will first invokes the function `fn` and collects all exported variables, in this case, both `name` and `age`; then assign the value to variables with the same label.

