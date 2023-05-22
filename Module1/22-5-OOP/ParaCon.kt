class ParaEx
{

    constructor(id:Int,name:String,surname:String)
    {
        println("Your Id is $id")
        println("Your Name is $name")
        println("Your Surname is $surname")
    }

    constructor(id:Int,name:String)
    {
        println("Your Id is $id")
        println("Your Name is $name")
    }

    constructor(id:Int,name:String,surname:String,email:String)
    {
        println("Your Id is $id")
        println("Your Name is $name")
        println("Your Surname is $surname")
        println("Your Email is $email")
    }



}



fun main()
{
    var s1 = ParaEx(101,"vishal","patil") //var objname = classname()
    var s2 = ParaEx(102,"pritesh") //var objname = classname()
    var s3 = ParaEx(103,"Xyz","Xyz","Xyz@gmail.com")



}