package tomuch.coffee.ecommerce.adpter

import android.app.Activity
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso
import tomuch.coffee.ecommerce.R
import tomuch.coffee.ecommerce.model.icon

class btnnAdapter(val activity: Activity,
//                     private val stringList: List<String>
                  private val arrayIcon: ArrayList<icon>
    ) : RecyclerView.Adapter<btnnAdapter.Holder> (){
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(R.id.im_icon)
        val tvini = view.findViewById<TextView>(R.id.tulis)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.grid_item_buttonup, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Picasso.get()
            .load(arrayIcon[position].avatar)
            .placeholder(R.drawable.ic_target)
            .error(R.drawable.ic_target)
            .into(holder.img)

        holder.tvini.text = arrayIcon[position].company
    }

    override fun getItemCount() =  arrayIcon.size
//
//    private val TAG = "SliderAdapter"
//    private val inflater: LayoutInflater = LayoutInflater.from(context)
//
//    override fun destroyItem( container: ViewGroup, position: Int, `object`: Any ) {
//        container.removeView(`object` as View)
//    }
//
//    override fun getCount() = stringList.size
//
//    override fun instantiateItem(view: ViewGroup, position: Int): Any {
//        val imageLayout = inflater.inflate(R.layout.item_slider, view, false)!!
//        val imageView = imageLayout.findViewById<ImageView>(R.id.image)
//        Picasso.get().load(stringList[position])
//            .placeholder(R.drawable.banner)
//            .error(R.drawable.banner)
//            .into(imageView)
//        view.addView(imageLayout, 0)
//        return imageLayout
//    }
//
//    override fun isViewFromObject( view: View, `object`: Any ) = view == `object`
//
//    override fun restoreState( state: Parcelable?, loader: ClassLoader? ) {
//
//    }
//
//    override fun saveState(): Parcelable? {
//        return null
//    }

}
