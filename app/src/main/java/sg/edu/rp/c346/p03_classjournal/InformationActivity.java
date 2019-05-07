package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InformationActivity extends AppCompatActivity {

    int requestCodeForAdd = 1;

    ListView lvWeek;
    ArrayAdapter aa;
    ArrayList<Week> week;
    Button btnInfo, btnAdd, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        lvWeek = findViewById(R.id.lvWeek);
        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = findViewById(R.id.buttonEmail);

        week = new ArrayList<Week>();

        Intent i = getIntent();
        this.setTitle("Info for C347");
        week.add(new Week(1, "C347", "B"));
        week.add(new Week(2, "C347", "C"));
        week.add(new Week(3, "C347", "A"));

        aa = new WeekAdapter(this, R.layout.grade_row, week);
        lvWeek.setAdapter(aa);


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuilder sb = new StringBuilder();
                for (Week s : week) {
                    sb.append("Week " + s.getWeek() + ": DG: " + s.getGrade());
                    sb.append("\n");
                }

                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "");


                email.putExtra(Intent.EXTRA_TEXT,
                        "Hi Faci \n\n I am ... \n Please see my remarks so far, thank you! \n\n " + sb.toString());

                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }


        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InformationActivity.this, Add.class);
                i.putExtra("week", lvWeek.getAdapter().getCount() + 1);
                startActivityForResult(i, requestCodeForAdd);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                // Get data passed back from 2nd activity

                String newGrade = data.getStringExtra("grade");

                week.add(new Week(lvWeek.getAdapter().getCount() + 1, "C347", newGrade));

                aa.notifyDataSetChanged();


            }
        }
    }
}
