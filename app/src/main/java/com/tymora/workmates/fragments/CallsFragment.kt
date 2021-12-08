package com.tymora.workmates.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tymora.workmates.databinding.FragmentCallsBinding

class CallsFragment : Fragment() {

    // para facilitar llamar vistas del layout a el codigo se utiliza view binding
    private  var _binding: FragmentCallsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // se enlaza _binding con el layout del fragmento y se infla para mostrarlo
        _binding = FragmentCallsBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }
}