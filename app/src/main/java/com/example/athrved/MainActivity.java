package com.example.athrved;


import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;



public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;


  static final int GOOGLE_SIGN_IN = 123;
    FirebaseAuth mAuth;
    Button signinbutton;
    TextView text;
    ImageView image;





  /*  @Override
    protected void onStart() {
        super.onStart();
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser!=null){
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
            finish();
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        signinbutton = findViewById(R.id.login);
        text = findViewById(R.id.text);
        image = findViewById(R.id.image);


               /* mAuth = FirebaseAuth.getInstance();

                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.default_web_client_id))
                        .requestEmail()
                        .build();

                mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

              signinbutton.setOnClickListener(v -> SignInGoogle());


               if (mAuth.getCurrentUser() != null) {
                    FirebaseUser user = mAuth.getCurrentUser();

                }
            }

            public void SignInGoogle() {

                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, GOOGLE_SIGN_IN);
            }

            private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
                Log.d("TAG", "firebaseAuthWithGoogle:" + acct.getId());

                AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
                mAuth.signInWithCredential(credential)
                        .addOnCompleteListener(this, task -> {
                            if (task.isSuccessful()) {


                                Log.d("TAG", "signInWithCredential:success");

                                FirebaseUser user = mAuth.getCurrentUser();

                            } else {


                                Log.w("TAG", "signInWithCredential:failure", task.getException());

                                Toast.makeText(MainActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        });
            }

       @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);

                if (requestCode == GOOGLE_SIGN_IN) {
                    Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                    try {
                        GoogleSignInAccount account = task.getResult(ApiException.class);
                        if (account != null) firebaseAuthWithGoogle(account);
                    } catch (ApiException e) {
                        Log.w("TAG", "Google sign in failed", e);
                    }}
                }


           private void updateUI(FirebaseUser user) {
                if (user != null) {
                    String name = user.getDisplayName();
                    String email = user.getEmail();


                } else {
                    text.setText("Firebase Login \n");


                }}*/

    }



    public void insta (View v){
        Uri uri = Uri.parse("https://instagram.com/edathrv?igshid=6jwvnb00xf8u");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void website (View v){


        Uri uri = Uri.parse("https://athrved.com/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    @Override
    public void onBackPressed () {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();


        } else {

            backToast = Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT);


            backToast.show();
            backPressedTime = System.currentTimeMillis();
        }}
    public void next (View v){
       startActivity(new Intent(MainActivity.this,Main2Activity.class));
    }
}