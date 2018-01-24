package snowroller.myapplication.fragments;


import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import snowroller.myapplication.R;
import snowroller.myapplication.databinding.FragmentTotalBinding;
import snowroller.myapplication.viewmodels.TotalFragmentViewModel;


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
        TotalFragmentViewModel viewModel = new TotalFragmentViewModel();

        FragmentTotalBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_total,
                container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
        //return inflater.inflate(R.layout.fragment_total, container, false);
    }

}
