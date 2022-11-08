package com.angel.practica3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.angel.practica3.databinding.ActivityMainBinding
import com.angel.practica3.databinding.ActivityNoticiasBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NoticiasActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityNoticiasBinding
    private lateinit var noticiaAdapter: NoticiaAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticiasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = noticiaAdapter
        }


        binding.fbAddNotice.setOnClickListener {
            val i = Intent(this, NewNotice::class.java)
            startActivity(i)
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        noticiaAdapter = NoticiaAdapter(mutableListOf(), this)
        mGridLayout = GridLayoutManager(this, 2)
        getNoticias()

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = noticiaAdapter
        }
    }

    private fun getNoticias(){
        doAsync {
            val noticias = NoticiaApplication.database.NoticiaDao().getAllNotices()
            uiThread {
                noticiaAdapter.setStores(noticias)
            }
        }
    }

    override fun onClick(notice: NoticiaEntity) {
        var link = Intent(Intent.ACTION_VIEW, Uri.parse(notice.url))
        startActivity(link)
    }


}