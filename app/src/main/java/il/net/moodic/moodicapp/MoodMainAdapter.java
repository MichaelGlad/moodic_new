package il.net.moodic.moodicapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Michael on 3/10/2017.
 */

public class MoodMainAdapter extends RecyclerView.Adapter<MoodMainAdapter.MyViewHolder> {

    MoodManager moodManager;
    MoodButtonListener adapterMoodButtonListener;

    public void setMoodManager(MoodManager moodManager) {
        this.moodManager = moodManager;
    }

    public void setAdapterMoodButtonListener(MoodButtonListener adapterMoodButtonListener) {
        this.adapterMoodButtonListener = adapterMoodButtonListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public Button btnMode;

        public MyViewHolder(View view) {
            super(view);
            btnMode = (Button) view.findViewById(R.id.btnMood);
            btnMode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position;
                    Log.d("my_logs", "Now in the Listener !!!!!!!!!!!!");
                    for (int i = 0; i < moodManager.moodArrayList.size(); i++) {
                        String buttonText = (String.valueOf(((Button) v).getText()));
                        if (moodManager.moodArrayList.get(i).getName().equals(buttonText)) {
                            moodManager.setCurrentPosition(i);
                            adapterMoodButtonListener.onMooodButtonListener();
                            return;
                        }

                    }

                }
            });
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_mood_button, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Mood insideMood = moodManager.moodArrayList.get(position);
        holder.btnMode.setText(insideMood.getName());
        holder.btnMode.setBackgroundColor(insideMood.getPrimaryColor());

    }


    @Override
    public int getItemCount() {
        return moodManager.moodArrayList.size();
    }
}
