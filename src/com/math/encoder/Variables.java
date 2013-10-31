package com.math.encoder;
import android.app.Application;

public class Variables extends Application{

	  private double[][] MessageMatrix,EncodingMatrix,ResultMatrix,DecodingMatrix;
	  private String message;

	  public String getMessage(){
	    return message;
	  }
	  public double[][] getMessageMatrix(){
		  return MessageMatrix;
	  }
	  public double[][] getEncodingMatrix(){
		  return EncodingMatrix;
	  }
	  public double[][] getResultMatrix(){
		  return ResultMatrix;
	  }
	  public double[][] getDecodingMatrix(){
		  return DecodingMatrix;
	  }
	  public void setMessage(String message){
		  this.message = message;
	  }
	  public void setMessageMatrix(double[][]MessageMatrix){
		  this.MessageMatrix =MessageMatrix;
	  }
	  public void setEncodingMatrix(double[][]EncodingMatrix){
		  this.EncodingMatrix = EncodingMatrix;
	  }
	  public void setResultMatrix(double[][]ResultMatrix){
		  this.ResultMatrix =ResultMatrix;
	  }
	  public void setDecodingMatrix(double[][]DecodingMatrix){
		  this.DecodingMatrix = DecodingMatrix;
	  }
	  
}
