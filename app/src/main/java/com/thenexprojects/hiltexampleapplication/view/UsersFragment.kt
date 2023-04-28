package com.thenexprojects.hiltexampleapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.thenexprojects.hiltexampleapplication.R
import com.thenexprojects.hiltexampleapplication.adapter.UsersAdapter
import com.thenexprojects.hiltexampleapplication.data.MyRoomDatabase
import com.thenexprojects.hiltexampleapplication.model.User
import com.thenexprojects.hiltexampleapplication.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment() {
    private val viewModel by viewModels<UserViewModel>{
        ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
    }
    private var adapter: UsersAdapter = UsersAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_users, container, false)
        val addButton: FloatingActionButton = view.findViewById(R.id.add)
        val items: RecyclerView = view.findViewById(R.id.items)

        items.layoutManager = LinearLayoutManager(requireContext())
        items.adapter = adapter

        viewModel.getAllUsers().observe(viewLifecycleOwner){
            adapter.updateUsers(it)
        }

        addButton.setOnClickListener {
            viewModel.addUser(User(null, "ExampleUsername", "ExampleName", 1))
        }

        return view
    }
}