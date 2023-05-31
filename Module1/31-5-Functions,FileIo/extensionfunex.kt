import com.sun.org.apache.xpath.internal.operations.Bool

class MyStudent
{

    fun haspassed(marks:Int):Boolean
    {
        return marks>40
    }


}
fun MyStudent.isscholar(marks: Int):Boolean
{
    return marks>95
}
fun main()
{

    var s1 = MyStudent()
    println("Pass Status: "+s1.haspassed(96))
    println("Scholarship Statsu :"+s1.isscholar(96))
}