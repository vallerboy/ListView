package pl.oskarpolak.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

        convertView = inflater.inflate(R.layout.custom_book_list_row, parent, false);

        TextView textTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
        TextView textAuthor = (TextView) convertView.findViewById(R.id.textViewAuthor);
        TextView textPages = (TextView) convertView.findViewById(R.id.textViewPages);

        textTitle.setText(data.get(position).getTitle());
        textAuthor.setText(data.get(position).getAuthor());
        textPages.setText("Ilość stron: " + data.get(position).getPages());


        return convertView;
    }
}
