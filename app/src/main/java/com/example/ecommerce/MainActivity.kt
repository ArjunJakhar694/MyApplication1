package com.example.ecommerce

<<<<<<< HEAD
=======
// MainActivity.kt
>>>>>>> github/master
import ProductAdapter
import ProductViewModel
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
<<<<<<< HEAD
=======
import com.example.ecommerce.R
>>>>>>> github/master

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.products.observe(this) { products ->
            adapter = ProductAdapter(products) { product ->
                // Navigate to ProductDetailActivity
                val intent = Intent(this, ProductDetailActivity::class.java).apply {
                    putExtra("PRODUCT", product)
                }
                startActivity(intent)
            }
            recyclerView.adapter = adapter
        }

        viewModel.fetchProducts()
    }
<<<<<<< HEAD
    fun add() {

    }

=======
>>>>>>> github/master
}
