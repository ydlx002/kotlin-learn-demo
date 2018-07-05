package learn2

/**
 *
 *@Package learn2
 *@Author lizhenhua
 *@Date 2018/7/4 18:10
 */
/**
 *
 */
fun main(args : Array<String>){
    println("Hello World!")
    println(max(1,2))
    main2(args);
}

//函数
fun max(a: Int, b: Int) : Int {
    return if (a>b) a else b
}

//if 表达式
fun max2(a: Int, b:Int): Int = if (a>b) a else b

//if 表达式2
fun max3(a: Int, b: Int) = if (a > b) a else b

//val 不可变变量(对应java中final类型) var 可变变量
val question = "the ultimate question of life, the universe, and everything"
val answer = 12
val answer2 : Int = 42
val yearsToCompute = 7.5e6
//val answer3: Int  //error
//answer3 = 42


fun test2(){
    //val 保存对象引用时，代码有效
    val languages = arrayListOf("JAVA")
    languages.add("test")
}

//var 允许改变值，但不允许改变类型
//error  var answer = 43
// answer ="no answer";

//字符串模板
fun main2(args: Array<String>){
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("hello , $name")
    println("hello ${args[0]}")
    println("hello, ${if (args.size > 0) args[0] else "someone"}")
}


//类和属性
class Person(val name: String)

class Person2(
        val name: String,
        var isMarried: Boolean
)

fun main3(){
    val person = Person2("bob",true);//调用构造方法不需要new
    //直接访问属性,不需要通过get
    println(person.name);
    //直接设置属性，不要通过set
    person.isMarried = true;
}

//自定义访问器
class Person3(val height: Int, val width: Int){
    val isSquare: Boolean
    get() {
        return height == width
    }
}

//在kotlin中，可以把多个类放在同一个文件中，文件的名字还可以随意选择。包层级结构不要遵循目录层级结构

