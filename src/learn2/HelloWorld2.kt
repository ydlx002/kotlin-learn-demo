package learn2

import kotlin.math.E

/**
 *
 *@Package learn2
 *@Author lizhenhua
 *@Date 2018/7/5 8:44
 */

//枚举类,声明中相对java 多了个class，enum是软关键字：只有当它出现在
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class Color2(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238)
}

//when 处理枚举
fun getMnemonic(color: Color) =
        when (color) {
            Color.RED -> "Richard"
            Color.ORANGE -> "Of"
            Color.YELLOW -> "York"
            Color.GREEN -> "Gave"
            Color.BLUE -> "Battle"
            Color.INDIGO -> "In"
            Color.VIOLET -> "Vain"
        }

//when 合并多个选项
fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

//在when结构中使用任意对象
fun mix(c1: Color, c2: Color) = when(setOf(c1,c2)){
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
    else -> throw Exception("dirty color")
}

//不带参数的when
fun mixOptimized(c1: Color, c2: Color) = when{
    (c1 == Color.RED && c2 == Color.YELLOW) || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE;
    (c1 == Color.YELLOW && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN;
    (c1 == Color.BLUE && c2 == Color.VIOLET) || (c1 ==Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO;
    else -> throw Exception("dirty color")
}

//合并类型检查和转换
interface Expr;
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval(e: Expr): Int {
    if(e is Num){
        val n = e as Num //显示转换多余
        return n.value;
    }
    if(e is Sum){
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("unkown expression")
}

//println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))

//重构： 用when代替if
//kotlin 中没有三元运算符，但if有返回值
fun eval2(e: Expr): Int =
        if (e is Num){
             e.value
        }else if (e is Sum){
             eval2(e.left) + eval2(e.right)
        }else{
            throw IllegalArgumentException("unkown expression")
        }

fun eval3(e: Expr): Int =
        when(e){
            is Num -> e.value
            is Sum -> eval3(e.right)+ eval3(e.left)
            else -> throw IllegalArgumentException("unkown expression")
        }

// 代码块作为if和when的分支
fun evalWithLogging(e : Expr) : Int =
        when (e){
            is Num -> {
                println("num: ${e.value}")
                e.value
            }
            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sun: $left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("unkown expression")
        }

//循环
fun fizzBuzz(i : Int) = when{
    i % 15 ==0 -> "FizzBuzz"
    i % 3 ==0 -> "Fizz"
    i % 5 ==0 -> "Buzz"
    else -> "$i"
}

//异常








