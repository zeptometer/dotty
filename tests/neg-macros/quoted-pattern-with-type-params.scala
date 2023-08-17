/**
  * Refer to: neg-custom-args/quoted-pattern-poly/quoted-pattern-with-type-params.scala
  */
import scala.quoted.*

def test(body: Expr[Any])(using Quotes): Expr[String] =
  body match
    case '{ [A] => (x : A) => $b[A] : (A => A) } => // error
      Expr("A higher-order pattern must carry value params")
    case '{ [A] => (x : A) => $b(x) : (A => A) } => // error
      Expr("`A` should be in type arguments because `x` depends on it")
    case '{ (a:Int) => $b[Int](a) : String } => // error
      Expr("Type params of a hoas pattern should be introduced inside the quote")
    case _ => Expr("not matched")
