package com.example.encryptiondecryption;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DECRYPT extends AppCompatActivity {
    private TextView decrypted;
    private EditText textToDecrypt;
    private Button DECRYPT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_decrypt);
        decrypted=findViewById(R.id.showDecryptedText);
        textToDecrypt=findViewById(R.id.textToDecrypt);
        DECRYPT=findViewById(R.id.decrypt);
        DECRYPT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String decryptedText=textToDecrypt.getText().toString();
                String normalText=processTheText(decryptedText);
                decrypted.setText(normalText);
                Toast.makeText(DECRYPT.this, "Decrypted Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public String processTheText(String text){
        String processedText="";
        for(int i=0; i<text.length(); i++){
            char word = (char) ((int)(text.charAt(i)) - 9);
            processedText+=(word);
        }
        return processedText;
    }
}