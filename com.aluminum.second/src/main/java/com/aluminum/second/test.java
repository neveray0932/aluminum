//package com.aluminum.second;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
//
//public class test {
//	public static void main(String[] args) {
//		try {
//			String file ="d:/brad/brad1.txt";
//			File source = new File(file);
//			FileInputStream fin = new FileInputStream(source);
//			FileOutputStream out = new FileOutputStream("d:/brad/test1/length.jpg");
//			int b;
//			FileReader read = new FileReader(file);
//			FileWriter write = new FileWriter(file);
//			write.write("您好 全世界");
//			write.close();
//			while((b=read.read())!=-1) {
//				System.out.println((char)b);
//			}
//			
////			byte[] buf = new byte[4*1024];
////			int len = 0;
////			while((len=fin.read(buf))!=-1) {
////				out.write(buf, 0, len);
////			}
//			
////			byte[] buf = new byte[(int)source.length()];
////			out.write(buf);
////			fin.read(buf);
////			System.out.println(new String(buf));
//			
//			
//			
//			
//			fin.close();
//			out.flush();
//			out.close();
//			System.out.println("OK");
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//		
//	}
//
//}
//
//
