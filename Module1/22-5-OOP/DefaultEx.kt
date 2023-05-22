class DefaultEx(var id:Int,var name:String)
{
    fun display()
    {
        println("Your Id is $id")
        println("Your Name is $name")

    }
}



fun main()
{
    var s1 = DefaultEx(101,"vishal") //var objname = classname()
    var s2 = DefaultEx(102,"pritesh") //var objname = classname()

    s1.display()
    s2.display()
}