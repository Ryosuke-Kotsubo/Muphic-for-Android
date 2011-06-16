package net.pakage.muphic;

import android.graphics.*;

public class Botton {
	
	private int x;
	private int y;
	private Bitmap bbotton;
	private Bitmap abotton;
	private boolean flag=false;
	
	public Botton(int posx,int posy,Bitmap Bbotton,Bitmap Abotton){
		x=posx;
		y=posy;
		bbotton=Bbotton;
		abotton=Abotton;
	}
	
	public void display(Canvas canvas,Paint paint){
		if(flag==false){
			Rect src=new Rect(0,0,bbotton.getWidth(),bbotton.getHeight());
			Rect dst=new Rect(x,y,x+bbotton.getWidth()/2,y+bbotton.getHeight()/2);
			canvas.drawBitmap(bbotton,src,dst,paint);
		}
		if(flag==true){
			Rect src=new Rect(0,0,abotton.getWidth(),abotton.getHeight());
			Rect dst=new Rect(x,y,x+abotton.getWidth()/2,y+abotton.getHeight()/2);
			canvas.drawBitmap(abotton,src,dst,paint);
			
		}
	}
	
	public boolean changeflag(int touchX,int touchY,boolean select){
		if(select==false&&flag==false&&touchX>x&&touchY>y&&touchX<x+bbotton.getWidth()/2&&touchY<y+bbotton.getHeight()/2)
		{	
			flag=true;
			return true;
		}
		else if(select==true&&flag==true&&touchX>x&&touchY>y&&touchX<x+abotton.getWidth()/2&&touchY<y+abotton.getHeight()/2)
		{
			flag=false;
			return true;
		}
		return false;
	}
	
	

}
