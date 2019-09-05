package com.shs.date

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shs.date.databinding.FragmentCreateBinding
import com.shs.date.model.Event
import java.time.LocalDate

class CreateFragment() : Fragment() {
    private lateinit var event: Event
    private var binding: FragmentCreateBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        event = Event("", "", "", "")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCreateBinding>(
            inflater, R.layout.fragment_create, container, false
        )
        this.binding = binding
        binding.startDateButton.setOnClickListener {
            // DatePickerDialog
            val today: LocalDate = LocalDate.now()
            val dialog = DatePickerDialog(requireContext(), startDateListener, today.year, today.monthValue - 1 , today.dayOfMonth)
            dialog.show()
        }
        binding.endDateButton.setOnClickListener {
            val today: LocalDate = LocalDate.now()
            val dialog = DatePickerDialog(requireContext(), endDateListener, today.year, today.monthValue - 1, today.dayOfMonth)
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

        binding.createButton.setOnClickListener {
            Toast.makeText(requireContext(), event.toString(), Toast.LENGTH_LONG).show()
//            Thread().run {
//                AppDatabase.getInstances(requireContext().applicationContext).eventDao().insertAll(event)
//            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    /**
     *  val df: DateFormat = SimpleDateFormat("yyyy-MM-dd")
    val selectedDate = df.parse("$year-$monthOfYear-$dayOfMonth")

     */
    private val startDateListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
        event = event.copy(startDate = "$year-${monthOfYear + 1}-$dayOfMonth")
        binding?.startDateButton?.text = event.startDate
    }

    private val endDateListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
        event = event.copy(endDate = "$year-${monthOfYear + 1}-$dayOfMonth")
        binding?.endDateButton?.text = event.endDate
    }

}
