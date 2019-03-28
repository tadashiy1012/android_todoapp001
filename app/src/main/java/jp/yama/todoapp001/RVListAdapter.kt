package jp.yama.todoapp001

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class RVListAdapter(private val ctx: Context, private val viewModel: MainViewModel): ListAdapter<Todo, RViewHolder>(diffCallback) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Todo>() {
            override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem == newItem
            }
            override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem.todo == newItem.todo
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RViewHolder {
        val inflater = LayoutInflater.from(ctx)
        val itemView = inflater.inflate(R.layout.todo_item, parent, false)
        return RViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RViewHolder, position: Int) {
        holder.txt.text = getItem(position).todo
        holder.btn.setOnClickListener {
            val tgt = getItem(position)
            viewModel.toggleDone(tgt)
            if (tgt.done) {
                holder.setStrike()
            } else {
                holder.unsetStrike()
            }
        }
    }

}