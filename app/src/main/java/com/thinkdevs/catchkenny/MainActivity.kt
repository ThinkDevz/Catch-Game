package com.thinkdevs.catchkenny

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AppCompatActivity

import android.view.View
import android.widget.ImageView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
	var score:Int =0
	var imageArray = ArrayList<ImageView>()
	var handler:Handler = Handler()
	var runnable:Runnable = Runnable {  }
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(toolbar)
		
		score =0
		imageArray = arrayListOf(imageView, imageView2,imageView3,imageView4,imageView5,
				imageView6, imageView7,imageView8,imageView9)
		
		hideImage()
		
		object :CountDownTimer(1000, 1000){
			override fun onFinish() {
			
				timer.text ="Timer's Off"
				handler.removeCallbacks(runnable)
				for (image in imageArray){
					image.visibility = View.INVISIBLE
				}
			}
			
			override fun onTick(millisUntilFinished: Long) {
				timer.text = "Time ${millisUntilFinished / 100}"
			}
			
			
		}.start()
		
		
	}
	
	fun increaseScore(view:View){
		score ++
		score_txt.text ="Score ${score}ore"
	
	}
	
	fun hideImage(){
		
		runnable = object:Runnable{
			override fun run() {
				for (image in imageArray){
					image.visibility = View.INVISIBLE
				}
				
				val random =Random()
				val index = random.nextInt(8-0)
				imageArray[index].visibility = View.VISIBLE
				
				handler.postDelayed(runnable, 500)
			}
			
		}
		
		handler.post(runnable)
		
		
	}
}
