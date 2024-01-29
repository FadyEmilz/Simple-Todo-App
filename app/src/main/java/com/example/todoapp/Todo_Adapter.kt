package com.example.todoapp

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Todo_Adapter(val todos : MutableList<Todo>) :RecyclerView.Adapter<Todo_Adapter.todo_ViewHolder>() {



    class todo_ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todo_ViewHolder {
        return todo_ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false))
    }
    fun toggleStrikeTrought(tv_title : TextView, isChecked : Boolean) {
        if(isChecked){
            tv_title.paintFlags = tv_title.paintFlags or STRIKE_THRU_TEXT_FLAG

        }
        else {
            tv_title.paintFlags = tv_title.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }


    }
    fun addTodo(todo: Todo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun deleteDoneTodos() {
        todos.removeAll { todo ->
            todo.cheacked
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: todo_ViewHolder, position: Int) {
        var current_todo = todos[position]
        holder.itemView.apply {
        var tv = findViewById<TextView>(R.id.tvTodoTitle)
            var cb = findViewById<CheckBox>(R.id.cbDone)
            tv.text = current_todo.title
            cb.isChecked = current_todo.cheacked
            toggleStrikeTrought(tv,cb.isChecked)
            cb.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeTrought(tv,isChecked)
                current_todo.cheacked = !current_todo.cheacked
            }


        }



    }

    override fun getItemCount(): Int {
        return todos.size
    }


}