package com.digitalrelay.materialplayground.fragments

import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.digitalrelay.materialplayground.R
import com.digitalrelay.materialplayground.views.FabProgressLayout


/**
 * A simple [Fragment] subclass.
 * Use the [CardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var fabProgressLayout: FabProgressLayout? = null
    private var placeholderTV: TextView? = null

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param p1 Parameter 1.
         * @param p2 Parameter 2.
         * @return A new instance of fragment AuthFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(p1: String, p2: String): CardFragment {
            val fragment = CardFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, p1)
            args.putString(ARG_PARAM2, p2)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            param1 = this.arguments?.getString(ARG_PARAM1)
            param2 = this.arguments?.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fabProgressLayout = view.findViewById(R.id.fab_progress)
        placeholderTV = view.findViewById(R.id.tv_placeholder)
        placeholderTV!!.visibility = View.INVISIBLE

        fabProgressLayout!!.setOnClickListener {
            placeholderTV!!.visibility = View.VISIBLE
            fabProgressLayout!!.startProgress()
            fabProgressLayout!!.postDelayed({
                fabProgressLayout!!.stopProgress()
                placeholderTV!!.visibility = View.INVISIBLE
            }, 5000)
        }
    }

}