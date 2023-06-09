fun main()
{
  /*  var list = mutableListOf("a","b",1,2,11.22,545.77576,'a')//changes//mutable//generic type
    list.add("c")
*/

    var list2 = listOf("a","b",1,1.5,1.55345,'f')//no changes//immutable
    println(list2)

    var list = mutableListOf("a","b",1,2,11.22,545.77576,'a')//mutable
    list.add("tops")

    println(list)

}