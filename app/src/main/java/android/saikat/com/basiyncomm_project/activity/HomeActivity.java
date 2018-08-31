package android.saikat.com.basiyncomm_project.activity;

import android.content.Intent;
import android.saikat.com.basiyncomm_project.R;
import android.saikat.com.basiyncomm_project.util.AppUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private LinearLayout customer_ll;
    private TextView title_tv;
    private ImageView menu_iv,search_iv;
    private ImageView add_msg_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWidgets();
        setListener();
    }
    private void getWidgets(){
        customer_ll=(LinearLayout)findViewById(R.id.customer_ll);
        title_tv=(TextView)findViewById(R.id.title_tv);
        title_tv.setText("BASIYN Communicator");
        menu_iv=(ImageView)findViewById(R.id.menu_iv);
        search_iv=(ImageView)findViewById(R.id.search_iv);
        menu_iv.setVisibility(View.GONE);
        search_iv.setVisibility(View.GONE);
        add_msg_iv=(ImageView)findViewById(R.id.add_msg_iv);
    }
    private void setListener(){
        customer_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ChatCustomerActivity.class));
            }
        });
        add_msg_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,NewMessageActivity.class).putExtra(AppUtils.FROM_ACTIVITY,AppUtils.NEW_MESSAGE));
            }
        });
    }
}
