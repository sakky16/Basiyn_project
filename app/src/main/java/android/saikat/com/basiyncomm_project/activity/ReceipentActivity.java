package android.saikat.com.basiyncomm_project.activity;

import android.saikat.com.basiyncomm_project.R;
import android.saikat.com.basiyncomm_project.adapter.ChatCustomerRecyclerAdapter;
import android.saikat.com.basiyncomm_project.adapter.ReceipentRecyclerAdapter;
import android.saikat.com.basiyncomm_project.model.Customer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReceipentActivity extends AppCompatActivity {
    private RecyclerView receipent_rv;
    private TextView title_tv;
    private ImageView menu_iv,search_iv;
    List<Customer> customerList=new ArrayList<>();
    ReceipentRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipent);
        getWidgets();
        setList();
        setAdapter();
    }
    private void getWidgets(){
        title_tv=(TextView)findViewById(R.id.title_tv);
        title_tv.setText("Select Recipient");
        menu_iv=(ImageView)findViewById(R.id.menu_iv);
        search_iv=(ImageView)findViewById(R.id.search_iv);
        menu_iv.setVisibility(View.INVISIBLE);
        receipent_rv=(RecyclerView)findViewById(R.id.recipent_rv);
    }
    private void setList(){
        customerList.add(new Customer("All Customer","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","30/06/18"));
        customerList.add(new Customer("All Seller","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","30/06/18"));
        customerList.add(new Customer("All Team","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","30/06/18"));
        customerList.add(new Customer("Kreeti Chandra Sharma","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","C"));
        customerList.add(new Customer("Kreeti Chandra Sharma","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","C"));
        customerList.add(new Customer("Rahul shama","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","C"));
        customerList.add(new Customer("Kreetika Roy","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","C"));
        customerList.add(new Customer("Dipak tripathi","#112,Blck-1B,Harsha Landmark,Horamavu,Bangalore-560023","C"));



    }
    private void setAdapter(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        adapter=new ReceipentRecyclerAdapter(ReceipentActivity.this,customerList);
        receipent_rv.setLayoutManager(linearLayoutManager);
        receipent_rv.setAdapter(adapter);


    }
}
