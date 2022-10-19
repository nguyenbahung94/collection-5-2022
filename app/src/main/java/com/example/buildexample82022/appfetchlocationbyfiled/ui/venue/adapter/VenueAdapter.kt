package com.example.buildexample82022.appfetchlocationbyfiled.ui.venue.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.buildexample82022.R
import com.example.buildexample82022.appfetchlocationbyfiled.api.model.Category
import com.example.buildexample82022.appfetchlocationbyfiled.api.model.Result
import com.example.buildexample82022.databinding.ViewholderVenuesItemBinding

class VenueAdapter : ListAdapter<Result, VenueAdapter.CategoriesViewHolder>(object :
    DiffUtil.ItemCallback<Result>() {
    /**
     * Called to check whether two objects represent the same item.
     *
     *
     * For example, if your items have unique ids, this method should check their id equality.
     *
     *
     * Note: `null` items in the list are assumed to be the same as another `null`
     * item and are assumed to not be the same as a non-`null` item. This callback will
     * not be invoked for either of those cases.
     *
     * @param oldItem The item in the old list.
     * @param newItem The item in the new list.
     * @return True if the two items represent the same object or false if they are different.
     * @see Callback.areItemsTheSame
     */
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.name == newItem.name
    }

    /**
     * Called to check whether two items have the same data.
     *
     *
     * This information is used to detect if the contents of an item have changed.
     *
     *
     * This method to check equality instead of [Object.equals] so that you can
     * change its behavior depending on your UI.
     *
     *
     * For example, if you are using DiffUtil with a
     * [RecyclerView.Adapter], you should
     * return whether the items' visual representations are the same.
     *
     *
     * This method is called only if [.areItemsTheSame] returns `true` for
     * these items.
     *
     *
     * Note: Two `null` items are assumed to represent the same contents. This callback
     * will not be invoked for this case.
     *
     * @param oldItem The item in the old list.
     * @param newItem The item in the new list.
     * @return True if the contents of the items are the same or false if they are different.
     * @see Callback.areContentsTheSame
     */
    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.name == newItem.name
    }

}) {

    class CategoriesViewHolder(
        private val binding: ViewholderVenuesItemBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(venue: Result) {
            binding.textviewVenueTitle.text = stringOrDefault(venue.name)
            binding.textviewCategoryVenue.text = stringOrDefault(getCategory(venue.categories))
            binding.textviewAddress.text = stringOrDefault(venue.location.formatted_address)
            binding.textviewDistance.text = context
                .getString(R.string.venue_distance_str, venue.distance)
        }

        private fun stringOrDefault(string: String): String {
            return if (string.isEmpty() || string.isBlank()) {
                context.getString(R.string.if_data_not_available_str)
            } else {
                string
            }
        }

        private fun getCategory(categoryList: List<Category>): String {
            return categoryList.joinToString(", ", transform = {
                return@joinToString it.name
            })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val binding =
            ViewholderVenuesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(binding, parent.context)
    }


    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}