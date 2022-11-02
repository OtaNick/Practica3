package com.angel.practica3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.angel.practica3.databinding.ItemNoticeBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class NoticiaAdapter(private val noticias: List<Noticia>,  private val listener: OnClickListener):
    RecyclerView.Adapter<NoticiaAdapter.ViewHolder>()
{
    private lateinit var context: Context

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        // Vinculamos la vista al adaptador
        val binding = ItemNoticeBinding.bind(view)

        fun setListener(noticia: Noticia) {
            binding.root.setOnClickListener {
                listener.onClick(noticia)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_notice, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val noticia = noticias.get(position)
        with(holder) {
            setListener(noticia)

            binding.tvTitulo.text = noticia.titulo
            binding.tvResumen.text = noticia.resumen
            binding.tvFecha.text = noticia.fecha
            Glide.with(context)
                .load(noticia.imagenDePortada)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                        .into(binding.imgPhoto)
        }
    }

    override fun getItemCount(): Int = noticias.size
}