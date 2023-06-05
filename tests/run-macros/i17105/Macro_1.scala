import scala.quoted.*

inline def testExpr(inline body: Any) = ${ testExprImpl('body) }
def testExprImpl(body: Expr[Any])(using Quotes): Expr[String] =
  body match
    case '{ def g(y: String) = "placeholder" + y; $a(g): String } =>
      '{ $a((z: String) => s"[1st case] ${z}") }
    case '{ def g(y: String)(z: String) = "placeholder" + y; $a(g): String } =>
      '{ $a((z1: String) => (z2: String) =>  s"[2nd case] ${z1}, ${z2}") }
    // case '{ def g[A](x: A) = List(); $a(g): String } =>
    //   '{ $a([A] => (x: A) => List(x, x)) }
    case _ => Expr("not matched")

inline def testCtxParam(inline body: Any) = ${ testCtxParamImpl('body) }
def testCtxParamImpl(body: Expr[Any])(using Quotes): Expr[String] =
  body match
    /* TODO issue-17105: Following cases causes type errors, which seems to be
     * different issue from 17105 */
    // case '{ given i: String = "given"; def g(using s: String) = "placeholder"; $a(g, i): String } =>
    //   '{ $a((s: String) => s"[3rd case] ${s}")("another_given") }
    // case '{ def g(using s: String) = "placeholder"; $a(g) } =>
    //   '{ $a((s: String) => s"[3rd case] ${s}") }
    case _ => Expr("not matched")
