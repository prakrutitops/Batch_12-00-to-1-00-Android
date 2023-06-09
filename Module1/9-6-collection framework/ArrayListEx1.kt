fun main()
{

        var arraylist = ArrayList<String>()

        arraylist.add("A")
        arraylist.add("B")
        arraylist.add("C")
        arraylist.add("D")
        arraylist.add(3,"E")

        var i:Iterator<String> = arraylist.iterator()

        while (i.hasNext())
        {
            println(i.next())
        }

}