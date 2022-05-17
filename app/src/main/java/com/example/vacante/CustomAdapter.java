package com.example.vacante;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.DestinationHolder> implements Filterable {

    private List<Destination> localDataSet;
    private List<Destination> localDataSetFull;

    public static OnItemClickListener itemClickListener;

    public CustomAdapter(List<Destination> localDataSet, OnItemClickListener onItemClickListener) {
        this.localDataSet = localDataSet;
        itemClickListener = onItemClickListener;
        localDataSetFull = new ArrayList<>(localDataSet);
    }

    @NonNull
    @Override
    public DestinationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.destination, parent, false);
        return new DestinationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationHolder holder, int position) {
        holder.bind(localDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    @Override
    public Filter getFilter() {
        return localDataSetFilter;
    }

    private Filter localDataSetFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Destination> filteredDataSet = new ArrayList<>();
            if(constraint == null || constraint.length() == 0) {
                filteredDataSet.addAll(localDataSetFull);
            }
            else {
                String filter = constraint.toString().toLowerCase().trim();
                for (Destination item: localDataSetFull) {
                    if (item.getName().toLowerCase().trim().startsWith(filter))
                    filteredDataSet.add(item);
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredDataSet;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            localDataSet.clear();
            localDataSet.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

    public static class DestinationHolder extends RecyclerView.ViewHolder {
        private final TextView Name;
        private final TextView Location;
        private final TextView Review;
        private final ImageView destImage;
        private final TextView Description;

        private final ConstraintLayout layout;

        public DestinationHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.dest_title);
            Location = itemView.findViewById(R.id.location);
            Review = itemView.findViewById(R.id.review);
            destImage = itemView.findViewById(R.id.iv_picture);
            Description = itemView.findViewById(R.id.description);
            layout = itemView.findViewById(R.id.container);
        }

        public void bind(Destination item) {
            Name.setText(item.getName());
            Location.setText(item.getLocation());
            Review.setText(item.getReview().toString());
            destImage.setImageDrawable(ContextCompat.getDrawable(destImage.getContext(), item.getImageId()));
            Description.setText(item.getDescription());
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(item);
                }
            });
        }
    }
}
