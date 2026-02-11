package mg.ispm.musdoc.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import mg.ispm.musdoc.R
import mg.ispm.musdoc.R.id.recycler_view
import mg.ispm.musdoc.adapter.MusicAdapter
import mg.ispm.musdoc.adapter.ScoreAdapter
import mg.ispm.musdoc.repository.MusicRepository

class ScoreFragment
    : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_score, container, false)
        //récupérer le recyclerview
        val RecyclerView = view?.findViewById<RecyclerView>(recycler_view)
        RecyclerView?.adapter = ScoreAdapter()
        return view
    }
}