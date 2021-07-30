package uz.coderboy.onlineshop.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.coderboy.onlineshop.databinding.ListItemHomeBinding
import uz.coderboy.onlineshop.ui.home.model.HomeMain

class HomeMainAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList = emptyList<HomeMain>()

    fun newList(list: List<HomeMain>){
        this.dataList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeViewHolder){
            holder.bind(dataList[position])
        }
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

    private class HomeViewHolder(private val binding: ListItemHomeBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(homeMain: HomeMain){
            binding.model = homeMain
            val adapter = HomeSubAdapter()
            if (homeMain.recommendationList != null) {
                adapter.newList(homeMain.recommendationList)
            }
            binding.recycler.adapter = adapter
            binding.recycler.layoutManager = GridLayoutManager(itemView.context, 3)
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup): HomeViewHolder{
                val bind  = ListItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return HomeViewHolder(bind)
            }
        }
    }
}