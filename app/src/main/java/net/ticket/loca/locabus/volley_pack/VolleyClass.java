package net.ticket.loca.locabus.volley_pack;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;
import cn.pedant.SweetAlert.SweetAlertDialog;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.*;
import com.android.volley.request.JsonArrayRequest;
import com.android.volley.request.JsonObjectRequest;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyClass {
    private Context act;
    private String TAG = "";
    String networkErrorMessage = "Network error – please try again.";
    String poorNetwork = "Your data connection is too slow – please try again when you have a better network connection";
    String timeout = "Response timed out – please try again.";
    String authorizationFailed = "Authorization failed – please try again.";
    String serverNotResponding = "Server not responding – please try again.";
    String parseError = "JSON data not received from server – please try again.";
    String networkErrorTitle = "Network error";
    String poorNetworkTitle = "Poor Network Connection";
    String timeoutTitle = "Network Error";
    String authorizationFailedTitle = "Network Error";
    String serverNotRespondingTitle = "Server Error";
    String parseErrorTitle = "Network Error";
    String otherErrorTitle="Error";
    String otherError="Something went wrong!";
    RequestQueue queue;

    public VolleyClass(Context context) {
        this.act = context;
        queue = Volley.newRequestQueue(context); //instantiate the request queue
//        this.TAG = TAG + " WebService";
    }

    public void volleyPostArrayData(final String url, JSONArray jsonArray, final VolleyArrayResponseListener listener) {

        final ProgressDialog pDialog = new ProgressDialog(act);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        //CHECKING IF APP IS ONLINE
        if (isOnline()) {

            JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.POST,
                    url, jsonArray,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.e(TAG, "volleyPostData response - " + response.toString());
                            try {
                                listener.onResponse(response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                pDialog.dismiss();
                            } catch (Exception e) {
                                Log.e(TAG, e.getMessage());
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    try {
                        pDialog.dismiss();
                    } catch (Exception e) {
                        Log.e(TAG, e.getMessage());
                    }
                    if (error instanceof TimeoutError) {
                        listener.onError(timeout, timeoutTitle);
                    } else if (error instanceof NoConnectionError) {
                        listener.onError(poorNetwork, poorNetworkTitle);
                    } else if (error instanceof AuthFailureError) {
                        listener.onError(authorizationFailed, authorizationFailedTitle);
                    } else if (error instanceof ServerError) {
                        listener.onError(serverNotResponding, serverNotRespondingTitle);
                    } else if (error instanceof NetworkError) {
                        listener.onError(networkErrorMessage, networkErrorTitle);
                    } else if (error instanceof ParseError) {
                        listener.onError(parseError, parseErrorTitle);
                    }
                }

            }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap();
//                headers.put("appId",app_id );
                return headers;
            }};
            int MY_SOCKET_TIMEOUT_MS = 30000;
            jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(MY_SOCKET_TIMEOUT_MS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            queue.add(jsonObjReq); // adding the request object to request queue.
        } else {

        }
    }

    public void volleyGetData(final String url, final VolleyArrayResponseListener listener) {


        //CHECKING IF APP IS ONLINE
        if (isOnline()) {

            //CREATING A JSONObject Request
            JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET,
                    url, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.e(TAG, "volleyPostData response - " + response.toString());
                            try {
                                listener.onResponse(response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    try {

                    } catch (Exception e) {
                        Log.e(TAG, e.getMessage());
                    }
                    if (error instanceof TimeoutError) {
                        listener.onError(timeout, timeoutTitle);
                    } else if (error instanceof NoConnectionError) {
                        listener.onError(poorNetwork, poorNetworkTitle);
                    } else if (error instanceof AuthFailureError) {
                        listener.onError(authorizationFailed, authorizationFailedTitle);
                    } else if (error instanceof ServerError) {
                        listener.onError(serverNotResponding, serverNotRespondingTitle);
                    } else if (error instanceof NetworkError) {
                        listener.onError(networkErrorMessage, networkErrorTitle);
                    } else if (error instanceof ParseError) {
                        listener.onError(parseError, parseErrorTitle);
                    }
                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap();
//                    headers.put("appId",app_id );
                    return headers;
                }};
            int MY_SOCKET_TIMEOUT_MS = 30000;
            jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(MY_SOCKET_TIMEOUT_MS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)); // setting default retry policy.
            queue.add(jsonObjReq); // adding the request object to request queue.
        } else {

        }
    }

    public void volleyJsonObjectPostData(final String url, JSONObject jsonObject, final VolleyObjectResponseListener listener) {


        if (isOnline()) {

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.e(TAG, "volleyPostData response - " + response.toString());
                            try {
                                listener.onResponse(response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    int status=0;
                    if (error.networkResponse!=null){
                        status=error.networkResponse.statusCode;
                    }
                    if (error instanceof TimeoutError) {
                        listener.onError(timeout, timeoutTitle,status);
                    } else if (error instanceof NoConnectionError) {
                        listener.onError(poorNetwork, poorNetworkTitle,status);
                    } else if (error instanceof AuthFailureError) {
                        listener.onError(authorizationFailed, authorizationFailedTitle,status);
                    } else if (error instanceof ServerError) {
                        listener.onError(serverNotResponding, serverNotRespondingTitle,status);
                    } else if (error instanceof NetworkError) {
                        listener.onError(networkErrorMessage, networkErrorTitle,status);
                    } else if (error instanceof ParseError) {
                        listener.onError(parseError, parseErrorTitle,status);
                    }
                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap();
//                    headers.put("appId",app_id );
                    return headers;
                }};
            int MY_SOCKET_TIMEOUT_MS = 30000;
            jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(MY_SOCKET_TIMEOUT_MS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)); // setting default retry policy.
            queue.add(jsonObjReq); // adding the request object to request queue.
        } else {

        }
    }

    public void volleyJsonObjectGetData(final String url, final String token, JSONObject jsonObject, final VolleyObjectResponseListener listener) {


        if (isOnline()) {

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                    url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.e(TAG, "volleyPostData response - " + response.toString());
                            try {
                                listener.onResponse(response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    int status=0;
                    if (error.networkResponse!=null){
                        status=error.networkResponse.statusCode;
                    }
                    if (error instanceof TimeoutError) {
                        listener.onError(timeout, timeoutTitle,status);

                    } else if (error instanceof NoConnectionError) {
                        listener.onError(poorNetwork, poorNetworkTitle,status);


                    } else if (error instanceof AuthFailureError) {
                        listener.onError(authorizationFailed, authorizationFailedTitle,status);

                    } else if (error instanceof ServerError) {
                        listener.onError(serverNotResponding, serverNotRespondingTitle,status);

                    } else if (error instanceof NetworkError) {
                        listener.onError(networkErrorMessage, networkErrorTitle,status);

                    } else if (error instanceof ParseError) {
                        listener.onError(parseError, parseErrorTitle,status);

                    }
                    else {
                        listener.onError(otherError,otherErrorTitle,status);

                    }


                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap();
                    headers.put("access-token",token );
                    return headers;
                }};
            int MY_SOCKET_TIMEOUT_MS = 30000;
            jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(MY_SOCKET_TIMEOUT_MS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)); // setting default retry policy.
            queue.add(jsonObjReq); // adding the request object to request queue.
        }
        else {

            Toast.makeText(act, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void volleyJsonStringGetData(final String url, final VolleyResponseListener listener) {

        final SweetAlertDialog pDialog = new SweetAlertDialog(act, SweetAlertDialog.PROGRESS_TYPE);
        final SweetAlertDialog pErrDialog=new SweetAlertDialog(act, SweetAlertDialog.ERROR_TYPE);
        pDialog.setTitleText("Loading...");
        pDialog.setCancelable(false);

        //CHECKING IF APP IS ONLINE
        if (isOnline()) {

            //CREATING A JSONObject Request
            StringRequest jsonObjReq = new StringRequest(
                    url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.e(TAG, "volleyPostData response - " + response.toString());
                            try {
                                listener.onResponse(response);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                pDialog.dismiss();
                            } catch (Exception e) {
                                Log.e(TAG, e.getMessage());
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    try {
                        pDialog.dismiss();
                    } catch (Exception e) {
                        Log.e(TAG, e.getMessage());
                    }

                    if(!((Activity) act).isFinishing())
                    {
                        pErrDialog.show();
                    }



                    if (error instanceof TimeoutError) {
                        listener.onError(timeout, timeoutTitle);
                        pErrDialog.setTitleText(timeoutTitle);
                        pErrDialog.setContentText(timeout);
                    } else if (error instanceof NoConnectionError) {
                        listener.onError(poorNetwork, poorNetworkTitle);
                        pErrDialog.setTitleText(poorNetworkTitle);
                        pErrDialog.setContentText(poorNetwork);
                    } else if (error instanceof AuthFailureError) {
                        listener.onError(authorizationFailed, authorizationFailedTitle);
                        pErrDialog.setTitleText(authorizationFailedTitle);
                        pErrDialog.setContentText(authorizationFailed);
                    } else if (error instanceof ServerError) {
                        listener.onError(serverNotResponding, serverNotRespondingTitle);
                        pErrDialog.setTitleText(serverNotRespondingTitle);
                        pErrDialog.setContentText(serverNotResponding);
                    } else if (error instanceof NetworkError) {
                        listener.onError(networkErrorMessage, networkErrorTitle);
                        pErrDialog.setTitleText(networkErrorTitle);
                        pErrDialog.setContentText(networkErrorMessage);
                    } else if (error instanceof ParseError) {
                        listener.onError(parseError, parseErrorTitle);
                        pErrDialog.setTitleText(parseErrorTitle);
                        pErrDialog.setContentText(parseError);
                    }
                    else {
                        listener.onError(otherError,otherErrorTitle);
                        pErrDialog.setTitleText(otherErrorTitle);
                        pErrDialog.setContentText(otherError);
                    }

                    if (error.networkResponse.statusCode==400){



                        listener.onError(timeout, timeoutTitle);
                        pErrDialog.setTitleText(timeoutTitle);
                        pErrDialog.setContentText(error.toString());


                    }
                    pErrDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {

                            pErrDialog.dismiss();
                        }
                    });
                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap();
//                    headers.put("appId",app_id );
                    return headers;
                }};
            int MY_SOCKET_TIMEOUT_MS = 30000;
            jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(MY_SOCKET_TIMEOUT_MS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)); // setting default retry policy.
            queue.add(jsonObjReq); // adding the request object to request queue.
        } else {

        }
    }



