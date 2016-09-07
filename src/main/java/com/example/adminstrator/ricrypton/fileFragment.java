package com.example.adminstrator.ricrypton;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Richard on 3/4/2016.
 */
public class fileFragment extends Fragment
{
    private final int READ_BLOCK_SIZE=100;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle richy)
    {
        final View root=inflater.inflate(R.layout.filefragment,container,false);
        final Button createFile=(Button)root.findViewById(R.id.mkfile);
        final Button resetFFrag=(Button)root.findViewById(R.id.ResetFileFrag);
        final EditText fileName=(EditText)root.findViewById(R.id.fname);
        final EditText fileContent=(EditText)root.findViewById(R.id.fcontent);
        createFile.setOnClickListener(new View.OnClickListener()
        {
            @Override
        public void onClick(View v)
            {
                String filename=fileName.getText().toString().trim()+".txt";
                String content=fileContent.getText().toString();
                createFile(filename,content,root);
            }
        });
        resetFFrag.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                fileName.setText("");
                fileContent.setText("");

            }
        });
        return root;
    }

    public void createFile(String fileName, String exp,View v)
    {
        if (fileName.equals(""))
        {
            Toast.makeText(v.getContext(),"Provide file name above!",Toast.LENGTH_SHORT).show();
        }

        else {
            if (SdcardAvailable()) {
                File sdcard = Environment.getExternalStorageDirectory();
                File directory = new File(sdcard.getAbsolutePath() + "/Ricrypton");
                if (!(directory.mkdirs())) {
                    directory.mkdirs();
                }
                File file = new File(directory.toString() + "/" + fileName);
                if (file.exists())
                    {
                      Toast.makeText(v.getContext(),"You are trying to update this file",Toast.LENGTH_SHORT).show();
                    }

                try {
                    FileOutputStream fout = new FileOutputStream(file);
                    PrintWriter pWriter = new PrintWriter(fout);
                    pWriter.println(exp);
                    pWriter.flush();
                    pWriter.close();
                    fout.close();
                    Toast.makeText(v.getContext(), "File Created successfully!", Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException fne) {
                    Toast.makeText(v.getContext(), fne.getMessage().toString(), Toast.LENGTH_SHORT).show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else
                Toast.makeText(v.getContext(), "Ensure sdcard is mounted\n and accessible", Toast.LENGTH_SHORT).show();
        }
    }
    public void readFile(String fileName,EditText edt, View v) {
        if (SdcardAvailable()) {
            File sdcard = Environment.getExternalStorageDirectory();
            File directory = new File(sdcard.getAbsolutePath() + "/Crypton");
            File file = new File(directory.toString() + "/" + fileName);

            try {
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis);
                char[] inputBuffer = new char[READ_BLOCK_SIZE];
                String fileFragment = "";
                int charRead;
                while ((charRead = isr.read(inputBuffer)) > 0) {
                    String readString = String.copyValueOf(inputBuffer, 0, charRead);
                    fileFragment += readString;
                    inputBuffer = new char[READ_BLOCK_SIZE];
                }
                //display loaded file
                edt.setText(fileFragment);
                Toast.makeText(v.getContext(), "File Loaded Successfully!", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException fne) {
                Toast.makeText(v.getContext(), fne.getMessage().toString(), Toast.LENGTH_SHORT).show();
            } catch (IOException ioe) {
                Toast.makeText(v.getContext(), ioe.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        }
        else
            Toast.makeText(v.getContext(),"Ensure sdcard is mounted\n and accessible",Toast.LENGTH_SHORT).show();
    }
    public boolean SdcardAvailable()
    {
        String state=Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)||Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))
        {
            return true;
        }
        return false;
    }
}
