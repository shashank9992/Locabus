package net.ticket.loca.locabus.volley_pack;

import org.json.JSONException;
import org.json.JSONObject;


public interface VolleyObjectResponseListener {
    void onResponse(JSONObject response) throws JSONException;

    void onError(String message, String title, int status);


}
