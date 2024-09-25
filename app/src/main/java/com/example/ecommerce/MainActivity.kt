package com.example.ecommerce


// MainActivity.ktttt
import ProductAdapter
import ProductViewModel
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.R

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
            println("Hello")
        }

        viewModel.fetchProducts()
    }
}
