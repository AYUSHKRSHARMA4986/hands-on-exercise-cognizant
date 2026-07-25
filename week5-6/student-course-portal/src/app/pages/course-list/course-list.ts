import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Course } from '../../services/course';
import { CourseCard } from '../../components/course-card/course-card';
import { HighlightDirective } from '../../directives/highlight';
import * as CourseActions from '../../store/course/course.actions';
import * as CourseSelectors from '../../store/course/course.selectors';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCard, HighlightDirective],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseListComponent implements OnInit {
  private store = inject(Store);

  courses$: Observable<Course[]> = this.store.select(CourseSelectors.selectAllCourses);
  isLoading$: Observable<boolean> = this.store.select(CourseSelectors.selectCoursesLoading);
  errorMessage$: Observable<string | null> = this.store.select(CourseSelectors.selectCoursesError);

  ngOnInit() {
    this.store.dispatch(CourseActions.loadCourses());
  }

  onEnroll(courseId: number) {
    console.log('Enrolling in course:', courseId);
  }
}
