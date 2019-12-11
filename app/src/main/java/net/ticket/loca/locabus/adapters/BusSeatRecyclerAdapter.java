package net.ticket.loca.locabus.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import net.ticket.loca.locabus.R;
import net.ticket.loca.locabus.interfaces.OnSeatSelected;
import net.ticket.loca.locabus.models.SeatDataModels.SeatData;

import java.util.ArrayList;
import java.util.List;

public class BusSeatRecyclerAdapter extends SelectableAdapter<RecyclerView.ViewHolder> {

    private OnSeatSelected mOnSeatSelected;
    private final int AVAIL_SEAT = 1;
    private final int BLANK_SEAT = 0;


    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private List<SeatData> mItems;

    public BusSeatRecyclerAdapter(Context context, List<SeatData> items, OnSeatSelected listner) {
        mOnSeatSelected = listner;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mItems = items;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == AVAIL_SEAT) {
            View itemView = mLayoutInflater.inflate(R.layout.list_item_seat, parent, false);

            return new AvailViewHolder(itemView);
        } else {
            View itemView = mLayoutInflater.inflate(R.layout.list_empty_seat, parent, false);

            return new EmptyViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        int isempty = mItems.get(position).getFieldEmpty();
        if (isempty == AVAIL_SEAT) {
            final AvailViewHolder holder = (AvailViewHolder) viewHolder;
            final SeatData item = mItems.get(position);
            if (item.getType() == 1) {
                //Seating
                if (item.getSeat_status() == 0) {
                    holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.seater_booked));
                } else if (item.getSeat_status() == 1) {
                    holder.imgSeat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            toggleSelection(position);
                            ArrayList<SeatData> selectedList = new ArrayList<>();
                            for (int i : getSelectedItems()) {
                                selectedList.add(mItems.get(i));
                            }
                            mOnSeatSelected.onSeatSelected(selectedList);
                        }
                    });
                    if (!isSelected(position)) {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.seater_availble_all));
                    } else {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.seater_selected));
                    }
                } else if (item.getSeat_status() == 2) {
                    holder.imgSeat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            toggleSelection(position);
                            ArrayList<SeatData> selectedList = new ArrayList<>();
                            for (int i : getSelectedItems()) {
                                selectedList.add(mItems.get(i));
                            }
                            mOnSeatSelected.onSeatSelected(selectedList);
                        }
                    });
                    if (!isSelected(position)) {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.seater_availble_male));
                    } else {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.seater_selected));
                    }
                } else if (item.getSeat_status() == 3) {
                    holder.imgSeat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            toggleSelection(position);
                            ArrayList<SeatData> selectedList = new ArrayList<>();
                            for (int i : getSelectedItems()) {
                                selectedList.add(mItems.get(i));
                            }
                            mOnSeatSelected.onSeatSelected(selectedList);
                        }
                    });
                    if (!isSelected(position)) {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.seater_availble_female));
                    } else {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.seater_selected));
                    }
                } else if (item.getSeat_status() == -2) {
                    holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.seater_booked_male));
                } else if (item.getSeat_status() == -3) {
                    holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.seater_booked_female));
                }

            } else if (item.getType() == 2) {
                //Sleeper
                if (item.getSeat_status() == 0) {
                    holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.sleeper_bocked));
                } else if (item.getSeat_status() == 1) {
                    holder.imgSeat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            toggleSelection(position);
                            ArrayList<SeatData> selectedList = new ArrayList<>();
                            for (int i : getSelectedItems()) {
                                selectedList.add(mItems.get(i));
                            }
                            mOnSeatSelected.onSeatSelected(selectedList);
                        }
                    });
                    if (!isSelected(position)) {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.sleeper_available_all));
                    } else {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.sleeper_selected));
                    }
                } else if (item.getSeat_status() == 2) {
                    holder.imgSeat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            toggleSelection(position);
                            ArrayList<SeatData> selectedList = new ArrayList<>();
                            for (int i : getSelectedItems()) {
                                selectedList.add(mItems.get(i));
                            }
                            mOnSeatSelected.onSeatSelected(selectedList);
                        }
                    });
                    if (!isSelected(position)) {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.sleeper_available_male));
                    } else {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.sleeper_selected));
                    }
                } else if (item.getSeat_status() == 3) {
                    holder.imgSeat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            toggleSelection(position);
                            ArrayList<SeatData> selectedList = new ArrayList<>();
                            for (int i : getSelectedItems()) {
                                selectedList.add(mItems.get(i));
                            }
                            mOnSeatSelected.onSeatSelected(selectedList);
                        }
                    });
                    if (!isSelected(position)) {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.sleeper_available_female));
                    } else {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.sleeper_selected));
                    }
                } else if (item.getSeat_status() == -2) {
                    holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.sleeper_bocked_male));
                } else if (item.getSeat_status() == -3) {
                    holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.sleeper_bocked_female));
                }
            } else {
                //Semi Sleeper
                if (item.getSeat_status() == 0) {
                    holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.semi_seater_booked));
                } else if (item.getSeat_status() == 1) {
                    holder.imgSeat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            toggleSelection(position);
                            ArrayList<SeatData> selectedList = new ArrayList<>();
                            for (int i : getSelectedItems()) {
                                selectedList.add(mItems.get(i));
                            }
                            mOnSeatSelected.onSeatSelected(selectedList);
                        }
                    });
                    if (!isSelected(position)) {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.semi_seater_available_all));
                    } else {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.semi_seater_selected));
                    }
                } else if (item.getSeat_status() == 2) {
                    holder.imgSeat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            toggleSelection(position);
                            ArrayList<SeatData> selectedList = new ArrayList<>();
                            for (int i : getSelectedItems()) {
                                selectedList.add(mItems.get(i));
                            }
                            mOnSeatSelected.onSeatSelected(selectedList);
                        }
                    });
                    if (!isSelected(position)) {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.semi_seater_available_male));
                    } else {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.semi_seater_selected));
                    }
                } else if (item.getSeat_status() == 3) {
                    holder.imgSeat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            toggleSelection(position);
                            ArrayList<SeatData> selectedList = new ArrayList<>();
                            for (int i : getSelectedItems()) {
                                selectedList.add(mItems.get(i));
                            }
                            mOnSeatSelected.onSeatSelected(selectedList);
                        }
                    });
                    if (!isSelected(position)) {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.semi_seater_available_female));
                    } else {
                        holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.semi_seater_selected));
                    }
                } else if (item.getSeat_status() == -2) {
                    holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.semi_seater_booked_male));
                } else if (item.getSeat_status() == -3) {
                    holder.imgSeat.setImageDrawable(mContext.getResources().getDrawable(R.drawable.semi_seater_booked_female));
                }
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        SeatData data = mItems.get(position);
        if (data.getFieldEmpty() == 1) {
            return AVAIL_SEAT;
        } else {
            return BLANK_SEAT;
        }
    }


    private static class AvailViewHolder extends RecyclerView.ViewHolder {
        ImageView imgSeat;

        AvailViewHolder(View itemView) {
            super(itemView);
            imgSeat = (ImageView) itemView.findViewById(R.id.img_seat);
        }

    }

    private static class EmptyViewHolder extends RecyclerView.ViewHolder {
        EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

}
