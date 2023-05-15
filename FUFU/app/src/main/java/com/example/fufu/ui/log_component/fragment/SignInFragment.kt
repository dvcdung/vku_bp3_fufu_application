package com.example.fufu.ui.log_component.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.fufu.R

class SignInFragment : Fragment() {

    private lateinit var btnSignIn: Button

    private lateinit var edtAccountLog: EditText
    private lateinit var edtPassLog: EditText

    private lateinit var email: String
    private lateinit var pass: String

    private lateinit var tvError: TextView
    private lateinit var progressBar: ProgressBar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        btnSignIn.setOnClickListener {
            email = edtAccountLog.text.toString()
            pass = edtPassLog.text.toString()
            progressBar.visibility = View.VISIBLE
            tvError.visibility = View.GONE
            val queue: RequestQueue = Volley.newRequestQueue(context)
            val url = "http://192.168.1.8/fufuAPI/signIn.php"
            val stringRequest = object : StringRequest(
                Method.POST, url,
                Response.Listener<String> { response ->
                    progressBar.visibility = View.GONE

                },
                Response.ErrorListener { error ->
                    progressBar.visibility = View.GONE
                    tvError.text = error.localizedMessage
                    tvError.visibility = View.VISIBLE
                }) {
                override fun getParams(): Map<String, String> {
                    val params: MutableMap<String, String> = HashMap()
                    params["email"] = email
                    params["pass"] = pass
                    return params
                }
            }
            queue.add(stringRequest)
        }
    }

    private fun initView(){
        btnSignIn = view?.findViewById(R.id.btnSignIn)!!
        edtAccountLog = view?.findViewById(R.id.edtAccountLogIn)!!
        edtPassLog = view?.findViewById(R.id.edtPassLogIn)!!
        tvError = view?.findViewById(R.id.tvErrorLog)!!
        progressBar = view?.findViewById(R.id.progressBarLog)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

}