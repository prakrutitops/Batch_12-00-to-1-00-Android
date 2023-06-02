open class MyBank
{
    open fun rate() :Int
    {
        return 0
    }
}

class Sbi :MyBank()
{
    override fun rate():Int
    {
        return 7
    }
}
class Icici :MyBank()
{
    override fun rate():Int
    {
        return 8
    }
}
class Axis :MyBank()
{
    override fun rate():Int
    {
        return 9
    }
}


fun main()
{
    var b = MyBank()

    b =Sbi()
    println(b.rate())

    b=Icici()
    println(b.rate())

    b=Axis()
    println(b.rate())

}