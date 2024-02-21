package com.example.gridviewadaptative

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.core.view.size
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivityGrid : AppCompatActivity() {

    private lateinit var coursesGL: GridLayout
    private lateinit var rvHome: RecyclerView
    private lateinit var adapterHome: HomeAdapter
    private lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_grid)

        setViewsGrid()
    }

    private fun setViewsGrid() {
//        coursesGL = findViewById(R.id.glHome)
        rvHome = findViewById(R.id.rvHome)

        val courseModelArrayList: ArrayList<CourseModel> = ArrayList()

        courseModelArrayList.add(CourseModel("DSA", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("JAVA", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("C++", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("Python", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("Javascript", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("DSA", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("Python", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("Javascript", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("DSA", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("C++", R.drawable.ic_launcher_foreground))

//        val adapter = CourseGVAdapter(this, courseModelArrayList)
//        coursesGL.adapter = adapter

        adapterHome = HomeAdapter(courseModelArrayList)
        val spanCount = 3

        with(rvHome) {
            setHasFixedSize(true)
            adapter = adapterHome

            layoutManager = GridLayoutManager(
                this@MainActivityGrid,
                spanCount,
                RecyclerView.VERTICAL,
                false
            ).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if (adapterHome.isHeading(position)) {
                            spanCount - 1
                        } else {
                            spanCount - 2
                        }
                    }
                }
            }
        }
    }
}