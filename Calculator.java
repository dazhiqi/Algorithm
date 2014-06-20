package Algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Calculator {
	
	public static void main(String[] args){
		
//		String str=" 11 12 13 56 ";
//		String[] data=str.split("\\s");
//		for(int i=0;i<data.length;i++){
//			System.out.println(data[i]);
//		}
		
		BufferedReader reader=null;
		InputStreamReader inputStreamReader=null;
		ArrayList<String>opt=new ArrayList<String>();
		try{
			System.out.println("请输入表达式：或直接输入#结束运算！");
			inputStreamReader=new InputStreamReader(System.in);
			reader=new BufferedReader(inputStreamReader);
			String str=reader.readLine();
			while(!str.equals("#")){
				System.out.println("运算结果为："+opt(str)+"");
				System.out.println("请输入表达式：或直接输入#结束运算！");
				str=reader.readLine();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(reader!=null){
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static float opt(String s) throws Exception{
		int a1=s.indexOf("+");
		int a2=s.indexOf("-");
		int a3=s.indexOf("*");
		int a4=s.indexOf("/");
		int a5=s.indexOf("(");
		if(a1==-1&&a2==-1&&a3==-1&&a4==-1){
			if(s.trim()==null||"".equals(s.trim())){
				throw new Exception("operate error");
			}
			return Float.parseFloat(s.trim());
		}
		
		if(a5!=-1){
		int a6=s.lastIndexOf(")");
			if(a6==-1){
				throw new Exception("括号不匹配");
			}else{
				float f=opt(s.substring(a5+1,a6).trim());
				s=s.replace(s.substring(a5,a6+1), String.valueOf(f));
				return opt(s);
			}
		}
		
		if(a1!=-1){
			return opt(s.substring(0,a1))+opt(s.substring(a1+1,s.length()));
		}
		if(a2!=-1){
			return opt(s.substring(0,a2))-opt(s.substring(a2+1,s.length()));
		}
		if(a3!=-1){
			return opt(s.substring(0,a3))*opt(s.substring(a3+1,s.length()));
		}
		if(a4!=-1){
			return opt(s.substring(0,a4))/opt(s.substring(a4+1,s.length()));
		}
		return Integer.parseInt(s.trim());
	}
}