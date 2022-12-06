package com.example.filmprac.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.filmprac.databinding.FragmentBaseBinding
import com.example.filmprac.viewModel.BaseViewModel

class BaseFragment : Fragment() {

    lateinit var binding: FragmentBaseBinding

    private lateinit var viewModel: BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ctrl + alt + L (+shift)
        binding = FragmentBaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // alt + enter for information
        viewModel = ViewModelProvider(this).get(BaseViewModel::class.java)
        viewModel.printInformation()
        viewModel.filmListLiveData.observe(viewLifecycleOwner) {
            binding.tvAll.text = it.toString()
        }
    }

}