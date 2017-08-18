package com.coderminion.searchdatafromlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by phoenix on 18/8/17.
 */


public class ListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<String> tv_shows_movies = null;
    private ArrayList<String> arraylist;

    public ListAdapter(Context context, ArrayList<String> tv_shows_movies) {
        Context mContext = context;
        this.tv_shows_movies = tv_shows_movies;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(tv_shows_movies);
    }

    public class ViewHolder {
        TextView rank;
    }

    @Override
    public int getCount() {
        return tv_shows_movies.size();
    }

    @Override
    public String getItem(int position) {
        return tv_shows_movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.simple_list_item_1, null);

            holder.rank = (TextView) view.findViewById(R.id.text1);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.rank.setText(tv_shows_movies.get(position));

        return view;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        tv_shows_movies.clear();
        if (charText.length() == 0) {
            tv_shows_movies.addAll(arraylist);
        }
        else
        {
            for (String item : arraylist)
            {
                if (item.toLowerCase(Locale.getDefault()).contains(charText))
                {
                    tv_shows_movies.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

}