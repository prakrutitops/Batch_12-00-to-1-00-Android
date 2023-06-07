class Sender
{
    fun send(msg:String)
    {
        println("sending $msg")

            Thread.sleep(1000)

        println("$msg sent")
    }
}

class Threadsend(var sender: Sender,var msg: String) :Thread()
{

    override fun run()
    {
        synchronized(sender)
        {
            sender.send(msg)
        }

    }

}

fun main()
{
    var sender = Sender()

    var t1 = Threadsend(sender,"Hii")
    var t2 = Threadsend(sender,"Byee")

    t1.start()
    t2.start()

    t1.join()
    t2.join()

    t1.suspend()
    t1.resume()

    //println(Thread.currentThread().name)
   // println(Thread.currentThread().priority)


}