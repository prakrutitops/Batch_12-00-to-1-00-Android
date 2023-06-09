fun main()
{

    var map = mutableMapOf<String,String>("A" to "1","B" to "2","C" to "3")

    for(i in map.entries)
    {
        println(i)
    }

}