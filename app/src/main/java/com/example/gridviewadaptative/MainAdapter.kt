package com.example.gridviewadaptative

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.floor

class MainAdapter(
    private val listButton: List<MainMenuButtonsModel>,
    private val width: Int,
    private val height: Int
) : RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_button_custom, parent, false)
        return MainAdapterViewHolder(itemView)
    }

    private val Int.dp: Int
        get() = (this / Resources.getSystem().displayMetrics.density).toInt()
    private val Int.px: Int
        get() = (this * Resources.getSystem().displayMetrics.density).toInt()

    override fun onBindViewHolder(holder: MainAdapterViewHolder, position: Int) {
        holder.bindView(listButton[position])

        Log.i("ALELOG", "position: $position")

        if (listButton.size < 2) {
            // default by xml
        } else if (listButton.size == 2) {
//            holder.buttonCast.maxWidth = 140.px
//            holder.buttonCast.minWidth = 140.px
            holder.buttonCast.maxWidth = floor(width / 2.5).toInt() //450
            holder.buttonCast.minWidth = floor(width / 2.5).toInt() //450
        } else {
            for (item in listButton) {
                holder.buttonCast.maxWidth = 112.px //300
                holder.buttonCast.minWidth = 112.px //300
            }
        }
    }

    override fun getItemCount(): Int = listButton.size

    class MainAdapterViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val buttonCast: ConstraintLayout = itemView.findViewById(R.id.menu_btn_cast)
        private val textButton: TextView = itemView.findViewById(R.id.txt_btn)
        private val imageButton: ImageView = itemView.findViewById(R.id.img_btn)

        fun bindView(item: MainMenuButtonsModel) {
            textButton.text = item.title
            imageButton.setImageDrawable(ContextCompat.getDrawable(itemView.context, item.image))
        }

    }
}


