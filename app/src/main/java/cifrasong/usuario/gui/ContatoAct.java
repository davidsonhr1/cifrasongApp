package cifrasong.usuario.gui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import cifrasong.R;

public class ContatoAct extends android.support.v7.app.AppCompatActivity {

    Toolbar toolbar;

    Button btnOK;
    EditText txtTo;
    EditText txtSubject;
    EditText txtMessage;

    public void onBackPressed(){
        Intent intent = new Intent(ContatoAct.this,MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        ImageView image = (ImageView) findViewById(R.id.imageView);

        image.setImageResource(R.drawable.ic_launcher_logo);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));

        btnOK = (Button) findViewById(R.id.btnOK);
        txtTo = (EditText) findViewById(R.id.etTo);
        txtTo.requestFocus();
        txtSubject = (EditText) findViewById(R.id.etSubject);
        txtMessage = (EditText) findViewById(R.id.etMessage);

        btnOK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String to = txtTo.getText().toString();
                String subject = txtSubject.getText().toString();
                String message = txtMessage.getText().toString();
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                mail.putExtra(Intent.EXTRA_SUBJECT, subject);
                mail.putExtra(Intent.EXTRA_TEXT, message);
                mail.setType("message/rfc822");
                startActivity(Intent.createChooser(mail, "Enviar e-mail via:"));
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContatoAct.this, MenuActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }

}
