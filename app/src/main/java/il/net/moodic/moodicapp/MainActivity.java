package il.net.moodic.moodicapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends Activity implements MoodButtonListener {

    MoodManager moodManager;
    private RecyclerView myRecyclerView;
    private MoodMainAdapter moodMainAdapter;
    TextView txtUpText, txtDownText;
    ImageView centralView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        moodManager = moodManager.getMyInstance(this);
        centralView = (ImageView) findViewById(R.id.img_view_main);
        centralView.setColorFilter(moodManager.moodArrayList.get(7).getPrimaryColor());

        myRecyclerView = (RecyclerView) findViewById(R.id.recycle_main);
        moodMainAdapter = new MoodMainAdapter();
        moodMainAdapter.setMoodManager(moodManager);
        moodMainAdapter.setAdapterMoodButtonListener(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        myRecyclerView.setLayoutManager(mLayoutManager);

        myRecyclerView.setAdapter(moodMainAdapter);


        for (int i = 0; i < moodManager.moodArrayList.size(); i++) {
            System.out.println(moodManager.moodArrayList.get(i));

        }


    }

    @Override
    public void onMooodButtonListener() {
        int position = moodManager.getCurrentPosition();
        String name = moodManager.moodArrayList.get(position).getName();

        txtDownText = (TextView) findViewById(R.id.txtDownText);

        //Picasso.with(this).load().into(centralView);
       if (name.equals("My Favorites")) centralView.setImageResource(R.drawable.ic_favorites);
       if (name.equals("Aggressive")) centralView.setImageResource(R.drawable.ic_aggressive);
       if (name.equals("Calm")) centralView.setImageResource(R.drawable.ic_calm);
       if (name.equals("Cool")) centralView.setImageResource(R.drawable.ic_cool);
       if (name.equals("Depressed")) centralView.setImageResource(R.drawable.ic_depresed);
       if (name.equals("Energetic")) centralView.setImageResource(R.drawable.ic_energetic);
       if (name.equals("Exited")) centralView.setImageResource(R.drawable.ic_excited);
       if (name.equals("Happy")) centralView.setImageResource(R.drawable.ic_happy);
       if (name.equals("Nervous")) centralView.setImageResource(R.drawable.ic_nervous);
       if (name.equals("Optimistic")) centralView.setImageResource(R.drawable.ic_optimistic);
       if (name.equals("Romantic")) centralView.setImageResource(R.drawable.ic_romantic);
       if (name.equals("Sad")) centralView.setImageResource(R.drawable.ic_sad);
       if (name.equals("Stressed")) centralView.setImageResource(R.drawable.ic_streesed);
       if (name.equals("Tired")) centralView.setImageResource(R.drawable.ic_tired);


















        Log.d("my_Logs", "the drawable is - " + moodManager.moodArrayList.get(position).getImage() );
        txtDownText.setText(moodManager.moodArrayList.get(position).getMoodText());
        txtDownText.setTextColor(moodManager.moodArrayList.get(position).getPrimaryColor());
        centralView.setColorFilter(moodManager.moodArrayList.get(position).getPrimaryColor());

    }


}
