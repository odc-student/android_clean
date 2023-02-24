package tn.orange.demoapp.common

import androidx.recyclerview.widget.DiffUtil

const val mediaUrl =
    "https://raw.githubusercontent.com/robert-z/simple-pokemon-json-api/master/public"

object StringDiffUtils : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem
    override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
}