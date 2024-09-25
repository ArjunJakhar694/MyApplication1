// ProductAdapter.kt
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.ProductDetailActivity
import com.example.ecommerce.R
import com.squareup.picasso.Picasso

class ProductAdapter(
    private val products: List<Product>,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.product_image)
        val titleView: TextView = itemView.findViewById(R.id.product_title)
        val priceView: TextView = itemView.findViewById(R.id.product_price)
        val ratingTextView: TextView = itemView.findViewById(R.id.rating_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.titleView.text = product.title
        holder.priceView.text = "$${product.price}"
        holder.ratingTextView.text = "${product.rating.rate ?: 0.0}"

        Picasso.get().load(product.image).into(holder.imageView)

        // Set click listener for the item
        holder.itemView.setOnClickListener {
            onItemClick(product)
        }

        // Set click listener for the favorite icon
        holder.itemView.findViewById<ImageView>(R.id.favorite_icon).setOnClickListener {
            // Show a toast message
            Toast.makeText(holder.itemView.context, "${product.title} added to favorites!", Toast.LENGTH_SHORT).show()

            // Navigate to ProductDetailActivity
            val intent = Intent(holder.itemView.context, ProductDetailActivity::class.java).apply {
                putExtra("PRODUCT", product)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = products.size
}

