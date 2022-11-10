package com.android.dev.tenatapp

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.dev.tenatapp.adapter.RecyclerAdapter
import com.android.dev.tenatapp.model.history
import com.android.dev.tenatapp.payment_section.Paymet_options_Activity

class RecordFragment : Fragment() {

    lateinit var binding: RecordFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_record, container, false)
        val bundle=this.arguments
        val data = ArrayList<history>()
        data.add(history("Rent","for September"," on 20 Aug 2018","\u20B9 6500",
            BitmapFactory.decodeResource(resources,R.drawable.rent)))
        data.add(history("Rent","for September"," on 20 Aug 2018","\u20B9 6500",
            BitmapFactory.decodeResource(resources,R.drawable.rent)))
        data.add(history("Security deposit",""," on 20 Aug 2018","\u20B9 6500",
            BitmapFactory.decodeResource(resources,R.drawable.security)))
        data.add(history("Rent","for September"," on 20 Aug 2018","\u20B9 6500",
            BitmapFactory.decodeResource(resources,R.drawable.rent)))
        data.add(history("Rent","for September"," on 20 Aug 2018","\u20B9 6500",
            BitmapFactory.decodeResource(resources,R.drawable.rent)))
        val total_paid_layout:ConstraintLayout=view.findViewById(R.id.Total_paid_layout)
        val total_due_layout:ConstraintLayout=view.findViewById(R.id.Total_due_layout)
        val pay_now_button:Button=view.findViewById(R.id.record_fragment_pay_now_button)
        if(bundle!=null){
            val type:String=bundle.get("type").toString();
            if(type.equals("dues")){
                pay_now_button.visibility=View.VISIBLE
                val recyclerview=view.findViewById<RecyclerView>(R.id.paid_recycler_view)
                recyclerview.layoutManager = LinearLayoutManager(context)
                val adapter = context?.let { RecyclerAdapter(data, it) }
                recyclerview.adapter = adapter
            }
            else{
                val recyclerview=view.findViewById<RecyclerView>(R.id.paid_recycler_view)
                recyclerview.layoutManager = LinearLayoutManager(context)
                val adapter = context?.let { RecyclerAdapter(data, it) }
                recyclerview.adapter = adapter
            }
        }
        else{
            val recyclerview=view.findViewById<RecyclerView>(R.id.paid_recycler_view)
            recyclerview.layoutManager = LinearLayoutManager(context)
            val adapter = context?.let { RecyclerAdapter(data, it) }
            recyclerview.adapter = adapter
        }
        total_paid_layout.setOnClickListener {
            //call recycler view here that is what is paid till now
            pay_now_button.visibility=View.GONE //pay now button not needed
        }
        total_due_layout.setOnClickListener {
            //show that pay_button which is disable
            pay_now_button.visibility=View.VISIBLE
            //again call recycler view with all due list
            Toast.makeText(context,"due clicked",Toast.LENGTH_LONG).show()
            pay_now_button.setOnClickListener {
                //get the history from all the list of recyclerview according to conditions
                val history_paying:history=data[0]//by default takes from 0th index
                val intent: Intent = Intent(this.context, Paymet_options_Activity::class.java)
                startActivity(intent)
            }
        }

        return view
    }
    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title="Record"
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title="Home"
    }
}