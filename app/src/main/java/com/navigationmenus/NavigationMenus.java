package com.navigationmenus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

public class NavigationMenus extends AppCompatActivity {
    //Class
    NavigationMenus_Listview NavListView;

    //OBJ
    ListView                NavList;
    DrawerLayout            MDrawerLayout;
    ActionBarDrawerToggle   MToggle;

    //Navigation Menus
    String[]    NavListTitles       = {
                                        "Sign in",
                                        "Sign up",
                                        "BLog",
                                        "Setting",
                                        "Download Document",
                                        "Prestasi",
                                        "Contact",
                                        "F.A.Q",
                                        "About"
                                    };
    Integer[]   NavListViewIcon     = {
                                        R.mipmap.ic_signin_black_24x,
                                        R.mipmap.ic_add_user_black_24x,
                                        R.mipmap.ic_blog_black_24x,
                                        R.mipmap.ic_gear_black_24x,
                                        R.mipmap.ic_folder_black_24x,
                                        R.mipmap.id_badge_black_24x,
                                        R.mipmap.ic_chat_black_24x,
                                        R.mipmap.ic_faq_black_24x,
                                        R.mipmap.ic_group_black_24x
                                    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_menus);

        //Toggle Navigation Menus
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavList          = (ListView) findViewById(R.id.navigationmenus_listview);
        NavListView      = new NavigationMenus_Listview(this,NavListTitles,NavListViewIcon);
        NavList.setAdapter(NavListView);

        MDrawerLayout   = (DrawerLayout) findViewById(R.id.navigationmenus);
        MToggle         = new ActionBarDrawerToggle(this,MDrawerLayout,R.string.open,R.string.close);
        MDrawerLayout.addDrawerListener(MToggle);
        MToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(MToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
