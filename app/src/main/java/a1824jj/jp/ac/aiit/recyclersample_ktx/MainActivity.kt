package a1824jj.jp.ac.aiit.recyclersample_ktx

import a1824jj.jp.ac.aiit.recyclersample_ktx.databinding.ActivityMainBinding
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private val fruitsList =
        listOf(Fruit("Mango", "Tom"),
            Fruit("Apple","Joe"),
            Fruit("Banana","Mark"),
            Fruit("Guava", "Mike"),
            Fruit("Lemon","Mike"),
            Fruit("Pear","Frank"),
            Fruit("Orange","Joe"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.apply {
            myRecyclerView.setBackgroundColor(Color.YELLOW)
            myRecyclerView.layoutManager = LinearLayoutManager(baseContext)
            myRecyclerView.adapter = MyRecyclerViewAdapter(fruitsList) { selectedFruitItem:Fruit->listItemClicked(selectedFruitItem) }
        }
    }

    private fun listItemClicked(fruit: Fruit){
        Toast.makeText(this@MainActivity, "${fruit.supplier}", Toast.LENGTH_LONG).show()
    }
}
