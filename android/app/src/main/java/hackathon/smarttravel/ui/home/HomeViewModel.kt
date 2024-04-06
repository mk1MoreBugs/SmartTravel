package hackathon.smarttravel.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hackathon.smarttravel.R
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
                            photo = R.drawable.dzhubga,
                            city = "Джубга",
                            type = "Гэмплинг",
                        ),
                        Item(
                            photo = R.drawable.dzhanhot,
                            city = "Джанхот",
                            type = "Гэмплинг",
                        ),
                        Item(
                            photo = R.drawable.divnomorskoe,
                            city = "Дивноморское",
                            type = "Кемпинг",
                        ),
                        Item(
                            photo = R.drawable.anapa,
                            city = "Анапа",
                            type = "Кемпинг",
                        ),
                        Item(
                            photo = R.drawable.vityazevo,
                            city = "Витязево",
                            type = "Гэмплинг",
                        ),
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
    val city: String,
    val type: String,
)
