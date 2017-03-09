package il.net.moodic.moodicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] colorsPrimaryNamesArray;
    String[] colorsAccentNamesArray;
    String[] namesMoodArray;

    ArrayList<Mood> moodArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namesMoodArray = getResources().getStringArray(R.array.moodsName);
        colorsPrimaryNamesArray = getResources().getStringArray(R.array.colorsPrimaryName);
        colorsAccentNamesArray = getResources().getStringArray(R.array.colorsAccentName);

//test sd
    }
}
