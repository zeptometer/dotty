/*
 * Supporting hoas quote pattern with bounded type variable
 * is future todo.
 */

import scala.quoted.*

def test(body: Expr[Any])(using Quotes): Expr[String] =
  body match
    case '{ [A <: Int, B] => (x : A, y : A) => $b[A](x, y) : A } => // error
      '{ $b[String]("truthy", "falsy") }
    case _ => Expr("not matched")
