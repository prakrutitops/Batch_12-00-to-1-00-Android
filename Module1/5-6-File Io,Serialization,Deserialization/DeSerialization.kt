import java.io.FileInputStream
import java.io.ObjectInputStream

fun main()
{
    var obinput = ObjectInputStream(FileInputStream("E://xyz.txt"))
    var s1:Student1 = obinput.readObject() as Student1
    println("${s1.id} and ${s1.name}")
}