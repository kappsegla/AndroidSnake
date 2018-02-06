package snowroller.myapplication.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import snowroller.myapplication.models.LiftRide;

/**
 * Created by Martin on 2018-02-06.
 */

class MyViewHolder extends RecyclerView.ViewHolder{

    public MyViewHolder(View itemView) {
        super(itemView);

        //Store binder reference for view
    }
}

public class LiftRidesListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<LiftRide> liftRides;

    public LiftRidesListAdapter(List<LiftRide> liftRides)
    {
        this.liftRides = liftRides;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflate a new view and store in a viewholder
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //Assign viewModel to view
    }

    @Override
    public int getItemCount() {
        return liftRides.size();
    }
}
