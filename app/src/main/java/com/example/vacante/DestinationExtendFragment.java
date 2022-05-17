package com.example.vacante;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DestinationExtendFragment extends Fragment {

    public DestinationExtendFragment() {
        super(R.layout.dest_extend_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();

        if(bundle != null) {
            String title = bundle.getString(DestinationFragment.DEST_NAME);
            ((TextView) view.findViewById(R.id.dest_title)).setText(title);

            Destination dest = bundle.getParcelable(DestinationFragment.DEST);
        }

        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotif();
            }
        });
    }

    public void createNotif() {

    }
}
