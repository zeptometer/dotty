import scala.quoted.*

def test(body: Expr[Any])(using Quotes): Expr[String] =
  body match
    case '{ [A] => (x : A, y : A) => $b[A](x, y) : A } =>
      '{ $b[String]("truthy", "falsy") }
    case '{ [A, B] => (x : A, f : A => B) => $b[A, B](x, f) : B} =>
      '{ $b[Int, String](10, (x:Int)=>x.toHexString) }
    case _ => Expr("not matched")
