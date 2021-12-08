package com.tymora.workmates.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.tymora.workmates.R
import com.tymora.workmates.adapters.ViewPagerAdapter
import com.tymora.workmates.databinding.FragmentTabsBinding

class TabsFragment : Fragment() {

    // para facilitar llamar vistas del layout a el codigo se utiliza view binding
    private  var _binding: FragmentTabsBinding? = null
    private val binding get() = _binding!!

    //El adaptador se llama solo cuando se utiliza para evitar errores de null-pointer
    private val viewPagerAdapter by lazy {
        ViewPagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // se añade un menu al fragmento
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // se enlaza _binding con el layout del fragmento y se infla para mostrarlo
        _binding = FragmentTabsBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // se le pone el adaptador al View Pager del layout para poder navegar entre fragmentos
        binding.pager.adapter = viewPagerAdapter

        val tabLayoutMediator = TabLayoutMediator(binding.tabLayout, binding.pager,
            TabLayoutMediator.TabConfigurationStrategy{
                tab, position -> when(position){
                    0 -> {
                        tab.text = "Contacts"
                        tab.setIcon(R.drawable.ic_tab_contacts_24)
                    }
                    1 -> {
                        tab.text = "Calls"
                        tab.setIcon(R.drawable.ic_baseline_call_24)

                    }
                    2 -> {
                        tab.text = "Notes"
                        tab.setIcon(R.drawable.ic_tab_notes_24)
                    }
                }
            })
        tabLayoutMediator.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}