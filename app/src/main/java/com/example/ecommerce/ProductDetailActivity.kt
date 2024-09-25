package com.example.ecommerce

import Product
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.example.ecommerce.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding
    private var quantity = 1
    private var productPrice: Double = 0.0
    private lateinit var product: Product // Store the product reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the product data from the intent
        product = intent.getParcelableExtra<Product>("PRODUCT") ?: return // Safely retrieve the product

        binding.titleTextView.text = product.title
        productPrice = product.price
        binding.priceTextView.text = "$${productPrice * quantity}"
        binding.descriptionTextView.text = product.description
        Picasso.get().load(product.image).into(binding.productImageView)

        // Set up click listeners for plus and minus icons
        binding.minusIcon.setOnClickListener {
            if (quantity > 1) {
                quantity--
                updateQuantityAndPrice()
            }
        }

        binding.plusIcon.setOnClickListener {
            quantity++
            updateQuantityAndPrice()
        }

        binding.buttonBuyNow.setOnClickListener {
            showPurchaseDetails() // Call the updated method
        }
    }

    private fun updateQuantityAndPrice() {
        binding.quantityTextView.text = quantity.toString()
        binding.priceTextView.text = "$${productPrice * quantity}"
    }

    private fun showPurchaseDetails() {
        val intent = Intent(this, PurchaseDetailActivity::class.java).apply {
            putExtra("TITLE", binding.titleTextView.text.toString())
            putExtra("PRICE", "$${productPrice * quantity}")
            putExtra("QUANTITY", quantity)
            putExtra("IMAGE", product.image)
            putExtra("DESCRIPTION", product.description) // Pass the description
        }
        startActivity(intent)
    }

}
