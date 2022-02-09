package com.example.sunlight

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Sunlight.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_choose_mood.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.login_tab_fragement.*
import kotlinx.android.synthetic.main.signup_fragement.*


const val RC_SIGN_IN = 123

class LoginActivity : AppCompatActivity() {
//    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {


        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        login_btn.setOnClickListener {
            when {
                TextUtils.isEmpty(login_email.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "Please Enter Your Email", Toast.LENGTH_SHORT).show()

                }

                TextUtils.isEmpty(login_password.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(this, "Please Enter Your Password", Toast.LENGTH_SHORT).show()

                }


                else-> {
                    val email: String = login_email.text.toString().trim() { it <= ' ' }
                    val password: String = login_password.text.toString().trim() { it <= ' ' }
                   FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!
                                Toast.makeText(
                                    this,
                                    "You Logged in Successfully.",
                                    Toast.LENGTH_SHORT
                                ).show()

                                val intent = Intent(this, choose_mood::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("UserId",
                                    FirebaseAuth.getInstance().currentUser!!.uid
                                    )
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this, task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }


            }
        }


        tv_newuser.setOnClickListener {
            val intent = Intent(this,SignUp_Fragement::class.java)
            startActivity(intent)
        }
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        sign_in_button.visibility = View.VISIBLE

        sign_in_button.setSize(SignInButton.SIZE_STANDARD)
        sign_in_button.setOnClickListener {
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {
            sign_in_button.visibility = View.VISIBLE
            val personName = acct.displayName
            val personGivenName = acct.givenName
            val personFamilyName = acct.familyName
            val personEmail = acct.email
            val personId = acct.id
            val personPhoto: Uri? = acct.photoUrl
        }






    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }
    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            sign_in_button.visibility = View.VISIBLE
            // Signed in successfully, show authenticated UI.
            val intent = Intent(this,choose_mood::class.java)
            intent.putExtra(choose_mood.NAME,account.displayName)
            startActivity(intent)
            finish()


        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            sign_in_button.visibility = View.VISIBLE

        }
    }



}

