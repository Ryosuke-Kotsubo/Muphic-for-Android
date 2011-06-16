package net.pakage.muphic;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

public class Muphic extends Activity {
    /** Called when the activity is first created. */
    private Title title;
	private TickHandler tickHandler;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        
        title=new Title(this);
        setContentView(title);
    }
    
    @Override
    public void onResume(){
    	super.onResume();
    	tickHandler=new TickHandler();
    	tickHandler.sleep(0);
    }
    
    @Override
    public void onPause(){
    	super.onPause();
    	tickHandler=null;
    }
    
    public class TickHandler extends Handler{
    	//handler message
    	@Override
    	public void handleMessage(Message msg){
    		title.invalidate();
    		if(tickHandler!=null)tickHandler.sleep(100);
    	}
    	
    	//sleep
    	public void sleep(long delayMills){
    		removeMessages(0);
    		sendMessageDelayed(obtainMessage(0),delayMills);
    	}
    }
}