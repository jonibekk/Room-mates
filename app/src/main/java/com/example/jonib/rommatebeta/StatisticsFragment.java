package com.example.jonib.rommatebeta;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class StatisticsFragment extends Fragment {

    private LineChart lineChart;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lineChartFunction();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_statistics, container, false);
    }

    public void lineChartFunction() {
        lineChart = getView().findViewById(R.id.lineChart);
        ArrayList<String> xAXES = new ArrayList<>();
        ArrayList<Entry> yAXESsin = new ArrayList<>();
        ArrayList<Entry> yAXEScos = new ArrayList<>();

        double x = 0;
        int numDataPoints = 1000;
        for (int i = 0; i < numDataPoints; i++) {
            final float sineFunction = Float.parseFloat(String.valueOf(Math.sin(x)));
            float cosFunction = Float.parseFloat(String.valueOf(Math.cos(x)));
            x = x + 0.1;
            yAXESsin.add(new Entry(sineFunction, 1));
            yAXEScos.add(new Entry(cosFunction, 1));
            xAXES.add(i, String.valueOf(x));
        }
        String[] xaxes = new String[xAXES.size()];
        for (int i = 0; i < xAXES.size(); i++) {
            xaxes[i] = xAXES.get(i).toString();
        }

        ArrayList<LineDataSet> lineDataSets = new ArrayList<>();
        LineDataSet lineDataSet1 = new LineDataSet(yAXEScos, "cos");
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColor(Color.BLUE);

        LineDataSet lineDataSet2 = new LineDataSet(yAXESsin, "sin");
        lineDataSet2.setDrawCircles(false);
        lineDataSet2.setColor(Color.RED);

        lineDataSets.add(lineDataSet1);
        lineDataSets.add(lineDataSet2);

        lineChart.setData(new LineData(xaxes, lineDataSets));

        lineChart.setVisibleXRangeMaximum(65f);

    }

}
