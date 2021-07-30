package uz.coderboy.onlineshop.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import uz.coderboy.onlineshop.R
import uz.coderboy.onlineshop.databinding.FragmentHomeBinding
import uz.coderboy.onlineshop.ui.home.adapter.HomeMainAdapter
import uz.coderboy.onlineshop.ui.home.model.HomeMain
import uz.coderboy.onlineshop.ui.home.model.HomeRecommendation

class HomeFragment : Fragment() {

    private val adapter = HomeMainAdapter()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val list = listOf<HomeMain>(
            HomeMain("We recommend",
                listOf<HomeRecommendation>(
                    HomeRecommendation("Arduino", "data:image/jpeg;base64,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", false, 0),
                    HomeRecommendation("Prado shoes", "https://google.com"),
                    HomeRecommendation("Prado shoes", "https://google.com")
                )
            ),
            HomeMain("Popular",
            listOf(
                HomeRecommendation("Arduino", "https://ya.ru", false, 0),
                HomeRecommendation("Prado shoes", "https://google.com"),
                HomeRecommendation("Prado shoes", "https://google.com")
            ))
        )
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())

        adapter.newList(list)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}