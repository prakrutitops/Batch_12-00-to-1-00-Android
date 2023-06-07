fun main()
{
    var list = mutableListOf("a","b",1,2,11.22,545.77576,'a')//changes//mutable//generic type
    list.add("c")


    var list2 = listOf<String>("a","b")//no changes//immutable

    println(list)
    println(list2)

}