package com.shs.date

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shs.date.databinding.FragmentCreateBinding
import com.shs.date.model.Event
import java.time.LocalDate

class CreateFragment() : Fragment() {
    private lateinit var event: Event

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCreateBinding>(
            inflater, R.layout.fragment_create, container, false
        )
        binding.calendarButton.setOnClickListener {
            // DatePickerDialog
            val today: LocalDate = LocalDate.now()

            val dialog = DatePickerDialog(requireContext(), listener, today.year, today.monthValue, today.dayOfMonth)
            dialog.show()
        }
        binding.titleEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               if (s != null) {
                   event = event.copy(title = s.toString())
               }
            }
        })

        binding.memoEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    event = event.copy(memo = s.toString())
                }
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private val listener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
        Toast.makeText(
            requireContext().applicationContext,
            "$year 년 $monthOfYear 월 $dayOfMonth 일",
            Toast.LENGTH_SHORT
        ).show();
    }

}
