package com.math.encoder;
import java.util.Arrays;

import Jama.Matrix;
public class StringToArray {
public String MatrixToDisplay(Matrix x){
	int count =0;
	double []d = new double[x.getColumnDimension()*x.getRowDimension()];
	for(int j = 0;j<=x.getColumnDimension()-1;j++)
		for(int i = 0;i<=2;i++){
			d[count] = x.get(i,j);
			count++;
		}
	 String e = Arrays.toString(d);
	 String f = e.replace("[", "");
	String g=  f.replace("]", "");
	return g;
}
}
