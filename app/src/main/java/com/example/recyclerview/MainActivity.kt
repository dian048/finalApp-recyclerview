package com.example.recyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val list = ArrayList<video>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_video)
        recyclerView.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()

        val outButton: Button = findViewById(R.id.out)
        outButton.setOnClickListener {
            goToLoginActivity()
        }
    }

    private fun goToLoginActivity() {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.action_list -> {
//                recyclerView.layoutManager = LinearLayoutManager(this)
//            }
//            R.id.action_grid -> {
//                recyclerView.layoutManager = GridLayoutManager(this, 2)
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }



    private fun getListHeroes(): ArrayList<video> {
        val dataName = resources.getStringArray(R.array.judul_video)
        val dataDescription = resources.getStringArray(R.array.data_dekripsi)
        val dataPhoto = resources.obtainTypedArray(R.array.data_gambar)
        val videoId=resources.obtainTypedArray(R.array.video_id)
        val listVideos = ArrayList<video>()
        for (i in dataName.indices) {
            val video = video(dataPhoto.getResourceId(i, -1),dataName[i], dataDescription[i], videoId.getResourceId(i,-1))
            listVideos.add(video)
        }
        return listVideos
    }

    private fun showRecyclerList() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listVideoAdapter = ListVideoAdapter(list)
        recyclerView.adapter = listVideoAdapter

        listVideoAdapter.setOnItemClickCallback(object : ListVideoAdapter.OnItemClickCallback {
            override fun onItemClicked(data: video){
                val intent = Intent(this@MainActivity, DetailActivity::class.java)

                intent.putExtra("VIDEO_DATA", data)

                startActivity(intent)



            }

        })
    }

    private fun showSelectedHero(video: video) {
        Toast.makeText(this, "Kamu memilih " + video.name, Toast.LENGTH_SHORT).show()
    }
}
