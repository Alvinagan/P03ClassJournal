package sg.edu.rp.c346.p03_classjournal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WeekAdapter extends ArrayAdapter<Week> {

    private ArrayList<Week>  week;
    private Context context;
    private TextView tvWeek, tvDailyGrade, tvGrade;
    private ImageView ivGrade;

    public WeekAdapter(Context context, int resource, ArrayList<Week> objects){
        super(context, resource, objects);
        week = objects;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.grade_row, parent, false);


        tvWeek = rowView.findViewById(R.id.textViewWeek);
        tvDailyGrade = rowView.findViewById(R.id.textViewDG);
        tvGrade = rowView.findViewById(R.id.textViewGrade);
        ivGrade = rowView.findViewById(R.id.ivGrade);

        Week currentWeek = week.get(position);

        tvDailyGrade.setText("DG");
        tvWeek.setText("week " + currentWeek.getWeek());
        tvGrade.setText(currentWeek.getGrade());
        ivGrade.setImageResource(R.drawable.dg);

        return rowView;
    }


}
