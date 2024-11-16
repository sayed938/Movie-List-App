package com.example.movielistapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.domain.entity.DetailsModel
import com.example.domain.entity.ImagesModel
import com.example.movielistapp.R
import com.example.movielistapp.databinding.FragmentDetailsBinding
import com.example.movielistapp.databinding.FragmentMainBinding
import com.example.movielistapp.ui.appdata.AppData
import com.example.movielistapp.ui.viewmodel.DetailsViewModel
import com.example.movielistapp.ui.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {
    private lateinit var movieId: String
    private lateinit var binding: FragmentDetailsBinding
    private val movieDetailsModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = DetailsFragmentArgs.fromBundle(requireArguments())
        movieId = args.movieId
        movieDetailsModel.getMovieImages(movieId)
        lifecycleScope.launch {
            movieDetailsModel.movieImages.collect {
                withContext(Dispatchers.Main) {
                    if (it == null) {
                        delay(1000)
                    } else {
                        imageSlider(it)
                    }
                }
            }
        }
        movieDetailsModel.getMovieDetails(movieId)
        lifecycleScope.launch {
            movieDetailsModel.movieDetails.collect {
                withContext(Dispatchers.Main) {
                    if (it == null) {
                        delay(1000)
                    } else {
                        binding.progressBar.visibility = View.INVISIBLE
                        binding.detailsMovieTitle.text = it.title
                        binding.movieDetailsBody.text = it.overview
                        binding.detailsMovieVote.text = it.vote_average.toString()
                    }

                }
            }
        }

    }

    fun imageSlider(it: ImagesModel) {
        val imageList = ArrayList<SlideModel>()
        imageList.add(
            SlideModel(
                AppData.baseImgUrl + it.posters[0].file_path
            )
        )
        imageList.add(
            SlideModel(
                AppData.baseImgUrl + it.posters[1].file_path

            )
        )
        imageList.add(
            SlideModel(
                AppData.baseImgUrl + it.posters[2].file_path
            )
        )
        binding.detailsImageSlider.setImageList(
            imageList, ScaleTypes.FIT
        )
    }
}