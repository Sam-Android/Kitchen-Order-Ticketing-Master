package com.example;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity 

{
      String []mydata1={"American Cuisine","French Cuisine","Indian Cuisine","Italian Cuisine"};
      String []mydata2={"Burger","French fries","Vegetarian Thali","Pasta"};
      Integer[] images={R.drawable.american_cuisine,R.drawable.french_cuisine,R.drawable.indian_cuisine,R.drawable.italian_cuisine};
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner mySpinner = (Spinner)findViewById(R.id.spinner1);
        mySpinner.setAdapter(new MyAdapter(this, R.layout.custom_spinner, mydata1));
    }
    
    
    public class MyAdapter extends ArrayAdapter<String>
    {

            public MyAdapter(Context context, int textViewResourceId, String[] objects) 
            {
                  super(context, textViewResourceId, objects);
                  // TODO Auto-generated constructor stub
            }
            
            
            @Override
            public View getDropDownView(int position, View convertView,ViewGroup parent)
            {
            return getCustomView(position, convertView, parent);
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) 
            {
            return getCustomView(position, convertView, parent);
            }

        public View getCustomView(int position, View convertView, ViewGroup parent) 
        {

            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.custom_spinner, parent, false);
            TextView label=(TextView)row.findViewById(R.id.textView1);
            label.setText(mydata1[position]);

            TextView sub=(TextView)row.findViewById(R.id.textView2);
            sub.setText(mydata2[position]);

            ImageView icon=(ImageView)row.findViewById(R.id.imageView1);
            icon.setImageResource(images[position]);

            return row;
            }
       
    	}
   }

