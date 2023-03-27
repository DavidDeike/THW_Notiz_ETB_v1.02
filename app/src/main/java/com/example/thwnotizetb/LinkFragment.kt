package com.example.thwnotizetb

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thwnotizetb.ui.thw.MainViewModel

@Suppress("DEPRECATION")
class LinkFragment : Fragment() {

    companion object {
        fun newInstance() = LinkFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_link, container, false)

        val Link1 = view.findViewById<Button>(R.id.link1_bt)
        val Link2 = view.findViewById<Button>(R.id.link2_bt)
        val Link3 = view.findViewById<Button>(R.id.link3_bt)
        val Link4 = view.findViewById<Button>(R.id.link4_bt)
        val Link5 = view.findViewById<Button>(R.id.link5_bt)





        Link1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.thw.de"))
            startActivity(intent)
        }
        Link2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://extranet.thw.de/cae/servlet/path/common/LoginPages;jsessionid=E02CBDBDA3BDFA986E63B448A500D32C.2_cid379?view=renderLogin"))
            startActivity(intent)
        }
        Link3.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bbk.bund.de/DE/Warnung-Vorsorge/Warn-App-NINA/warn-app-nina_node.html"))
            startActivity(intent)
        }
        Link4.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dwd.de/DE/Home/home_node.html"))
            startActivity(intent)
        }
        Link5.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.divera247.com"))
            startActivity(intent)
        }


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }


}
