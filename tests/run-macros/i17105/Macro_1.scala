import scala.quoted.*

inline def testExpr(inline body: Any) = ${ testExprImpl('body) }
def testExprImpl(body: Expr[Any])(using Quotes): Expr[String] =
  body match
    case '{ def g(y: String) = "placeholder" + y; $a(g): String } =>
      '{ $a((z: String) => s"(1st case ${z})") }
    case '{ def g(y: String)(z: String) = "placeholder" + y; $a(g): String } =>
      '{ $a((z1: String) => (z2: String) =>  s"(2nd case ${z1}, ${z2})") }
    case _ => Expr("not matched")

// TODO issue-17105: Clean this up if not neccessary
// inline def test1: String =  ${ testExpr1 }
// def testExpr1(using Quotes): Expr[String] =
//   '{ def f(x: Int) = 1; val n = 2; f(n) } match
//     case '{ def g(y: Int) = 1; val n = 2; $a(g, n): Int } =>  Expr(a.show)
//     case _ => Expr("not matched")

// inline def test2: String = ${ testExpr2 }
// def testExpr2(using Quotes): Expr[String] =
//   '{ def f(x: Int, y:Int) = 1; f(1, 2) } match
//     case '{ def g(y: Int, z:Int) = 1; $a(g): Int } =>  Expr(a.show)
//     case _ => Expr("not matched")

// inline def test3: String = ${ testExpr3 }
// def testExpr3(using Quotes): Expr[String] =
//   '{
//       def f1(using Ordered[Int]) =
//         def f2(using Ordered[Int]) =
//           1 < 2
//         f2 || 2 < 3: Boolean
//    } match
//     case '{
//       def g1(using ord: Ordered[Int]) =
//         def g2(using Ordered[Int]) =
//           1 < 2
//         $a(g2, ord): Boolean
//     } => Expr(a.show)
//     case _ => Expr("not matched")
