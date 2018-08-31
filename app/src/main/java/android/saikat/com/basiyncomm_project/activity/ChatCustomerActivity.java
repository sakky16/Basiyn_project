package android.saikat.com.basiyncomm_project.activity;

import android.saikat.com.basiyncomm_project.R;
import android.saikat.com.basiyncomm_project.adapter.ChatCustomerRecyclerAdapter;
import android.saikat.com.basiyncomm_project.model.Customer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatCustomerActivity extends AppCompatActivity {
    private RecyclerView customer_rv;
    private TextView title_tv;
    List<Customer> customerList=new ArrayList<>();
    private ChatCustomerRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_customer);
        getWidgets();
        setList();
        setAdapter();

    }
    private void getWidgets(){
        customer_rv=(RecyclerView)findViewById(R.id.customer_rv);
        title_tv=(TextView)findViewById(R.id.title_tv);
        title_tv.setText("Chat - Customers");
    }
    private void setList(){
        customerList.add(new Customer("Kreeti Chandra Sharma","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","30/06/18"));
        customerList.add(new Customer("Kreeti Chandra Sharma","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","30/06/18"));
        customerList.add(new Customer("Rahul shama","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","30/06/18"));
        customerList.add(new Customer("Kreetika Roy","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","30/06/18"));
        customerList.add(new Customer("Dipak tripathi","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","30/06/18"));
        customerList.add(new Customer("Hari ram pal","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","30/06/18"));
        customerList.add(new Customer("Rakesh Jhunjhunwala","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","30/06/18"));
        customerList.add(new Customer("Dhiman kanti roy","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","30/06/18"));


    }
    private void setAdapter(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        adapter=new ChatCustomerRecyclerAdapter(ChatCustomerActivity.this,customerList);
        customer_rv.setLayoutManager(linearLayoutManager);
        customer_rv.setAdapter(adapter);


    }
}
