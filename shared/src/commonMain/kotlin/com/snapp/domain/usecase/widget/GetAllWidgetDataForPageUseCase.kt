package com.snapp.domain.usecase.widget

import com.snapp.data.model.page.PageConfig
import com.snapp.data.api.request.TableRequest
import com.snapp.data.model.widget.TableResponse
import com.snapp.domain.repository.WidgetDataRepository
import com.snapp.domain.usecase.page.CollectWidgetDataKeysUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.putJsonArray
import kotlinx.serialization.json.putJsonObject

class GetAllWidgetDataForPageUseCase(
    private val collectWidgetDataKeysUseCase: CollectWidgetDataKeysUseCase,
    private val widgetDataRepository: WidgetDataRepository
) {
    suspend operator fun invoke(pageConfig: PageConfig): Map<String, JsonObject> = coroutineScope {
        val pairs = collectWidgetDataKeysUseCase(pageConfig.components)
        pairs.map { (widget, isTable) ->
            async {
                val dataKey = widget.dataKey ?: return@async "" to buildJsonObject { }
                val data = if (isTable) {
                    val tableResponse = widgetDataRepository.getTableData(
                        dataKey,
                        TableRequest(page = 1, pageSize = 10)
                    )
                    tableResponseToJsonObject(tableResponse)
                } else {
                    widgetDataRepository.getWidgetData(dataKey, null)
                }
                dataKey to data
            }
        }.awaitAll().filter { it.first.isNotBlank() }.toMap()
    }

    private fun tableResponseToJsonObject(response: TableResponse): JsonObject = buildJsonObject {
        putJsonArray("records") { response.records.forEach { add(it) } }
        putJsonObject("meta") {
            put("totalRecords", response.meta.totalRecords)
            put("totalPages", response.meta.totalPages)
            put("page", response.meta.currentPage)
            put("pageSize", response.meta.pageSize)
        }
    }
}
