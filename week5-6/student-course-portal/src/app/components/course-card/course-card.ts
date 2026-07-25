import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe'; // Adjust path if needed

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard {
  @Input() course: any;
  @Output() enroll = new EventEmitter<number>();

  isExpanded = false;

  onEnrollClick() {
    this.enroll.emit(this.course.id);
  }
}
