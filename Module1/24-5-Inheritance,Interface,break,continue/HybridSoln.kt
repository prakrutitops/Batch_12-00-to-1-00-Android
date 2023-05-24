open class bank

{
    fun bank()
    {
        println(" bank ")
    }

}
open class saving : bank()
{
    fun saving()
    {
        println(" saving")
    }
}
interface currant
{
    fun currant()
    {
        println(" current")
    }
}
class deposite : saving() ,currant
{
    fun depo()
    {
        println(" deposite")
    }
}

fun main()
{
    var A2 =  deposite()

    A2.depo()
    A2.currant()
    A2.saving()
    A2.bank()
}