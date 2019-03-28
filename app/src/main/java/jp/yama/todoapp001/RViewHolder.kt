package jp.yama.todoapp001

import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val txt: TextView
    val btn: Button

    init {
        txt = view.findViewById(R.id.txt)
        btn = view.findViewById(R.id.doneBtn)
    }

    fun setStrike() {
        val paint = txt.paint
        txt.paintFlags = (paint.flags or Paint.STRIKE_THRU_TEXT_FLAG)
    }

    fun unsetStrike() {
        val paint = txt.paint
        txt.paintFlags = (paint.flags and Paint.STRIKE_THRU_TEXT_FLAG.inv())
    }

}