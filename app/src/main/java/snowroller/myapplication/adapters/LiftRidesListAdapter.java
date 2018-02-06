package snowroller.myapplication.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Martin on 2018-02-06.
 */

class MyViewHolder extends RecyclerView.ViewHolder{

    public MyViewHolder(View itemView) {
        super(itemView);
    }
}

public class LiftRidesListAdapter extends RecyclerView.Adapter<MyViewHolder> {
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
