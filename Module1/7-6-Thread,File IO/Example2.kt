class A11 : Runnable
{
    override fun run()
    {
        //   super.run()
        for(i in 1..10)
        {
            println("Thread A: "+i)
        }

    }
}
class B11 :Runnable
{
    override fun run()
    {
        //   super.run()
        for(i in 1..10)
        {
            println("Thread B: "+i)
        }

    }
}

fun main()
{
    var a = Thread(A11())
    var b = Thread(B11())
    a.start()
    b.start()



}