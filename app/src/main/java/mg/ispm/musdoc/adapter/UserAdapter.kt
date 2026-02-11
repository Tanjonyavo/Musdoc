package mg.ispm.musdoc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mg.ispm.musdoc.R
import mg.ispm.musdoc.UserModel

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userLists : ArrayList<UserModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(

        LayoutInflater.from (parent.context).inflate(R.layout.type_user, parent, false)

    )


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val user = userLists[position]
        holder.bindView(user)

    }

    override fun getItemCount(): Int {
        return userLists.size
    }

    fun addItem(items:ArrayList<UserModel>){
        this.userLists = items
        notifyDataSetChanged()

    }


    class UserViewHolder (var view : View) : RecyclerView.ViewHolder(view) {

        private var name = view.findViewById<TextView>(R.id.score_name)
        private var nivanxiete = view.findViewById<TextView>(R.id.niv_anxiete)
        private var nivDepression = view.findViewById<TextView>(R.id.niv_depre)
        private var dltbtn = view.findViewById<Button>(R.id.btnSupprimer)
        private var renamebtn = view.findViewById<Button>(R.id.btnModifier)

        fun bindView(user : UserModel) {
            name.text= user.name.toString()
            nivanxiete.text=user.anx.toString()
            nivDepression.text=user.depre.toString()

        }
    }

}