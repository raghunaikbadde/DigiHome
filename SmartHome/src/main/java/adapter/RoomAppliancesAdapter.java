package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart.digihome.R;
import com.triggertrap.seekarc.SeekArc;

import java.util.ArrayList;

import Constants.Constants;
import pojo.Appliance;
import pojo.ElectricFan;
import pojo.ElectricLight;

public class RoomAppliancesAdapter extends RecyclerView.Adapter{
    private ArrayList<Appliance> dataSet;
    private Context mContext;
    public static final int DEVICE_LIGHT_VIEW_TYPE = 0;
    public static final int DEVICE_FAN_VIEW_TYPE = 1;
    public RoomAppliancesAdapter(ArrayList<Appliance> appliances,Context context){
        dataSet = appliances;
        mContext = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
       // Appliance appliance = dataSet.get(position);
        View view;
        if(viewType==DEVICE_LIGHT_VIEW_TYPE){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.light_appliance_layout,viewGroup,false);
            ElectricLightViewHolder electricLightViewHolder = new ElectricLightViewHolder(view);
            return  electricLightViewHolder;

        } if (viewType == DEVICE_FAN_VIEW_TYPE){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fan_appliance_layout,viewGroup,false);
            ElectricFanViewHolder electricFanViewHolder = new ElectricFanViewHolder(view);
            return  electricFanViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Appliance appliance = dataSet.get(position);
        if(appliance!=null){
            switch (appliance.getTypeOfAppliance()){
                case ElectricLight.DEVICE_TYPE:
                    if(viewHolder instanceof ElectricLightViewHolder)
                    ((ElectricLightViewHolder)viewHolder).switchCompat.setChecked(appliance.isPowerOn());
                    break;
                case ElectricFan.DEVICE_TYPE:
                    //ElectricFanViewHolder electricFanViewHolder = (ElectricFanViewHolder) viewHolder;
                    ElectricFan electricFan = (ElectricFan)appliance;
                    if(viewHolder instanceof ElectricFanViewHolder) {
                        ((ElectricFanViewHolder) viewHolder).switchCompat.setChecked(electricFan.isPowerOn());
                        ((ElectricFanViewHolder) viewHolder).seekArc.setProgress(electricFan.getProgressStep());
                    }
                    break;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(dataSet.get(position).getTypeOfAppliance().equals(ElectricLight.DEVICE_TYPE)){
            return DEVICE_LIGHT_VIEW_TYPE;
        } else if(dataSet.get(position).getTypeOfAppliance().equals(ElectricFan.DEVICE_TYPE)){
            return DEVICE_FAN_VIEW_TYPE;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ElectricLightViewHolder extends RecyclerView.ViewHolder{

        SwitchCompat switchCompat;

        public ElectricLightViewHolder(@NonNull View itemView) {
            super(itemView);
            switchCompat = itemView.findViewById(R.id.lightswitcher);
        }
    }

    public static class ElectricFanViewHolder extends RecyclerView.ViewHolder{

        SwitchCompat switchCompat;
        SeekArc seekArc;
        TextView progressTv;
        public ElectricFanViewHolder(@NonNull View itemView) {
            super(itemView);
            switchCompat = itemView.findViewById(R.id.fanswitcher);
            seekArc = itemView.findViewById(R.id.seekArc);
            progressTv = itemView.findViewById(R.id.label);
            seekArc.setOnSeekArcChangeListener(new SeekArc.OnSeekArcChangeListener() {
                @Override
                public void onProgressChanged(SeekArc seekArc, int progress, boolean fromUser) {
                    progressTv.setText((int)(((double)progress/100)*100)+"%");

                }

                @Override
                public void onStartTrackingTouch(SeekArc seekArc) {

                }

                @Override
                public void onStopTrackingTouch(SeekArc seekArc) {

                }
            });
        }
    }
}
