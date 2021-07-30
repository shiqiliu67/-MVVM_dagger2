package com.shiqiliu.mvvm_course_dagger.ui.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shiqiliu.mvvm_course_dagger.model.remote.repository.MainRepository
import com.shiqiliu.mvvm_course_dagger.ui.course.addCourse.AddCourseViewModel
import com.shiqiliu.mvvm_course_dagger.ui.course.getCourse.GetCourseViewModel
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val mainRepository: MainRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddCourseViewModel::class.java)){
            return AddCourseViewModel(mainRepository) as T
        }
        else if(modelClass.isAssignableFrom(GetCourseViewModel::class.java)){
            return GetCourseViewModel(mainRepository) as T
        }

        throw IllegalArgumentException("Unknown View model")
    }
}