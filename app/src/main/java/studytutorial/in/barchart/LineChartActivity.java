package studytutorial.in.barchart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class LineChartActivity extends AppCompatActivity {
    private LineChart chart;
    LineDataSet set1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);
        chart = (LineChart) findViewById(R.id.linechart);

        set1 = new LineDataSet(getDataSet(), "The year 2017");

        set1.setColors(Color.parseColor("#F78B5D"), Color.parseColor("#FCB232"), Color.parseColor("#FDD930"), Color.parseColor("#ADD137"), Color.parseColor("#A0C25A"));

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        // hide Y-axis
        YAxis right = chart.getAxisRight();
        YAxis left=chart.getAxisLeft();
        left.setDrawLabels(false);
        right.setDrawLabels(false);
        left.setDrawGridLines(false);
        right.setDrawGridLines(false);

        //hide X-axis
        XAxis xright=chart.getXAxis();
        xright.setDrawLabels(false);
        xright.setDrawGridLines(false);


      /*  chart.getAxisRight().setEnabled(false);
        xright.setPosition(XAxis.XAxisPosition.BOTTOM);*/

        chart.setData(data);

        // custom description
        Description description = new Description();
        description.setText("");
        chart.setDescription(description);

        // hide legend
        chart.getLegend().setEnabled(false);
        chart.animateX(1000);
        chart.invalidate();
    }

    private ArrayList<Entry> getDataSet() {
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        yVals.add(new Entry(0, 0));
        yVals.add(new Entry(0, 1));
        yVals.add(new Entry(0, 2));
        yVals.add(new Entry(50, 3));
        // yVals.add(new Entry(180.9f, 4));

        set1 = new LineDataSet(yVals, "");
        set1.setColor(Color.BLACK);
        set1.setCircleColor(Color.BLACK);
        set1.setLineWidth(1f);
        set1.setCircleRadius(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(1f);
        set1.setDrawFilled(true);

        return yVals;
    }
}
