package com.example.theapp

import android.view.View
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val backgroundImages = listOf(
        R.drawable.bg_1,
        R.drawable.bg_2,
        R.drawable.bg_3,
        R.drawable.bg_4,
        R.drawable.bg_5,
        R.drawable.bg_6,
        R.drawable.bg_7,
        R.drawable.bg_8,
        R.drawable.bg_9,
        R.drawable.bg_10,
        R.drawable.bg_11,
        R.drawable.bg_12,
        R.drawable.bg_13
    )

    private val gradientDrawables = listOf(
        R.drawable.gradient1,
        R.drawable.gradient2,
        R.drawable.gradient3,
        R.drawable.gradient4
    )

    private val textColors = listOf(
        Color.BLACK,
        Color.WHITE,
        Color.WHITE,
        Color.BLACK
    )

    private val quotes = listOf(
        "Breathe. \n- Earth",
        "There is a world beyond ours, a world that is far away, nearby and invisible. \n- Maria Sabina",
        "If you Say it, it Won\'t happen. \n- Anonymous",
        "Be Here Now. \n- Ram Dass",
        "Use this moment to the hilt. And don\'t be afraid of what other people think of it. \n- Ram Dass",
        "What you need is Courage… and then to pay attention, and make of it what you will. \n- Dennis McKenna",
        "Approach life, from a non-fearful perspective, intending to learn, and extract benefit from this experience. \n- Hamilton Morris",
        "How long will this last, this delicious feeling of being alive, of having penetrated the veil which hides and the wonders of celestial vistas? It doesn\'t matter, as there can be nothing but gratitude for even a glimpse of what exists for those who can become open to it. \n- Sasha Shulgin",
        "There\'s no end. There no death. Consciousness goes on, and This is It. \n- Kilindi Iyi",
        "You are an explorer, and you represent our species, and the greatest good you can do is bring back a new idea, because our world is endangered of the absence of consciousness. \n- Terrence McKenna",
        "Everything is trying to prove the perfection of it\'s own perception. \n- Juris Ahn",
        "Evoke the Muse, not the Algorithm. \n- Gwyllm Llwydd",
        "In the province of the mind what one believes to be true, either is true or becomes true within certain limits. These limits are to be found experimentally and experientially. When so found these limits turn out to be further beliefs to be transcended. \n- John C. Lilly",
        "You\'re either On The Bus or You\'re Off The Bus. \n- Merry Pranksters",
        "Wake up to find out that You Are the Eyes of the World. \n- Grateful Dead",
        "Open up to the possibility that everything you know right now is wrong. \n- Terrence McKenna",
        "Free The Imagination. \n- Dale Pendell",
        "Drop Out; Tune In; Drop In. \n- Timothy Leary & Co.",
        "Pain is the First Teacher we Deny. \n- Dale Pendell",
        "Go Against the Flow. \n- Nasim Jah",
        "Cure yourself with the light of the sun and the rays of the moon. \nWith the sound of the river and the waterfall. \nWith the swaying of the sea and the fluttering of birds. \nHeal yourself with mint, with neem and eucalyptus. \nSweeten yourself with lavender, rosemary, and chamomile. \nHug yourself with the cocoa bean and a touch of cinnamon. \nPut love in tea instead of sugar, and take it looking at the stars. \nHeal yourself with the kisses that the wind gives you and the hugs of the rain. \nGet strong with bare feet on the ground and with everything that is born from it. \nGet smarter every day by listening to your intuition. \n- Maria Sabina",
        "This is The Beginning of the Beginning of the End of the Beginning. \n- Robbie Robertson",
        "Progress isn't only in the thing that's visible. \n- Bhavana K",
        "It's like we're walking on the ground we see from the air. \n- Anonymous",
        "There's more than This One way of seeing the world, that you see Now. \n- James Lawler",
        "Question the rules of the game you're Now finding yourself in. \n- Terrence McKenna",
        "Fungi are the interface organism between life and death. \n- Paul Stamets",
        "C\'est lá que je vivrai jusqu\'à ce que je meurs. \n- 61)A3HT3TA3W",
        "If This wasn't real, It would be the craziest Experience ever. \n- Joe Rogan",
        "The opposite of spiritual is not material but egotistical. \n- Michael Pollan",
        "To be more sensitive to pleasure is to be more sensitive to pain. \n- Alan W. Watts",
        "Living in the Now is the best planning you can do for the future. \n- Alan W. Watts",
        "You\'re only as Present and Free as the last time you changed your mind. Right now. \n- Timothy Leary",
        "Whether you experience heaven or hell, remember that it is your mind which is creating them Now. \n- Timothy Leary",
        "Change appears as life itself; Life and change are interchangeable and interdependent. \n- Ram Dass",
        "The problem right Now is not to find the answer; it's Here, and to face this answer. \n- Terrence McKenna",
        "We don't see things as they are, we see them as we are in this Moment. \n- Anaïs Nin",
        "Throw your dreams into space and Trust in what it is that comes back. \n- Anaïs Nin",
        "The forest is not only good to eat but good to think. \n- Unknown",
        "Have you lost contact with living nature? \n- Albert Hofmann",
        "Go out of your mind, and use your head. \n- Timothy Leary",
        "To be Enlightened just be a completely ordinary person. \n- Veronique Vienne",
        "Accept the universe as matter expanding into nothing - nothing that is something, and perform all acts with ease. \n- Albert Einstein",
        "We are all practicing Death right Now. \n- Anonymous",
        "All great music is one way or another Life-Changing and Mind-Changing. \n- Genesis P-Orridge",
        "You\'re seeing the Void, and part of it is coming back with you forever. \n- Ricky & Peggy-Sue Jones",
        "More people should experience Life and Reality. Find your prescription Now. \n- George Carlin",
        "Free-thinkers are more difficult to manipulate and control, which begs the question: right Now- Are You? \n- Zoe Helene",
        "We Laugh as We Do Not Know. \n- Anonymous",
        "You are Now at the Edge. Leap and Find the Treasure. \n- Salvador Dali",
        "Time is a Hummingbird and I am the Nectar in the belly. \n- Anonymous",
        "Begin, right Now, as if for the very first time. \n- Sam Harris",
        "To know not Knowing is most intimate. \n- Old Dizang",
        "Close your eyes. See your Inner Being in detail. \n- Lakshmanjoo",
        "This Universe before your eyes- it is all a Dance. See it as such and Breathe. \n- Red Pine",
        "Love and Sex are not Evil because all that Perceives is the Mind. Is your Mind your own? \n- Crazy Cloud",
        "Right Now, It is an It because it is enough to be you. \n- Crazy Cloud",
        "Pink is the Most True Color. \n- Little Stonehouse",
        "Right now This is the phase of Amplification - distinguish the Signal from the Noise and receive the Message. \n- Claude E. Shanon",
        "42. \n- Douglas Adams",
        "What is This? \n- Dongshan",
        "You Are Not The Target! \n- Laura Archera Huxley",
        "The story you are experiencing now is an ice cube- something frozen from before you remember. Right now- Melt the ice cube. \n- Laura Archera Huxley",
        "Dive Deeper into Darkness. \n- Zenju Earthlyn Manuel",
        "Do not try to be the fastest. \n- Atisha",
        "Abandon All hope of Achievement. \n- Atisha",
        "Do not expect any applause. \n- Atisha",
        "The Demon is the Ally. \n- Vajrayogini",
        "In this Instant, Do No Harm, to others and to yourself. \n- Jessica Graham",
        "This moment And Every single moment is a chance to experience Freedom and Reality. There is no distinction between a Future in which we are Free and Realising that We Are Free, Right Now. \n- Sam Harris",
        "Surf the waves of emotion you face now, rather than letting them engulf you. \n- Arlene Englander",
        "Always maintain only a Joyful Mind. \n- Atisha"

    )

    private lateinit var quoteOfTheDay: String
    private val SHARED_PREFS = "sharedPrefs"
    private val LAST_QUOTE_TIME = "lastQuoteTime"

    private var currentGradientIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val pillButton: ImageButton = findViewById(R.id.button_TopLeft)
        val centerText: TextView = findViewById(R.id.centerText)
        val nowButton: Button = findViewById(R.id.button_Now)
        val surpriseButton: Button = findViewById(R.id.button_Surprise)
        val mainLayout: ConstraintLayout = findViewById(R.id.main)
        val backgroundImageView: ImageView = findViewById(R.id.backgroundImage)
        val infoButton: ImageButton = findViewById(R.id.button_info)
        val infoBox: TextView = findViewById(R.id.infoBubble)

        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        quoteOfTheDay = getQuoteOfTheDay(sharedPreferences)

        fun updateBackgroundImage() { // Function for the Surprise Button + troubleshoot why this function requires to be inside the OnCreate function
            val randomImage = backgroundImages.random()
            val drawable: Drawable? = ContextCompat.getDrawable(this, randomImage)

            drawable?.let {
                backgroundImageView.setImageDrawable(it)
                backgroundImageView.alpha = 0.28f // Adjust transparency
            }
        }

        centerText.text = quoteOfTheDay
        mainLayout.setBackgroundColor(gradientDrawables[0])
        centerText.setTextColor(textColors[0])
        backgroundImageView.setImageResource(R.drawable.bg_0)

        pillButton.setOnClickListener {
            mainLayout.setBackgroundResource(gradientDrawables[currentGradientIndex])
            centerText.setTextColor(textColors[currentGradientIndex])
            currentGradientIndex = (currentGradientIndex + 1) % gradientDrawables.size
        }

        infoButton.setOnClickListener {
            if (infoBox.visibility == View.GONE) {
                infoBox.visibility = View.VISIBLE
            } else {
                infoBox.visibility = View.GONE
            }
        }

        mainLayout.setOnClickListener {
            if (infoBox.visibility == View.VISIBLE) {
                infoBox.visibility = View.GONE
            }
        }

        nowButton.setOnClickListener {
            centerText.text = quoteOfTheDay
        }

        surpriseButton.setOnClickListener {
            centerText.text = getRandomQuote()
            updateBackgroundImage()
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        }
    private fun getRandomQuote(): String {
        return quotes[Random.nextInt(quotes.size)]
    }

    private fun getQuoteOfTheDay(sharedPreferences: SharedPreferences): String {
        val currentTimeMillis = System.currentTimeMillis()
        val lastQuoteTime = sharedPreferences.getLong(LAST_QUOTE_TIME, 0)

        return if ((currentTimeMillis - lastQuoteTime) >= TimeUnit.HOURS.toMillis(11)) {
            // 24 hours have passed, get a new quote
            val newQuote = getRandomQuote()
            sharedPreferences.edit().putString("quoteOfTheDay", newQuote).apply()
            sharedPreferences.edit().putLong(LAST_QUOTE_TIME, currentTimeMillis).apply()
            newQuote
        } else {
            // Use the same quote
            sharedPreferences.getString("quoteOfTheDay", getRandomQuote()) ?: getRandomQuote()
        }
    }

    }
