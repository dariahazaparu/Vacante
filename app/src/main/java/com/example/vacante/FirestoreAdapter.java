package com.example.vacante;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public abstract class FirestoreAdapter<VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH>
        implements EventListener<QuerySnapshot> { // Add this "implements"

    // ...

    // Add this method
    @Override
    public void onEvent(QuerySnapshot documentSnapshots,
                        FirebaseFirestoreException e) {

        // Handle errors
        if (e != null) {
            Log.w(TAG, "onEvent:error", e);
            return;
        }

        // Dispatch the event
        for (DocumentChange change : documentSnapshots.getDocumentChanges()) {
            // Snapshot of the changed document
            DocumentSnapshot snapshot = change.getDocument();

            switch (change.getType()) {
                case ADDED:
                    // TODO: handle document added
                    break;
                case MODIFIED:
                    // TODO: handle document modified
                    break;
                case REMOVED:
                    // TODO: handle document removed
                    break;
            }
        }

        //onDataChanged();
    }

//    protected void onDocumentAdded(DocumentChange change) {
//        mSnapshots.add(change.getNewIndex(), change.getDocument());
//        notifyItemInserted(change.getNewIndex());
//    }
//
//    protected void onDocumentModified(DocumentChange change) {
//        if (change.getOldIndex() == change.getNewIndex()) {
//            // Item changed but remained in same position
//            mSnapshots.set(change.getOldIndex(), change.getDocument());
//            notifyItemChanged(change.getOldIndex());
//        } else {
//            // Item changed and changed position
//            mSnapshots.remove(change.getOldIndex());
//            mSnapshots.add(change.getNewIndex(), change.getDocument());
//            notifyItemMoved(change.getOldIndex(), change.getNewIndex());
//        }
//    }
//
//    protected void onDocumentRemoved(DocumentChange change) {
//        mSnapshots.remove(change.getOldIndex());
//        notifyItemRemoved(change.getOldIndex());
//    }

    // ...
}