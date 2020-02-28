package com.example.cs17aaf1.map;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String site;
    String site2;

    String a;
    String b;
    double lat;
    double lng;
    String c;
    String d;


    String e;
    String f;
    double lat2;
    double lng2;
    String g;
    String h;
    double lat3;
    double lng3;
    String i;
    String j;
    double lat4;
    double lng4;
    String k;
    String l;
    double lat5;
    double lng5;
    String m;
    String n;
    double lat6;
    double lng6;
    String o;
    String p;
    double lat7;
    double lng7;
    String q;
    String r;
    double lat8;
    double lng8;
    String s;
    String t;
    double lat9;
    double lng9;
    String w;
    String v;
    double lat10;
    double lng10;
    String x;
    String y;
    double lat11;
    double lng11;
    String z;
    String a1;
    double lat12;
    double lng12;
    double lat13;
    double lng13;
    double lat14;
    double lng14;
    double lat15;
    double lng15;
    double lat16;
    double lng16;
    double lat17;
    double lng17;
    double lat18;
    double lng18;
    double lat19;
    double lng19;
    double lat20;
    double lng20;
    double lat21;
    double lng21;
    double lat22;
    double lng22;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        csv();
        LatLng one = new LatLng(lat,lng);
        mMap.addMarker(new MarkerOptions().position(one).title(site).snippet(a));
        mMap.addMarker(new MarkerOptions().position(one).title(site2).snippet(b).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(one));

        LatLng two = new LatLng(lat2,lng2);
        mMap.addMarker(new MarkerOptions().position(two).title(site).snippet(c));
        mMap.addMarker(new MarkerOptions().position(two).title(site2).snippet(d).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(two));
//
        LatLng three = new LatLng(lat3,lng3);
        mMap.addMarker(new MarkerOptions().position(three).title(site).snippet(e));
        mMap.addMarker(new MarkerOptions().position(three).title(site2).snippet(f).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(three));
//
        LatLng four = new LatLng(lat4,lng4);
        mMap.addMarker(new MarkerOptions().position(four).title(site).snippet(g));
        mMap.addMarker(new MarkerOptions().position(four).title(site2).snippet(h).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(four));

        LatLng five = new LatLng(lat5,lng5);
        mMap.addMarker(new MarkerOptions().position(five).title(site).snippet(i));
        mMap.addMarker(new MarkerOptions().position(five).title(site2).snippet(j).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(five));

        LatLng six = new LatLng(lat6,lng6);
        mMap.addMarker(new MarkerOptions().position(six).title(site).snippet(k));
        mMap.addMarker(new MarkerOptions().position(six).title(site2).snippet(l).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(six));

        LatLng seven = new LatLng(lat7,lng7);
        mMap.addMarker(new MarkerOptions().position(seven).title(site).snippet(m));
        mMap.addMarker(new MarkerOptions().position(seven).title(site2).snippet(n).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seven));

        LatLng eight = new LatLng(lat8,lng8);
        mMap.addMarker(new MarkerOptions().position(eight).title(site).snippet(o));
        mMap.addMarker(new MarkerOptions().position(eight).title(site2).snippet(p).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(eight));

        LatLng nine = new LatLng(lat9,lng9);
        mMap.addMarker(new MarkerOptions().position(nine).title(site).snippet(q));
        mMap.addMarker(new MarkerOptions().position(nine).title(site2).snippet(r).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nine));


    }
    public void csv(){

        InputStream inputStream = null;
        try {
            //inputStream = new FileInputStream("f.csv");
            InputStreamReader is = new InputStreamReader(getAssets().open("f.csv"));
            BufferedReader reader = new BufferedReader(is);


            String line = "";
            while ((line = reader.readLine()) != null){
                String [] data = line.split(",");

                //y = Double.parseDouble(data[0]);
                //b = Double.toString(y);


                site = String.valueOf(data[0]);
                site2 = String.valueOf(data[1]);

                a = String.valueOf(data[2]);
                b = String.valueOf(data[3]);
                lat = Double.parseDouble(data [4]);
                lng = Double.parseDouble(data [5]);

//
                c = String.valueOf(data[6]);
                d = String.valueOf(data[7]);
                lat2 = Double.parseDouble(data[8]);
                lng2 = Double.parseDouble(data[9]);

                //ttt= String.valueOf(data[12]);
                //hhh= String.valueOf(data[13]);
                e = String.valueOf(data[10]);;
                f = String.valueOf(data[11]);;
                lat3=Double.parseDouble(data[12]);
                lat3=Double.parseDouble(data[13]);

                //nnnn=String.valueOf(data[18]);
                //ooo= String.valueOf(data[19]);
                g= String.valueOf(data[14]);;
                h = String.valueOf(data[15]);;
                lat4=Double.parseDouble(data[16]);
                lng4=Double.parseDouble(data[17]);


                i= String.valueOf(data[18]);
                j= String.valueOf(data[19]);
                lat5 = Double.parseDouble(data[20]);
                lng5 = Double.parseDouble(data[21]);

                k = String.valueOf(data[22]);
                l = String.valueOf(data[23]);
                lat6 = Double.parseDouble(data[24]);
                lng6 = Double.parseDouble(data[25]);


                m = String.valueOf(data[26]);
                n=String.valueOf(data[27]);
                lat7 = Double.parseDouble(data[28]);
                lng7 = Double.parseDouble(data[29]);

                o = String.valueOf(data[30]);
                p=String.valueOf(data[31]);
                lat8 = Double.parseDouble(data[32]);
                lng8 = Double.parseDouble(data[33]);

                q=String.valueOf(data[34]);
                r =String.valueOf(data[35]);
                lat9 = Double.parseDouble(data[36]);
                lng9 = Double.parseDouble(data[37]);

//                s = String.valueOf(data[38]);
//                t=String.valueOf(data[39]);
//                lat10 = Double.parseDouble(data[40]);
//                lng10 = Double.parseDouble(data[41]);






            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
