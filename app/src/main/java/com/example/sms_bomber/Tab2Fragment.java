package com.example.sms_bomber;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Tab2Fragment extends Fragment {

    private EditText phone;
    private EditText message;
    private Button envoi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Envoi message
        View view = inflater.inflate(R.layout.sms_fragment,container,false);
        phone = (EditText) view.findViewById(R.id.txtPhone);
        message = (EditText) view.findViewById(R.id.txtMessage);
        envoi = (Button) view.findViewById(R.id.btnEnvoi);

        // gestion de l'event click sur le bouton envoi
        createOnClickEnvoiButton();

        return view;
    }
    // Click sur bouton envoi -> envoi de sms
    private void createOnClickEnvoiButton(){
        envoi.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                SmsManager.getDefault().sendTextMessage(phone.getText().toString(), null, message.getText().toString(), null, null);
            }
        });
    }
}
