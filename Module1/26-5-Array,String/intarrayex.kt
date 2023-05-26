fun main()
{
    var x:Int=1

     var n = IntArray(5)//size

    for(i in 0..4)
    {
        n[i]=x
        x++

        //n[0]
        //n[1]
        //n[2]
        //n[3]
        //n[4]
    }
    println("array element :")

    for(i in 0 .. 4)
    {
        print(" "+ n[i])
    }

}