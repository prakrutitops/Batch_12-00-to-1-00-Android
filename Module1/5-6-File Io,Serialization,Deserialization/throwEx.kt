import java.lang.ArithmeticException

class Check
{

    fun agecheck( age:Int)
    {
        if(age>=18)
        {
            println("Eligible")
        }
        else
        {
            throw ArithmeticException("jredjrfew")
        }


    }

}
fun main()
{

    var c1 = Check()
    c1.agecheck(12)


}