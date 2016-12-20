package com.jacker.file
import scala.util.Random

import java.util.Date
import java.text.SimpleDateFormat
import java.io.PrintWriter
import java.io.File
import java.io.FileWriter

object Producer {
  
  def main(args: Array[String]): Unit = {
    val num = args(0)
    val writer = new FileWriter("test.txt", true); //��ǰ���̸�Ŀ¼��   
    for(i <- 1 to num.toInt ){
      val now = new Date().getTime
      val dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")  
      val userdate = dateFormat.format(now)//ʱ��
      val cid = Random.nextInt(1000000).toString()//������ID
      val product = Random.nextInt(50).toString()//��Ʒ
      val appEventArray = Array("view", "collection", "shopping", "buy", "null");
      val appEvent = appEventArray(Random.nextInt(appEventArray.length))//�¼�
      val line = Array(userdate, cid,product,appEvent).mkString(",")
      Thread.sleep(50)
      writer.write(line+"\n")
      println(line)  
    }
     writer.close() 
  }
} 