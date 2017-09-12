package com.example.pedro.recyclerviewpesos;

import android.graphics.Color;
import android.renderscript.Sampler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Pedro on 30/08/2017.
 */

public class PesoAdaptador extends RecyclerView.Adapter<PesoAdaptador.PesoViewHolder>{

    private List<Peso> pesos;
    public PesoAdaptador(List<Peso> pesos){
        this.pesos = pesos;
    }


    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(ViewHolder, int)
     */
    @Override
    public PesoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case 0:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_primero,parent,false);
                break;
            default:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
                break;

        }

        return new PesoViewHolder(v);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override {@link #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(PesoViewHolder holder, int position) {
        Peso peso = pesos.get(position);
        holder.tvFecha.setText(peso.getFecha());
        holder.tvPeso.setText(peso.getPeso());

        double diferencia;
        String diferenciaString;
        if (position!=0){
            Peso pesomenosuno = pesos.get(position-1);
            diferencia = Double.parseDouble(peso.getPeso())-Double.parseDouble(pesomenosuno.getPeso());
            diferenciaString = String.valueOf(diferencia);
        }else{
            diferencia = 0;
            diferenciaString = "0";
        }
        holder.tvDiferencia.setText(diferenciaString);

        if (diferencia>0){
            holder.tvDiferencia.setTextColor(Color.parseColor("#64DD17"));
        } else if (diferencia == 0){
            holder.tvDiferencia.setTextColor(Color.parseColor("#000000"));
        } else {
            holder.tvDiferencia.setTextColor(Color.parseColor("#D50000"));
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return pesos.size();
    }

    public class PesoViewHolder extends RecyclerView.ViewHolder{
        private TextView tvFecha;
        private TextView tvPeso;
        private TextView tvDiferencia;


        public PesoViewHolder(View itemView) {
            super(itemView);
            tvFecha = (TextView) itemView.findViewById(R.id.IDfecha);
            tvPeso = (TextView) itemView.findViewById(R.id.IDpeso);
            tvDiferencia = (TextView) itemView.findViewById(R.id.IDdiferencia);
        }
    }


    /**
     * Return the view type of the item at <code>position</code> for the purposes
     * of view recycling.
     * <p>
     * <p>The default implementation of this method returns 0, making the assumption of
     * a single view type for the adapter. Unlike ListView adapters, types need not
     * be contiguous. Consider using id resources to uniquely identify item view types.
     *
     * @param position position to query
     * @return integer value identifying the type of the view needed to represent the item at
     * <code>position</code>. Type codes need not be contiguous.
     */
    @Override
    public int getItemViewType(int position) {
        int viewType = 1;
        if (position==0) {viewType = 0;};
        return viewType;
    }
}
