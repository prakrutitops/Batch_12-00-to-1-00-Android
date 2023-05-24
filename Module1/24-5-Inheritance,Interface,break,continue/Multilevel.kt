open class P
{
    fun p1()
    {
       println("P Accessed")
    }
}
open class Q :P()
{
    fun q1()
    {
        println("Q Accessed")
    }
}
class R :Q()
{
    fun r1()
    {
        println("R Accessed")
    }
}

fun main()
{
    var r1 = R()
    r1.p1()
    r1.q1()
    r1.r1()
}