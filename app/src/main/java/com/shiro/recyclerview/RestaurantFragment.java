package com.shiro.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class RestaurantFragment extends Fragment {

    public RecyclerView recyclerView;

    public MyRestaurantRecyclerViewAdapter restaurantAdapter;

    public List<Restaurant> restaurantList;

    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestaurantFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //Restaurant list
            this.restaurantList = new ArrayList<>();
            this.restaurantList.add(new Restaurant(1, "Casa Chano", "https://diariodeavisos.elespanol.com/wp-content/uploads/2016/11/guachinche-tenerife.jpg", (float) 4.0, "Calle la Chicha, Tenerife"));
            this.restaurantList.add(new Restaurant(1, "Bar McLolo", "https://rentacar.canarias.com/blog/wp-content/uploads/guachinche-e1495188818933.jpg", (float) 2.9, "Santa Ursula, Tenerife"));
            this.restaurantList.add(new Restaurant(1, "La Huerta de Adán", "https://2.bp.blogspot.com/-QBS-04DzGPU/WQWa5Mo7rFI/AAAAAAAAB1c/7vSwpT5GmVYbU6ROHtvDBYuNMjsxCrurACLcB/s1600/costillas-a-la-brasa-con-papas.jpg", (float) 4.7, "La Matanza, Tenerife"));
            this.restaurantList.add(new Restaurant(1, "El caserío", "https://imgs-akamai.mnstatic.com/84/2b/842bfd12ff27309a97fd82dea4082c37.jpg", (float) 5.0, "La Perdoma, Tenerife"));
            // we associate the adapter to the recycler view
            restaurantAdapter = new MyRestaurantRecyclerViewAdapter(this.restaurantList, mListener);
            recyclerView.setAdapter(restaurantAdapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Restaurant item);
    }
}
