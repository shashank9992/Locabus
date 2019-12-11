package net.ticket.loca.locabus.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.ticket.loca.locabus.R;
import net.ticket.loca.locabus.helpers.Helper;
import net.ticket.loca.locabus.models.bus_model.Buses;

import java.util.ArrayList;

public class OutStationBusAdapter extends RecyclerView.Adapter<OutStationBusAdapter.MyViewHolder> {

    private ArrayList<Buses> busList;
    private Context mcontext;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_traveller_name, tv_amount, tv_arrival, tv_dept, tv_estimate_time, tv_seat_left, tv_bus_type;

        MyViewHolder(View view) {
            super(view);
            tv_traveller_name = view.findViewById(R.id.tv_traveller_name);
            tv_arrival = view.findViewById(R.id.label_arrive_time);
            tv_dept = view.findViewById(R.id.label_depart_time);
            tv_estimate_time = view.findViewById(R.id.label_estimate_time);
            tv_amount = view.findViewById(R.id.tv_bus_fare);
            tv_seat_left = view.findViewById(R.id.label_seat_lefts);
            tv_bus_type = view.findViewById(R.id.label_bus_type);
        }
    }


    public OutStationBusAdapter(Context context, ArrayList<Buses> busList) {
        this.busList = busList;
        this.mcontext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.outstaion_bus_result_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Buses buses = busList.get(position);
        holder.tv_amount.setText(buses.getBusStatus().getBaseFares().get(0).toString());
        holder.tv_arrival.setText(Helper.convertDateTime("yyyy-MM-dd HH:mm:ss", "HH:mm",
                buses.getArrTime()));
        holder.tv_dept.setText(Helper.convertDateTime("yyyy-MM-dd HH:mm:ss", "HH:mm",
                buses.getDeptTime()));
        holder.tv_estimate_time.setText(buses.getDuration()+" min");
        holder.tv_traveller_name.setText(buses.getCompanyName().toString());
        holder.tv_seat_left.setText(buses.getBusStatus().getAvailability() + " sets lefts");
        holder.tv_bus_type.setText(buses.getDisplayBusType().toString());

    }

    @Override
    public int getItemCount() {
        return busList.size();
    }
}