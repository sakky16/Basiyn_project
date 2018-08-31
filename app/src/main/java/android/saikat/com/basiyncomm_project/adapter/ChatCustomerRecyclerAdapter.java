package android.saikat.com.basiyncomm_project.adapter;

import android.content.Context;
import android.content.Intent;
import android.saikat.com.basiyncomm_project.R;
import android.saikat.com.basiyncomm_project.activity.NewMessageActivity;
import android.saikat.com.basiyncomm_project.model.Customer;
import android.saikat.com.basiyncomm_project.util.AppUtils;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by trisys on 14/7/18.
 */

public class ChatCustomerRecyclerAdapter extends RecyclerView.Adapter<ChatCustomerRecyclerAdapter.CustomViewHolder> {
    private Context context;
    private List<Customer> customerList;
    private LayoutInflater inflater;

    public ChatCustomerRecyclerAdapter(Context context, List<Customer> customerList){
        this.context=context;
        this.customerList=customerList;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        if(customerList.size()>0){
          view=inflater.inflate(R.layout.chat_customer_item,parent,false);

        }
        return new CustomViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final Customer customer=customerList.get(position);
        holder.name_tv.setText(customer.getName());
        holder.address_tv.setText(customer.getAdreess());
        holder.date_tv.setText(customer.getDate());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, NewMessageActivity.class);
                intent.putExtra(AppUtils.FROM_ACTIVITY,AppUtils.CUSTOMER_LIST);
                intent.putExtra(AppUtils.NAME,customer.getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView name_tv,address_tv,date_tv;
        private LinearLayout rootView;



        public CustomViewHolder(View itemView) {
            super(itemView);
            name_tv=(TextView)itemView.findViewById(R.id.name_tv);
            address_tv=(TextView)itemView.findViewById(R.id.address_tv);
            date_tv=(TextView)itemView.findViewById(R.id.date_tv);
            rootView=(LinearLayout)itemView.findViewById(R.id.rootView);

        }
    }
}
