package com.navigationmenus;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavigationMenus_Listview extends ArrayAdapter<String> {
    Activity    activity;
    String[]    titles;
    Integer[]   mipmaps;

    public NavigationMenus_Listview(Activity activity,String[] titles,Integer[] mipmaps) {
        super(activity,R.layout.navigation_menus_listview,titles);

        this.activity   = activity;
        this.titles     = titles;
        this.mipmaps    = mipmaps;
    }

    class ViewHolder {
        TextView tv_titles;
        ImageView iv_images;

        public ViewHolder(View view) {
            tv_titles   = (TextView) view.findViewById(R.id.navigationmenus_listview_title);
            iv_images   = (ImageView) view.findViewById(R.id.navigationmenus_listview_icon);
        }
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View            r               = convertView;
        ViewHolder      viewholder      = null;
        LayoutInflater layoutinflater;

        if(r == null) {
            layoutinflater  = activity.getLayoutInflater();
            r               = layoutinflater.inflate(R.layout.navigation_menus_listview,null,true);
            viewholder      = new ViewHolder(r);
            r.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) r.getTag();
        }

        viewholder.tv_titles.setText(titles[position]);
        viewholder.iv_images.setImageResource(mipmaps[position]);
        return r;
    }
}
