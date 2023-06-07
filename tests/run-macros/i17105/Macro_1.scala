import scala.quoted.*

inline def testExpr(inline body: Any) = ${ testExprImpl('body) }
def testExprImpl(body: Expr[Any])(using Quotes): Expr[String] =
  body match
    case '{ def g(y: String) = "placeholder" + y; $a(g): String } =>
      '{ $a((z: String) => s"[1st case] ${z}") }
    case '{ def g(y: String)(z: String) = "placeholder" + y; $a(g): String } =>
      '{ $a((z1: String) => (z2: String) =>  s"[2nd case] ${z1}, ${z2}") }
    case '{
      type t
      def p(a: `t`): String = $x(a): String
      $y(p): String
    } =>
      '{ $y($x) }
    case _ => Expr("not matched")
