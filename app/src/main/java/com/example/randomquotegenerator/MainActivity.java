package com.example.randomquotegenerator;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private Button newQuoteButton;
    private Button shareQuoteButton;

    private String[] quotes = {
            "'The only way to do great work is to love what you do. –   Steve Jobs'",
            "'Life is what happens when you’re busy making other plans'. –  John Lennon",
            "'The purpose of our lives is to be happy'. –   Dalai Lama",
            "'Get busy living or get busy dying'. –   Stephen King",
            "'You have within you right now, everything you need to deal with whatever the world can throw at you'. –   Brian Tracy",
            "'Success is most often achieved by those who don't know that failure is inevitable.' -   Coco Chanel",
            "'Take up one idea. Make that one idea your life  think of it, dream of it, live on that idea. Let the brain, muscles, nerves, every part of your body be full of that idea, and just leave every other idea alone. This is the way to success.' -     Swami Vivekananda",
            "All our dreams can come true if we have the courage to pursue them. -      Walt Disney",
            "Success is walking from failure to failure with no loss of enthusiasm. -     Winston Churchill",
            "Someone is sitting in the shade today because someone planted a tree a long time ago. -    Warrent buffet",
            "There is no easy walk to freedom anywhere, and many of us will have to pass through the valley of the shadow of death again and again before we reach the mountaintop of our desires. -     Nelson Mandela",
            "Live as if you were to die tomorrow. Learn as if you were to live forever.- Mahatma Gandhi"
    };

    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        newQuoteButton = findViewById(R.id.newQuoteButton);
        shareQuoteButton = findViewById(R.id.shareQuoteButton);

        newQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewQuote();
            }
        });

        shareQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareQuote();
            }
        });

        // Generate the first quote
        generateNewQuote();
    }

    private void generateNewQuote() {
        String newQuote = quotes[random.nextInt(quotes.length)];
        quoteTextView.setText(newQuote);
    }

    private void shareQuote() {
        String quote = quoteTextView.getText().toString();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, quote);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}
