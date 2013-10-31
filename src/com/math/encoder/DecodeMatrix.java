package com.math.encoder;

import java.util.Arrays;
import Jama.Matrix;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class DecodeMatrix extends Activity{
String d2="";
public String StringToString(String a, Matrix DecodingMatrix){
if (a.isEmpty()){
	Toast.makeText(getApplicationContext(), "There is nothing to decode", 5000).show();
	return d2;
}
else if(a.contains("qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM")){
	Toast.makeText(getApplicationContext(), "Can't decode message", 5000).show();
	return d2;
}
else{
		String[]  b = a.split(",");
		double[]x = new double[b.length];
		for(int i =0;i<b.length;i++)
			x[i] = Double.parseDouble(b[i]);
		double[][]y = new double[3][x.length/3];
		for(int j = 0;j<=x.length/3-1;j++)
			for(int i = 0;i<=2;i++)
				y[i][j] = x[i+3*j];
		Matrix A = new Matrix(y);
		Matrix DecodedMatrix = DecodingMatrix.times(A);
		double []d = new double[DecodedMatrix.getRowDimension()*DecodedMatrix.getColumnDimension()];
		int count =0;
			for (int j = 0;j<=DecodedMatrix.getColumnDimension()-1;j++)
				for(int i = 0;i<=2;i++)	{
						d[count] = DecodedMatrix.get(i, j);
						count++;}
		char []e = new char[d.length];
		for(int i = 0;i<=d.length-1;i++)
			e[i]= (char)(d[i]+0.5);
		String a1 = Arrays.toString(e);
		String b1 = a1.replace(" ", "");
		String c1 = b1.replace(",,", " ");
		String c2 = c1.replace(",", "");
		String d1 = c2.replace("[", "");
		d2 = d1.replace("]", "");}
	return d2;
}
}
