package com.fahmtechnologies.swipeviewviewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fahmtechnologies.swipeviewviewpager2.Adapter.DemoCollectionPagerAdapter
import com.fahmtechnologies.swipeviewviewpager2.Fragment.FirstFragment
import com.fahmtechnologies.swipeviewviewpager2.Fragment.SecondFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        init()
    }

    private fun init() {
        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> {
                        FirstFragment.newInstance()
                    }
                    else -> {
                        SecondFragment.newInstance()
                    }
                }
            }

            override fun getItemCount(): Int {
                return 6
            }
        }

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "First"
                1 -> "Second"
                2 -> "Third"
                4 -> "Four"
                5 -> "Five"
                else -> "Template"
            }
        }.attach()
    }
}