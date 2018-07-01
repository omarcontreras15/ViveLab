package co.edu.ufps.vivelab.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Stack;

import co.edu.ufps.vivelab.fragment.acerca_de.AcercaDe;
import co.edu.ufps.vivelab.fragment.configuracion.Configuracion;
import co.edu.ufps.vivelab.fragment.cursos_aprobados.CursosAprobados;
import co.edu.ufps.vivelab.fragment.cursos_ofertados.CursosOfertados;
import co.edu.ufps.vivelab.fragment.editar_usuario.EditarUsuario;
import co.edu.ufps.vivelab.fragment.noticias.Noticias;
import co.edu.ufps.vivelab.R;

public class Inicio extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Stack<MenuItem> pilaItem;
    private MenuItem itemActual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //cargar el frament de inicio
        Fragment fragment=new CursosOfertados();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
        this.reescribirTitleBar(navigationView.getMenu().getItem(0));
        //en esta pila se guarda los item de los menus a medida que se clickean
        this.pilaItem=new Stack<MenuItem>();
        //se guarda el item del menu de inicio por primera vez en la pila
        this.pilaItem.push(navigationView.getMenu().getItem(0));
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            // verificamos que la pila de los item no se encuentre vacia y ademas si el item actual
            //corresponde al del tope de la pila
            if(!this.pilaItem.empty() && this.itemActual==this.pilaItem.get(this.pilaItem.size()-1)) {
                //si la condicion anterior de cumple se eliminar de la pila un item
                this.pilaItem.pop();
            }
            //verificamos que la pila no se encuentre vacia
            if (!this.pilaItem.empty()) {
                //agregamos el nuevo item a la pila
                MenuItem item=this.pilaItem.pop();
                this.itemActual=item;
                this.reescribirTitleBar(item);
                this.pilaItem.push(item);
            }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            super.onBackPressed();

        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cerrar_sesion) {
            //cerramos sesion en el aplicativo
            FirebaseAuth.getInstance().signOut();
            //redireccionamos a la pantalla de login
            finish();
            //redireccionamos al activity de login
            this.pasarActivity(Login.class);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment=null;
        switch (id){
            case R.id.nav_noticias:
                fragment=new Noticias();
                break;

            case R.id.nav_cursos_ofertados:
                fragment=new CursosOfertados();
                break;

            case R.id.nav_cursos_aprobados:
                fragment=new CursosAprobados();
                break;

            case R.id.nav_editar_usuario:
                fragment=new EditarUsuario();
                break;

            case R.id.nav_configuracion:
                fragment=new Configuracion();
                break;

            case R.id.nav_internet:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.facebook.com/pvdlabcucuta/"));
                this.startActivity(intent);
                break;

            case R.id.nav_acerca_de:
                fragment=new AcercaDe();
                break;
        }

        if(this.itemActual!=item && fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commit();
            this.pilaItem.push(item);
            this.itemActual=item;
            this.reescribirTitleBar(item);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //metodo para pasar a una siquiete activity
    private void pasarActivity(Class clase){
        Intent activity=new Intent(getApplicationContext(),clase);
        startActivity(activity);
    }

    private void reescribirTitleBar(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.nav_noticias:
                getSupportActionBar().setTitle("Noticias");
                break;

            case R.id.nav_cursos_ofertados:
                getSupportActionBar().setTitle("Cursos Ofertados");
                break;

            case R.id.nav_cursos_aprobados:
                getSupportActionBar().setTitle("Cursos Aprobados");
                break;

            case R.id.nav_editar_usuario:
                getSupportActionBar().setTitle("Editar Usuario");
                break;

            case R.id.nav_configuracion:
                getSupportActionBar().setTitle("Preferencias del usuario");
                break;

            case R.id.nav_internet:

                break;

            case R.id.nav_acerca_de:
                getSupportActionBar().setTitle("Acerca De");
                break;
        }

        item.setChecked(true);
    }
}
