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
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class fragment2 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle richy)
    {
        final View root=inflater.inflate(R.layout.decrypt_exp,container,false);
        final EditText expressionF2=(EditText)root.findViewById(R.id.Indecexp);
        final EditText decryptedF2=(EditText)root.findViewById(R.id.decexp);
        final Button decrypt=(Button)root.findViewById(R.id.btndec);
        final Button resetF2=(Button)root.findViewById(R.id.resetF2);
        decrypt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                decrypt(expressionF2,decryptedF2,root,decrypt);
            }
        });
        resetF2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                expressionF2.setText("");
                decryptedF2.setText("");
                decrypt.setBackgroundColor(Color.rgb(160,222,10));
                Toast.makeText(root.getContext(),"Cleared!",Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
    public void decrypt (EditText a,EditText b,View v,Button btn)
    {
        DecodeMorseCode dmc=new DecodeMorseCode();
        if (a.getText().toString().equals(""))
            Toast.makeText(v.getContext(), "Provide an expression above!", Toast.LENGTH_SHORT).show();
        else
        {
            String expression=a.getText().toString();
            String decryptedValue=dmc.decode(expression);
            if (decryptedValue.isEmpty())
                Toast.makeText(v.getContext(),"Expression is not morse-encrypted!",Toast.LENGTH_SHORT).show();
            else
            {
                b.setText(decryptedValue);
                Toast.makeText(v.getContext(), "Decryption successfull!", Toast.LENGTH_SHORT).show();
                btn.setBackgroundColor(Color.rgb(255, 0, 0));
            }
        }
    }
}
