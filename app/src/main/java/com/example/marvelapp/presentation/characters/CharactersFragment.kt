package com.example.marvelapp.presentation.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
//import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.example.core.domain.model.Character
import com.example.marvelapp.databinding.FragmentCharactersBinding
import com.example.marvelapp.framework.imageloader.ImageLoader
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val binding: FragmentCharactersBinding get() = _binding!!

    //private val viewModel: CharactersViewModel by viewModels()

    //@Inject
    //lateinit var imageLoader: ImageLoader

    //private lateinit var charactersAdapter: CharactersAdapter
    private var charactersAdapter: CharactersAdapter = CharactersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharactersBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCharactersAdapter()
        observeInitialLoadState()

        @Suppress("MaxLineLength")
        charactersAdapter.submitList(listOf(
            Character(0,"Spider Man", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pocket-lint.com%2Fpt-br%2Ftv%2Fnoticias%2Fsony%2F159643-como-transmitir-o-homem-aranha-no-way-home-at-home-data-de-lancamento-aluguel-comprar&psig=AOvVaw1mgC9L_JPIch9TCbxQy1xF&ust=1648646698726000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCIitx9m16_YCFQAAAAAdAAAAABAD"),
            Character(0,"Spider Man", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pocket-lint.com%2Fpt-br%2Ftv%2Fnoticias%2Fsony%2F159643-como-transmitir-o-homem-aranha-no-way-home-at-home-data-de-lancamento-aluguel-comprar&psig=AOvVaw1mgC9L_JPIch9TCbxQy1xF&ust=1648646698726000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCIitx9m16_YCFQAAAAAdAAAAABAD"),
            Character(0,"Spider Man", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pocket-lint.com%2Fpt-br%2Ftv%2Fnoticias%2Fsony%2F159643-como-transmitir-o-homem-aranha-no-way-home-at-home-data-de-lancamento-aluguel-comprar&psig=AOvVaw1mgC9L_JPIch9TCbxQy1xF&ust=1648646698726000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCIitx9m16_YCFQAAAAAdAAAAABAD"),
            Character(0,"Spider Man", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pocket-lint.com%2Fpt-br%2Ftv%2Fnoticias%2Fsony%2F159643-como-transmitir-o-homem-aranha-no-way-home-at-home-data-de-lancamento-aluguel-comprar&psig=AOvVaw1mgC9L_JPIch9TCbxQy1xF&ust=1648646698726000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCIitx9m16_YCFQAAAAAdAAAAABAD")
        ))

        //lifecycleScope.launch {
        //    viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
        //        viewModel.charactersPagingData("").collect { pagingData ->
        //            charactersAdapter.submitData(pagingData)
        //        }
        //    }
        //}
    }

    private fun initCharactersAdapter() {
//        charactersAdapter = CharactersAdapter(imageLoader) { character, view ->
//            val extras = FragmentNavigatorExtras(
//                view to character.name
//            )
//
//            val directions = CharactersFragmentDirections
//                .actionCharactersFragmentToDetailFragment(
//                    character.name,
//                    DetailViewArg(
//                        characterId = character.id,
//                        name = character.name,
//                        imageUrl = character.imageUrl
//                    )
//                )
//
//            findNavController().navigate(directions, extras)
//        }

        with(binding.recyclerCharacters) {
            scrollToPosition(0)
            setHasFixedSize(true)
            adapter = charactersAdapter
//                .withLoadStateFooter(
//                footer = CharactersLoadStateAdapter(
//                    charactersAdapter::retry
//                )
//            )
        }
    }

    private fun observeInitialLoadState() {
//        lifecycleScope.launch {
//            charactersAdapter.loadStateFlow.collectLatest { loadState ->
//                binding.flipperCharacters.displayedChild = when (loadState.refresh) {
//                    is LoadState.Loading -> {
//                        setShimmerVisibility(true)
//                        FLIPPER_CHILD_LOADING
//                    }
//                    is LoadState.NotLoading -> {
//                        setShimmerVisibility(false)
//                        FLIPPER_CHILD_CHARACTERS
//                    }
//                    is LoadState.Error -> {
//                        setShimmerVisibility(false)
//                        binding.includeViewCharactersErrorState.buttonRetry.setOnClickListener {
//                            charactersAdapter.retry()
//                        }
//                        FLIPPER_CHILD_ERROR
//                    }
//                }
//            }
//        }
    }
    @Suppress("UnusedPrivateMember")
    private fun setShimmerVisibility(visibility: Boolean) {
//        binding.includeViewCharactersLoadingState.shimmerCharacters.run {
//            isVisible = visibility
//            if (visibility) {
//                startShimmer()
//            } else stopShimmer()
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    @Suppress("UnusedPrivateMember")
    companion object {
        private const val FLIPPER_CHILD_LOADING = 0
        private const val FLIPPER_CHILD_CHARACTERS = 1
        private const val FLIPPER_CHILD_ERROR = 2
    }
}
