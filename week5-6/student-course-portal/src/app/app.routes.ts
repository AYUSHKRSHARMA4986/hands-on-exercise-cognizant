import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { CourseListComponent } from './pages/course-list/course-list';
import { EnrollmentForm } from './pages/enrollment-form/enrollment-form';
import { ReactiveEnrollment } from './pages/reactive-enrollment/reactive-enrollment';
import { StudentProfile } from './pages/student-profile/student-profile';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'courses', component: CourseListComponent },
  { path: 'enroll', component: EnrollmentForm },               // Must point to EnrollmentForm
  { path: 'reactive-enroll', component: ReactiveEnrollment }, // Must point to ReactiveEnrollment
  { path: 'profile', component: StudentProfile },
  { path: '**', redirectTo: '' }
];
