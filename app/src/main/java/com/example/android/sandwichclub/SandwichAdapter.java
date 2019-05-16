package com.example.android.sandwichclub;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SandwichAdapter extends RecyclerView.Adapter<SandwichAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private String[] SandwichDatabase;
    private Context context;

    public SandwichAdapter(@NonNull Context context, String[] SandwichDatabase) {
        this.layoutInflater = LayoutInflater.from(context);
        this.SandwichDatabase = SandwichDatabase;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.sandwichName.setText(SandwichDatabase[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Info", position);
                view.getContext().startActivity(intent);
    }
});

    }

    @Override
    public int getItemCount() {
        return SandwichDatabase == null ? 0 : SandwichDatabase.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView sandwichName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sandwichName = itemView.findViewById(R.id.sandwich_name);

        }
    }

}
