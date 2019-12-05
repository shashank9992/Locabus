package net.ticket.loca.locabus.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import net.ticket.loca.locabus.R;
import net.ticket.loca.locabus.models.StopListData;


import java.util.ArrayList;

public class StopListAdapter extends BaseAdapter {
    ArrayList<StopListData> stopListDataArrayList;
    private Context context;
    private LayoutInflater inflater;

    public StopListAdapter(Context context,ArrayList<StopListData> stopListDataArrayList){

        this.context=context;
        this.stopListDataArrayList=stopListDataArrayList;
        inflater=LayoutInflater.from(this.context);
    }
    @Override
    public int getCount() {
        return stopListDataArrayList.size();
    }

    @Override
    public StopListData getItem(int i) {
        return stopListDataArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view==null){

            view=inflater.inflate(R.layout.stop_list_item,viewGroup,false);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }
        else {

            viewHolder=(ViewHolder) view.getTag();
        }

        StopListData stopListData=getItem(i);
        viewHolder.tv_stop_name.setText(stopListData.getStop_name_english());
        return view;
    }

    public class ViewHolder{
        TextView tv_stop_name;
        public ViewHolder(View view){

            tv_stop_name=view.findViewById(R.id.tv_stop_name);
        }
    }
}
