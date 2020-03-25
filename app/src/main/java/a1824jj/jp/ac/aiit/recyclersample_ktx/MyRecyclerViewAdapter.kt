package a1824jj.jp.ac.aiit.recyclersample_ktx

import a1824jj.jp.ac.aiit.recyclersample_ktx.databinding.ListItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private val fruitsList:List<Fruit>, private val clickListener:(Fruit)->Unit): RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val dataBinding: ListItemBinding ) : RecyclerView.ViewHolder(dataBinding.root){
        fun bind(fruit: Fruit, clickListener:(Fruit)->Unit){
            dataBinding.apply {
                nameTextView.text = fruit.name
                root.setOnClickListener {
                    clickListener(fruit)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val dataBinding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(dataBinding)
    }

    override fun getItemCount() = fruitsList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruit = fruitsList[position]
        holder.bind(fruit, clickListener)
    }

}