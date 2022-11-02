package com.angel.practica3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.angel.practica3.databinding.ActivityMainBinding
import com.angel.practica3.databinding.ActivityNoticiasBinding

class NoticiasActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityNoticiasBinding
    private lateinit var noticiaAdapter: NoticiaAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticiasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noticiaAdapter = NoticiaAdapter(getNoticias(),this)
        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = noticiaAdapter
        }

    }

    override fun onClick(notice: Noticia) {
        var link = Intent(Intent.ACTION_VIEW, Uri.parse(notice.url))
        startActivity(link)
    }

    private fun getNoticias(): MutableList<Noticia> {
        val noticias = mutableListOf<Noticia>()

        val noticia1 = Noticia(1, "Pepe se la saca", "Pepe ha intentado sacarsela, ¿lo habrá conseguido?", "24 de octubre","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPZEdV2PT0dqRapU0ndT-Yy3783IuvjR3M1g&usqp=CAU", "https://www.elconfidencial.com/alma-corazon-vida/2022-10-23/siete-personas-tienen-llaves-controlar-internet_3509662/")
        val noticia2 = Noticia(2, "Tal vez no se la saca", "No, lo ha intentado pero creemos que no ha conseguido sacarsela", "25 de octubre", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3pn0nOl0OvQ6HMxtZkFCGrRD4DX7qFwRwMQ&usqp=CAU", "https://www.elconfidencial.com/alma-corazon-vida/2022-10-24/misterio-gusto-olor-gasolina-por-que-gusta-tanto_3509120/")
        val noticia3 = Noticia(3, "Bueno, si se la saca", "Ojo porque parece que después de mucho esfuerzo si que se la saca", "4 de diciembre", "https://images7.memedroid.com/images/UPLOADED645/6201803e9abd9.jpeg", "https://www.elconfidencial.com/alma-corazon-vida/2022-10-25/luz-sol-hace-ninos-sientan-mas-hambre-estudio_3508488/")
        val noticia4 = Noticia(4, "No, al final no se la ha sacado", "Pues no, depués de mucho esfuerzo no se la ha sacado", "18 de enero", "https://tresubresdobles.com/wp-content/uploads/2021/04/skft-23aff38e10ee3c4e430a1f3450c4a01d.jpeg","https://www.elconfidencial.com/alma-corazon-vida/2022-10-21/humanos-limitados-tener-ciento-cincuenta-amigos_3507670/")
        val noticia5 = Noticia(5, "Antonio decide aprobar a todos", "Antonio Calabuig decide aprobar a todos los alumnos del IES la senia despues de descrubrir que se puede hechar gasolina a 1'10€/L", "6 de enero", "https://statics.memondo.com/p/s1/ccs/2021/11/CC_2787755_457516c5f58d453bb76dfd2d979cc9c1_meme_otros_las_imagenes_mas_random_de_animales_1.jpg?cb=385881","https://www.elmundo.es/papel/firmas/2018/02/24/5a9003a722601d1e548b45db.html")

        noticias.add(noticia1)
        noticias.add(noticia2)
        noticias.add(noticia3)
        noticias.add(noticia4)
        noticias.add(noticia5)

        return noticias
    }
}