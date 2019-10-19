package com.test.recyclerviewwithgroupdate.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.recyclerviewwithgroupdate.R
import com.test.recyclerviewwithgroupdate.model.MovieDetailsModel
import kotlinx.android.synthetic.main.lsv_item_data.view.*
import kotlinx.android.synthetic.main.lsv_item_date.view.*

class MyAdapter(val context: Context, val arrayListMovies: ArrayList<MovieDetailsModel>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        lateinit var view: View

        if (viewType == 1) {
            view = LayoutInflater.from(context).inflate(R.layout.lsv_item_data, parent, false)
            return ViewHolderMovieDetails(view)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.lsv_item_date, parent, false)
            return ViewHolderDates(view)
        }
    }

    override fun getItemCount(): Int {
        return arrayListMovies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (arrayListMovies[position].type == 1) {
            holder.itemView.textViewMovieName.text = arrayListMovies[position].moviename
            holder.itemView.textViewReleaseDate.text = arrayListMovies[position].releasedate
            holder.itemView.textViewRating.text = "Rating: "+arrayListMovies[position].rating
        } else {
            holder.itemView.textViewDate.text = arrayListMovies[position].releasedate
        }

    }

    override fun getItemViewType(position: Int): Int {
        return arrayListMovies[position].type
    }

    open inner class ViewHolder : RecyclerView.ViewHolder {

        constructor(itemView: View) : super(itemView) {
        }

    }

    inner class ViewHolderMovieDetails : ViewHolder {

        constructor(itemView: View) : super(itemView) {
        }

    }

    inner class ViewHolderDates : ViewHolder {

        constructor(itemView: View) : super(itemView) {
        }

    }


}