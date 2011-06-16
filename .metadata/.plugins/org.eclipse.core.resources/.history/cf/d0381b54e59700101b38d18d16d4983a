package net.pakage.muphic;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.*;
import android.content.Context;
import android.view.View;
import android.view.MotionEvent;

public class StoryCriateWindow extends View{
	
	private Bitmap bg;
	private Resources r;
	private int touchX;
	private int touchY;
	private int touchAction=-999;
	private Botton endbotton;
	private Bitmap endbbotton;
	private Bitmap endabotton;
	private Activity activity = (Activity)this.getContext();
	
	public StoryCriateWindow(Context context){
		super(context);
		r=getResources();
		bg=BitmapFactory.decodeResource(r, R.drawable.nextwindow);
		endbbotton=BitmapFactory.decodeResource(r, R.drawable.end);
		endabotton=BitmapFactory.decodeResource(r, R.drawable.pushend);
	}
	
	public void onDraw(Canvas canvas){
		Paint paint = new Paint();
		Rect src=new Rect(0,0,bg.getWidth(),bg.getHeight());
		Rect dst=new Rect(0,0,getWidth(),getHeight());
		canvas.drawBitmap(bg,src,dst,paint);
		endbotton=new Botton(getWidth()-100,0,endbbotton,endabotton);
		

		if(touchAction==MotionEvent.ACTION_DOWN||touchAction==MotionEvent.ACTION_MOVE){
			endbotton.changeflag(touchX, touchY,false);
		}
		
		if(touchAction==MotionEvent.ACTION_UP){
			endbotton.changeflag(touchX, touchY, true);
		}
		
		endbotton.display(canvas, paint);
	}
	
	public boolean onTouchEvent(MotionEvent event){
		touchX=(int)event.getX();
		touchY=(int)event.getY();
		touchAction=event.getAction();

		
		if(touchAction==MotionEvent.ACTION_UP){
			if(endbotton.changeflag(touchX, touchY, true)){
				activity.finish();
			}
		}
		
		return true;
	}

}
