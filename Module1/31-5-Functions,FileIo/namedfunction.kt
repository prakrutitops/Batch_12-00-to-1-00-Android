import java.math.BigInteger

//With Para With Return type
fun details(fname:String,lname:String,email:String,mobile:BigInteger)
{
    println("Your Firstname is $fname")
    println("Your Lastname is $lname")
    println("Your Email is $email")
    println("Your Mobile is $mobile")
}

fun main()
{
   // println(details(lname = "patil", fname = "vishal", email = "vishal@gmail.com", mobile = 4534533333.toBigInteger()))

    println("Enter Your Firstname")
    var fname1 = readLine().toString()

    println("Enter Your Lastname")
    var lname1 = readLine().toString()

    println("Enter Your Email")
    var email1 = readLine().toString()

    println("Enter Your Mobile")
    var mob1 = readLine()!!.toBigInteger()

    details(fname1,lname1,email1,mob1)



}