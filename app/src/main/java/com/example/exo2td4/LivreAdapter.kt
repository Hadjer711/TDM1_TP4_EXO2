package com.example.exo2td4


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_livre_list_item.view.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlin.collections.ArrayList


class LivreAdapter(var clickListner: OnLivreListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private val TAG: String = "AppDebug"

    private var items: List<Livre> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LivreViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_livre_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is LivreViewHolder -> {
                holder.bind(items.get(position), clickListner)
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(livre: List<Livre>){
        items = livre
    }

    class LivreViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val livre_image = itemView.livre_image
        val livre_title = itemView.livre_title
        val livre_author = itemView.livre_author

        fun bind(livre: Livre, action: OnLivreListener){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(livre.image)
                .into(livre_image)
           livre_title.setText(livre.titre)
            livre_author.setText(livre.auteur)

            itemView.setOnClickListener{
                action.onLivreClick(livre, adapterPosition )
            }

        }



    }

    public interface OnLivreListener {
        fun onLivreClick(livre: Livre, position: Int)
    }

}