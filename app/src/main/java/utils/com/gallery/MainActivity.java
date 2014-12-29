package utils.com.gallery;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.gallery.FunnyGallery;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends Activity {

    FunnyGallery  gallery;
    FunnyGallery  gallery3;
    FunnyGallery  gallery2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final JSONArray data = new JSONArray();
                for (int i=0;i<20;i++){
                    JSONObject obj = new JSONObject();
                    try {
                        obj.put("name","x"+i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    data.put(obj);
                }
        final JSONArray data2 = new JSONArray();
        for (int i=0;i<20;i++){
            JSONObject obj = new JSONObject();
            try {
                obj.put("name","y"+i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            data2.put(obj);
        }

        gallery = (FunnyGallery) findViewById(R.id.gallery);
        gallery.constructor(data);

        gallery2 = (FunnyGallery) findViewById(R.id.gallery2);
        gallery2.constructor(data);
        gallery3 = (FunnyGallery) findViewById(R.id.gallery3);
        gallery3.constructor(data);
        Button random = (Button) findViewById(R.id.random);
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gallery3.random();
            }
        });

        Button change = (Button) findViewById(R.id.change);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("width","width="+gallery2.getWidth());
                gallery2.changeData(data2);
                Log.i("width","width2="+gallery2.getWidth());
            }
        });

        Button gotonr= (Button) findViewById(R.id.gotonr);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.i("width","width="+gallery2.getWidth());
//                gallery2.changeData(data2);
//                Log.i("width","width2="+gallery2.getWidth());
            }
        });

        gallery.random();
        gallery2.random();
        gallery3.random();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onClickBTN(View view){
        Log.i("Merge","Merge");
    }
}
