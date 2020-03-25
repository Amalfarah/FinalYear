package com.example.cs17aaf1.gbvreport;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class location extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;
    String location;
    Address address;
    Address address2;
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
       
        // Add a marker in Sydney and move the camera
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
    }

    private void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
        mGoogleApiClient.connect();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);

        startActivityForResult(intent,0);
        return true;


    }

    public void onBackPressed(){
        Intent intent = new Intent(location.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, (LocationListener) this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    public void onLocationChanged(Location location) {

        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }
        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, (LocationListener) this);
        }

    }

    public void searchLocation(View view) throws IOException {

        send sendcode= new send();

        //Thread t = new Thread();
        EditText locationSearch = (EditText) findViewById(R.id.editText);
        location = locationSearch.getText().toString();
        List<Address> addressList = null;

        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }
            address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title(location));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            Toast.makeText(getApplicationContext(),address.getLatitude()+" "+address.getLongitude(),Toast.LENGTH_LONG).show();
            //mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        }


        EditText newlocation = (EditText) findViewById(R.id.editText1);
        location = newlocation.getText().toString();
        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }
            address2 = addressList.get(0);
            LatLng latLng = new LatLng(address2.getLatitude(), address2.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title(location));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            Toast.makeText(getApplicationContext(),address2.getLatitude()+" "+address2.getLongitude(),Toast.LENGTH_LONG).show();
        }

        sendcode.execute();

        //t.Threed();



    }
    class send extends AsyncTask<Void,Void,Void> {

        Socket s;
        PrintWriter pw;
        PrintWriter pw2;
        Socket w;


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                s = new Socket("134.83.53.199", 1000);
                pw = new PrintWriter(s.getOutputStream());
                pw.write((address.getLatitude()+","+address.getLongitude()));
                pw.flush();
                pw.write((address2.getLatitude()+","+address2.getLongitude()));
                pw.flush();


//                pw = new PrintWriter(String.valueOf(s.getInputStream()));
////                read = new InputStreamReader(s.getInputStream());
////                data = new BufferedReader(read);
//                AlertDialog.Builder alert = new AlertDialog.Builder(MapsActivity.this);
//                alert.setMessage(pw.toString());
//                alert.setPositiveButton("send", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
                pw.close();

                //readserver();

            }
            catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;

        }
//        public void readserver(){
//            try {
//
//
//                read = new InputStreamReader(s.getInputStream());
//                data = new BufferedReader(read);
//                AlertDialog.Builder alert = new AlertDialog.Builder(location.this);
//                alert.setMessage(data.toString());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

    }


    class t extends AsyncTask<Void,Void,Void>{
        InputStreamReader read;
        BufferedReader data;
        Socket w;
        PrintWriter pw2;
        @Override
        protected Void doInBackground(Void... voids) {

            try {
//
                w = new Socket("134.83.53.199", 1000);
                pw2 = new PrintWriter(String.valueOf(w.getInputStream()));
                pw2.println();
                //read = new InputStreamReader(w.getInputStream());
                //data = new BufferedReader(read);
                AlertDialog.Builder alert = new AlertDialog.Builder(location.this);
                alert.setMessage(pw2.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }





            return null;
        }
    }


//    class Thread {
//        Socket s;
//        PrintWriter pw;
//        PrintWriter pw2;
//        public void Threed() {
//
//            Thread t =new Thread();
//            try {
//                s = new Socket("134.83.53.199", 1000);
//                pw = new PrintWriter(s.getOutputStream());
//                pw.write((address.getLatitude()+","+address.getLongitude()));
//                pw.flush();
//                pw.write((address2.getLatitude()+","+address2.getLongitude()));
//                pw.flush();
//                pw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//    }
}
