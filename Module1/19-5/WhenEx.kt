fun main()
{

    println("Enter Your Number")
    var num = readLine()!!.toInt()

    when(num)
    {

        1->
        {
            println("Selected Language is English")

            println("Select 1 For Credit card \n Select 2 For Debit Card \n Select 3 For ATM Card ")

            var e1= readLine()!!.toInt()

            if(e1==1)
            {
                println("Credit Card Found")
            }

            else if(e1==2)
            {
                println("Debit Card Found")
            }

            else if(e1==3)
            {
                println("ATM Card Found")
            }


        }
        2->
        {
            println("Selected Language is Hindi")
        }
        3->
        {
            println("Selected Language is Gujarati")
        }
    }


}