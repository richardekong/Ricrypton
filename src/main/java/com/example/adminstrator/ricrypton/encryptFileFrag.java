package com.example.adminstrator.ricrypton;

/**
 * Created by Richard on 3/8/2016.
 */
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class encryptFileFrag extends Fragment
{
    private MorseCode mc;
    private final int READ_BLOCK_SIZE=100;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle idle)
    {
        final View root=inflater.inflate(R.layout.encrypt_file,container,false);
        final EditText fileName=(EditText)root.findViewById(R.id.fname2);
        final EditText fileContent=(EditText)root.findViewById(R.id.fcontent1);
        final EditText encryptedValue=(EditText)root.findViewById(R.id.encexp2);
        final ImageButton encryptBtn=(ImageButton)root.findViewById(R.id.btnencfile);
        final ImageButton saveBtn=(ImageButton)root.findViewById(R.id.btnsave1);
        final ImageButton refresh=(ImageButton)root.findViewById(R.id.resetEFF);

        encryptBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mc=new MorseCode();
                if (!(fileName.getText().toString().equals("")))
                {
                    readFile(fileName.getText().toString().trim()+".txt", fileContent, root);
                    if (!(fileContent.getText().toString().equals("")))
                    {

                        String contents = fileContent.getText().toString();
                        String encryptedContent = mc.encode(contents);
                        Toast.makeText(root.getContext(), "File encrypted successfully!", Toast.LENGTH_SHORT).show();
                        encryptedValue.setText(encryptedContent);
                    }
                    else
                        Toast.makeText(root.getContext(),"No contents to encrypt in "+fileName.getText().toString(),Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(root.getContext(),"Provide valid file name",Toast.LENGTH_SHORT).show();
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
                    public void onClick(View v)
            {
                if (!(fileName.getText().toString().equals("")|| fileContent.getText().toString().equals(""))) {
                    saveFile(fileName.getText().toString().trim() + ".txt", encryptedValue.getText().toString(), root);
                }
                else
                    Toast.makeText(root.getContext(),"Provide valid file name\nEnsure file name:"+fileName.getText().toString()+" contains document",
                            Toast.LENGTH_SHORT).show();
            }

        });
        refresh.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fileName.setText("");
                fileContent.setText("");
                encryptedValue.setText("");
                Toast.makeText(root.getContext(),"Cleared!",Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
    public void saveFile(String fileName,String exp,View v)
    {
        if (SdcardAvailable()) {
            File sdcard = Environment.getExternalStorageDirectory();
            File directory = new File(sdcard.getAbsolutePath() + "/Ricrypton");
            if (!(directory.mkdirs())) {
                directory.mkdirs();
            }

                File file = new File(directory.toString() + "/" + fileName);
                try {
                    FileOutputStream fout = new FileOutputStream(file);
                    PrintWriter pWriter = new PrintWriter(fout);
                    pWriter.println(exp);
                    pWriter.flush();
                    pWriter.close();
                    fout.close();
                    Toast.makeText(v.getContext(), "File saved to" + file.getPath().toString() + "\n successfully!", Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException fne) {
                    Toast.makeText(v.getContext(), fne.getMessage().toString(), Toast.LENGTH_SHORT).show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

        }
        else
            Toast.makeText(v.getContext(),"Ensure sdcard is mounted\n and accessible",Toast.LENGTH_SHORT).show();
    }
    public void readFile(String fileName,EditText edt, View v) {
        if (SdcardAvailable()) {
            File sdcard = Environment.getExternalStorageDirectory();
            File directory = new File(sdcard.getAbsolutePath() + "/Ricrypton");
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
