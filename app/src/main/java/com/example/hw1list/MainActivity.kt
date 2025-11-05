package com.example.hw1list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : ComponentActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton
    private val adapter: MyAdapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager =
            GridLayoutManager(this, resources.getInteger(R.integer.column_count))
        recyclerView.adapter = adapter

        fab = findViewById(R.id.add_button)
        fab.setOnClickListener {
            val newList = ArrayList(adapter.items)
            newList.add(Item(adapter.items.size))
            adapter.update(newList)
        }

        val saved = savedInstanceState?.getIntegerArrayList("items")
        if (saved != null) {
            val items = ArrayList<Item>()
            for (num in saved) {
                items.add(Item(num))
            }
            adapter.update(items)
        } else {
            adapter.update(listOf(Item(0), Item(1)))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val numbs = ArrayList<Int>()
        for (item in adapter.items) {
            numbs.add(item.num)
        }
        outState.putIntegerArrayList("items", numbs)
    }

}
