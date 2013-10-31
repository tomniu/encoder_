package com.math.encoder; 
import java.util.Arrays;
import java.util.Random;


import Jama.Matrix;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EncoderActivity extends Activity {

	Button b1, b2;
	public EditText message;
	EditText et1, et2, et3, et4, et5, et6, et7, et8, et9;
	Button done;
	TextView result_message_encoded,result_encoding_matrix,result_message_decoded,result_decoding_matrix;
	Matrix EncodingMatrix, MessageMatrix,EncodedMatrix,DecodingMatrix;
	String DecodedMessage;
	String MessageEncoded;
	Variables var;
	StringToArray sta;
	int a,a1,a2,a3,a4,a5,a6,a7,a8;
	double[][]x;
	Matrix m;

@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		 boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true);
		   /* if (firstrun){*/
		    	new AlertDialog.Builder(this).setTitle("How to use").setMessage("Enter a message in the text box. To encode, press the Encode Button. To decode, press the Decode Button. Press Menu for further options.").setNeutralButton("OK", null).show();
		   /* getSharedPreferences("PREFERENCE", MODE_PRIVATE)
		        .edit()
		        .putBoolean("firstrun", false)
		        .commit();
		    }*/
		Variables var = (Variables)getApplicationContext();
		b1 = (Button) findViewById(R.id.en);
		b2 = (Button) findViewById(R.id.de);
		message = (EditText)findViewById(R.id.message);
		b1.setOnClickListener(new ButtonHandler1());
		b2.setOnClickListener(new ButtonHandler2());
		result_message_encoded = (TextView)findViewById(R.id.result_message_encoded);
		result_message_decoded = (TextView)findViewById(R.id.result_message_decoded);
		result_encoding_matrix = (TextView)findViewById(R.id.result_encoding_matrix);
		result_decoding_matrix = (TextView)findViewById(R.id.result_decoding_matrix);
		Random r = new Random();
		a = r.nextInt(9999);
		a1 = r.nextInt(9999);
		a2 = r.nextInt(9999);
		a3 = r.nextInt(9999);
		 a4 = r.nextInt(9999);
		 a5 = r.nextInt(9999);
		 a6 = r.nextInt(9999);
		 a7 = r.nextInt(9999);
		 a8 = r.nextInt(9999);
		x = new double[3][3];
		x [0][0]= a;
		x [0][1]= a1;
		x [0][2]= a2;
		x [1][0]= a3;
		x [1][1]= a4;
		x [1][2]= a5;
		x [2][0]= a6;
		x [2][1]= a7;
		x [2][2]= a8;
		m = new Matrix(x);
		while(m.det()==0){
			a = r.nextInt(9999);
			a1 = r.nextInt(9999);
			a2 = r.nextInt(9999);
			a3 = r.nextInt(9999);
			 a4 = r.nextInt(9999);
			 a5 = r.nextInt(9999);
			 a6 = r.nextInt(9999);
			 a7 = r.nextInt(9999);
			 a8 = r.nextInt(9999);
		}
		x [0][0]= a;
		x [0][1]= a1;
		x [0][2]= a2;
		x [1][0]= a3;
		x [1][1]= a4;
		x [1][2]= a5;
		x [2][0]= a6;
		x [2][1]= a7;
		x [2][2]= a8;
		EncodingMatrix =new Matrix(x);
		DecodingMatrix = EncodingMatrix.inverse();
		var.setEncodingMatrix(EncodingMatrix.getArray());	
		var.setDecodingMatrix(DecodingMatrix.getArray());
}


public void onActivityResult(int requestCode, int resultCode, Intent data) {
	if (resultCode == 0)
	{
      var = ((Variables)getApplicationContext());
      EncodingMatrix = new Matrix(var.getEncodingMatrix());
      
      //var.setDecodingMatrix(EncodingMatrix.inverse().getArray());
      if(EncodingMatrix.det()!=0){
      DecodingMatrix = EncodingMatrix.inverse();
      result_decoding_matrix.setText("DecodingMatrix:  \n"+Arrays.deepToString(DecodingMatrix.getArray()));
      }
      result_encoding_matrix.setText("EncodingMatrix:  \n"+Arrays.deepToString(EncodingMatrix.getArray()));
      
    }
	else if(resultCode ==1){
		  var = ((Variables)getApplicationContext());
	      DecodingMatrix = new Matrix(var.getDecodingMatrix());
	      result_decoding_matrix.setText("DecodingMatrix:  \n"+Arrays.deepToString(DecodingMatrix.getArray()));
	}
 }
	public class ButtonHandler1 implements View.OnClickListener {
	
		public void onClick(View v) {
			EncodeMatrix encode = new EncodeMatrix();
			EncodedMatrix = encode.encode(message.getText().toString(), EncodingMatrix);
			sta = new StringToArray();
	    	MessageEncoded = sta.MatrixToDisplay(EncodedMatrix);
			result_message_encoded.setText("Messgae Encoded: \n"+MessageEncoded);
		}
	}
	

	public class ButtonHandler2 implements View.OnClickListener {
		public void onClick(View v) {
			DecodeMatrix decode = new DecodeMatrix();
			try {
				DecodedMessage = decode.StringToString(message.getText().toString(), DecodingMatrix);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				if(e.toString().equals("java.lang.NullPointerException"))
					Toast.makeText(getApplicationContext(), "There is nothing to decode", 5000).show();
				else
					Toast.makeText(getApplicationContext(), "Erro. Can't decode non array objects", 5000).show();
			}
			result_message_decoded.setText("\nMessage Decoded: \n"+DecodedMessage);
			
			
		}

	}

		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu, menu);
	    return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case R.id.copy:
	    	 final ClipboardManager clipBoard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
	    	 clipBoard.setText(MessageEncoded);
	        return true;
	    case R.id.edit_encoding:
	    	Intent i = new Intent(EncoderActivity.this,EditEncodingMatrix.class);
	    	startActivityForResult(i,0);
	        return true;
	    case R.id.edit_decoding:
	    	Intent j = new Intent(EncoderActivity.this,EditDecodingMatrix.class);
	    	startActivityForResult(j,1);
	        return true;
	        
	        
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	    
	}
	
}
