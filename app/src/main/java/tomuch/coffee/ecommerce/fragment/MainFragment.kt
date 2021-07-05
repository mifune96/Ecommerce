package tomuch.coffee.ecommerce.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tomuch.coffee.ecommerce.R
import tomuch.coffee.ecommerce.adpter.SliderAdapter
import tomuch.coffee.ecommerce.adpter.btnnAdapter
import tomuch.coffee.ecommerce.model.icon

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.main_item, container, false)
        val lists: List<String> = listOf(
            "https://images.tokopedia.net/img/cache/500/coCfvv/2021/7/3/6e95379c-8c99-40f3-bd0c-d10521fb05ab.jpg.webp?ect=4g",
            "https://images.tokopedia.net/img/cache/500/coCfvv/2021/7/3/15446573-6c21-4bc3-a6f3-4e8db55a6cc4.jpg.webp?ect=4g",
            "https://images.pexels.com/photos/37728/pexels-photo-37728.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
        )



        init(view)

        createSlider(lists)
        displayproduk()
        return view
    }

    private fun getArrayicon(): ArrayList<icon> {
        val getcompany = resources.getStringArray(R.array.company)
        val getavatar = resources.getStringArray(R.array.avatar)

        val arrListicon: ArrayList<icon> = arrayListOf()
        for (i in getcompany.indices) {
            arrListicon.add(
                icon(
                    getcompany[i],
                    getavatar[i]
                )
            )

        }
        return arrListicon
    }

    lateinit var vpslider: RecyclerView
    lateinit var glidebuttonup: RecyclerView
    fun init(view: View) {
        vpslider = view.findViewById(R.id.vpSlider)
        glidebuttonup = view.findViewById(R.id.glidebuttonup)
    }


    private fun displayproduk() {

        val layoutManager1 = LinearLayoutManager(activity)
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL

        glidebuttonup.adapter = btnnAdapter(requireActivity(), getArrayicon())
        glidebuttonup.layoutManager = layoutManager1

    }

    lateinit var adapter: SliderAdapter
    private fun createSlider(string: List<String>) {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        adapter = SliderAdapter(requireActivity(), string)

        vpslider.adapter = adapter
        vpslider.layoutManager = layoutManager

    }


}








