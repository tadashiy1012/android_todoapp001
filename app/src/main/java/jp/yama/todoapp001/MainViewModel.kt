package jp.yama.todoapp001

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;

class MainViewModel : ViewModel() {

    val todos: MutableLiveData<List<Todo>> by lazy {
        MutableLiveData<List<Todo>>().also {
            it.value = listOf(Todo("hoge"))
        }
    }

    fun appendTodo(todo: String) {
        val mutable = todos.value?.toMutableList()
        mutable?.add(Todo(todo))
        todos.value = mutable?.toList()!!
    }

    fun toggleDone(tgt: Todo) {
        val mutable = todos.value?.toMutableList()
        val found = mutable?.find { it == tgt }
        found?.done = !found?.done!!
        todos.value = mutable.toList()
    }

    fun clearDone() {
        val mutable = todos.value?.toMutableList()
        val filtered = mutable?.filter { !it.done }
        todos.value = filtered?.toList()
    }

}
