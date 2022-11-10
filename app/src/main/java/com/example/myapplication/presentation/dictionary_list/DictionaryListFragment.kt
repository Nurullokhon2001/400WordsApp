package com.example.myapplication.presentation.dictionary_list

import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentDictionaryListBinding
import com.example.myapplication.presentation.adapter.DictionaryListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DictionaryListFragment : Fragment() {

    private var _binding: FragmentDictionaryListBinding? = null
    private val binding get() = _binding!!
    private var mp: MediaPlayer? = null

    private val adapter by lazy {
        DictionaryListAdapter(
            tableListClickListener = {
//           val action = ElementListFragmentDirections.actionElementListFragmentToDetailsFragment(it)
//           findNavController().navigate(action)
                viewModel.getSound(it!!)
            }
        )
    }
    private val viewModel by viewModels<DictionaryListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDictionaryListBinding.inflate(layoutInflater, container, false)
        viewModel.getVocabulary().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        binding.list.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val menuHost: MenuHost = requireActivity()

        viewModel.sound.observe(viewLifecycleOwner) {
           it?.let {
               audioPlayer(it.path)
           }
        }

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_menu, menu)
                val searchItem = menu.findItem(R.id.action_search)
                val searchView = searchItem.actionView as SearchView
                searchView.queryHint = "Калимаро ворид кунед"
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        Log.e("onQueryTextSubmit", "onQueryTextSubmit: $query")
                        return true
                    }

                    override fun onQueryTextChange(newText: String): Boolean {
                        if (newText.isNotEmpty()) {
                            val new = "%$newText%"
                            viewModel.searchVocabulary(new).observe(viewLifecycleOwner) {
                                adapter.submitList(it)
                            }
                        } else {
                            viewModel.getVocabulary().observe(viewLifecycleOwner) {
                                adapter.submitList(it)
                            }
                        }
                        Log.e("onQueryTextSubmit", "onQueryTextChange: $newText")
                        return true
                    }
                })
                searchView.isIconified = false
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                when (menuItem.itemId) {
                    R.id.action_search -> {
                    }
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun audioPlayer(fullPath: String) {
        try {
            if (mp != null) {
                mp?.stop()
                mp?.release()
                mp = null
            }
            mp = MediaPlayer()
            val decs: AssetFileDescriptor = requireContext().resources.assets.openFd(fullPath)
            mp?.setDataSource(decs.fileDescriptor, decs.startOffset, decs.length)
            decs.close()
            mp?.prepare()
            mp?.setVolume(1f, 1f)
            mp?.isLooping = false

            mp?.start()
        } catch (ex: Exception) {
            Log.i("", ex.message!!)
        }
    }

    override fun onDestroyView() {
        mp = null
        viewModel.getSound(1000)
        super.onDestroyView()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}