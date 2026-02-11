package mg.ispm.musdoc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mg.ispm.musdoc.R
import mg.ispm.musdoc.repository.ScoreStore

class ScoreAdapter : RecyclerView.Adapter<ScoreAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val user: TextView? = view.findViewById(R.id.score_name)
        val anx: TextView? = view.findViewById(R.id.score_anx)
        val depre: TextView? = view.findViewById(R.id.score_depre)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreAdapter.ViewHolder {
        val view: View? = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_score, parent, false)
        return ScoreAdapter.ViewHolder(view!!)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = ScoreStore.scores[position]
        holder.user?.text = current.name
        holder.anx?.text = current.anx.toString()
        holder.depre?.text = current.depre.toString()
    }

    override fun getItemCount(): Int = ScoreStore.scores.size
}