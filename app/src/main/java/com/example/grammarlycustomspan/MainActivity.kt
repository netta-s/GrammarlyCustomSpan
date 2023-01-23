package com.example.grammarlycustomspan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import androidx.core.content.ContextCompat
import androidx.core.text.toSpanned
import androidx.core.text.getSpans
import androidx.core.widget.doOnTextChanged
import com.example.grammarlycustomspan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        binding.editText.doOnTextChanged { text, _, _, _ ->
            val spans = text?.toSpanned()?.getSpans<CustomSpan>() ?: emptyArray()
            binding.data.text = "CustomSpan count: ${spans.size}"
        }

        binding.addSpan.setOnClickListener {
            val color = ContextCompat.getColor(this, R.color.purple_700)
            val span = CustomSpan(color, CustomData("bar"))
            val spannable = SpannableString("my span").apply {
                setSpan(span, 0, length, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            binding.editText.editableText.insert(
                binding.editText.editableText.length,
                spannable
            )
        }
    }
}