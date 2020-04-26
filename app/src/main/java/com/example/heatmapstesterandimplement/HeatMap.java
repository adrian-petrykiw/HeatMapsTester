package com.example.heatmapstesterandimplement;
import android.graphics.Color;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.Gradient;
import com.google.maps.android.heatmaps.HeatmapTileProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class HeatMap extends MapsActivity {

    private static final int ALT_HEATMAP_RADIUS = 10;

    private static final double ALT_HEATMAP_OPACITY = 0.4;

    private static final int[] ALT_HEATMAP_GRADIENT_COLORS = {
            Color.argb(0, 0, 255, 255),// transparent
            Color.argb(255 / 3 * 2, 0, 255, 255),
            Color.rgb(0, 191, 255),
            Color.rgb(0, 0, 127),
            Color.rgb(255, 0, 0)
    };
    public static final float[] ALT_HEATMAP_GRADIENT_START_POINTS = {
            0.0f, 0.10f, 0.20f, 0.60f, 1.0f
    };
    public static final Gradient ALT_HEATMAP_GRADIENT = new Gradient(ALT_HEATMAP_GRADIENT_COLORS,
            ALT_HEATMAP_GRADIENT_START_POINTS);
    private HeatmapTileProvider mProvider;
    private TileOverlay mOverlay;
    private LatLng latlng = new LatLng(40.7484, 73.9857);
    private List<LatLng> coordinates  = new ArrayList<LatLng>();

    public void addHeatMap() {
        coordinates.add(latlng);
        mProvider = new HeatmapTileProvider.Builder().data(coordinates).gradient(ALT_HEATMAP_GRADIENT).build();
        mOverlay = getmMap().addTileOverlay(new TileOverlayOptions().tileProvider(mProvider));
    }



}
