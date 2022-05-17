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

    public static String DEST_NAME = "name";
    public static String DEST = "dest";

    public static List<Destination> destList = new ArrayList<>();
    public static CustomAdapter adapter;
    public DestinationFragment() {
        super(R.layout.dest_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initiatize();
        ViewGroup viewGroup = (ViewGroup) view;
        int x = viewGroup.getChildCount();
        adapter = new CustomAdapter(destList, this);
        RecyclerView rv = view.findViewById(R.id.recyclerView);
        rv.setAdapter(adapter);
    }

    private void initiatize() {
        if(destList.isEmpty()){

            destList.add(new Destination(
                    "Maldive",
                    "Ocean",
                    4.5F,
                    R.drawable.maldive,
                    "a"
            ));
            destList.add( new Destination(
                    "Madrid",
                    "Spain",
                    4.2F,
                    R.drawable.madrid,
                    ""
            ));
        }
    }


    @Override
    public void onItemClick(Destination item) {
        Bundle bundle = new Bundle();
        bundle.putString(DEST_NAME, item.getName());
        bundle.putParcelable(DEST, item);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        DestinationExtendFragment secondFragment = new DestinationExtendFragment();
        secondFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.dest_fragment_container, secondFragment)
                .addToBackStack(null);

        fragmentTransaction.commit();
    }


}
