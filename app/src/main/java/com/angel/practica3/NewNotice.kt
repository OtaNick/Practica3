package com.angel.practica3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.angel.practica3.databinding.ActivityNewNoticeBinding
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NewNotice : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityNewNoticeBinding
    private lateinit var noticiaAdapter: NoticiaAdapter
    private lateinit var mGridLayout: GridLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener{
            val noticiaEntity = NoticiaEntity(
                titulo = binding.etTitulo.text.toString(),
                resumen = binding.etResumen.text.toString(),
                fecha = binding.etFecha.text.toString(),
                imagenDePortada = binding.etImagen.text.toString(),
                url = binding.etUrl.text.toString()
            )
            noticiaAdapter.noticias.add(noticiaEntity)
            doAsync {
                NoticiaApplication.database.NoticiaDao().addNotice(noticiaEntity)
            }

            val i = Intent(this, NoticiasActivity::class.java)
            startActivity(i)
        }
    }


    override fun onClick(notice: NoticiaEntity) {
        var link = Intent(Intent.ACTION_VIEW, Uri.parse(notice.url))
        startActivity(link)
    }

}