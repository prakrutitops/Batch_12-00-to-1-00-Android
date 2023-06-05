import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun main()
{
    var s1 = Student1(101,"tytury")
    var fout = FileOutputStream("E://xyz.txt")//file create
    var obt = ObjectOutputStream(fout)//object create
    obt.writeObject(s1)
    println("success")
}