interface Print
{
    fun print()
    {
        println("printing")
    }
}
interface  Show
{
    fun show()
    {
        println("Showing")
    }
}
class V :Print,Show
{
    fun v1()
    {
        println("v1")
    }
}

fun main()
{
   var v1 = V()
   v1.print()
   v1.show()
    v1.v1()
}