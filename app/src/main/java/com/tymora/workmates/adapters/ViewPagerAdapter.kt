package com.tymora.workmates.adapters

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tymora.workmates.fragments.CallsFragment
import com.tymora.workmates.fragments.ContactsFragment
import com.tymora.workmates.fragments.NotesFragment
import kotlin.math.log

//FragmentStateAdapter funciona similar a un recyclerList, ayuda a mostrar fragmentos como en una lista(usamos su posición)
class ViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    // cuantos fragmentos va a tener la app en el TabLayout
    override fun getItemCount(): Int = 3

    // devuelve el fragmento que se necesita según su posición
    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ContactsFragment()
            1 -> CallsFragment()
            2 -> NotesFragment()

            else -> ContactsFragment()
        }
    }
}