class A1 : Thread()
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
class B1 :Thread()
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
    var a = A1()
    var b = B1()

    a.start()
    b.start()

}