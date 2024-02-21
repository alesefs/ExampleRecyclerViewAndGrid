package com.example.gridviewadaptative

import android.R.attr.value
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.widget.Button
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var clMainMenu: ConstraintLayout
    private lateinit var button: Button

    private lateinit var coursesGV: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels

        Log.i("ALELOG", "height: $height width: $width")

        setViews(width, height)
//        setViewsGrid()
    }

/*    private fun setViewsGrid() {
        coursesGV = findViewById(R.id.idGVcourses)
        val courseModelArrayList: ArrayList<CourseModel> = ArrayList<CourseModel>()

        courseModelArrayList.add(CourseModel("DSA", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("JAVA", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("C++", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("Python", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("Javascript", R.drawable.ic_launcher_foreground))
        courseModelArrayList.add(CourseModel("DSA", R.drawable.ic_launcher_foreground))

        val adapter = CourseGVAdapter(this, courseModelArrayList)
        coursesGV.adapter = adapter
    }*/

    private fun setViews(width: Int, height: Int) {
        clMainMenu = findViewById(R.id.cl_main_menu)
        recyclerView = findViewById(R.id.rv_main_menu)
        button = findViewById<Button?>(R.id.btn_button).apply {
            text = "click to grid"
            setOnClickListener {
                val myIntent = Intent(context, MainActivityGrid::class.java)
                startActivity(myIntent)
            }
        }

        with(recyclerView) {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                RecyclerView.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            adapter = MainAdapter(
                listButton(),
                width, height
            )
        }
    }

    private fun listButton() : List<MainMenuButtonsModel> = listOfNotNull(
        MainMenuButtonsModel(
            getString(R.string.app_name),
            getString(R.string.app_name),
            R.drawable.ic_launcher_foreground
        ),
        MainMenuButtonsModel(
            getString(R.string.app_name),
            getString(R.string.app_name),
            R.drawable.ic_launcher_foreground
        ),
        MainMenuButtonsModel(
            getString(R.string.app_name),
            getString(R.string.app_name),
            R.drawable.ic_launcher_foreground
        ),
        MainMenuButtonsModel(
            getString(R.string.app_name),
            getString(R.string.app_name),
            R.drawable.ic_launcher_foreground
        ),
        MainMenuButtonsModel(
            getString(R.string.app_name),
            getString(R.string.app_name),
            R.drawable.ic_launcher_foreground
        ),
        MainMenuButtonsModel(
            getString(R.string.app_name),
            getString(R.string.app_name),
            R.drawable.ic_launcher_foreground
        )
    )
}