//    public void volleyJsonPut(final String url, JSONObject jsonObject, final VolleyObjectResponseListener listener) {
//
//        final SweetAlertDialog pDialog = new SweetAlertDialog(act, SweetAlertDialog.PROGRESS_TYPE);
//        final SweetAlertDialog pErrDialog=new SweetAlertDialog(act, SweetAlertDialog.ERROR_TYPE);
//        pDialog.setTitleText("Loading...");
//        pDialog.setCancelable(false);
//        Log.e(TAG, "volleyPostData request url - " + url);
//
//        //CHECKING IF APP IS ONLINE
//        if (isOnline()) {
//            try {
//                pDialog.show();
//            } catch (Exception e) {
//                Log.e(TAG, e.getMessage());
//            }
//            //CREATING A JSONObject Request
//            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.PUT,
//                    url, jsonObject,
//                    new Response.Listener<JSONObject>() {
//                        @Override
//                        public void onResponse(JSONObject response) {
//                            Log.e(TAG, "volleyPostData response - " + response.toString());
//                            try {
//                                listener.onResponse(response);
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                            try {
//                                pDialog.dismiss();
//                            } catch (Exception e) {
//                                Log.e(TAG, e.getMessage());
//                            }
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    try {
//                        pDialog.dismiss();
//                    } catch (Exception e) {
//                        Log.e(TAG, e.getMessage());
//                    }
//                    pErrDialog.show();
//                    if (error instanceof TimeoutError) {
//                        listener.onError(timeout, timeoutTitle,);
//                        pErrDialog.setTitleText(timeoutTitle);
//                        pErrDialog.setContentText(timeout);
//                    } else if (error instanceof NoConnectionError) {
//                        listener.onError(poorNetwork, poorNetworkTitle);
//                        pErrDialog.setTitleText(poorNetworkTitle);
//                        pErrDialog.setContentText(poorNetwork);
//                    } else if (error instanceof AuthFailureError) {
//                        listener.onError(authorizationFailed, authorizationFailedTitle);
//                        pErrDialog.setTitleText(authorizationFailedTitle);
//                        pErrDialog.setContentText(authorizationFailed);
//                    } else if (error instanceof ServerError) {
//                        listener.onError(serverNotResponding, serverNotRespondingTitle);
//                        pErrDialog.setTitleText(serverNotRespondingTitle);
//                        pErrDialog.setContentText(serverNotResponding);
//                    } else if (error instanceof NetworkError) {
//                        listener.onError(networkErrorMessage, networkErrorTitle);
//                        pErrDialog.setTitleText(networkErrorTitle);
//                        pErrDialog.setContentText(networkErrorMessage);
//                    } else if (error instanceof ParseError) {
//                        listener.onError(parseError, parseErrorTitle);
//                        pErrDialog.setTitleText(parseErrorTitle);
//                        pErrDialog.setContentText(parseError);
//                    }
//                    else {
//                        listener.onError(otherError,otherErrorTitle);
//                        pErrDialog.setTitleText(otherErrorTitle);
//                        pErrDialog.setContentText(otherError);
//                    }
//
//                    pErrDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                        @Override
//                        public void onClick(SweetAlertDialog sweetAlertDialog) {
//
//                            pErrDialog.dismiss();
//                        }
//                    });
//                }
//            });
//            int MY_SOCKET_TIMEOUT_MS = 30000;
//            jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(MY_SOCKET_TIMEOUT_MS,
//                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)); // setting default retry policy.
//            queue.add(jsonObjReq); // adding the request object to request queue.
//        }
//    }



    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) act.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}
