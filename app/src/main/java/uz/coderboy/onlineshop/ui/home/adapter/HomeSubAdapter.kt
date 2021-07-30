package uz.coderboy.onlineshop.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.coderboy.onlineshop.databinding.ListSubItemHomeBinding
import uz.coderboy.onlineshop.ui.home.model.HomeRecommendation

class HomeSubAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList = emptyList<HomeRecommendation>()

    fun newList(list: List<HomeRecommendation>){
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

    private class HomeViewHolder(private val bind: ListSubItemHomeBinding):
            RecyclerView.ViewHolder(bind.root){
                fun bind(homeRecommendation: HomeRecommendation){
                    bind.model = homeRecommendation
                    bind.executePendingBindings()
                }
        companion object{
            fun from(parent: ViewGroup): HomeViewHolder{
                val bind = ListSubItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return HomeViewHolder(bind)
            }
        }
            }
}