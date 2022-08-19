package com.viol4tsf.exchangerate.screens.root

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.viol4tsf.exchangerate.R
import com.viol4tsf.exchangerate.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_root.*
import kotlinx.android.synthetic.main.fragment_root.view.*

class RootFragment : Fragment() {

    private var cont: Context ?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        cont = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_root, container, false)

        view.tabLayout.tabIconTint = null
        view.viewPager.adapter = ViewPagerAdapter(cont as FragmentActivity)

        TabLayoutMediator(view.tabLayout, view.viewPager){ tab, position ->
            when(position){
                0 -> {
                    tab.setIcon(R.drawable.ic_baseline_attach_money_24)
                }
                1 -> {
                    tab.setIcon(R.drawable.ic_baseline_location_on_24)
                }
            }
        }.attach()

        return view
    }
}