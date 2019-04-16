package com.negosy.catalogo;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initDrawer(toolbar);
    }

    private void initDrawer(Toolbar toolbar) {
        PrimaryDrawerItem dashboard = new PrimaryDrawerItem()
                .withIcon(CommunityMaterial.Icon.cmd_gauge)
                .withIdentifier(1).withName("Dashboard");

        PrimaryDrawerItem bank = new PrimaryDrawerItem()
                .withIcon(CommunityMaterial.Icon.cmd_bank)
                .withIdentifier(6).withName("Bancos");

        SecondaryDrawerItem point_of_sale = new SecondaryDrawerItem()
                .withIdentifier(7)
                .withIcon(CommunityMaterial.Icon.cmd_cart_plus)
                .withName("Punto de venta");

        SecondaryDrawerItem open_box = new SecondaryDrawerItem()
                .withIdentifier(8)
                .withIcon(GoogleMaterial.Icon.gmd_lock_outline)
                .withName("Apertura de caja");

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(getDrawable(R.drawable.header_background))
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName("Ever Vásquez")
                                .withEmail("ever@negosy.com")
                                .withIcon(R.mipmap.ever_profile)
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(
                        dashboard,
                        new ExpandableDrawerItem().withName("Inventario")
                                .withIcon(CommunityMaterial.Icon.cmd_barcode_scan)
                                .withIdentifier(2).withSetSelected(false)
                                .withSelectable(false).withSubItems(
                                new SecondaryDrawerItem()
                                        .withName("Productos")
                                        .withLevel(2)
                                        .withIdentifier(201),
                                new SecondaryDrawerItem()
                                        .withName("Lineas")
                                        .withLevel(2)
                                        .withIdentifier(202),
                                new SecondaryDrawerItem()
                                        .withName("Categorias")
                                        .withLevel(2)
                                        .withIdentifier(203)
                        ),
                        new ExpandableDrawerItem().withName("Almacén")
                                .withIcon(CommunityMaterial.Icon.cmd_cube_send)
                                .withIdentifier(4).withSetSelected(false)
                                .withSelectable(false).withSubItems(
                                new SecondaryDrawerItem()
                                        .withName("Entradas")
                                        .withLevel(2)
                                        .withIdentifier(401),
                                new SecondaryDrawerItem()
                                        .withName("Salidas")
                                        .withLevel(2)
                                        .withIdentifier(402)
                        ),
                        new ExpandableDrawerItem().withName("Contactos")
                                .withIcon(CommunityMaterial.Icon.cmd_account_multiple_outline)
                                .withIdentifier(3).withSetSelected(false)
                                .withSelectable(false).withSubItems(
                                new SecondaryDrawerItem()
                                        .withName("Clientes")
                                        .withLevel(2)
                                        .withIdentifier(301),
                                new SecondaryDrawerItem()
                                        .withName("Empleados")
                                        .withLevel(2)
                                        .withIdentifier(302),
                                new SecondaryDrawerItem()
                                        .withName("Proveedores")
                                        .withLevel(2)
                                        .withIdentifier(303)
                        ),
                        new ExpandableDrawerItem().withName("Caja")
                                .withIcon(CommunityMaterial.Icon.cmd_coin)
                                .withIdentifier(5).withSetSelected(false)
                                .withSelectable(false).withSubItems(
                                new SecondaryDrawerItem()
                                        .withName("Transacciones")
                                        .withLevel(2)
                                        .withIdentifier(502),
                                new SecondaryDrawerItem()
                                        .withName("Cobros")
                                        .withLevel(2)
                                        .withIdentifier(503),
                                new SecondaryDrawerItem()
                                        .withName("Ingresos")
                                        .withLevel(2)
                                        .withIdentifier(504),
                                new SecondaryDrawerItem()
                                        .withName("Egresos")
                                        .withLevel(2)
                                        .withIdentifier(505)
                        ),
                        bank,
                        new DividerDrawerItem(),
                        point_of_sale,
                        open_box
//                        item2,
//                        new SecondaryDrawerItem().withName(R.string.material_drawer_open)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        return true;
                    }
                })
                .build();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
