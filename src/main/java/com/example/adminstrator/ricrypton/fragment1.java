package com.example.adminstrator.ricrypton;

/**
 * Created by Richard on 3/1/2016.
 */
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class fragment1 extends Fragment
{

    public fragment1()
    {

    }
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle richy)
    {
        final View root=inflater.inflate(R.layout.encrypt_exp,container,false);
        final EditText expressionInputF1=(EditText)root.findViewById(R.id.Incexp);
        final EditText encryptedOutputF1=(EditText)root.findViewById(R.id.encexp);
        final Button encryptBtnF1 = (Button) root.findViewById(R.id.encrytpBtnF1);
        final Button resetF1=(Button)root.findViewById(R.id.Reset);
            encryptBtnF1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    encrypt(expressionInputF1,encryptedOutputF1,root,encryptBtnF1);
                }
            });
        resetF1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                expressionInputF1.setText("");
                encryptedOutputF1.setText("");
                encryptBtnF1.setBackgroundColor(Color.rgb(160, 222, 10));
                Toast.makeText(root.getContext(),"Cleared!",Toast.LENGTH_SHORT ).show();
            }
        });

        return root;
    }
    public void encrypt(EditText a,EditText b,View v,Button btn)
    {
        MorseCode mc=new MorseCode();
        if (a.getText().toString().equals(""))
            Toast.makeText(v.getContext(), "Provide an expression above!", Toast.LENGTH_SHORT).show();
        else
        {
            String expression=a.getText().toString();
            String encryptedValue=mc.encode(expression);
            Toast.makeText(v.getContext(), "Encryption successfull!", Toast.LENGTH_SHORT).show();
            btn.setBackgroundColor(Color.rgb(255, 0, 0));
            b.setText(encryptedValue);
        }
    }
}
