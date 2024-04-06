package hackathon.okrugyuga.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hackathon.okrugyuga.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    init {

        getData()
    }


    private fun getData() {
        _uiState.update {currentState ->
            currentState.copy(
                fetch = true,
            )
        }
        viewModelScope.launch {
            _uiState.update {currentState ->
                currentState.copy(
                    items = listOf(
                        Item(
                            photo = R.drawable.comfort,
                            name = "Комфорт",
                            type = "Стандартный",
                            price = 3000,
                            personCount = 2,
                        ),
                        Item(
                            photo = R.drawable.standart,
                            name = "Стандарт",
                            type = "Стандартный",
                            price = 2000,
                            personCount = 2,
                        )
                    ),
                    fetch = false,
                )
            }
        }
    }
}


data class HomeUiState(
    val fetch: Boolean = false,
    val selectedItem: Int? = null,
    val items: List<Item> = emptyList()

)


data class Item(
    val photo: Int,
    val personCount: Int,
    val price: Int,
    val name: String,
    val type: String,
)
