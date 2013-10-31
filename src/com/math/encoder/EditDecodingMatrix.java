package com.math.encoder;

import java.util.Arrays;
import Jama.Matrix;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditDecodingMatrix extends Activity {
	EditText et1, et2, et3, et4, et5, et6, et7, et8, et9;
	Button done;
	
	double[][] decode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_decoding_matrix);
		et1 = (EditText) findViewById(R.id.et1);
		et2 = (EditText) findViewById(R.id.et2);
		et3 = (EditText) findViewById(R.id.et3);
		et4 = (EditText) findViewById(R.id.et4);
		et5 = (EditText) findViewById(R.id.et5);
		et6 = (EditText) findViewById(R.id.et6);
		et7 = (EditText) findViewById(R.id.et7);
		et8 = (EditText) findViewById(R.id.et8);
		et9 = (EditText) findViewById(R.id.et9);
		done = (Button) findViewById(R.id.doneDe);
		done.setOnClickListener(new ButtonHandler());

	}

	public class ButtonHandler implements View.OnClickListener {
		
		public void onClick(View v) {
			double a1 = 0, a2 = 0, a3 = 0, b1 = 0, b2 = 0, b3 = 0, c1 = 0, c2 = 0, c3 = 0;

			
				try {
					a1 = Double.parseDouble(et1.getText().toString());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					a2 = Double.parseDouble(et2.getText().toString());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					a3 = Double.parseDouble(et3.getText().toString());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					b1 = Double.parseDouble(et4.getText().toString());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					b2 = Double.parseDouble(et5.getText().toString());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					b3 = Double.parseDouble(et6.getText().toString());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					c1 = Double.parseDouble(et7.getText().toString());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					c2 = Double.parseDouble(et8.getText().toString());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					c3 = Double.parseDouble(et9.getText().toString());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			decode = new double[][]{ { a1, a2, a3 }, { b1, b2, b3 },
					{ c1, c2, c3 } };
			Variables var = ((Variables)getApplicationContext());
			var.setDecodingMatrix(decode);
			setResult(1);
			finish();
			
		}

	}
	
	
}
