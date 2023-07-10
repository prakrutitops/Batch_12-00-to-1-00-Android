package com.example.tablayoutex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.listviewex.MyAdapter2
import com.example.tablayoutex.databinding.FragmentChatBinding


class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!



    lateinit var list:MutableList<Model>
    lateinit var listView: ListView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        //var view = inflater.inflate(R.layout.fragment_chat, container, false)
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        val view = binding.root
        listView =view.findViewById(R.id.list)

        list = ArrayList()

        list.add(Model(R.drawable.android,"Android","1234"))
        list.add(Model(R.drawable.java,"Java","4567"))
        list.add(Model(R.drawable.php,"Php","1456"))
        list.add(Model(R.drawable.android,"Android","1234"))
        list.add(Model(R.drawable.java,"Java","4567"))
        list.add(Model(R.drawable.php,"Php","1456"))
        list.add(Model(R.drawable.android,"Android","1234"))
        list.add(Model(R.drawable.java,"Java","4567"))
        list.add(Model(R.drawable.php,"Php","1456"))
        list.add(Model(R.drawable.android,"Android","1234"))
        list.add(Model(R.drawable.java,"Java","4567"))
        list.add(Model(R.drawable.php,"Php","1456"))


        var adapter = MyAdapter2(requireActivity(),list)
        listView.adapter = adapter


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}