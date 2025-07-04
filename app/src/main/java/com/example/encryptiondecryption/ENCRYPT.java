package com.example.encryptiondecryption;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ENCRYPT extends AppCompatActivity {
    private TextView encrypted;
    private EditText toEncrypt;
    private Button encryptionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_encrypt);
        toEncrypt=findViewById(R.id.textToDecrypt);
        encrypted=findViewById(R.id.showDecryptedText);
        encryptionButton=findViewById(R.id.decrypt);
        encryptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String normalText = toEncrypt.getText().toString();
                String encryptedText=processTheText(normalText);
                encrypted.setText(encryptedText);
                ClipboardManager copyTheText = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData copy = ClipData.newPlainText("encrypted Text",encryptedText);
                copyTheText.setPrimaryClip(copy);
                Toast.makeText(ENCRYPT.this, "Encrypted text copied😎", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public String processTheText(String text){
        String processedText="";
        for(int i=0; i<text.length(); i++){
            char word = (char) ((int)(text.charAt(i)) + 9);
            processedText+=(word);
        }
        return processedText;
    }
}