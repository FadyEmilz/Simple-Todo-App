package com.example.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var todoAdapter: Todo_Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        todoAdapter = Todo_Adapter(mutableListOf())

        binding.rvTodoItems.adapter = todoAdapter
        binding.rvTodoItems.layoutManager = LinearLayoutManager(this)
        binding.btnAddTodo.setOnClickListener {
            var todo_title = binding.etTodoTitle.text.toString()
            if(todo_title.isNotEmpty()){
               val todo = Todo(todo_title)
               todoAdapter.addTodo(todo)
                binding.etTodoTitle.text.clear()

            }


        }
        binding.btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()

        }
    }
}