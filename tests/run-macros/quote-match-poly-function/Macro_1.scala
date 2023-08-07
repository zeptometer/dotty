import scala.quoted.*

inline def testExpr(inline body: Any) = ${ testExprImpl1('body) }
def testExprImpl1(body: Expr[Any])(using Quotes): Expr[String] =
  body match
    case '{ [A] => (x : Int, y : Int) => $b(x, y) : Int } =>
      '{ "case 2 matched => " + $b(2, 3) }
    case '{ [A] => (x : A, y : A) => $b[A](x, y) : A } =>
      '{ "case 3 matched => " + $b[String]("truthy", "falsy") }
    case '{ [A] => (x : A, y : A) => $b[A](x, y) : (A, A) } =>
      '{ "case 4 matched => " + $b[String]("truthy", "falsy")._2 }
    case _ => Expr("not matched")
