open class A
{
    fun a1()
    {
       println("A Accessed")
    }
}
class B : A() //inheritance
{
    fun b1()
    {
        println("B Accessed")
    }
}

fun main()
{

    var b = B()

    b.a1()
    b.b1()
}