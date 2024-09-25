package com.example.ecommerce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.example.ecommerce.databinding.ActivityPurchaseDetailBinding



class PurchaseDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPurchaseDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPurchaseDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the product data from the intent
        val title = intent.getStringExtra("TITLE")
        val price = intent.getStringExtra("PRICE")
        val quantity = intent.getIntExtra("QUANTITY", 1)
        val image = intent.getStringExtra("IMAGE")
        val description = intent.getStringExtra("DESCRIPTION")

        // Set the data to views
        binding.titleTextView.text = title
        binding.priceTextView.text = price
        binding.quantityTextView.text = "Quantity: $quantity" // Updated line
        binding.descriptionTextView.text = description
        Picasso.get().load(image).into(binding.productImageView)
    }

}
