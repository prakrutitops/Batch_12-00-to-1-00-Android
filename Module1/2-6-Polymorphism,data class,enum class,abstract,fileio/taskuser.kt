import java.io.FileOutputStream


fun main()
{
    println(" Emter Your first  Name : ")
    var name = readLine().toString()

    println(" Emter Your last name : ")
    var lname = readLine().toString()

    println(" Emter Your Email : ")
    var email = readLine().toString()

    println(" Emter Your mobile  : ")
    var mob = readLine().toString()

    println(" Emter Your Password  : ")
    var pass = readLine().toString()

    println(" Emter Your RePassword  : ")
    var repass = readLine().toString()


    if (pass.equals(repass))
    {
        println("Your password is Correct :  pls enter to save!!!!")
        var fout = FileOutputStream("E://userdata.txt")

        var name1 ="\n Your Firstname is :"
        var lname1 ="\n Your Lastname is :"
        var email1 ="\n Your Email is :"
        var pass1 ="\n Your Password is :"
        var mob1 ="\n Your Mobile is :"

        fout.write(name1.toByteArray())
        fout.write(name.toByteArray())
        fout.write(lname1.toByteArray())
        fout.write(lname.toByteArray())
        fout.write(email1.toByteArray())
        fout.write(email.toByteArray())
        fout.write(pass1.toByteArray())
        fout.write(pass.toByteArray())
        fout.write(mob1.toByteArray())
        fout.write(mob.toByteArray())

        println("success")
    }
    else
    {
        println("Your Password is incorrect: pls Try Again!!!")
    }


}