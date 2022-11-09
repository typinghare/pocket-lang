# Abstract Syntax Tree

## Overview

This document is a specification of the design, including data structure and design pattern, of the abstract syntax tree of Pocket. Although it is not a mandate to let the grammar comply with the data structure of the abstract syntax tree, it is considered to be a good practice to make them consistent. This documentation will revolve around the following simple example:

~~~typescript
// hello-word.pok
{
		Int a = 2 b = 3, c = 4, d;
  	d = a + b * c;
  	Console.print(d);
}
~~~

As this project progresses, this document will be continually added. However, we do not consider any other statement of expression that is not included in the document now.

## Stmt

### ExprStmt

~~~tsx
class ExprStmt extends Stmt {
  Expr expr;
}
~~~

It is quite common that a statement consists of a sole expression. Given that an expression is not allowed to appear in some structures, we use `ExprStmt` to contain it. For instance, the following statement can also be seen as an expression.

~~~typescript
Console.print(d);
~~~

### AssignStmt

~~~typescript
class AssignStmt extends Stmt {
  Expr type;
  List<Expr> targetList;
  List<Expr> valueList;
}
~~~

The assignment statement is a basic kind of statement. The `type` attribute, which implies the type of target variables, is the leftmost expression of this statement. Since there can be more than one assignments in an assignment stament, the target and value are lists. Target and value in two lists are corresponding. Take the third line for example, the target list and value list are respectively:

~~~typescript
targetList: ["a", "b", "c", "d"]
valueList: ["2", "3", "4", null]
~~~

In Pocket, the `type` attribute can be `null`. For example, the fourth line doesn't declare the type of target `d`. Note that in Pocket, **a variable is not allowed to change its type in a single scope**.

## Expr

### IdExpr

~~~typescript
class IdExpr extends Expr {
  String value;		// id
}
~~~

Id expression is one of the atom expressions. The attribute `value` is the name of the identifier. For instance, the `a` in line 3 is an id, so it will  look like `Id("a")` in the AST.

### TypeExpr

~~~typescript
class TypeExpr extends Expr {
  Type type;
}

abstract class Type extends Node {
  protected String literal;
}

class IntType extends Type {}
class FloatType extends Type {}
class StrType extends Type {}
class BoolType extends Type {}	// "true" or "false"
class NullType extends Type {}	// "null"
~~~

Type Expression is another atom expression. The `literal` attribute is the literal of a token. For example, "2" is an integer literal, so it pertains to the `IntType`; "true" is a boolean literal, so it is `BoolType`. There are four concrete types as above.

### AttrExpr

~~~typescript
class AttrExpr extends Expr {
  Expr target;
  IdExpr attr;
}
~~~

Attribute expression. Take `Console.print` as example, `Console` is the target, while `print` is the attribute of the target. A complicated example is the nested attribute expression, such as `System.out.println`. `System.out` can be seen as a target expression, which should be an attribute expression with `System` as target and `out` as attribute; then `println` can be seen as the attribute expression (an id expression).

### UnaryExpr

~~~typescript
class UnaryExpr {
  UnaryOp unaryOp;
  Expr operand;
}
~~~

### BinaryExpr

~~~typescript
class BinaryExpr extends Expr {
  BinaryOp binaryOp;
  Expr left;
  Expr right;
}

enum BinaryOp {
  PLUS, MINUS, MULTIPLY, DIVIDE, MOD;
}
~~~

A binary expression is a expression which is separated into two parts by an operator. For instance, `a + b` is a binary expression, where `+` is a binary operator, `a` is the left operation, and `b` is the right operation. `a + b * c` is a nested binary expression, where:

~~~java
a + b * c = 'a' '+' 'b * c'
b * c = 'b' '*' 'c'
~~~

### BlockFnExpr

~~~typescript
class BlockFnExpr extends Expr {
  Expr returnType;
  List<Stmt> stmtList;
  Stmt returnStmt;
}
~~~

A block function expression is a function without parameters, including the parentheses. The whole six lines of the example is a block function, the return type of which is ignored. If the return type is missing, the default value is `void`, meaning that the function should not have a return value as well as a return statement.

### CallExpr

~~~typescript
class CallExpr extends Expr {
  Expr target;
  List<Expr> argList;
}
~~~

Line 5 is a classic call expression. The target of this call expression is `Console.print`, and the only argument of it is `d`. Therefore, the argument list of this call expression contains only one element.

### FnExpr

~~~typescript
class FnExpr extends BlockFnExpr {
  List<Expr> typeList;
  List<IdExpr> paramList;
}
~~~

A function expression is a function with parameters. We do not implement this expression for the time being.
