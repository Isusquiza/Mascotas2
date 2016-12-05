package com.eisusquiza.mascotas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.eisusquiza.mascotas.adapter.ContactoAdaptador;
import com.eisusquiza.mascotas.adapter.PageAdapter;
import com.eisusquiza.mascotas.fragments.PerfilFragment;
import com.eisusquiza.mascotas.fragments.RecycleViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.mRefresh: //AQUI ESCRIBIR LA ACCION
                Intent intent  = new Intent(this, Main2Activity.class );
                startActivity(intent);
                break;

            case R.id.mContacto:
                Intent w = new Intent (this, ActivityContacto.class);
                startActivity(w);
                break;

            case R.id.mAcerca:
                Intent i = new Intent (this, ActivityAbout.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar!=null){
            Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
            setSupportActionBar(toolbar);
        }

        Button btnHueso = (Button) findViewById(R.id.btnHueso);

       // Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
       // setSupportActionBar(miActionBar);

        //btnHueso.setOnClickListener(new OnClickListener() {

            //VISUALIZAR TEXTO
          //  TextView tv = (TextView)findViewById(R.id.texto);

            //DECLARAR CONTADOR
//            int contador = 0;

  //          @Override
    //        public void onClick(View v) {
    //            // TODO Auto-generated method stub
    //            contador++;

                // MODIFICAR TEXTO DEL TEXTVIEW
      //          tv.setText("Contador: " +contador);


        //    }
       // });


    //}

      /* */
        }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecycleViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager (){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_casa_perro);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);

    }


   public void agregarFab(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabCamara);
    }

}
