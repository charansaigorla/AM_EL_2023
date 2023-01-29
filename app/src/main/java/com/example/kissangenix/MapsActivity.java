package com.example.kissangenix;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.kissangenix.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        // Add a marker in Sydney and move the camera
        LatLng Bengaluru = new LatLng(12.9716, 77.5946);
        mMap.addMarker(new MarkerOptions()
                .position(Bengaluru)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : Rice,Maize,Potato")
                .title("Bengaluru"));
        CircleOptions circl1 = new CircleOptions()
                .center(Bengaluru)
                .radius(20000);

        Circle circle = mMap.addCircle(circl1);
        circle.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bengaluru));

        LatLng Kolar = new LatLng(13.1362, 78.1291);
        mMap.addMarker(new MarkerOptions()
                .position(Kolar)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : Ground nut,Rice")
                .title("Kolar"));
        CircleOptions circl2 = new CircleOptions()
                .center(Kolar)
                .radius(20000);

        Circle cir1 = mMap.addCircle(circl2);
        cir1.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Kolar));


        LatLng Bagalkot = new LatLng(16.1691, 75.6615);
        mMap.addMarker(new MarkerOptions()
                .position(Bagalkot)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : Maize, Wheat, Groundnut, Sunflower,Cotton,SugarCane")
                .title("Bagalkot"));
        CircleOptions circl3 = new CircleOptions()
                .center(Bagalkot)
                .radius(20000);

        Circle cir3 = mMap.addCircle(circl3);
        cir3.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bagalkot));

        LatLng Belgavi = new LatLng(15.8497, 74.4977);
        mMap.addMarker(new MarkerOptions()
                .position(Belgavi)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : jowar,maize,paddy,wheat,bajra,grams")
                .title("Belgavi"));
        CircleOptions circl4 = new CircleOptions()
                .center(Belgavi)
                .radius(20000);

        Circle cir4 = mMap.addCircle(circl4);
        cir4.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Belgavi));


        LatLng Bellary = new LatLng(15.1394, 76.9214);
        mMap.addMarker(new MarkerOptions()
                .position(Bellary)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : cotton,jowar,groundnuts,rice,sunflower")
                .title("Bellary"));
        CircleOptions circl5 = new CircleOptions()
                .center(Bellary)
                .radius(20000);

        Circle cir5 = mMap.addCircle(circl5);
        cir5.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bellary));


        LatLng Bidar = new LatLng(17.9104, 77.5199);
        mMap.addMarker(new MarkerOptions()
                .position(Bidar)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : Greengram,Bengalgram,Blackgram,Paddy,Sugar Cane")
                .title("Bidar"));
        CircleOptions circl6 = new CircleOptions()
                .center(Bidar)
                .radius(20000);

        Circle cir6 = mMap.addCircle(circl6);
        cir6.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bidar));

        LatLng Chamrajnagar = new LatLng(11.9261, 76.9437);
        mMap.addMarker(new MarkerOptions()
                .position(Chamrajnagar)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : Jowar,Ragi,Sugar Cane,Sunflower")
                .title("Chamrajnagar"));
        CircleOptions circl7 = new CircleOptions()
                .center(Chamrajnagar)
                .radius(20000);

        Circle cir7 = mMap.addCircle(circl7);
        cir7.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chamrajnagar));

        LatLng DakshinaKannada = new LatLng(12.8438, 75.2479);
        mMap.addMarker(new MarkerOptions()
                .position(DakshinaKannada)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  Arecanut,Coconut,Pepper,Cashew,Banana,Vegetables")
                .title("DakshinaKannada"));
        CircleOptions circl8 = new CircleOptions()
                .center(DakshinaKannada)
                .radius(20000);

        Circle cir8 = mMap.addCircle(circl8);
        cir8.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(DakshinaKannada));

        LatLng Davangere = new LatLng(14.4644, 75.9218);
        mMap.addMarker(new MarkerOptions()
                .position(Davangere)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  sugarcane,rice,maize")
                .title("Davangere"));
        CircleOptions circl9 = new CircleOptions()
                .center(Davangere)
                .radius(20000);

        Circle cir9 = mMap.addCircle(circl9);
        cir9.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Davangere));

        LatLng Dharwad = new LatLng(15.4589, 75.0078);
        mMap.addMarker(new MarkerOptions()
                .position(Dharwad)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  Mango,Sapota,Rose,Jasmine,Brinjal")
                .title("Dharwad"));
        CircleOptions circl10 = new CircleOptions()
                .center(Dharwad)
                .radius(20000);

        Circle cir10 = mMap.addCircle(circl10);
        cir10.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Dharwad));

        LatLng Hassan = new LatLng(13.0033, 76.1004);
        mMap.addMarker(new MarkerOptions()
                .position(Hassan)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  Coffee,Black Pepper,Potato,Paddy,Sugarcane")
                .title("Hassan"));
        CircleOptions circl11 = new CircleOptions()
                .center(Hassan)
                .radius(20000);

        Circle cir11 = mMap.addCircle(circl11);
        cir11.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Hassan));

        LatLng Shivamogga = new LatLng(13.9299, 75.5681);
        mMap.addMarker(new MarkerOptions()
                .position(Shivamogga)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  paddy,arecanut,cotton,maize,oil seeds,cashewnut,pepper")
                .title("Shivamogga"));
        CircleOptions circl12 = new CircleOptions()
                .center(Shivamogga)
                .radius(20000);

        Circle cir12 = mMap.addCircle(circl12);
        cir12.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Shivamogga));


        LatLng Uttarakannada = new LatLng(14.7937, 74.6869);
        mMap.addMarker(new MarkerOptions()
                .position(Uttarakannada)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  cashew,pineapple,coconut,vanilla")
                .title("UttaraKannada"));
        CircleOptions circl13 = new CircleOptions()
                .center(Uttarakannada)
                .radius(20000);

        Circle cir13 = mMap.addCircle(circl13);
        cir13.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Uttarakannada));

        LatLng Kodagu = new LatLng(12.3375, 75.8069);
        mMap.addMarker(new MarkerOptions()
                .position(Kodagu)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  cashew,pineapple,coconut,vanilla")
                .title("Kodagu"));
        CircleOptions circl14 = new CircleOptions()
                .center(Kodagu)
                .radius(20000);

        Circle cir14 = mMap.addCircle(circl14);
        cir14.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Kodagu));


        LatLng Chitradurga = new LatLng(14.2251, 76.3980);
        mMap.addMarker(new MarkerOptions()
                .position(Chitradurga)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  cashew,pineapple,coconut,vanilla")
                .title("Chitradurga"));
        CircleOptions circl15 = new CircleOptions()
                .center(Chitradurga)
                .radius(20000);

        Circle cir15 = mMap.addCircle(circl15);
        cir15.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chitradurga));


        LatLng Raichur = new LatLng(16.2160, 77.3566);
        mMap.addMarker(new MarkerOptions()
                .position(Raichur)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  rice,cotton,groundnut,pulses")
                .title("Raichur"));
        CircleOptions circl16 = new CircleOptions()
                .center(Raichur)
                .radius(20000);

        Circle cir16 = mMap.addCircle(circl16);
        cir16.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Raichur));

        LatLng Kalaburagi = new LatLng(17.3297, 76.8343);
        mMap.addMarker(new MarkerOptions()
                .position(Kalaburagi)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  rice,cotton,groundnut,pulses")
                .title("Kalaburgi"));
        CircleOptions circl17 = new CircleOptions()
                .center(Kalaburagi)
                .radius(20000);

        Circle cir17 = mMap.addCircle(circl17);
        cir17.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Kalaburagi));
        LatLng Chikkamagaluru = new LatLng(13.3161, 75.7720);
        mMap.addMarker(new MarkerOptions()
                .position(Chikkamagaluru)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : Groundnut, Sesamum, Sunflower, Castor ")
                .title("Chikkamagaluru"));
        CircleOptions circl18 = new CircleOptions()
                .center(Chikkamagaluru)
                .radius(20000);

        Circle cir18 = mMap.addCircle(circl18);
        cir18.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chikkamagaluru));


        LatLng Gadag = new LatLng(15.4315, 75.6355);
        mMap.addMarker(new MarkerOptions()
                .position(Gadag)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  Wheat, Jower, Maize,groundnut,pulses")
                .title("Gadag"));
        CircleOptions circl19 = new CircleOptions()
                .center(Gadag)
                .radius(20000);

        Circle cir19 = mMap.addCircle(circl19);
        cir19.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Gadag));

        LatLng Haveri = new LatLng(14.7951, 75.3991);
        mMap.addMarker(new MarkerOptions()
                .position(Haveri)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  Maize, Paddy, Jowar, Ragi")
                .title("Haveri"));
        CircleOptions circl20 = new CircleOptions()
                .center(Haveri)
                .radius(20000);

        Circle cir20 = mMap.addCircle(circl20);
        cir20.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Haveri));

        LatLng Koppal = new LatLng(15.3505, 76.1567);
        mMap.addMarker(new MarkerOptions()
                .position(Koppal)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : Jawar, Bajra, Wheat, Paddy, Horsegram, Greengram, Cowpeas")
                .title("Koppal"));
        CircleOptions circl21 = new CircleOptions()
                .center(Koppal)
                .radius(20000);

        Circle cir21 = mMap.addCircle(circl21);
        cir21.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Koppal));

        LatLng Mandya = new LatLng(12.5218, 76.8951);
        mMap.addMarker(new MarkerOptions()
                .position(Mandya)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : Ragi, Rice, Sugarcane")
                .title("Mandya"));
        CircleOptions circl22 = new CircleOptions()
                .center(Mandya)
                .radius(20000);

        Circle cir22 = mMap.addCircle(circl22);
        cir22.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Mandya));

        LatLng Ramnagara = new LatLng(12.9716, 77.5946);
        mMap.addMarker(new MarkerOptions()
                .position(Ramnagara)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : Ragi, Rice, Sugarcane")
                .title("Ramnagara"));
        CircleOptions circl23 = new CircleOptions()
                .center(Ramnagara)
                .radius(20000);

        Circle cir23 = mMap.addCircle(circl23);
        cir23.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Ramnagara));

        LatLng Tumakuru = new LatLng(13.3379, 77.1173);
        mMap.addMarker(new MarkerOptions()
                .position(Tumakuru)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : Coconut, Arecanut, Banana, Mango, Sapota, Pomegranate")
                .title("Tumkuru"));
        CircleOptions circl24 = new CircleOptions()
                .center(Tumakuru)
                .radius(20000);

        Circle cir24 = mMap.addCircle(circl24);
        cir24.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Tumakuru));

        LatLng Vijaypura = new LatLng(16.8302, 75.7100);
        mMap.addMarker(new MarkerOptions()
                .position(Vijaypura)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : Jowar, Bajra, Maize, Wheat, Millets, Bengal Gram")
                .title("Vijaypura"));
        CircleOptions circl25 = new CircleOptions()
                .center(Vijaypura)
                .radius(20000);

        Circle cir25 = mMap.addCircle(circl25);
        cir25.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Vijaypura));

        LatLng Yadgiri = new LatLng(16.7626, 77.1442);
        mMap.addMarker(new MarkerOptions()
                .position(Yadgiri)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  Jowar, Red gram, Sunflower, Groundnut")
                .title("Yadgiri"));
        CircleOptions circl26 = new CircleOptions()
                .center(Yadgiri)
                .radius(20000);

        Circle cir26 = mMap.addCircle(circl26);
        cir26.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Yadgiri));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Vijaypura));

        LatLng Chikkaballapur = new LatLng(13.4355, 77.7315);
        mMap.addMarker(new MarkerOptions()
                .position(Chikkaballapur)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  Mango, Grapes, Pomegranate, Sapota, Guava")
                .title("Chikkaballapur"));
        CircleOptions circl27 = new CircleOptions()
                .center(Chikkaballapur)
                .radius(20000);

        Circle cir27 = mMap.addCircle(circl27);
        cir27.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chikkaballapur));

        LatLng Udupi = new LatLng(13.3409, 74.7421);
        mMap.addMarker(new MarkerOptions()
                .position(Udupi)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP :  Coconut, Arecanut, Cashew, Rubber")
                .title("Udupi"));
        CircleOptions circl28 = new CircleOptions()
                .center(Udupi)
                .radius(20000);

        Circle cir28 = mMap.addCircle(circl28);
        cir28.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Udupi));



        LatLng Mysore = new LatLng(12.2958, 76.6394);
        mMap.addMarker(new MarkerOptions()
                .position(Mysore)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.corn))
                .snippet("RECOMENDED CROP : Ragi, Rice, Sugarcane, Sunflower ")
                .title("Mysore"));
        CircleOptions circl30 = new CircleOptions()
                .center(Mysore)
                .radius(20000);

        Circle cir30 = mMap.addCircle(circl30);
        cir30.setFillColor(Color.GREEN);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Mysore));


    }
}