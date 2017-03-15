package il.net.moodic.moodicapp;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import java.util.Comparator;

/**
 * Created by Michael on 3/8/2017.
 */
public class Mood implements Comparable {
    String name;
    String moodText;
    int[] colors;
    int image;


    public Mood(String name, String moodText, int[] colors, int image) {
        this.name = name;
        this.moodText = moodText;
        this.colors = colors;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoodText() {
        return moodText;
    }

    public void setMoodText(String moodText) {
        this.moodText = moodText;
    }

    public int[] getColors() {
        return colors;
    }

    public int getPrimaryColor() {
        return colors[0];
    }

    public void setColors(int[] colors) {
        this.colors = colors;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return ("Mood name - " +getName()+ ": MoodText - " + getMoodText()+": Mood primary Color -" + getColors()[0] + ": Drawable - " + getImage());
    }

    @Override
    public int compareTo(Object o) {

        String firstName = getName();
        String secondName = ((Mood)o).getName();

        if (firstName.equals(secondName)) {
            return 0;
        }
        return 1;

    }
}
