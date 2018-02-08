package snowroller.myapplication.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import snowroller.myapplication.databinding.ListItemBinding;
import snowroller.myapplication.models.LiftRide;

/**
 * Created by Martin on 2018-02-06.
 */

class MyViewHolder extends RecyclerView.ViewHolder {
    private ListItemBinding binding;

    public MyViewHolder(View itemView) {
        super(itemView);

        //Store binder reference for view
        binding = DataBindingUtil.bind(itemView);
    }

    public void bindViewModel(LiftRide liftRide)
    {
        binding.setViewModel(liftRide);
        binding.executePendingBindings();
    }
}

public class LiftRidesListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<LiftRide> liftRides;

    public LiftRidesListAdapter(List<LiftRide> liftRides) {
        this.liftRides = liftRides;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflate a new view and store in a new Viewholder
        View v = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false).getRoot();

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //Assign viewModel to view
        LiftRide liftRide = liftRides.get(position);
        holder.bindViewModel(liftRide);
    }

    @Override
    public int getItemCount() {
        return liftRides.size();
    }

    public void setList(List<LiftRide> liftRides)
    {
        this.liftRides = liftRides;
        this.notifyDataSetChanged();
    }
}
