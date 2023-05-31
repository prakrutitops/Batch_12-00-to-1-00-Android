//With Para With Return type
fun add(a:Int,b:Int) : Int
{
    return a+b
}
//With Para without Return type
fun add2(a:Int,b:Int)
{
    var c=a+b
    println(c)
}
//With Return type without para
fun add3():Int
{
    var a=5
    var b=6
    var c=a+b
    return c
}
//without para without return type
fun add4()
{
    var a=5
    var b=6
    var c=a+b
    println(c)
}
fun main()
{
    println(add(5,6))
    add2(5,6)
    println(add3())
    add4()
}