package com.example.youtube_tut;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DomeniuAdapter extends BaseAdapter {
    private List<Domeniu > domenii=new ArrayList<>();

    public DomeniuAdapter(List<Domeniu> lista){

        domenii=lista;
    }
    @Override
    public int getCount() {
        return domenii.size();
    }

    @Override
    public Object getItem(int position) {
        return domenii.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v1=inflater.inflate(R.layout.item_menu, parent,false);
        ImageView image=v1.findViewById(R.id.imageDom);
        TextView tx1=v1.findViewById(R.id.domeniu);
        TextView tx2=v1.findViewById(R.id.pret);
        //String imgUrl= ((Domeniu) getItem(position)).getImgUrl();
       //preluam elem din lista si modificam
        Domeniu temp= domenii.get(position);
        tx1.setText(temp.getDenumire());
        tx2.setText(temp.getNr_postari()+"");
        int img=((Domeniu) getItem(position)).getImgUrl();
        image.setImageResource(img);


        return v1;
    }
    public void updateList(List<Domeniu> meniuri){
        domenii.clear();
        domenii.addAll(meniuri);
        notifyDataSetChanged();

    }

}
