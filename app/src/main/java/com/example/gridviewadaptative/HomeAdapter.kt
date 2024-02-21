package com.example.gridviewadaptative

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class HomeAdapter(
    private val courseModelArrayList: ArrayList<CourseModel>
) : RecyclerView.Adapter<HomeAdapter.HomeAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return HomeAdapterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeAdapterViewHolder, position: Int) {
        holder.bindView(courseModelArrayList[position], position)
    }

    override fun getItemCount(): Int = courseModelArrayList.size

    fun isHeading(position: Int): Boolean //= position % 3 == 0 && position > 0
    {
        return position == 1 || position == 3 || position == 6
    }

    class HomeAdapterViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val cardView: CardView = itemView.findViewById(R.id.cvHome)
        private val imageView: ImageView = itemView.findViewById(R.id.ivHome)
        private val textView: TextView = itemView.findViewById(R.id.tvHome)

        fun bindView(item: CourseModel, position: Int) {
            if (position > 0 && position % 3 == 0) {
                cardView.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.teal_200))
            }

//            if ( position == 2 || position == 5) {
//                cardView.layoutParams = ConstraintLayout.LayoutParams(
//                    ConstraintLayout.LayoutParams.MATCH_PARENT,
//                    ConstraintLayout.LayoutParams.WRAP_CONTENT
//                )
//            }

            textView.text = item.course_name
            imageView.setImageDrawable(ContextCompat.getDrawable(itemView.context, item.imgid))
        }
    }

}
