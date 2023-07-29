/*
 * Supporting hoas quote pattern with bounded type variable
 * is future todo.
 */

import scala.quoted.*

def test(body: Expr[Any])(using Quotes): Expr[String] =
  body match
    case '{ [A] => (x : A) => $b[A] : A => A } => // error // error
      '{ $b[String]("str") } // error
    case _ => Expr("not matched")
