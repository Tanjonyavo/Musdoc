package mg.ispm.musdoc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mg.ispm.musdoc.MusicModel
import mg.ispm.musdoc.R

class MusicAdapter(
    private val list: List<MusicModel>,
    private val layoutId: Int,
    private val onMusicClick: (MusicModel) -> Unit,
    private val onToggleLike: (MusicModel) -> Unit,
) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    // boîte pour ranger tius les composants à contrôler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val musicImage: ImageView? = view.findViewById(R.id.image_item)
        val musicName: TextView? = view.findViewById(R.id.name_item)
        val starIcon: ImageView? = view.findViewById(R.id.star_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //récupérer les informations de la musique
        val currentMusic = list[position]

        //mettre à jour la musique
        holder.musicImage?.setImageResource(currentMusic.image)
        holder.musicName?.text = currentMusic.name

        //vérifier si la musique a été liked
        if (currentMusic.liked == 1) {
            holder.starIcon?.setImageResource(R.drawable.ic_like)
        } else {
            holder.starIcon?.setImageResource(R.drawable.ic_unlike)
        }

        //interaction sur l'élément
        holder.itemView.setOnClickListener { onMusicClick(currentMusic) }

        //rajouter une interaction sur l'étoile
        holder.starIcon?.setOnClickListener { onToggleLike(currentMusic) }
    }

    override fun getItemCount(): Int = list.size

}