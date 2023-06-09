import java.util.*

fun main()
{

        var linkedlist = LinkedList<String>()

        linkedlist.add("A")
        linkedlist.add("B")
        linkedlist.add("C")
        linkedlist.add("D")
        linkedlist.addFirst("E")
        linkedlist.addLast("G")


        var i:Iterator<String> = linkedlist.iterator()

        while (i.hasNext())
        {
            println(i.next())
        }

}