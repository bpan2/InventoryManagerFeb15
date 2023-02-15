package com.inventorymanager.Helpers.Adapters;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inventorymanager.Models.Entities.Product;
import com.inventorymanager.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private List<Product> products = new ArrayList<>();
    private OnItemClickListener listener;


    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_card, viewGroup, false);
        return new ProductHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder productHolder, int i) {
        Product currentProduct = products.get(i);
        productHolder.productIDInventoryTextInputEditText.setText(currentProduct.getProductID());
        productHolder.upcInventoryTextInputEditText.setText(currentProduct.getUpc());
        productHolder.skuInventoryTextInputEditText.setText(currentProduct.getSku());
        productHolder.priceInventoryTextInputEditText.setText(currentProduct.getPrice());
        productHolder.onHandQtyInventoryTextInputEditText.setText(currentProduct.getOnHandQty());
        productHolder.brandInventoryTextInputEditText.setText(currentProduct.getBrand());
        productHolder.modelInventoryTextInputEditText.setText(currentProduct.getModel());
        productHolder.unitOfMeasurementIDInventoryTextInputEditText.setText(currentProduct.getUnitOfMeasurementID());
        productHolder.productCategoryIDInventoryTextInputEditText.setText(currentProduct.getProductCategoryID());
        //productHolder.manufacturerIDInventoryTextInputEditText.setText(currentProduct.getManufacturerID());
       //productHolder.supplierIDInventoryTextInputEditText.setText(currentProduct.getSupplierID());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<Product> products){
        this.products = products;
        notifyDataSetChanged();
    }

    public Product getProductAt(int adapterPosition) {
        return products.get(adapterPosition);
    }

    class ProductHolder extends RecyclerView.ViewHolder {
        private TextInputEditText productIDInventoryTextInputEditText;
        private TextInputEditText upcInventoryTextInputEditText;
        private TextInputEditText skuInventoryTextInputEditText;
        private TextInputEditText priceInventoryTextInputEditText;
        private TextInputEditText onHandQtyInventoryTextInputEditText;
        private TextInputEditText brandInventoryTextInputEditText;
        private TextInputEditText modelInventoryTextInputEditText;
        private TextInputEditText unitOfMeasurementIDInventoryTextInputEditText;
        private TextInputEditText productCategoryIDInventoryTextInputEditText;
        private TextInputEditText manufacturerIDInventoryTextInputEditText;
        private TextInputEditText supplierIDInventoryTextInputEditText;


        public int position;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);

            productIDInventoryTextInputEditText = itemView.findViewById(R.id.productIDInventoryTextInputEditText);
            upcInventoryTextInputEditText = itemView.findViewById(R.id.upcInventoryTextInputEditText);
            skuInventoryTextInputEditText = itemView.findViewById(R.id.skuInventoryTextInputEditText);
            priceInventoryTextInputEditText = itemView.findViewById(R.id.priceInventoryTextInputEditText);
            onHandQtyInventoryTextInputEditText = itemView.findViewById(R.id.onHandQtyInventoryTextInputEditText);
            brandInventoryTextInputEditText = itemView.findViewById(R.id.brandInventoryTextInputEditText);
            modelInventoryTextInputEditText = itemView.findViewById(R.id.modelInventoryTextInputEditText);
            unitOfMeasurementIDInventoryTextInputEditText = itemView.findViewById(R.id.unitOfMeasurementIDInventoryTextInputEditText);
            productCategoryIDInventoryTextInputEditText = itemView.findViewById(R.id.productCategoryIDInventoryTextInputEditText);
            //manufacturerIDInventoryTextInputEditText = itemView.findViewById(R.id.manufacturerIDInventoryTextInputEditText);
            //supplierIDInventoryTextInputEditText = itemView.findViewById(R.id.supplierIDInventoryTextInputEditText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    position = getAdapterPosition();

                    if(listener !=  null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(products.get(position));
                    }
                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClick(Product product);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
