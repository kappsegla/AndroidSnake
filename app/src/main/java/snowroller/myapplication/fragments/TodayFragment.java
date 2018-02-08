package snowroller.myapplication.fragments;


import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import snowroller.myapplication.R;
import snowroller.myapplication.databinding.FragmentTodayBinding;
import snowroller.myapplication.viewmodels.TodayViewModel;
import snowroller.myapplication.viewmodels.ViewModelProvider;


/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment extends Fragment {

    private TodayViewModel viewModel;

    public TodayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = ViewModelProvider.getInstance().getBottomNavigationViewModel().todayViewModel;

        FragmentTodayBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_today,
                container, false);
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }
}
