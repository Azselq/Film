package com.example.filmprac.View

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.filmprac.ViewModel.BaseViewModel
import com.example.filmprac.databinding.FragmentBaseBinding

class BaseFragment : Fragment() {
    lateinit var binding: FragmentBaseBinding

    private lateinit var viewModel: BaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBaseBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(BaseViewModel::class.java)
        viewModel.printInformation()
        viewModel.FilmListLiveData.observe(viewLifecycleOwner){
            binding.tvAll.text = it.toString()
        }
    }

}