package com.estudos.brunobarreto.recyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.estudos.brunobarreto.recyclerview.R;
import com.estudos.brunobarreto.recyclerview.domain.Car;

import java.util.List;

/**
 * Created by bruno.barreto on 28/04/2017.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {

    private List<Car> mList;
    private LayoutInflater mLayoutInflater;

    public CarAdapter(Context c, List<Car> l) {
        mList = l;
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup ViewGroup, int viewType) {

        Log.i("LOG", "onCreateViewHolder");

        View v = mLayoutInflater.inflate(R.layout.item_car, ViewGroup, false);
        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {

        Log.i("LOG", "onBindViewHolder");

        myViewHolder.ivCar.setImageResource(mList.get(position).getPhoto());
        myViewHolder.tvModel.setText(mList.get(position).getModels());
        myViewHolder.tvBrand.setText(mList.get(position).getBrands());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addListItem(Car c, int position) {
        mList.add(c);
        notifyItemInserted(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivCar;
        public TextView tvModel;
        public TextView tvBrand;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivCar   = (ImageView) itemView.findViewById(R.id.iv_car);
            tvModel = (TextView) itemView.findViewById(R.id.tv_model);
            tvBrand = (TextView) itemView.findViewById(R.id.tv_brand);
        }
    }

}
