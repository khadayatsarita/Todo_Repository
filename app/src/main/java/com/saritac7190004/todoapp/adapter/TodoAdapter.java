package com.saritac7190004.todoapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saritac7190004.todoapp.R;
import com.saritac7190004.todoapp.model.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sarita on 6/12/2020.
 */
public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    List<Todo> todos = new ArrayList<>();
    private onItemClickListner listner;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.todo_rv_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView description;
        TextView priority;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.editText_todoTitle);
            description = itemView.findViewById(R.id.editText_todoDescription);
            priority = itemView.findViewById(R.id.textView_todoPriority);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listner != null && position != RecyclerView.NO_POSITION) {
                        listner.onItemClick(todos.get(position));
                    }
                }
            });
        }

        public void bind(int position) {
            title.setText(todos.get(position).getTitle());
            description.setText(todos.get(position).getDescription());
            priority.setText(String.valueOf(todos.get(position).getPriority()));
        }
    }

    public Todo getTodoAt(int position) {
        return todos.get(position);
    }

    public interface onItemClickListner {
        void onItemClick(Todo todo);
    }

    public void setOnItemClickListner(onItemClickListner listner) {
        this.listner = listner;
    }
}

