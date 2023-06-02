abstract class Abc
{
    fun a1()
    {
        println("a1")
    }

    abstract fun a2()

}

class Y1 : Abc()
{
    override fun a2()
    {

        println("A2")


    }

}

fun main()
{
    var y = Y1()
    y.a1()
    y.a2()
}