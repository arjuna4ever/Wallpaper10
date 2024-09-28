package com.example.wallpaperv2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
ImageView i;
Button a,b;
int images[]= {R.drawable.shogun,R.drawable.cynthia,R.drawable.snow,R.drawable.kartik};
int current_index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        i = findViewById(R.id.im);
        a =findViewById(R.id.b1);
        b = findViewById(R.id.b2);
        i.setImageResource(images[current_index]);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 current_index = (current_index - 1 + images.length) % images.length;
                 i.setImageResource(images[current_index]);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_index = (current_index + 1 ) % images.length;
                i.setImageResource(images[current_index]);
            }
        });
    }
}