package com.example.restaurant

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var tabLayout: TabLayout
    private lateinit var rvMenu: RecyclerView
    private var tabSelectedFromScrolling = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        rvMenu = binding.rvMenu
        tabLayout = binding.tabLayout
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvMenu.layoutManager = LinearLayoutManager(this)
        rvMenu.adapter = MenuAdapter(getAllMenuItems())
        setupTabLayout()
        setupRecyclerView()


    }

    private fun setupRecyclerView() {
        rvMenu.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = rvMenu.layoutManager as LinearLayoutManager
                val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()

                when {
                    (firstVisiblePosition in starters.indices) -> {
                        if (tabLayout.selectedTabPosition != 0) {
                            tabSelectedFromScrolling = true
                            tabLayout.getTabAt(0)?.select()
                        }
                    }

                    (firstVisiblePosition in starters.size until (starters.size + mainCourses.size)) -> {
                        if (tabLayout.selectedTabPosition != 1) {
                            tabSelectedFromScrolling = true
                            tabLayout.getTabAt(1)?.select()
                        }
                    }

                    (firstVisiblePosition >= (starters.size + mainCourses.size)) -> {
                        if (tabLayout.selectedTabPosition != 2) {
                            tabSelectedFromScrolling = true
                            tabLayout.getTabAt(2)?.select()
                        }
                    }
                }
            }
        }
        )
    }


    private fun setupTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("Starters").setIcon(R.drawable.icon_starter))
        tabLayout.addTab(tabLayout.newTab().setText("Main").setIcon(R.drawable.icon_main_course))
        tabLayout.addTab(tabLayout.newTab().setText("Desserts").setIcon(R.drawable.icon_dessert))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val layoutManager = rvMenu.layoutManager as LinearLayoutManager
                val position: Int
                if (tab != null && !tabSelectedFromScrolling) {
                    position = when (tab.position) {
                        0 -> 0
                        1 -> starters.size
                        2 -> starters.size + mainCourses.size
                        else -> 0
                    }
                    layoutManager.scrollToPositionWithOffset(position, 0)
                }
                    tabSelectedFromScrolling = false
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        }

        )
    }
}