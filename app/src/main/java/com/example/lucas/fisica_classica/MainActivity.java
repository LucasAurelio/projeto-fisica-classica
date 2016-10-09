package com.example.lucas.fisica_classica;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                    return "Corrente";
                case 2:
                    return "Magnético";
            }
            return null;
        }
    }

    public void getAnswerForca(View v){
        //CHECAR PRA OBRIGAR A INSERIR
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

        String teste = "F = "+String.format("%.3f",valorTotal)+"x10^("+potenciaTotal+")  N";
        myanswer.setText(teste);
    }

    public void getAnswerDiametro(View v){

        TextView answer = (TextView) findViewById(R.id.answerDiametro);

        EditText testando1 = (EditText) findViewById(R.id.corrente1);
        if(testando1.getText().toString().toLowerCase().trim().equals("")){
            answer.setText("");
            Toast.makeText(this,"Insira o valor da corrente", Toast.LENGTH_SHORT).show();
            return;
        }
        EditText testando2 = (EditText) findViewById(R.id.densidade1);
        if(testando2.getText().toString().toLowerCase().trim().equals("")){
            answer.setText("");
            Toast.makeText(this,"Insira o valor da densidade", Toast.LENGTH_SHORT).show();
            return;
        }

        //unidades valores
        int corrente1potencia;
        EditText corrente1unidadeText = (EditText) findViewById(R.id.unidade4);
        String corrente1unidade = corrente1unidadeText.getText().toString().toLowerCase().trim();
        if (corrente1unidade.equals("")){
            corrente1potencia = 0;
        }else if(corrente1unidade.equals("femto")){
            corrente1potencia = -15;
        }else if(corrente1unidade.equals("pico")){
            corrente1potencia = -12;
        }else if(corrente1unidade.equals("nano")){
            corrente1potencia = -9;
        }else if(corrente1unidade.equals("micro")){
            corrente1potencia = -6;
        }else if(corrente1unidade.equals("mili")){
            corrente1potencia = -3;
        }else if(corrente1unidade.equals("centi")){
            corrente1potencia = -2;
        }else if(corrente1unidade.equals("deci")){
            corrente1potencia = -1;
        }else if(corrente1unidade.equals("deca")){
            corrente1potencia = 1;
        }else if(corrente1unidade.equals("hecto")){
            corrente1potencia = 2;
        }else if(corrente1unidade.equals("quilo")){
            corrente1potencia = 3;
        }else if(corrente1unidade.equals("mega")){
            corrente1potencia = 6;
        }else if(corrente1unidade.equals("giga")){
            corrente1potencia = 9;
        }else if(corrente1unidade.equals("tera")){
            corrente1potencia = 12;
        }else if(corrente1unidade.equals("peta")){
            corrente1potencia = 15;
        }else{
            answer.setText("");
            Toast.makeText(this,"Unidade(s) inválida(s)", Toast.LENGTH_SHORT).show();
            return;
        }

        int densidade1potencia1;
        EditText densidade1unidade1Text = (EditText) findViewById(R.id.unidade5);
        String densidade1unidade1 = densidade1unidade1Text.getText().toString().toLowerCase().trim();
        if (densidade1unidade1.equals("")){
            densidade1potencia1 = 0;
        }else if(densidade1unidade1.equals("femto")){
            densidade1potencia1 = -15;
        }else if(densidade1unidade1.equals("pico")){
            densidade1potencia1 = -12;
        }else if(densidade1unidade1.equals("nano")){
            densidade1potencia1 = -9;
        }else if(densidade1unidade1.equals("micro")){
            densidade1potencia1 = -6;
        }else if(densidade1unidade1.equals("mili")){
            densidade1potencia1 = -3;
        }else if(densidade1unidade1.equals("centi")){
            densidade1potencia1 = -2;
        }else if(densidade1unidade1.equals("deci")){
            densidade1potencia1 = -1;
        }else if(densidade1unidade1.equals("deca")){
            densidade1potencia1 = 1;
        }else if(densidade1unidade1.equals("hecto")){
            densidade1potencia1 = 2;
        }else if(densidade1unidade1.equals("quilo")){
            densidade1potencia1 = 3;
        }else if(densidade1unidade1.equals("mega")){
            densidade1potencia1 = 6;
        }else if(densidade1unidade1.equals("giga")){
            densidade1potencia1 = 9;
        }else if(densidade1unidade1.equals("tera")){
            densidade1potencia1 = 12;
        }else if(densidade1unidade1.equals("peta")){
            densidade1potencia1 = 15;
        }else{
            answer.setText("");
            Toast.makeText(this,"Unidade(s) inválida(s)", Toast.LENGTH_SHORT).show();
            return;
        }

        int densidade1potencia2;
        EditText densidade1unidade2Text = (EditText) findViewById(R.id.unidade6);
        String densidade1unidade2 = densidade1unidade2Text.getText().toString().toLowerCase().trim();
        if (densidade1unidade2.equals("")){
            densidade1potencia2 = 0;
        }else if(densidade1unidade2.equals("femto")){
            densidade1potencia2 = -15;
        }else if(densidade1unidade2.equals("pico")){
            densidade1potencia2 = -12;
        }else if(densidade1unidade2.equals("nano")){
            densidade1potencia2 = -9;
        }else if(densidade1unidade2.equals("micro")){
            densidade1potencia2 = -6;
        }else if(densidade1unidade2.equals("mili")){
            densidade1potencia2 = -3;
        }else if(densidade1unidade2.equals("centi")){
            densidade1potencia2 = -2;
        }else if(densidade1unidade2.equals("deci")){
            densidade1potencia2 = -1;
        }else if(densidade1unidade2.equals("deca")){
            densidade1potencia2 = 1;
        }else if(densidade1unidade2.equals("hecto")){
            densidade1potencia2 = 2;
        }else if(densidade1unidade2.equals("quilo")){
            densidade1potencia2 = 3;
        }else if(densidade1unidade2.equals("mega")){
            densidade1potencia2 = 6;
        }else if(densidade1unidade2.equals("giga")){
            densidade1potencia2 = 9;
        }else if(densidade1unidade2.equals("tera")){
            densidade1potencia2 = 12;
        }else if(densidade1unidade2.equals("peta")){
            densidade1potencia2 = 15;
        }else{
            answer.setText("");
            Toast.makeText(this,"Unidade(s) inválida(s)", Toast.LENGTH_SHORT).show();
            return;
        }

        int potenciaIntermediaria = corrente1potencia+((-1)*(densidade1potencia1+((-1)*(densidade1potencia2+densidade1potencia2))));

        EditText corrente1Text = (EditText) findViewById(R.id.corrente1);
        double corrente1 = Double.parseDouble(corrente1Text.getText().toString());
        EditText densidade1Text = (EditText) findViewById(R.id.densidade1);
        double densidade1 = Double.parseDouble(densidade1Text.getText().toString());

        double valorTotal = 2*(Math.sqrt(corrente1/(densidade1*Math.PI)));

        int potenciaTotal;
        if(potenciaIntermediaria%2!=0){
            potenciaIntermediaria = potenciaIntermediaria-1;
            valorTotal = valorTotal*10;
            potenciaTotal = potenciaIntermediaria/2;
        }else{
            potenciaTotal = potenciaIntermediaria/2;
        }

        String resposta = "D = "+String.format("%.3f",valorTotal)+"x10^("+potenciaTotal+")  m";

        answer.setText(resposta);
    }

    public void getAnswerResistencia(View v){

        TextView myAnswer = (TextView) findViewById(R.id.answerResistencia);

        EditText testando1 = (EditText) findViewById(R.id.resistencia1);
        if(testando1.getText().toString().toLowerCase().trim().equals("")){
            myAnswer.setText("");
            Toast.makeText(this,"Insira o valor da resistência 1", Toast.LENGTH_SHORT).show();
            return;
        }

        EditText testando2 = (EditText) findViewById(R.id.resistencia2);
        myAnswer.setText("");
        if(testando2.getText().toString().toLowerCase().trim().equals("")){
            Toast.makeText(this,"Insira o valor da resistência 2", Toast.LENGTH_SHORT).show();
            return;
        }

        //unidades valores
        /*
        int resistencia1potencia;
        EditText resistencia1unidadeText = (EditText) findViewById(R.id.unidade5);
        String resistencia1unidade = resistencia1unidadeText.getText().toString().toLowerCase().trim();
        if (resistencia1unidade.equals("")){
            resistencia1potencia = 0;
        }else if(resistencia1unidade.equals("femto")){
            resistencia1potencia = -15;
        }else if(resistencia1unidade.equals("pico")){
            resistencia1potencia = -12;
        }else if(resistencia1unidade.equals("nano")){
            resistencia1potencia = -9;
        }else if(resistencia1unidade.equals("micro")){
            resistencia1potencia = -6;
        }else if(resistencia1unidade.equals("mili")){
            resistencia1potencia = -3;
        }else if(resistencia1unidade.equals("centi")){
            resistencia1potencia = -2;
        }else if(resistencia1unidade.equals("deci")){
            resistencia1potencia = -1;
        }else if(resistencia1unidade.equals("deca")){
            resistencia1potencia = 1;
        }else if(resistencia1unidade.equals("hecto")){
            resistencia1potencia = 2;
        }else if(resistencia1unidade.equals("quilo")){
            resistencia1potencia = 3;
        }else if(resistencia1unidade.equals("mega")){
            resistencia1potencia = 6;
        }else if(resistencia1unidade.equals("giga")){
            resistencia1potencia = 9;
        }else if(resistencia1unidade.equals("tera")){
            resistencia1potencia = 12;
        }else if(resistencia1unidade.equals("peta")){
            resistencia1potencia = 15;
        }else{
            myAnswer.setText("");
            Toast.makeText(this,"Unidade(s) inválida(s)", Toast.LENGTH_SHORT).show();
            return;
        }

        int resistencia2potencia;
        EditText resistencia2unidadeText = (EditText) findViewById(R.id.unidade6);
        String resistencia2unidade = resistencia2unidadeText.getText().toString().toLowerCase().trim();
        if (resistencia2unidade.equals("")){
            resistencia2potencia = 0;
        }else if(resistencia2unidade.equals("femto")){
            resistencia2potencia = -15;
        }else if(resistencia2unidade.equals("pico")){
            resistencia2potencia = -12;
        }else if(resistencia2unidade.equals("nano")){
            resistencia2potencia = -9;
        }else if(resistencia2unidade.equals("micro")){
            resistencia2potencia = -6;
        }else if(resistencia2unidade.equals("mili")){
            resistencia2potencia = -3;
        }else if(resistencia2unidade.equals("centi")){
            resistencia2potencia = -2;
        }else if(resistencia2unidade.equals("deci")){
            resistencia2potencia = -1;
        }else if(resistencia2unidade.equals("deca")){
            resistencia2potencia = 1;
        }else if(resistencia2unidade.equals("hecto")){
            resistencia2potencia = 2;
        }else if(resistencia2unidade.equals("quilo")){
            resistencia2potencia = 3;
        }else if(resistencia2unidade.equals("mega")){
            resistencia2potencia = 6;
        }else if(resistencia2unidade.equals("giga")){
            resistencia2potencia = 9;
        }else if(resistencia2unidade.equals("tera")){
            resistencia2potencia = 12;
        }else if(resistencia2unidade.equals("peta")){
            resistencia2potencia = 15;
        }else{
            myAnswer.setText("");
            Toast.makeText(this,"Unidade(s) inválida(s)", Toast.LENGTH_SHORT).show();
            return;
        }

        int potenciaTotal = (resistencia1potencia + resistencia2potencia)+(-1)*(resistencia1potencia);
         */

        EditText resistencia1text = (EditText) findViewById(R.id.resistencia1);
        double resistencia1 = Double.parseDouble(resistencia1text.getText().toString());
        EditText resistencia2text = (EditText) findViewById(R.id.resistencia2);
        double resistencia2 = Double.parseDouble(resistencia2text.getText().toString());

        double valorTotal = (resistencia1*resistencia2)/(resistencia1+resistencia2);


        String resposta = "R = "+String.format("%.3f",valorTotal)+" Ω";

        TextView answer = (TextView) findViewById(R.id.answerResistencia);
        answer.setText(resposta);
    }
}
