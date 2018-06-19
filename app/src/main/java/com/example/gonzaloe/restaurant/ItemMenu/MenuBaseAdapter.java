package com.example.gonzaloe.restaurant.ItemMenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import com.example.gonzaloe.restaurant.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;


public class MenuBaseAdapter extends BaseAdapter implements OnLoadComplelmg {

    private ArrayList<ItemMenuStructure> list;
    private ArrayList<TextView> counter;
    private Context context;

    public MenuBaseAdapter(Context context, ArrayList<ItemMenuStructure> list) {
        this.list = list;
        this.context = context;
        counter = new ArrayList<TextView>();
    }

    public TextView getCounter(int position) {
        return this.counter.get(position);
    }


    @Override
    public int getCount() {
        return this.list.size();
    }


    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.itemfood, null);
        }

        TextView txt1 = convertView.findViewById(R.id.txtVStadoCasa);
        TextView txt2 = convertView.findViewById(R.id.txtVprecio);

        TextView txt3 = convertView.findViewById(R.id.txtVCiudad);

        ImageView img = convertView.findViewById(R.id.imgViewCasa);


        txt1.setText(this.list.get(position).getEstado());
        txt2.setText(this.list.get(position).getPrecio());
        txt3.setText(this.list.get(position).getCiudad());
        //txt4.setText(this.list.get(position).getUrl());


        counter.add(txt2);

        if (this.list.get(position).getImg() == null) {

            LoaderImg loader = new LoaderImg();
            loader.setOnloadCompleteImg(img, position, this);
            loader.execute(this.list.get(position).getUrlimg());
        } else {
            img.setImageBitmap(this.list.get(position).getImg());
        }
        return convertView;

    }


    private void loadData() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("", new JsonHttpResponseHandler() {


        });
    }

    @Override
    public void OnLoadCompletelmgResult(ImageView img, int position, Bitmap imgsourceimg) {

        this.list.get(position).setImg(imgsourceimg);
        img.setImageBitmap(imgsourceimg);


    }
}

