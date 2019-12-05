package net.ticket.loca.locabus.volley_pack;

import org.json.JSONArray;
import org.json.JSONException;


public interface VolleyArrayResponseListener {
    void onResponse(JSONArray response) throws JSONException;

    void onError(String message, String title);


}
