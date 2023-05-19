fun main()
{

        println("Enter Your Age")
        var age = readLine()!!.toInt()

    //iF-ELSE
        if(age>=18)
        {
            println("Eligible to vote")

            //nested if
            if(age>=50)
            {
                println("Senior citizen category")
            }
            else
            {
                println("You are not under senior citizen category")
            }


        }
        else
        {
            println("Not eligible to vote")
        }

}