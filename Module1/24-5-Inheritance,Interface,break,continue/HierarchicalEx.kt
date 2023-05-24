open class Bank
{
    fun bank()
    {
        println("banking")
    }
}
class Current :Bank()
{
    fun current()
    {
        println("current")
    }
}
class Saving :Bank()
{
    fun save()
    {
        println("saving")
    }
}

fun main()
{
    var c = Current()
    var s = Saving()

    c.current()
    s.save()
    s.bank()
}