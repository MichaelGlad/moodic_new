package il.net.moodic.moodicapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Michael on 3/9/2017.
 */

public class MoodManager {
    private static MoodManager myInstance;

    private int[] colorsPrimaryNamesArray;
    private int[] colors1NamesArray;
    private int[] colors2NamesArray;
    private int[] colors3NamesArray;
    private int[] drawablesArray;
    private String[] namesMoodArray;
    private String[] moodTextArray;
    private int[] insideColorsArray;
    private int currentPosition;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    final static String MY_LOG = "my_logs";

    boolean isFavorite = false;

    private Mood insideMood;

    SharedPreferences sherdPref;

    ArrayList<Mood> moodArrayList = new ArrayList<>();

    public int getPositionByMoodName(String name) {
        int position = -1;
        for (int i = 0; i < moodArrayList.size(); i++) {
            if (moodArrayList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return position;
    }


    public static MoodManager getMyInstance(Context context) {
        if (myInstance == null) {


            myInstance = new MoodManager(context);
        }
        return myInstance;
    }

    private MoodManager() {
    }

    private MoodManager(Context myContext) {

        namesMoodArray = myContext.getResources().getStringArray(R.array.moodsName);
        colorsPrimaryNamesArray = myContext.getResources().getIntArray(R.array.colorsPrimaryName);
        colors1NamesArray = myContext.getResources().getIntArray(R.array.colorsOne);
        colors2NamesArray = myContext.getResources().getIntArray(R.array.colorsTwo);
        colors3NamesArray = myContext.getResources().getIntArray(R.array.colorsThree);
        drawablesArray = myContext.getResources().getIntArray(R.array.drawabals);
        moodTextArray = myContext.getResources().getStringArray(R.array.moodsText);

        sherdPref = myContext.getSharedPreferences("Favorite", MODE_PRIVATE);
        String savedText = sherdPref.getString("isFavorite", "");
        if (!savedText.isEmpty()) {
            isFavorite = true;

        }

//            sPref = getPreferences(MODE_PRIVATE);
//            Editor ed = sPref.edit();
//            ed.putString(SAVED_TEXT, etText.getText().toString());
//            ed.commit();


//            sPref = getPreferences(MODE_PRIVATE);
//            String savedText = sPref.getString(SAVED_TEXT, "");
//            etText.setText(savedText);


        for (int i = 0; i < namesMoodArray.length; i++) {
            //if ((i==0) && isFavorite)
            insideColorsArray = new int[4];
            insideColorsArray[0] = colorsPrimaryNamesArray[i];
            insideColorsArray[1] = colors1NamesArray[i];
            insideColorsArray[2] = colors2NamesArray[i];
            insideColorsArray[3] = colors3NamesArray[i];
            Log.d(MY_LOG, "The Primary Color " + colorsPrimaryNamesArray[i]);
            insideMood = new Mood(namesMoodArray[i], moodTextArray[i], insideColorsArray, drawablesArray[i]);
            moodArrayList.add(insideMood);


        }


        if (!isFavorite) moodArrayList.remove(0);


    }
}
