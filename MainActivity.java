
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    CustomAdapter customAdapter;
    ArrayList<Contacts> arrayList =new ArrayList<>();
    ArrayClass arrayClass = new ArrayClass();
    ListView listmain;
   final DBHandler dbHandler = new DBHandler(this);
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    listmain.setVisibility(View.VISIBLE);

                    // The list View of all words
                    navigation_home_function();
                    return true;
                case R.id.navigation_dashboard:
                    listmain.setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_notifications:

                    listmain.setVisibility(View.INVISIBLE);

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        listmain = findViewById(R.id.listmain);


            arrayList = arrayClass.returnArraylist();
            for(int i=0;i<=19;i++) {
                //  dbHandler.addContact(new Contacts(arrayList.get(i).getID(),arrayList.get(i).getWordName(),
                //        arrayList.get(i).getMean(),arrayList.get(i).getStar(),arrayList.get(i).getVoice()));
                Toast.makeText(getApplicationContext(),arrayList.get(i).getID() + ":" + arrayList.get(i).getWordName(), Toast.LENGTH_SHORT).show();
            }
                customAdapter = new CustomAdapter(getApplicationContext(), arrayList);
            listmain.setAdapter(customAdapter);

    }

    public void navigation_home_function(){

    }
}
