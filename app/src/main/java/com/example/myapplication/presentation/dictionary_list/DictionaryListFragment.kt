package com.example.myapplication.presentation.dictionary_list

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
import com.example.myapplication.presentation.adapter.TableListAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DictionaryListFragment : Fragment() {

    private var _binding: FragmentDictionaryListBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy {
        TableListAdapter(
            tableListClickListener = {
//           val action = ElementListFragmentDirections.actionElementListFragmentToDetailsFragment(it)
//           findNavController().navigate(action)
            }
        )
    }
    private val viewModel by viewModels<DictionaryListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDictionaryListBinding.inflate(layoutInflater, container, false)
        viewModel.getTableList().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        binding.list.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_menu, menu)
                val searchItem = menu.findItem(R.id.action_search)
                val searchView = searchItem.actionView as SearchView
                searchView.queryHint = "Search People"
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        Log.e("onQueryTextSubmit", "onQueryTextSubmit: $query ")
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        Log.e("onQueryTextSubmit", "onQueryTextChange: $newText ")
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

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}