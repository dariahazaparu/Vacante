package com.example.vacante;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DestinationFragment extends Fragment implements OnItemClickListener  {

    private String DEST_NAME = "name";
    private String DEST = "dest";

    public static List<Destination> destList = new ArrayList<>();

    public DestinationFragment() {
        super(R.layout.dest_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initiatize();
        ViewGroup viewGroup = (ViewGroup) view;
        int x = viewGroup.getChildCount();
        CustomAdapter adapter = new CustomAdapter(destList, this);
        RecyclerView rv = view.findViewById(R.id.recyclerView);
        rv.setAdapter(adapter);
    }

    private void initiatize() {
        destList.add(new Destination(
                "Maldive",
                "Ocean",
                4.5F,
                R.drawable.maldive
        ));
        destList.add( new Destination(
                "Madrid",
                "Spain",
                4.2F,
                R.drawable.madrid
        ));
    }


    @Override
    public void onItemClick(Destination item) {
        Bundle bundle = new Bundle();
        bundle.putString(DEST_NAME, item.getName());
        bundle.putParcelable(DEST, item);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        SecondFragment secondFragment = new SecondFragment();
//        secondFragment.setArguments(bundle);
//        fragmentTransaction.replace(R.id.fragment_container, secondFragment)
//                .addToBackStack(null);

        fragmentTransaction.commit();
    }
}
