fun main()
{
    //logic
    try
    {
        var ans = 10/0
        println(ans)
    }
    //if logic have any error then it will be catch here
    catch(e:Exception)
    {
        println(e)
    }
    //data will executed compulsory
    finally
    {
        println("execute")
    }
}