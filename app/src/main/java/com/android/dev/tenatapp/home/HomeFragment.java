package com.android.dev.tenatapp.home;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.dev.tenatapp.MainActivity;
import com.android.dev.tenatapp.R;
import com.android.dev.tenatapp.RecordFragment;
import com.android.dev.tenatapp.adapter.MenuAdapter;
import com.android.dev.tenatapp.databinding.FragmentHomeBinding;
import com.android.dev.tenatapp.model.Menu;
import com.android.dev.tenatapp.model.history;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    MenuAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        loadMenuRecyclerView();
        return binding.getRoot();
    }

    private void loadMenuRecyclerView() {
        ArrayList<Menu> menuList = new ArrayList<Menu>() {{
            add(new Menu("Breakfast", "8:00AM - 11:00AM", R.drawable.ic_breakfast));
            add(new Menu("Lunch", "12:00PM - 3:00PM", R.drawable.ic_lunch));
            add(new Menu("Dinner", "8:00PM - 10:00PM", R.drawable.ic_dinner));
        }};
        adapter = new MenuAdapter(menuList);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.mCardAddComplaints.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_complaintsFragment);
            }
        });
        binding.lateCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)
                        getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.late_check_in_popup, null);
                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ImageButton close=v.findViewById(R.id.close_button);
                        close.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                popupWindow.dismiss();
                            }
                        });
                        MaterialButton materialButton=v.findViewById(R.id.inform_button);
                        materialButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //send to backend
                                Toast.makeText(getActivity(), "inform clicked", Toast.LENGTH_SHORT).show();
                                popupWindow.dismiss();//close window
                            }
                        });
                        return true;
                    }
                });
            }
        });
        binding.leavingProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)
                        getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.leaving_property, null);
                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        ImageButton close=v.findViewById(R.id.close_button);
                        close.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                popupWindow.dismiss();
                            }
                        });
                        MaterialButton materialButton=v.findViewById(R.id.inform_button);
                        materialButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //send to backend
                                popupWindow.dismiss();//close window
                            }
                        });
                        return true;
                    }
                });

            }
        });
        binding.rlTotalPaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("type","paid");
                RecordFragment record=new RecordFragment();
                record.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, record).commit();
            }
        });
        binding.totalDues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("type","dues");
                RecordFragment record=new RecordFragment();
                record.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, record).commit();
            }
        });
    }


        @Override
        public void onDestroyView () {
            super.onDestroyView();
            binding = null;
        }
    }


/*    DisplayMetrics displayMetrics = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels/2;
        Toast.makeText(getContext(), "width "+width, Toast.LENGTH_SHORT).show();*/


/*

    ViewGroup.LayoutParams testingLayoutParams = binding.btnTesting.getLayoutParams();
    ViewGroup.LayoutParams originalLayoutParams = binding.btnOriginal.getLayoutParams();
//Button new width
        testingLayoutParams.width = originalLayoutParams.width;
                binding.btnTesting.setLayoutParams(testingLayoutParams);*/
