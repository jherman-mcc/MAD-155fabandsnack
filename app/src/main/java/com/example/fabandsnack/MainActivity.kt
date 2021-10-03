package com.example.fabandsnack

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    var listItems = ArrayList<String>()
    var adapter: ArrayAdapter<String> ?= null
    lateinit var listView: ListView
    lateinit var fab1: FloatingActionButton
    lateinit var fab2: FloatingActionButton
    lateinit var undoOnClickListener1: View.OnClickListener
    lateinit var undoOnClickListener2: View.OnClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lv1)
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listItems
        )
        listView.adapter = adapter
        fab1 = findViewById(R.id.FAB1)
        fab2 = findViewById(R.id.FAB2)

        fab1.setOnClickListener {
            addListItem()

//      Experiment with some code from the internet. So, I'm commenting out the code from the video.
//            Snackbar.make(it, "Added an item", Snackbar.LENGTH_LONG)
//                .setAction("UNDO", undoOnClickListener1)
//                .show()
//      The following is code that I found on the internet to spice up the Snackbar...

            val snackbar = Snackbar.make(it, "Added an item",
                Snackbar.LENGTH_LONG).setAction("UNDO", undoOnClickListener1)
            snackbar.setActionTextColor(Color.BLUE)
            val snackbarView = snackbar.view
            snackbarView.setBackgroundColor(Color.LTGRAY)
            val textView =
                snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
            textView.setTextColor(Color.BLUE)
            textView.textSize = 28f
            snackbar.show()


        }

        fab2.setOnClickListener {
            deleteListItem()


//      Experiment with some code from the internet. So, I'm commenting out the code from the video.

//            Snackbar.make(it, "Deleted selected item", Snackbar.LENGTH_LONG)
//                .setAction("UNDO", undoOnClickListener2)
//                .show()

//      The following is code that I found on the internet to spice up the Snackbar...

            val snackbar = Snackbar.make(it, "Deleted an item",
                Snackbar.LENGTH_LONG).setAction("UNDO", undoOnClickListener2)
            snackbar.setActionTextColor(Color.BLUE)
            val snackbarView = snackbar.view
            snackbarView.setBackgroundColor(Color.LTGRAY)
            val textView =
                snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
            textView.setTextColor(Color.BLUE)
            textView.textSize = 28f
            snackbar.show()

        }

        undoOnClickListener1 = View.OnClickListener {
            listItems.removeAt(listItems.size - 1)
            adapter?.notifyDataSetChanged()
            Snackbar.make(it, "Item removed", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        undoOnClickListener2 = View.OnClickListener {
            listItems.add("Item 1")
            adapter?.notifyDataSetChanged()
            Snackbar.make(it, "Item re-added", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


    }

    private fun addListItem() {
        listItems.add("Item 1")
        adapter?.notifyDataSetChanged()
     }

    private fun deleteListItem() {
        listItems.remove("Item 1")
        adapter?.notifyDataSetChanged()

        }
    }
