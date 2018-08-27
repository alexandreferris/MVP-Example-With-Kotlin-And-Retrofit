package br.com.alexandreferris.mvpexamplewithkotlinretrofit

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.alexandreferris.mvpexamplewithkotlinretrofit.model.Beer

/**
 * Created by alexandre on 14/08/18.
 */
class BeerListAdapter(private val dataSet: ArrayList<Beer>) : RecyclerView.Adapter<BeerListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val txtName: TextView
        val txtABV: TextView

        init {
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener { Log.d(TAG, "Element $adapterPosition clicked.") }
            txtName = v.findViewById(R.id.txtName)
            txtABV = v.findViewById(R.id.txtABV)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d(TAG, "Element $position set.")

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.txtName.text = dataSet.get(position).name
        viewHolder.txtABV.text = dataSet.get(position).abv.toString() + "%"
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    companion object {
        private val TAG = "CustomAdapter"
    }

}