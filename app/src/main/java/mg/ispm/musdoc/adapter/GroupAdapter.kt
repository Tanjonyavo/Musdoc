package mg.ispm.musdoc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import mg.ispm.musdoc.GroupModel
import mg.ispm.musdoc.R

class GroupAdapter(
    private val groupList: List<GroupModel>,
    private val layoutId: Int,
    private val onGroupClick: (GroupModel) -> Unit,
) : RecyclerView.Adapter<GroupAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val groupImage: ImageView? = view.findViewById(R.id.group_image_item)
        val groupItem: ConstraintLayout? = view.findViewById(R.id.group_item)
        val groupName: TextView? = view.findViewById(R.id.group_name_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupAdapter.ViewHolder {
        val view: View? = LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)
        return GroupAdapter.ViewHolder(view!!)
    }

    override fun onBindViewHolder(holder: GroupAdapter.ViewHolder, position: Int) {
        //récupérer les informations de la musique
        val currentMusic = groupList[position]

        //mettre à jour la musique
        holder.groupImage?.setImageResource(currentMusic.image)
        holder.groupName?.text = currentMusic.name

        //interaction sur l'élément
        holder.groupItem?.setOnClickListener { onGroupClick(currentMusic) }

    }

    override fun getItemCount(): Int = groupList.size

}