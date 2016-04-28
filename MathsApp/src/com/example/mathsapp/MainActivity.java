package com.example.mathsapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private MediaPlayer mPlayer;// ±≥æ∞“Ù¿÷
	private Button mButton;
	public Boolean buttonIsPressed = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mButton = (Button) findViewById(R.id.voice_control_button);
		Button_control_voice();
	}

	@Override
	protected void onResume()
	{
		mPlayer = MediaPlayer.create(this, R.raw.bg_mic);
		mPlayer.start();
		// mPlayer.setLooping(true);//—≠ª∑≤•∑≈±≥æ∞“Ù¿÷
		super.onResume();
	}

	// ±ª±ª∏≤∏«∫Û‘›Õ£∫Û
	@Override
	protected void onPause() 
	{
		mPlayer.stop();
		//mPlayer.release();
		super.onPause();
	}

	@Override
	protected void onDestroy() 
	{
		if(mPlayer!=null)
		{
			//mPlayer.stop();
			mPlayer.release();
			mPlayer = null;
		}
		
		super.onDestroy();
	}
	
	public void voice_on()
	{
		if(mPlayer==null)
		{
			mPlayer = MediaPlayer.create(this, R.raw.bg_mic);
			mPlayer.start();
		}
	}
	
	public void voice_off()
	{
		if(mPlayer!=null)
		{
			mPlayer.release();
			mPlayer = null;
		}
	}

	public void Button_control_voice()
	{
		mButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(buttonIsPressed==false)
				{
					mButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.voice_stop));
					voice_off();
					buttonIsPressed=true;
				}
				else
				{
					mButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.voice));
					voice_on();
					buttonIsPressed=false;
				}
			}
		});
	}
	
	public void Start(View view) 
	{
		mPlayer = MediaPlayer.create(this, R.raw.click);
		mPlayer.start();
		Intent intent = new Intent(this, PlayActivity.class);
		startActivity(intent);
		// MainActivity.this.finish();
	}
}
