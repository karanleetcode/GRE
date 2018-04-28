package com.example.acer.gre;

/**
 * Created by Acer on 4/28/2018.
 */

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by win-8 on 05-02-2017.
 */

public class CustomAdapter extends ArrayAdapter<Contacts> {
    private final Context context;
    private final ArrayList<Contacts> array;
    TextView wordName, meaning;

    public int sum;

    public CustomAdapter(Context context, ArrayList<Contacts> array2) {
        super(context, -1, array2);
        this.context = context;
        this.array = array2;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.list_item_example, parent, false);
        final Contacts cn = array.get(position);
        wordName = (TextView) rowView.findViewById(R.id.wordName);
        wordName.setText(cn.getWordName());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(context,cn.getWordName(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(context,Main2Activity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("wordname",cn.getWordName());
                view.getContext().startActivity(intent);

            }
        });
        return rowView;
    }
}
