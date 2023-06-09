fun main()
{

    //you can store multiple data in single array
    var data = arrayOf(1,1.5,"abcd",'q',true)

    //println(data[2])

    //data[2]="b"

    //println("array size is ${data.size}")

   // println("array contain ${data.contains(1.5)}")

  //  println("array first elements is ${data.first()}")

    println(" abcd Index  ${data.indexOf("abcd")}")

    println("---------------")
    //println(data.toString())
    for (i in data)
    {
       println(i)
    }

    println("---------------")

    var duplicate = data.copyOfRange(1,3)

    for (i in duplicate)
    {
        println(i)
    }


}