fun main()
{

        var mylist = mutableListOf<String>("Java","Android")

        mylist.add("Kotlin")
        mylist.add("C#")

        var mylist2 = mutableListOf<String>("Flutter","Dart","Kotlin")

       /* println(mylist)
        println(mylist2)*/

       // mylist.addAll(mylist2)
        //mylist.remove("C#")
       // mylist.removeAt(3)
        //mylist.removeAll(mylist2)

        mylist.retainAll(mylist2)

        var i:Iterator<String> = mylist.iterator() //fetch value from list

        while(i.hasNext())
        {
            println(i.next())
        }






}