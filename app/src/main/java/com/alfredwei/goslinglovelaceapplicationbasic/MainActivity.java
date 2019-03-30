package com.alfredwei.goslinglovelaceapplicationbasic;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView name = (TextView) findViewById(R.id.name);

        Configuration mConfiguration = this.getResources().getConfiguration();
        int ori = mConfiguration.orientation;
        try
        {
            if (ori == mConfiguration.ORIENTATION_LANDSCAPE)
            {
                InputStream is = null;
                if (mConfiguration.locale.getCountry().equals("US"))
                    is = getResources().openRawResource(R.raw.james_intro);
                else if (mConfiguration.locale.getCountry().equals("CN"))
                {
                    is = getResources().openRawResource(R.raw.james_intro_ch);
                    name.setText("詹姆斯·高斯林");
                }
                int length = is.available();
                byte buffer[] = new byte[length];
                is.read(buffer);
                String result = new String(buffer, "UTF-8");
                ((TextView) findViewById(R.id.content)).setText(result);

                Glide.with(this)
                        .load(R.drawable.james_gosling_2008)
                        .into(imageView);

            }
            else if (ori == mConfiguration.ORIENTATION_PORTRAIT)
            {
                InputStream is = null;
                if (mConfiguration.locale.getCountry().equals("US"))
                    is = getResources().openRawResource(R.raw.ada_intro);
                else if (mConfiguration.locale.getCountry().equals("CN"))
                {
                    is = getResources().openRawResource(R.raw.ada_intro_ch);
                    name.setText("埃达·洛夫莱斯");
                }
                int length = is.available();
                byte buffer[] = new byte[length];
                is.read(buffer);
                String result = new String(buffer, "UTF-8");
                ((TextView) findViewById(R.id.content)).setText(result);

                Glide.with(this)
                        .load(R.drawable.ada_lovelace)
                        .into(imageView);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
