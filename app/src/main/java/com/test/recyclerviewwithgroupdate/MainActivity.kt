package com.test.recyclerviewwithgroupdate

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.recyclerviewwithgroupdate.adapter.MyAdapter
import com.test.recyclerviewwithgroupdate.model.MovieDetailsModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var arrayListMovies: ArrayList<MovieDetailsModel>
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrayListMovies = ArrayList()

//        recyclerViewMovies.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewMovies.setLayoutManager(mLayoutManager)
        adapter = MyAdapter(this, arrayListMovies)
        recyclerViewMovies.setAdapter(adapter)
        setData()

    }


    private fun setData() {

        arrayListMovies.add(MovieDetailsModel("Batla House", "15-08-2019", "9/10", 1))
        arrayListMovies.add(MovieDetailsModel("Kabir Singh", "21-06-2019", "9/10", 1))
        arrayListMovies.add(MovieDetailsModel("Chhichhore", "30-08-2019", "9/10", 1))
        arrayListMovies.add(MovieDetailsModel("War", "02-10-2019", "9/10", 1))
        arrayListMovies.add(MovieDetailsModel("Sanju", "10-2-2018", "9/10", 1))
        arrayListMovies.add(MovieDetailsModel("Raazi", "10-3-2018", "8/10", 1))
        arrayListMovies.add(MovieDetailsModel("Race 3", "10-4-2018", "9/10", 1))
        arrayListMovies.add(MovieDetailsModel("Baaghi 2", "10-5-2018", "9/10", 1))
        arrayListMovies.add(MovieDetailsModel("Robot 2.0", "10-6-2018", "9/10", 1))
        arrayListMovies.add(MovieDetailsModel("Padman", "10-7-2018", "8/10", 1))
        arrayListMovies.add(MovieDetailsModel("Dhadak", "10-8-2018", "6/10", 1))

        Log.d("size:",arrayListMovies.size.toString())

        setDate()

    }

    private fun setDate(){

        var year = ""

        for (i in arrayListMovies.size-1 downTo 0){
            val data = arrayListMovies[i]
            if (returnYear(data.releasedate) != year) {
                year = returnYear(data.releasedate)
                arrayListMovies.add((i+1),MovieDetailsModel("", year, "", 2))
            }
        }
        arrayListMovies.reverse()

        adapter.notifyDataSetChanged()
    }

    private fun returnYear(date : String) : String{

        return date.split("-")[2]

    }


}
