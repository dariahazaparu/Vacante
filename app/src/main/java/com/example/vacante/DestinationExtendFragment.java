package com.example.vacante;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
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
            String description = bundle.getString(DestinationFragment.DEST_DESC);
            ((TextView) view.findViewById(R.id.dest_description)).setText(description);
            String imageId = bundle.getString(DestinationFragment.DEST_IMAGE);
            ((ImageView) view.findViewById(R.id.dest_image)).setImageDrawable(ContextCompat.getDrawable(getContext(), Integer.valueOf(imageId)));;

            Destination dest = bundle.getParcelable(DestinationFragment.DEST);
        }

//        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                createNotif();
//            }
//        });

        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                assert bundle != null;
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Vreau sa merg in "+bundle.getString(DestinationFragment.DEST_NAME)+ "!");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }

    public void createNotif() {

    }
}
