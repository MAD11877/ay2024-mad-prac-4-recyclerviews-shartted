package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Intent;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    public static ArrayList<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        Random random = new Random();
        userList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int name = new Random().nextInt(999999999);
            int description = new Random().nextInt(999999999);
            boolean followed = new Random().nextBoolean();

            User user = new User("John Doe", "MAD Developer",1,false);
            user.setName("Name"+ String.valueOf(name));
            user.setDescription("Description "+String.valueOf(description));
            user.setFollowed(followed);
            userList.add(user);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        UserAdapter userAdapter = new UserAdapter(userList, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}