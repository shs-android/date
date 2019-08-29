package com.shs.date.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shs.date.R
import com.shs.date.databinding.FragmentListBinding

class ListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentListBinding>(
            inflater, R.layout.fragment_list, container, false
        )
        setRecyclerView(binding)
        addClickListener(binding)
        return binding.root
    }

    private fun setRecyclerView(binding: FragmentListBinding) {
        binding.recyclerView.adapter = ListAdapter()
    }

    private fun addClickListener(binding: FragmentListBinding) {
        binding.createEventButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_createFragment)
        }
    }
}
