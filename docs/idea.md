## Process

**Source code** => **Tokens** => **Concrete Syntax Tree** => **Abstract Syntax Tree** => **Result**.

## Lexer



## Parser



## Abstract Syntax Tree

### Design

Before converting the concrete syntax tree to an abstract syntax tree, we need to design a specified form of AST. The structure of the AST is closely linked with the design of a compiler and its features. Although there is no convention or standard of the form, we should comply with the following requirements: (See [Wikipedia: Abstract syntax tree](https://en.wikipedia.org/wiki/Abstract_syntax_tree))

* Variable types must be preserved, as well as the location of each declaration in the source code.
* The order of executable statements must be explicitly represented and well-defined.
* The Left and right components of binary operations must be stored and correctly identified.
* Identifiers and their assigned values must be stored for assignment statements.

Before diving into the design, we need to nail down some concepts. As we look at the following Java code snippet, we can gain some insights. We have to contemplate: what kind of tree is the best one to describe this code snippet without leaving out any information?

~~~java
public static void main(String[] args) {
    int sum = 0;
    for (int i = 0; i < 10; i++) {
      	if (i % 3 == 0) sum += i * 2 + 1;
    }
    System.out.println(sum);
}
~~~

Some pioneers have answered this question. There are three kinds of structure: statement, expression, and literal.

Literal is the simplest. `0`, `10`, `3`, `2`, and `1` are literals in the above sample, and they are all integer types. Notice that we should specify the basicDataType of literals for the next semantic analysis. However, we don't have to parse their value, just keep them as lexemes.

An expression is a combination of values and functions that are combined and interpreted by the compiler to create a new value. The key phrase is "new value". That means an expression is always accompanied by a new value. The simplest expression is a literal, such as `0` on line 2 and `10` on line 3. `i * 2 + 1` is a more complex expression, which contains two binary operators.

A statement is just a standalone unit of execution and does not return anything. For instance, line 2 and line 4 are statements. In java, different statements are usually separated by semicolons. The second line is called an **assign-statement**, while the fourth line is called an **if-statement**. Notice that in the body of the if-statement contains one assign-statement. We will talk about the structure of statements soon.

#### Expression

Generally, one expression contains one **operator**. Operators behave like functions but differ syntactically or semantically. For example, the expression `a + b` contains a binary operator `+` and two operands `a` and `b`. As the name implies, a binary operator contains two operands, respectively the left operand and the right operand; a unary operator contains only one operand. (Examples of unary expressions: `!a`, `++b`).

So how we parse `i * 2 + 1`? It can be seen as: `left-expression + right-expression`, where the right-expression is simply a literal `1`, and the left-expression is `i * 2`. We can recursively derive any complicated compound expressions. Notice that a literal or an identifier are so-called "atom expressions". 

An expression can always yield a value, or say a result. For example, the result of `i * 2` is 6 when `i = 3`. The process of deriving a value from one or more operands is called **evaluation**. In computer science, we use **eval** to represent it. Operators can be seen as special functions. If we say the operator `*` is `multiply`, then we can rewrite `i * 2` as `multiply.eval(i, 2);`.

Besides those normal operators, we have some programming-particular operators, such as call operator `()` and subscript operator `[]` in Java. Take the call operator. Consider the expression `print("Hello World!");`. There are two operands here, one of which is an identifier `print` and the other is a literal `"Hello World!"`.

#### Statement

A statement can be regarded as a specific structure. A statement never yield a value, it is like a function with void return. Take `if (i % 3 == 0) sum += i * 2 + 1;` for example. The `i % 3 == 0` is a **bool-expression**, and the body is another statement. The meaning of it is: if the result of the bool-expression is true, then the statement in the body will be executed. The original statement can then be rewrite as `if (bool-expression1) statement1;`. With these preludes, we can now define the structure of if-statement:

~~~pseudocode
class IfStatement {
		BoolExpression boolExpression;
		List<Statement> statementList; 	/* if-body */
		List<Statement> elseStatementList;	/* else-body */
}
~~~

Let's define one more—assignment-statement.

~~~pseudocode
class AssignmentStatement {
		Expression target;
		Expression valueExpression;
}
~~~

### Implementing

First we create a `Node` abstract class, it is the node of the AST.

~~~java
public abstract class Node {}
~~~

Then we create `Stmt`, `Expr` and `Type` abstract classes respectively extend `Node`.

~~~java
public abstract class Type extends Node {}	// literal
public abstract class Expr extends Node {}	// expression
public abstract class Stmt extends Node {}	// statement
~~~

After that we create some concrete classes extends them.

~~~java
public class IntType extends Type {}		// integer basicDataType
public class FloatType extends Type {}	// float basicDataType 
~~~

~~~java
public class UnaryExpr extends Expr {
  private UnaryOp operator;
  private Expr operand; 
}

public class BinaryExpr extends Expr {
  private BinaryOp operator;
  private Expr leftOperand;
  private Expr rightOperand;
}

public class BoolExpr extends Expr {
  private BoolOp operator;
  private Expr leftOperand;
  private Expr rightOperand;
}

public class IdExpr extends Expr {
  private Id value;
}

public class AttributeExpr extends Expr {
  private Expr value;
  private Id attribute;
}

public class BlockFnExpr extends Expr {
  private List<Stmt> stmtList;
  private Stmt returnStmt;
  private Stmt breakStmt;
  private Stmt continueStmt;
}
~~~

~~~java
public class AssignStmt extends Stmt {
  private Expr basicDataType;
  private Expr target;
  private Expr value;
}

public class CallStmt extends Stmt {
  private Expr target;
  private List<Expr> argumentlist;
}
~~~

