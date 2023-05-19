fun main()
{
    var temp=0
    var maxnum=0

    println("Enter Number")
    var num = readLine()!!.toInt()

    while (num > 0)
    {
            temp = num%10

            if(temp>maxnum)
            {
                maxnum=temp
            }

            num=num/10
    }
    println("max Number is $maxnum")
}