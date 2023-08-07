import scala.quoted.*

def test(body: Expr[Any])(using Quotes): Expr[String] =
  body match
    case '{ [A] => (x : A) => $b[A] : A => A } => // error // error
      Expr("Hoas pattern should always take value params")
    case '{ [A] => (x : A) => $b(x) : A => A } => // error // error
      Expr("`A` should be in type arguments because `x` depends on it")
    case '{ (a:Int) => $b[Int](a) : String } => // error
      Expr("Type params of a hoas pattern should be introduced inside the quote")
    case _ => Expr("not matched")
