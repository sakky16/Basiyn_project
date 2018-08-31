package android.saikat.com.basiyncomm_project.activity;

import android.content.Intent;
import android.saikat.com.basiyncomm_project.R;
import android.saikat.com.basiyncomm_project.adapter.ChatingRecyclerAdater;
import android.saikat.com.basiyncomm_project.model.Chat;
import android.saikat.com.basiyncomm_project.util.AppUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewMessageActivity extends AppCompatActivity {
    private TextView title_tv;
    private ImageView menu_iv,search_iv,next_iv;
    private List<Chat> chatList;
    private RelativeLayout profile_rl;
    private RecyclerView chat_rv;
    private String from_activity,name;
    private ChatingRecyclerAdater adater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        getWidgets();
        getExtra();
        if(from_activity!=null){
            if(from_activity.equalsIgnoreCase(AppUtils.CUSTOMER_LIST)){
                profile_rl.setVisibility(View.VISIBLE);
                setList();
                setAdapter();
                setWidgets(name);
            }
            else {
                menu_iv.setVisibility(View.GONE);
                search_iv.setVisibility(View.GONE);
                setWidgets("New Message");

            }
        }
        setListener();

    }
    private void setWidgets(String title){
        title_tv.setText(title);
    }
    private void getExtra(){
        from_activity=getIntent().getStringExtra(AppUtils.FROM_ACTIVITY);
        name=getIntent().getStringExtra(AppUtils.NAME);
    }
    private void getWidgets(){
        title_tv=(TextView)findViewById(R.id.title_tv);
        chat_rv=(RecyclerView)findViewById(R.id.chat_rv);
        menu_iv=(ImageView)findViewById(R.id.menu_iv);
        search_iv=(ImageView)findViewById(R.id.search_iv);
        next_iv=(ImageView)findViewById(R.id.next_iv);
        profile_rl=(RelativeLayout)findViewById(R.id.profile_rl);

    }
    private void setListener(){
        if(from_activity!=null){
            if(from_activity.equalsIgnoreCase(AppUtils.NEW_MESSAGE)){
                next_iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(NewMessageActivity.this,ReceipentActivity.class));
                    }
                });
            }
        }
    }

    private void setList(){
        chatList=new ArrayList<>();
        chatList.add(new Chat(getString(R.string.msg),"8:05 PM (3 oct)",getString(R.string.MSG_TEXT),getString(R.string.FROM_MSG)));
        chatList.add(new Chat(getString(R.string.msg),"8:05 PM (3 oct)",getString(R.string.MSG_TEXT),getString(R.string.TO_MSG)));
        chatList.add(new Chat(getString(R.string.msg),"8:05 PM (3 oct)",getString(R.string.MSG_TEXT),getString(R.string.TO_MSG)));
        chatList.add(new Chat(getString(R.string.msg),"8:05 PM (3 oct)",getString(R.string.MSG_IMAGE),getString(R.string.TO_MSG)));
        chatList.add(new Chat(getString(R.string.msg),"8:05 PM (3 oct)",getString(R.string.MSG_TEXT),getString(R.string.FROM_MSG)));

    }
    private void setAdapter(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        adater=new ChatingRecyclerAdater(NewMessageActivity.this,chatList);
        chat_rv.setLayoutManager(linearLayoutManager);
        chat_rv.setAdapter(adater);
    }

}
