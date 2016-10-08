package com.example.lucas.fisica_classica;

import android.icu.text.DecimalFormat;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            //}
        //});

        //final Button getAnswer = (Button) findViewById(R.id.buttonForca);
        //getAnswer.setOnClickListener(new View.OnClickListener(){

        //});

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 2){
                View rootView = inflater.inflate(R.layout.fragment_segunto_estagio, container, false);
                return rootView;
                //ASSUNTO 2
            }else if (getArguments().getInt(ARG_SECTION_NUMBER) == 3){
                View rootView = inflater.inflate(R.layout.fragment_terceiro_estagio, container, false);
                return rootView;
                //ASSUNTO 3
            }else{
                View rootView = inflater.inflate(R.layout.fragment_main, container, false);
                return rootView;
                //ASSUNTO 1
            }
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Coulomb";
                case 1:
                    return "Resistor";
                case 2:
                    return "Campo";
            }
            return null;
        }
    }

    public void getAnswerForca(View v){
        //CHECAR PRA OBRIGAR A INSERIR
        //add código
        EditText testando1 = (EditText) findViewById(R.id.carga1);
        if(testando1.getText().toString().toLowerCase().trim().equals("")){
            Toast.makeText(this,"Insira o valor da carga 1", Toast.LENGTH_SHORT).show();
            return;
        }
        EditText testando2 = (EditText) findViewById(R.id.carga2);
        if(testando2.getText().toString().toLowerCase().trim().equals("")){
            Toast.makeText(this,"Insira o valor da carga 2", Toast.LENGTH_SHORT).show();
            return;
        }
        EditText testando3 = (EditText) findViewById(R.id.distancia1);
        if(testando3.getText().toString().toLowerCase().trim().equals("")){
            Toast.makeText(this,"Insira o valor da distância entre as cargas", Toast.LENGTH_SHORT).show();
            return;
        }

        TextView myanswer = (TextView) findViewById(R.id.answerForca);

        //constante K
        double knumero = 8.99;
        int kpotencia = -19;

        //unidades valores
        int carga1potencia;
        EditText carga1unidadeText = (EditText) findViewById(R.id.unidade1);
        String carga1unidade = carga1unidadeText.getText().toString().toLowerCase().trim();
        if (carga1unidade.equals("")){
            carga1potencia = 0;
        }else if(carga1unidade.equals("femto")){
            carga1potencia = -15;
        }else if(carga1unidade.equals("pico")){
            carga1potencia = -12;
        }else if(carga1unidade.equals("nano")){
            carga1potencia = -9;
        }else if(carga1unidade.equals("micro")){
            carga1potencia = -6;
        }else if(carga1unidade.equals("mili")){
            carga1potencia = -3;
        }else if(carga1unidade.equals("centi")){
            carga1potencia = -2;
        }else if(carga1unidade.equals("deci")){
            carga1potencia = -1;
        }else if(carga1unidade.equals("deca")){
            carga1potencia = 1;
        }else if(carga1unidade.equals("hecto")){
            carga1potencia = 2;
        }else if(carga1unidade.equals("quilo")){
            carga1potencia = 3;
        }else if(carga1unidade.equals("mega")){
            carga1potencia = 6;
        }else if(carga1unidade.equals("giga")){
            carga1potencia = 9;
        }else if(carga1unidade.equals("tera")){
            carga1potencia = 12;
        }else if(carga1unidade.equals("peta")){
            carga1potencia = 15;
        }else{
            myanswer.setText("");
            Toast.makeText(this,"Unidade(s) inválida(s)", Toast.LENGTH_SHORT).show();
            return;
        }

        int carga2potencia;
        EditText carga2unidadeText = (EditText) findViewById(R.id.unidade2);
        String carga2unidade = carga2unidadeText.getText().toString().toLowerCase().trim();
        if (carga2unidade.equals("")) {
            carga2potencia = 0;
        }else if(carga2unidade.equals("femto")){
            carga2potencia = -15;
        }else if(carga2unidade.equals("pico")){
            carga2potencia = -12;
        }else if(carga2unidade.equals("nano")){
            carga2potencia = -9;
        }else if(carga2unidade.equals("micro")){
            carga2potencia = -6;
        }else if(carga2unidade.equals("mili")){
            carga2potencia = -3;
        }else if(carga2unidade.equals("centi")){
            carga2potencia = -2;
        }else if(carga2unidade.equals("deci")){
            carga2potencia = -1;
        }else if(carga2unidade.equals("deca")){
            carga2potencia = 1;
        }else if(carga2unidade.equals("hecto")){
            carga2potencia = 2;
        }else if(carga2unidade.equals("quilo")){
            carga2potencia = 3;
        }else if(carga2unidade.equals("mega")){
            carga2potencia = 6;
        }else if(carga2unidade.equals("giga")){
            carga2potencia = 9;
        }else if(carga2unidade.equals("tera")){
            carga2potencia = 12;
        }else if(carga2unidade.equals("peta")){
            carga2potencia = 15;
        }else{
            myanswer.setText("");
            Toast.makeText(this,"Unidade(s) inválida(s)", Toast.LENGTH_SHORT).show();
            return;
        }

        int distanciapotencia;
        EditText distanciaunidadeText = (EditText) findViewById(R.id.unidade3);
        String distanciaunidade = distanciaunidadeText.getText().toString().toLowerCase().trim();
        if (distanciaunidade.equals("")){
            distanciapotencia = 0;
        }else if(distanciaunidade.equals("femto")){
            distanciapotencia = -15;
        }else if(distanciaunidade.equals("pico")){
            distanciapotencia = -12;
        }else if(distanciaunidade.equals("nano")){
            distanciapotencia = -9;
        }else if(distanciaunidade.equals("micro")){
            distanciapotencia = -6;
        }else if(distanciaunidade.equals("mili")){
            distanciapotencia = -3;
        }else if(distanciaunidade.equals("centi")){
            distanciapotencia = -2;
        }else if(distanciaunidade.equals("deci")){
            distanciapotencia = -1;
        }else if(distanciaunidade.equals("deca")){
            distanciapotencia = 1;
        }else if(distanciaunidade.equals("hecto")){
            distanciapotencia = 2;
        }else if(distanciaunidade.equals("quilo")){
            distanciapotencia = 3;
        }else if(distanciaunidade.equals("mega")){
            distanciapotencia = 6;
        }else if(distanciaunidade.equals("giga")){
            distanciapotencia = 9;
        }else if(distanciaunidade.equals("tera")){
            distanciapotencia = 12;
        }else if(distanciaunidade.equals("peta")){
            distanciapotencia = 15;
        }else{
            myanswer.setText("");
            Toast.makeText(this,"Unidade(s) inválida(s)", Toast.LENGTH_SHORT).show();
            return;
        }

        int potenciaTotal = (carga1potencia + carga2potencia + kpotencia) +(-2)*(distanciapotencia);

        EditText carga1Text = (EditText) findViewById(R.id.carga1);
        double carga1 = Double.parseDouble(carga1Text.getText().toString());
        EditText carga2Text = (EditText) findViewById(R.id.carga2);
        double carga2 = Double.parseDouble(carga2Text.getText().toString());

        EditText distanciaText = (EditText) findViewById(R.id.distancia1);
        double distancia = Double.parseDouble(distanciaText.getText().toString());

        double valorTotal = ((carga1*carga2)/(distancia*distancia))*knumero;

        String teste = ""+String.format("%.2f",valorTotal)+"x10^("+potenciaTotal+")  N";
        myanswer.setText(teste);
    }
}
