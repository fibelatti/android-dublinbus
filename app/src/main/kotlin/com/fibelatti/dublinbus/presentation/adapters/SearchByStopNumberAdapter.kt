package com.fibelatti.dublinbus.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fibelatti.dublinbus.R
import com.fibelatti.dublinbus.data.models.StopInformationResult
import kotlinx.android.synthetic.main.list_item_bus.view.*

class SearchByStopNumberAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    internal inner class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: StopInformationResult) = with(itemView) {
            text_view_bus_number.text = context.getString(R.string.search_activity_text_route, item.route)
            text_view_bus_direction.text = item.destination

            if (item.duetime.equals("Due", true)) {
                text_view_bus_eta.text = item.duetime
            } else {
                text_view_bus_eta.text = context.resources.getQuantityString(R.plurals.search_activity_text_eta,
                        Integer.valueOf(item.duetime), item.duetime)
            }
        }
    }

    var list: MutableList<StopInformationResult> = ArrayList()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) =
            (holder as DataViewHolder).bind(list[position])

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return DataViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.list_item_bus, parent, false))
    }

    fun clearList() {
        list.clear()
        notifyDataSetChanged()
    }

    fun addToList(item: StopInformationResult) {
        list.add(item)
        notifyDataSetChanged()
    }

    fun addManyToList(listItems: List<StopInformationResult>) {
        list.addAll(listItems)
        notifyDataSetChanged()
    }
}