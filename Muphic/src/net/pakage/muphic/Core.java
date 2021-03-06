package net.pakage.muphic;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Core {

	private int x=0;
	private int y=0;
	
	public Core(int X,int Y){
		x=X;
		y=Y;
	}
	
	public void setXY(int touchX,int touchY){
		x=touchX;
		y=touchY;
	}
	
	public void display(Canvas canvas,Paint paint){
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(Color.BLUE);
		canvas.drawCircle(x,y,15,paint);
	}
	
	public int PositionX(){
		return x;
	}
	
	public int PositionY(){
		return y;
	}
	
	public boolean judge(int touchX,int touchY){
		double dist;
		dist=Math.sqrt(Math.pow(Math.abs(x-touchX),2)+Math.pow(Math.abs(y-touchY),2));
		if(dist<15)return true;
		return false;
	}
	
}
