import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive-enrollment',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment.html',
  styleUrl: './reactive-enrollment.css'
})
export class ReactiveEnrollment {
  enrollForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      studentEmail: ['', [Validators.required, Validators.email]],
      courseId: ['', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue]
    });
  }

  get f() { return this.enrollForm.controls; }

  onSubmit() {
    if (this.enrollForm.valid) {
      console.log('Reactive Form Submitted:', this.enrollForm.value);
      alert('Enrollment Successful!');
      this.enrollForm.reset();
    }
  }
}
