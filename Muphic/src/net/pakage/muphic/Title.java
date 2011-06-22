package net.pakage.muphic;

import android.app.Activity;
import android.content.res.Resources;
import android.content.*;
import android.graphics.*;
import android.view.View;
import android.view.MotionEvent;

public class Title extends View{
	
	private int touchX;
	private int touchY;
	private int touchAction=-999;
	private Bitmap endbbotton;
	private Bitmap endabotton;
	private Bitmap startbbotton;
	private Bitmap startabotton;
	private Bitmap contbbotton;
	private Bitmap contabotton;
	private Bitmap bg;
	private Botton startbotton,endbotton,contbotton;
	private Resources r;
	private Activity activity = (Activity)this.getContext();
	Intent intent=new Intent();
	


	public Title(Context context) {
		super(context);
		r=getResources();
		setBackgroundColor(Color.WHITE);
		endbbotton=BitmapFactory.decodeResource(r, R.drawable.end);
		endabotton=BitmapFactory.decodeResource(r, R.drawable.pushend);
		startbbotton=BitmapFactory.decodeResource(r, R.drawable.start);
		startabotton=BitmapFactory.decodeResource(r, R.drawable.pushstart);
		contbbotton=BitmapFactory.decodeResource(r, R.drawable.contenue);
		contabotton=BitmapFactory.decodeResource(r, R.drawable.pushcontenue);
		bg=BitmapFactory.decodeResource(r, R.drawable.title);
		setFocusable(true);	
	}

	protected void onDraw(Canvas canvas){
		Paint paint=new Paint();
		paint.setAntiAlias(true);
		endbotton=new Botton(getWidth()-100,0,endbbotton,endabotton);
		startbotton=new Botton(getWidth()-getWidth()/4-50,getHeight()/2,startbbotton,startabotton);
		contbotton=new Botton(getWidth()/4-75,getHeight()/2,contbbotton,contabotton);
		if(touchAction==MotionEvent.ACTION_DOWN||touchAction==MotionEvent.ACTION_MOVE){
			startbotton.changeflag(touchX, touchY,false); //chaaaaange bottttorrrrn!!
			endbotton.changeflag(touchX, touchY,false);
			contbotton.changeflag(touchX, touchY,false);
		}
		
		if(touchAction==MotionEvent.ACTION_UP){
			startbotton.changeflag(touchX, touchY,true);
			endbotton.changeflag(touchX, touchY,true);
			contbotton.changeflag(touchX, touchY,true);
			
		}
		Rect src=new Rect(0,0,bg.getWidth(),bg.getHeight());
		Rect dst=new Rect(0,0,getWidth(),getHeight());
		canvas.drawBitmap(bg,src,dst,paint);
		startbotton.display(canvas, paint);
		endbotton.display(canvas, paint);
		contbotton.display(canvas, paint);
		}
	
	public boolean onTouchEvent(MotionEvent event){
		touchX=(int)event.getX();
		touchY=(int)event.getY();
		touchAction=event.getAction();
		
		if(touchAction==MotionEvent.ACTION_UP){
			if(startbotton.changeflag(touchX, touchY,true)){
				intent.setClassName("net.pakage.muphic", "net.pakage.muphic.CriateStory");
				activity.startActivity(intent);
			}
			if(endbotton.changeflag(touchX, touchY, true)){
				activity.finish();
			}
		}

		return true;
	}
	
}
