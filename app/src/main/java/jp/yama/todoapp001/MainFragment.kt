package jp.yama.todoapp001

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var rview: RecyclerView
    private lateinit var inTxt: EditText
    private lateinit var addBtn: Button
    private lateinit var clearBtn: Button
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        rview = view.findViewById(R.id.rview)
        inTxt = view.findViewById(R.id.inTxt)
        addBtn = view.findViewById(R.id.addBtn)
        clearBtn = view.findViewById(R.id.clearBtn)
        addBtn.setOnClickListener {
            viewModel.appendTodo(inTxt.text.toString())
        }
        clearBtn.setOnClickListener {
            viewModel.clearDone()
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val adapter = RVListAdapter(this.context!!, viewModel)
        rview.setHasFixedSize(true)
        rview.layoutManager = LinearLayoutManager(this.context!!)
        rview.adapter = adapter
        viewModel.todos.observe(this, Observer {
            it.forEach {
                Log.d("yama", it.todo + ":" + it.done.toString())
            }
            adapter.submitList(it)
        })
    }

}
