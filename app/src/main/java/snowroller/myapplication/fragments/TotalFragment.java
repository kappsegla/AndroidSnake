package snowroller.myapplication.fragments;


import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import snowroller.myapplication.R;
import snowroller.myapplication.adapters.LiftRidesListAdapter;
import snowroller.myapplication.databinding.FragmentTotalBinding;
import snowroller.myapplication.models.LiftRide;
import snowroller.myapplication.services.Services;
import snowroller.myapplication.viewmodels.TotalViewModel;
import snowroller.myapplication.viewmodels.ViewModelProvider;


/**
 * A simple {@link Fragment} subclass.
 */
public class TotalFragment extends Fragment {


    public TotalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        TotalViewModel viewModel = ViewModelProvider.getInstance().getBottomNavigationViewModel().totalViewModel;

        FragmentTotalBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_total,
                container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
        //return inflater.inflate(R.layout.fragment_total, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Services.getService().liftRides("3206","13").enqueue(new Callback<List<LiftRide>>() {
            @Override
            public void onResponse(Call<List<LiftRide>> call, Response<List<LiftRide>> response) {
                RecyclerView list = getActivity().findViewById(R.id.recyclerView);
                list.setAdapter(new LiftRidesListAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<LiftRide>> call, Throwable t) {

            }
        });
    }
}
