data class MyDataClass(var name : String, var id : Int)
{

}
fun main()
{
    var user1 = MyDataClass("kot", 10)
    var user2 = MyDataClass("kot", 10)

    println(user1)//address
    println(user2.toString())//address

    if (user1 == user2)
    {
        println("Equal")
    }
    else
    {
        println("Not equal")
    }

    var user3 = user1.copy()
    println(user3.toString())
}
