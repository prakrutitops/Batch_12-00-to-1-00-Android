import java.io.FileOutputStream

//FileOutputStream - write
//FileInputStream - read


fun main()
{
    println("Enter Detail: ")
    var data = readLine().toString()
    var fout = FileOutputStream("E://pritesh.txt")
    fout.write(data.toByteArray())
    println("success")


}