package mg.ispm.musdoc.repository

import mg.ispm.musdoc.GroupModel
import mg.ispm.musdoc.R
import mg.ispm.musdoc.repository.GroupRepository.Singleton.groupList

class GroupRepository {

    object Singleton {
        //créer une liste qui va stocker les musiques
        val groupList = arrayListOf<GroupModel>()
    }

    fun updateData() {
        groupList.clear()

        groupList.add(GroupModel("Bonus", R.drawable.ic_bonus))
        groupList.add(GroupModel("Depression", R.drawable.ic_depression))
        groupList.add(GroupModel("Manque de concentration", R.drawable.ic_mdc))
        groupList.add(GroupModel("Peur", R.drawable.ic_fear))
        groupList.add(GroupModel("Relaxation", R.drawable.ic_relaxation))
        groupList.add(GroupModel("Son curative", R.drawable.ic_care))
        groupList.add(GroupModel("Stress", R.drawable.ic_stress))
    }

}