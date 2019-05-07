package sg.edu.rp.c346.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lvModuleCode;
    ArrayList<String> al;
    ArrayAdapter<String> aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModuleCode = findViewById(R.id.listViewModule);

        al = new ArrayList<String>();
        al.add("C347");
        al.add("C302");

        ArrayAdapter<String> aaModule;

        aaModule = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, al);
        lvModuleCode.setAdapter(aaModule);

        lvModuleCode.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedType = al.get(position);

                Intent i = new Intent(MainActivity.this, InformationActivity.class);
                i.putExtra("type", selectedType);
                startActivity(i);
            }
        });



    }
}
