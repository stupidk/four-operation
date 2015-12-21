package com.example.shit;



import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class OperationActivity extends Activity {
	
	Button begin,qd;
	Button end;

	EditText ed1,ed2,ed3;
	int a,b,c;
	int answ,resp;
	int n=0,m=0,r=1;
	private Chronometer ch;
	double aver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.operation);
        begin=(Button)findViewById(R.id.button1);
        end=(Button)findViewById(R.id.button3);
        qd=(Button)findViewById(R.id.button2);
        ch = (Chronometer) findViewById(R.id.chronometer1);
        ed1=(EditText)findViewById(R.id.editText1);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        
        
        end.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				android.os.Process.killProcess(android.os.Process.myPid());
			}
		});

        begin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				c=(int)(Math.random()*4);
				
				
				switch(c){
				
				case 1:
					jiafa();
					break;
				case 2:
					jianfa();
					break;
				case 3:
					chengfa();
					break;
				case 4:
					chufa();
					break;
				case 0:
					
				   default:
				   break;
					
					
				}
				ch.setFormat(""); // Self dont show
				ch.setBase(0); // set base value
				ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
					long value = 0;

					@Override
					public void onChronometerTick(Chronometer chronometer) {
						
						if(value<30){
							value++;
						}
						else{
							ch.stop();
							
						    Toast.makeText(OperationActivity.this, "时间到了", Toast.LENGTH_LONG).show();
						}
						chronometer.setText("" + value); // overriding text
															// show
					}
				});
				ch.start();
				
			}
		});
      
        
            qd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				resp=Integer.parseInt(ed1.getText().toString());
		      
		     	if(resp==answ)
				{
					Toast.makeText(OperationActivity.this, "you right", Toast.LENGTH_LONG).show();
			        ++n;
				}
		     	
				 else 
				{
					Toast.makeText(OperationActivity.this, "you lose", Toast.LENGTH_LONG).show();
				
				}
		     	if(r==5)
		     	{
		     		aver=(double) n/r*100;
		     		ed3.setText(aver+"");
		     		
		     		
		     	}
		     	else
		     	{
		     		++r;
		     	}
		    	
			 
			}
		});
		  
       
     
        
        
        
         if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    public void jiafa()
    {
    	a=(int)(Math.random()*10);
    	b=(int)(Math.random()*10);
    	answ=(a+b);
    	ed2.setText(a+"+"+b+"=");
    }
    public void jianfa()
    {
    	a=(int)(Math.random()*10);
    	b=(int)(Math.random()*10);
    	if(a>b)
    	{
    		answ=(a-b);
    		ed2.setText(a+"-"+b+"=");
    		
    	}
    	else
    	{
    		answ=(b-a);
    		ed2.setText(b+"-"+a+"=");
    	}
   
    }
    public void chengfa()
    {
    	a=(int)(Math.random()*10);
    	b=(int)(Math.random()*10);
    	answ=(a*b);
    	ed2.setText(a+"*"+b+"=");
    }
    public void chufa()
    {
    	a=(int)(Math.random()*10);
    	b=(int)(Math.random()*10);
    	if(b==0)
    	{
    		Toast.makeText(OperationActivity.this, "a/b不成立！", Toast.LENGTH_LONG).show();
    	}
    	else
    	{
    		answ=(a/b);
    	}
    		
    }
   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
