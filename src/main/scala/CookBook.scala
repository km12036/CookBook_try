import java.io.FileWriter
object CookBook extends App {


  val srcName = "http://www.gutenberg.org/cache/epub/13177/pg13177.txt"
  val dstName = "c:/poems/CookBook.txt"
  def openSource(fName:String) = {
    //actually get a real sequence of strings
    val filePointer = scala.io.Source.fromURL(srcName)
    val myLines = filePointer.getLines.toSeq

    filePointer.close()
    myLines
  }



  def processSeq(mySeq:Seq[String])= {


   // val filteredSeq=mySeq.map(_.trim).filter(n=>(n.headOption.exists(_.isDigit))||(n==n.toUpperCase))

    //Couldn't fully figure out homework
val filteredSeq=mySeq.filter(n=>(n.startsWith("    "))||(n==n.toUpperCase))
val newseq= filteredSeq.slice(280,1393)
newseq

  }

  def saveSeq(destName:String, mySeq:Seq[String]) = {
    println(s"Saving my Sequence to file $destName")
    mySeq.foreach(println) //we are good up to here
    val fw = new FileWriter(destName)
    mySeq.map(_ + "\n").foreach(fw.write) // adding new line to each line before writing
    fw.close()
  }

  //the actual program runs here, little tiny pipeline like a factory
  val mySeq = openSource(srcName)
  val filteredSeq = processSeq(mySeq)
  saveSeq(dstName,filteredSeq)


}
