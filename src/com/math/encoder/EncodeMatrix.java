package com.math.encoder;

import Jama.Matrix;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
public class EncodeMatrix {
	double[] x,x1;
	double[][] R;
	int count;
	Matrix A;
public Matrix encode(String Ch,Matrix EncodingMatrix){
	count=Ch.length();
x=new double[count];  
numbers n = new numbers();
for (int k = 0; k<= count- 1; k++) 
	x[k]=n.letterToNumber(Ch.charAt(k));
int i,j;	
	if (count%3==1){
	x1=new double[count+2];
	for (i=0; i<=count-1;i++)
		x1[i]=x[i];
	x1[i]=32;
	x1[i+1]=32; 
    }
	else if (count%3==2){
	x1=new double[count+1];
	for (i=0; i<=count-1;i++)
		x1[i]=x[i];
	x1[i]=32;
    }			
	else if (count%3==0){
		x1=new double[count];
		for (i=0; i<=count-1;i++)
			x1[i]=x[i];
	    }
	R = new double[3][x1.length/3];

for (j=0;j<= x1.length/3-1;j++){

	for (i=0;i<=2;i++){
		
		R[i][j]=x1[i+3*j];
		
	}
	
}
Matrix MessageMatrix = new Matrix(R);
Matrix ResultMatrix = EncodingMatrix.times(MessageMatrix);
return ResultMatrix;
}
public class numbers {
		public int letterToNumber(char a) {
			return (int)a;
		}
	}
	
	
	}
	


