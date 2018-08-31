package android.saikat.com.basiyncomm_project.adapter;

import android.content.Context;
import android.saikat.com.basiyncomm_project.R;
import android.saikat.com.basiyncomm_project.model.Chat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by trisys on 15/7/18.
 */

public class ChatingRecyclerAdater extends RecyclerView.Adapter<ChatingRecyclerAdater.CustomAdapter> {
    private List<Chat> chatList;
    private Context context;
    private LayoutInflater inflater;

    public ChatingRecyclerAdater(Context context, List<Chat> chatList){
        this.context=context;
        this.chatList=chatList;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if(chatList.get(position).getMessage_user().equalsIgnoreCase(context.getString(R.string.FROM_MSG))){

            return 0;
        }
        else {
            if(chatList.get(position).getMessage_type().equalsIgnoreCase(context.getString(R.string.MSG_TEXT))){
                return 1;
            }
            else {
                return 2;
            }

        }
    }

    @Override
    public CustomAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        switch (viewType){
            case 0:{
                view=inflater.inflate(R.layout.from_chat_text,parent,false);
            }
            break;
            case 1:{
                view=inflater.inflate(R.layout.to_chat_text,parent,false);
            }
            break;
            case 2:{
                view=inflater.inflate(R.layout.to_chat_image,parent,false);
            }
        }
        return new CustomAdapter(view,viewType);
    }

    @Override
    public void onBindViewHolder(CustomAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public class CustomAdapter extends RecyclerView.ViewHolder{
        CardView cardView;


        public CustomAdapter(View itemView,int viewType) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.card_view);
            if(viewType==0){
                cardView.setCardBackgroundColor(context.getResources().getColor(R.color.orage));
            }

        }
    }
}
