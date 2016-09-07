package com.example.adminstrator.ricrypton;

/**
 * Created by Richard on 4/5/2016.
 */


import java.util.List;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FileArrayAdapter extends ArrayAdapter
{
    private Context c;
    private int id;
    private List<Item>items;

    //FileArrayAdapter constructor
    public FileArrayAdapter(Context context, int textViewResourceId,List<Item>objects)
    {
        //calling default constructor of ArrayAdapter
        super(context,textViewResourceId,objects);
        c=context;
        id=textViewResourceId;
        items=objects;
    }
    public Item getItem(int i)
    {

        return items.get(i);
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent )
    {
        View v=convertView;
        if (v==null)
        {
            LayoutInflater vi=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=vi.inflate(id, null);
        }
        /*create a new view of my layout and inflate it in the row*/
        // convertView =(RelativeLayout)inflater.inflate(resource, null);
        final Item o=items.get(position);
        if (o!=null)
        {
            TextView t1=(TextView)v.findViewById(R.id.TextView01);
            TextView t2=(TextView)v.findViewById(R.id.TextView02);
            TextView t3=(TextView)v.findViewById(R.id.TextViewDate);
            //set image
            ImageView img=(ImageView)v.findViewById(R.id.folder_icon1);
            String uri="mipmap/"+o.getImage();
            int imgResource=c.getResources().getIdentifier(uri,null,c.getPackageName());
            Drawable image=c.getResources().getDrawable(imgResource);
            img.setImageDrawable(image);

            if (t1!=null)
                t1.setText(o.getName());
            if (t2!=null)
                t2.setText(o.getData());
            if (t3!=null)
                t3.setText(o.getDate());
        }
        return v;
    }
}
