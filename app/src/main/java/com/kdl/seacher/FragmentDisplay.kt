package com.kdl.seacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class FragmentDisplay:Fragment() {

    lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(requireContext(),R.layout.fragment_display,null)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val listView = view.findViewById<ListView>(R.id.search_items)
        viewModel.displayList.observe(viewLifecycleOwner, Observer {
            listView.apply {
                adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,it)
            }
        })
        return view
    }
}