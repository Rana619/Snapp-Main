package com.snapp.data.model.page

import com.snapp.data.serializer.ActionsSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class PageWidget(
    val id: String,
    val type: String,
    val title: String? = null,
    @SerialName("description") val desc: String? = null,
    val dataKey: String? = null,
    val route: String? = null,
    @Serializable(with = ActionsSerializer::class)
    val actions: List<String>? = null,
    val inlineActions: List<String>? = null,
    val width: Int? = null,
    val height: Int? = null,
    val gridRow: Int? = null,
    val gridColumn: Int? = null,
    val options: JsonObject? = null,
    val components: List<PageWidget>? = null
)
