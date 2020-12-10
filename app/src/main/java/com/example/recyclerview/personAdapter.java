package com.example.recyclerview;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class personAdapter extends FirebaseRecyclerAdapter<
        person, personAdapter.personsViewholder> {

    public personAdapter(
            @NonNull FirebaseRecyclerOptions<person> options)
    {
        super(options);
    }

    @Override
    protected void
    onBindViewHolder(@NonNull personsViewholder holder,
                     int position, @NonNull person model)
    {

        holder.ID.setText(model.getFirstname());

        holder.name.setText(model.getLastname());

        holder.designation.setText(model.getAge());
    }

    @NonNull
    @Override
    public personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person, parent, false);
        return new personsViewholder(view);
    }

    static class personsViewholder
            extends RecyclerView.ViewHolder {
        TextView ID, name, designation;
        public personsViewholder(@NonNull View itemView)
        {
            super(itemView);

            ID
                    = itemView.findViewById(R.id.firstname);
            name = itemView.findViewById(R.id.lastname);
            designation = itemView.findViewById(R.id.age);
        }
    }
}
