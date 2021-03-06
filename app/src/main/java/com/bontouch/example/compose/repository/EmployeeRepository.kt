package com.bontouch.example.compose.repository

import com.bontouch.example.compose.config.SettingsRepository
import com.bontouch.example.compose.data.EmployeeData
import com.bontouch.example.compose.domain.Teams
import com.bontouch.example.compose.ui.util.update
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

object EmployeeRepository {
    private val teamsStateFlow = MutableStateFlow<Teams>(EmployeeData.people)

    val teamsFlow: Flow<Teams>
        get() = teamsStateFlow

    fun setEmployeeNotes(name: String, notes: String) {
        teamsStateFlow.update { teams ->
            Teams(
                studios = teams.studios.map { team ->
                    team.copy(employees = team.employees.map { employee ->
                        if (employee.name == name) {
                            employee.copy(
                                notes = notes
                            )
                        } else {
                            employee
                        }
                    })
                }
            )
        }
    }
}
