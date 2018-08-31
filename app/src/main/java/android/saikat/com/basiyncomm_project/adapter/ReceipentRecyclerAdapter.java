package android.saikat.com.basiyncomm_project.adapter;

import android.content.Context;
import android.saikat.com.basiyncomm_project.R;
import android.saikat.com.basiyncomm_project.model.Customer;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by trisys on 15/7/18.
 */

public class ReceipentRecyclerAdapter extends RecyclerView.Adapter<ReceipentRecyclerAdapter.CustomAdapter> {
    List<Customer> customerList;
    private Context context;
    LayoutInflater inflater;

    public ReceipentRecyclerAdapter(Context context,List<Customer> customerList){
        this.context=context;
        this.customerList=customerList;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        Customer customer=customerList.get(position);
        if(customer.getName().equalsIgnoreCase("All Customer")||
                customer.getName().equalsIgnoreCase("All Seller")||
        customer.getName().equalsIgnoreCase("All Team")){
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public CustomAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        switch (viewType){
            case 0:{
               view=inflater.inflate(R.layout.receipent_item,parent,false);
            }
            break;
            case 1:{
                view=inflater.inflate(R.layout.receipent_cs_item,parent,false);
            }
            break;
        }
        return new CustomAdapter(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter holder, int position) {
        Customer customer=customerList.get(position);
        if(customer.getName().equalsIgnoreCase("All Customer")){
            holder.name.setTextColor(context.getResources().getColor(R.color.green));
            holder.title.setText("C");

        }
        else if(customer.getName().equalsIgnoreCase("All Seller")){
            holder.name.setTextColor(context.getResources().getColor(R.color.yellow));
            holder.title.setText("S");

        }
        else if(customer.getName().equalsIgnoreCase("All Team")){
            holder.name.setTextColor(context.getResources().getColor(R.color.light_blue));
            holder.title.setText("T");

        }
        else {
            holder.address.setText(customer.getAdreess());
            holder.title.setText(customer.getDate());
        }
        holder.name.setText(customer.getName());


    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public class CustomAdapter extends RecyclerView.ViewHolder{
        TextView title,name,address;

        public CustomAdapter(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title_tv);
            name=(TextView)itemView.findViewById(R.id.name_tv);
            address=(TextView)itemView.findViewById(R.id.address_tv);
        }
    }
}
