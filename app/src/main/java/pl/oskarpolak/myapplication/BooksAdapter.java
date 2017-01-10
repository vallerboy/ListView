package pl.oskarpolak.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by OskarPraca on 2017-01-10.
 */

public class BooksAdapter extends BaseAdapter{

    ArrayList<BookData> data;
    Context context;
    LayoutInflater inflater;

    public BooksAdapter(List<BookData> dataList, Context con){
        data = (ArrayList) dataList;
        context = con;
        inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder;
        if(convertView != null){
            viewHolder = (ViewHolder) convertView.getTag();
        }else {
            convertView = inflater.inflate(R.layout.custom_book_list_row, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        viewHolder.textTitle.setText(data.get(position).getTitle());
        viewHolder.textAuthor.setText(data.get(position).getAuthor());
        viewHolder.textPages.setText("Ilość stron: " + data.get(position).getPages());


        return convertView;
    }

     class ViewHolder {

         @BindView(R.id.textViewTitle)
         TextView textTitle;
         @BindView(R.id.textViewAuthor)
         TextView textAuthor;
         @BindView(R.id.textViewPages)
         TextView textPages;

          public ViewHolder(View v){
              ButterKnife.bind(this, v);
          }

     }
}
