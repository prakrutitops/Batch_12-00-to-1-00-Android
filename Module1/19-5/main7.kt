fun main()
{

    println("Enter Your Username")
    var uname= readLine()

    println("Enter Your Password")
    var pass= readLine()



    if(uname!!.length==0)
    {
        println("Please Enter Your username")
    }
     if(pass!!.length==0)
    {
        println("Please Enter Your Password")
    }
    else
    {
        println("Success")
    }




}