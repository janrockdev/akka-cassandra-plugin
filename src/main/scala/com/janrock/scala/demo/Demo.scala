package com.janrock.scala.demo

import com.datastax.driver.core._

/**
  * Created by bot on 07/05/17.
  */
object Demo extends App {

  val tag = "yo" // search tag (input)

  private val cluster = Cluster.builder()
    .addContactPoint("51.140.120.14")
    .withPort(9042)
    .build()

  val session = cluster.connect("susi")
  val query = s"SELECT content, link FROM susi.predefined where tag = '$tag' ALLOW FILTERING;"
  val result = session.execute(query)

  while (result.iterator.hasNext) {
    val line = result.one()
    val column0 = line.getObject(0)
    val column1 = line.getObject(1).toString.replace("[", "").replace("]", "").split(",").toList

    // TODO: return list object
    if (column1.head.nonEmpty) {
      for (alt <- column1) {
        val query_alt = s"SELECT content FROM susi.predefined where id = $alt ALLOW FILTERING;"
        val result_alt = session.execute(query_alt)
        val tag_alt = result_alt.one().getObject(0)
        println("Tag: " + tag + " with value: " + column0 + " with alternative: " + tag_alt)
      }
    }
    else
      println("Tag: " + tag + " with value: " + column0)
  }

  cluster.close()
  sys.exit()
}
