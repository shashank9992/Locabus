package net.ticket.loca.locabus.volley_pack;

import org.json.JSONException;


public interface VolleyResponseListener {
    void onResponse(String response) throws JSONException;

    void onError(String message, String title);


}
