# Specification

## Code

Facing the same requirement, one thousand developers provide one thousand kinds of runnable code. However, some are messy, inefficient, and difficult to maintain, while others are elegant, robust, and legible. Rightfully, we should write the latter. There come the code style standards, and this project will comply with the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).

Moreover, developers should properly comment on every class, every property, and every method in [JavaDoc](https://en.wikipedia.org/wiki/Javadoc) style (Non-functional classes such as exception classes are excluded). Class declarations should contain the name of the authors. Only the authors of a class have permission to modify or delete it. Any branch that modifies classes of other authors will not be merged into the main branch unless authorized or specified.

This project is written in [Java17 LTS](https://docs.oracle.com/en/java/javase/17/). The version of maven is `3.8.x`.

## Git

## Abbreviation

| Full name            | Abbreviation/acronym | Comment                              |
| -------------------- | -------------------- | ------------------------------------ |
| expression           | expr                 |                                      |
| statement            | stmt                 |                                      |
| attribute            | attr                 |                                      |
| concrete syntax tree | CST                  |                                      |
| abstract syntax tree | AST                  |                                      |
| return               | rtn                  |                                      |
| declaration          | decl                 | The "declarator" should not use this |

